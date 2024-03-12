package src._2024_03_06;

import com.github.javafaker.Faker;
import lombok.Getter;

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

    static Set<Player> generePlayer(int quantityPlayer) {

        return Stream.generate(() -> new Player(FAKER.funnyName().name(), EXCHANGER, getListActionOf03()))
                .limit(quantityPlayer)
                .collect(Collectors.toSet());
    }


    public static void main(String[] args) throws InterruptedException {

//new Team(FAKER.funnyName().name(),EXCHANGERPLAYER,generePlayer(3)).start();
//new Team(FAKER.funnyName().name(),EXCHANGERPLAYER,generePlayer(3)).start();


        Tourney tourney = new Tourney("First", genereTeam(3, 3),EXCHANGERTEAM);
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
    public Set<Player> players;
    @Getter
    private double points = 0.0d;


    public Team(String name, Exchanger<Player> exchanger, Set<Player> players) {
        this.name = name;
        this.exchanger = exchanger;
        this.players = players;
    }


    private void makeGame(Player player1, Player player2) throws InterruptedException {
        synchronized (this) {
            player2.start();
            player1.join();
            player2.join();
        }
    }

    @Override
    public void run() {
        Player get;
        for (Player player : players) {
            try {
                get = exchanger.exchange(player);
                makeGame(player, get);
                points += player.getPoints();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            this.notifyAll();
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

    public void makeTourney(Team team, Team team1) throws InterruptedException {
        synchronized (this) {
            team.start();
            team1.start();
            team.join();
            team1.join();
        }
    }


    @Override
    public void run() {

        for (int i = 0; i < teams.size(); i++) {
            for (Team team : teams) {
                if (!teams.get(i).equals(team)) {
                    try {
                        makeTourney(teams.get(i), team);
                        System.out.println(teams.get(i) + " = " + team);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        synchronized (this) {
            this.notifyAll();
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

