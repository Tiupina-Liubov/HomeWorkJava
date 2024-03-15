package src._2024_03_06;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EXCH {
    private static final Exchanger<Action> EXCHANGER = new Exchanger<>();

    private static final Exchanger<Player> EXCHANGERPLAYER = new Exchanger<>();

    private static final Exchanger<Team> EXCHANGERTEAM = new Exchanger<>();

    private static final Faker FAKER = new Faker();

    private static final Random RANDOM = new Random();


    static List<Action> getListActionOf03() {
        List<Action> actionList = new ArrayList<>();
        Action[] actions = Action.values();

        for (int i = 0; i < 3; i++) {
            actionList.add(actions[RANDOM.nextInt(actions.length)]);
        }
        return actionList;
    }

    static List<Team> genereTeam(int quantityTeams, int quantityPlayer) {
        return Stream.generate(() -> new Team(FAKER.team().name(), EXCHANGERPLAYER, generePlayer(quantityPlayer)))
                .limit(quantityTeams)
                .toList();
    }

    static List<Player> generePlayer(int quantityPlayer) {

        return Stream.generate(() -> new Player(FAKER.funnyName().name(), EXCHANGER, getListActionOf03()))
                .limit(quantityPlayer)
                .toList();
    }


    public static void main(String[] args) throws InterruptedException {

//        new Team(FAKER.funnyName().name(), EXCHANGERPLAYER, generePlayer(3)).start();
//        new Team(FAKER.funnyName().name(), EXCHANGERPLAYER, generePlayer(3)).start();


        Tourney tourney = new Tourney("First", genereTeam(3, 3), EXCHANGERTEAM);
//        tourney.teams
//                .forEach(team ->tourney.teams.stream()
//                        .filter(team1 -> !team1.equals(team))
//                        .forEach(team1 -> {
//                            try {
//                                tourney.makeTourney(team);
//                            } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }));
////        tourney.join();
//        tourney.teams
//                .forEach(System.out::println);

    }
}

enum Action {
    SCISSORS,
    STONE,
    PAPER
}


class Player extends Thread {

    public String name;

    public Exchanger<Action> exchanger;

    private List<Action> actionList;
    @Getter
    private double points = 0.0d;


    public Player(String name, Exchanger<Action> exchanger, List<Action> actionList) {
        this.name = name;
        this.exchanger = exchanger;
        this.actionList = actionList;
    }

    private void getWinner(Action p1, Action p2) {
        if (p1 == Action.PAPER && p2 == Action.STONE ||
                p1 == Action.SCISSORS && p2 == Action.PAPER ||
                p1 == Action.STONE && p2 == Action.SCISSORS) {
            points += 1.0;
        } else if (p1 == Action.PAPER && p2 == Action.PAPER ||
                p1 == Action.SCISSORS && p2 == Action.SCISSORS ||
                p1 == Action.STONE && p2 == Action.STONE) {
            points += 0.5;


        }
    }

    @Override
    public void run() {
        Action get;
        for (Action action : actionList) {
            try {
                get = exchanger.exchange(action);
                getWinner(action, get);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", points=" + getPoints() +
                '}';
    }
}


class Team extends Thread {
    public String name;
    public Exchanger<Player> exchanger;
    public List<Player> players;
    @Getter
    private double points = 0.0d;

    public Team(String name, Exchanger<Player> exchanger, List<Player> players) {
        this.name = name;
        this.exchanger = exchanger;
        this.players = players;
    }


    private void playGames(Player opponent) throws InterruptedException {
        synchronized (this) {
            for (Player player : players) {
                Thread newPlayerThread = new Thread(player); // Создаем новый поток игрока
                newPlayerThread.start();
                newPlayerThread.join();
            }
        }
    }


    @Override
    public void run() {
        try {
            Player opponent;
            for (Player player : players) {
                opponent = exchanger.exchange(player);
                playGames(opponent);
                System.out.println(player);
                System.out.println(opponent);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}

class Match extends Thread {
    private Team team1;
    private Team team2;
    @Getter
    private Team winner;
    @Getter
    private Team loser;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public void run() {
        if (team1.getPoints() > team2.getPoints()) {
            winner = team1;
            loser = team2;
        } else {
            winner = team2;
            loser = team1;
        }
    }
}

class Tourney extends Thread {

    public String name;
    public List<Team> teams;
    private Exchanger<Team> teamExchanger;

    public Tourney(String name, List<Team> teams, Exchanger<Team> teamExchanger) {
        this.name = name;
        this.teams = teams;
        this.teamExchanger = teamExchanger;
        this.start();
    }

    public void makeTourney(Team team) throws InterruptedException {
        for (Team opponentTeam : teams) {
            if (!team.equals(opponentTeam)) {
                Match match = new Match(team, opponentTeam);
                match.start();
                match.join();
                System.out.println(match.getWinner() + " - " + match.getLoser());
            }
        }
    }


    @Override
    public void run() {
        for (Team team : teams) {
            try {
                makeTourney(team);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }



    @Override
    public String toString() {
        return "Tourney{" +
                "name='" + name + '\'' +
                ", teams=" + teams +
                '}';
    }
}

