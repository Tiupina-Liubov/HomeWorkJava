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
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    static List<Action> getListActionOf10() {
        List<Action> actionList = new ArrayList<>();
        Action[] actions = Action.values();

        for (int i = 0; i < 10; i++) {
            actionList.add(actions[RANDOM.nextInt(actions.length)]);
        }
        return actionList;
    }

   static List<Team> genereTeam(int quantityTeams, int quantityPlayer) {
        return Stream.generate(()-> new Team(FAKER.team().name(),EXCHANGERPLAYER,generePlayer(quantityPlayer)))
                .limit(quantityTeams)
                .toList();
    }

    static Set<Player> generePlayer(int quantityPlayer) {
            return Stream.generate(()-> new Player(FAKER.funnyName().name(), EXCHANGER,getListActionOf10()))
                    .limit(quantityPlayer)
                    .collect(Collectors.toSet());
        }


    public static void main(String[] args) {
         List<Team> teams= genereTeam(10,3);
        System.out.println(teams);



    }
}

enum Action {
    SCISSORS,
    STONE,
    PAPER
}

class Player extends Thread {
    private String name;
    private Exchanger<Action> exchanger;
    private List<Action> actionList;

    @Getter
    private double points = 0.0d;

    public Player(String name, Exchanger<Action> exchanger, List<Action> actionList) {
        this.name = name;
        this.exchanger = exchanger;
        this.actionList = actionList;
    }

    public void getWinner(Action p1, Action p2) {
        if (p1 == Action.PAPER && p2 == Action.STONE ||
                p1 == Action.SCISSORS && p2 == Action.PAPER ||
                p1 == Action.STONE && p2 == Action.SCISSORS) {
            System.out.println("***WINNER: " + name + " ***");
            this.points += 1.0;
        } else if (p1 == Action.PAPER && p2 == Action.PAPER ||
                p1 == Action.SCISSORS && p2 == Action.SCISSORS ||
                p1 == Action.STONE && p2 == Action.STONE) {
            System.out.println("***DRAW: " + name + " ***");
            this.points += 0.5;
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
                ", points=" + points +
                '}';
    }
}

class Team extends Thread {
    private String nameTeam;
    private Exchanger<Player> exchanger;
    private Set<Player> players;
    private double points = 0.0d;

    public Team(String nameTeam, Exchanger<Player> exchanger, Set<Player> players) {
        this.nameTeam = nameTeam;
        this.exchanger = exchanger;
        this.players = players;
    }

    public double makeScoring(){
      return players.stream()
              .map(player -> points)
              .reduce(Double::sum)
              .orElse(0.0);
    }

    public void makeGame(Player player1, Player player2) throws InterruptedException {
        synchronized (this) {
            while (players.size() < 2) {
                this.wait();
            }
        }
        for (int i = 0; i < players.size(); i++) {
            player1.run();
            player2.run();
        }
    }


    @Override
    public void run() {
        Player get;
        for (Player player : players) {
            try {
                get = exchanger.exchange(player);
                makeGame(player, get);
            } catch (InterruptedException e) {
                System.err.println("Team " + nameTeam + " thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            this.notifyAll();
        }
    }

    @Override
    public String toString() {
        return  '\n'+nameTeam +
                " = " + points ;
    }
}
