package src.new_year;

import java.util.*;

public class Game {
    public static final Random RANDOM = new Random();

    public static <T extends Participant> Map<Team<T>, Float> resultPlayTeams(Map<Team<T>, Float> teams) {
        for (Map.Entry<Team<T>, Float> m : teams.entrySet()) {
            for (Team<T> tClone : teams.keySet()) {
                if (!m.getKey().equals(tClone)) {
                    if (play(m.getKey(), tClone) == null) {
                        teams.put(m.getKey(), m.getValue() + 0.5f);
                        teams.put(tClone, teams.get(tClone) + 0.5f);
                        collectionStatisticalData(m.getKey(), tClone, 0.5f, 0.5f);
                        break;

                    } else if (play(m.getKey(), tClone) == m.getKey()) {
                        oneCouch(teams, m.getKey());
                        collectionStatisticalData(m.getKey(), tClone, 1.0f, 0.0f);
                        break;

                    } else {
                        oneCouch(teams, tClone);
                        collectionStatisticalData(m.getKey(), tClone, 0.0f, 1.0f);
                        break;
                    }
                }
            }
        }
        System.out.println("+++++++++++++++++++++");
        System.out.printf(teams+"\n");
        Utility.sortBuPoints(teams);
        System.out.printf(teams+"\n");

        return teams;
    }

    private static <T extends Participant> Team<T> play(Team<T> team1, Team<T> team2) {

        int rnd = RANDOM.nextInt(3);
        int rnd1 = RANDOM.nextInt(3);
        String str1 = switch (rnd) {
            case 0 -> HandPosition.SCISSORS.name();
            case 1 -> HandPosition.PAPER.name();
            default -> HandPosition.STONE.name();
        };

        String str2 = switch (rnd1) {
            case 0 -> HandPosition.SCISSORS.name();
            case 1 -> HandPosition.PAPER.name();
            default -> HandPosition.STONE.name();
        };
        if (str1.equals(str2)) {
            return null;
        } else {
            if ((str1.equals(HandPosition.SCISSORS.name()) && str2.equals(HandPosition.PAPER.name())) ^ (str1
                    .equals(HandPosition.PAPER.name()) && str2.equals(HandPosition.STONE.name())) ^
                    (str1.equals(HandPosition.STONE.name()) && str2.equals(HandPosition.SCISSORS.name()))) {
                return team1;
            } else {
                return team2;
            }
        }
    }

    private static <T extends Participant> void collectionStatisticalData(Team<T> team1, Team<T> team2, float couchTeam1, float couchTeam2) {
        if (Handler.getListGamingStatistics().size() == 0) {
            Handler.setListGamingStatistics(newStatisticMap(team1, team2, couchTeam1, couchTeam2));
        } else if (!Handler.getListGamingStatistics().containsKey(newMapNameTeamsPlay(team1, team2)) &&
                (!Handler.getListGamingStatistics().containsKey(newMapNameTeamsPlay(team2, team1)))) {
            Handler.setListGamingStatistics(newStatisticMap(team1, team2, couchTeam1, couchTeam2));
        } else {
            if (Handler.getListGamingStatistics().containsKey(newMapNameTeamsPlay(team1, team2))) {
                addingResult(newMapNameTeamsPlay(team1, team2), couchTeam1);
                addingResult(newMapNameTeamsPlay(team2, team1), couchTeam2);
            }
        }
    }

    private static <T extends Participant> Map<Map<String, String>, List<Float>> newStatisticMap(Team<T> team1, Team<T> team2, float couchTeam1, float couchTeam2) {
        Map<Map<String, String>, List<Float>> newStatisticMap = new HashMap<>();
        Map<String, String> stringMap1 = new HashMap<>();
        Map<String, String> stringMap2 = new HashMap<>();
        stringMap1.put(team1.getName(), team2.getName());
        stringMap2.put(team2.getName(), team1.getName());
        List<Float> listTeam1 = new ArrayList<>();
        listTeam1.add(0, couchTeam1);
        List<Float> listTeam2 = new ArrayList<>();
        listTeam2.add(0, couchTeam2);
        newStatisticMap.put(stringMap1, listTeam1);
        newStatisticMap.put(stringMap2, listTeam2);
        return newStatisticMap;
    }

    public static <T extends Participant> Map<String, String> newMapNameTeamsPlay(Team<T> team1, Team<T> team2) {
        Map<String, String> stringMap1 = new HashMap<>();
        stringMap1.put(team1.getName(), team2.getName());
        return stringMap1;
    }

    private static void addingResult(Map<String, String> nameTeams, float couch) {
        for (Map.Entry<Map<String, String>, List<Float>> list : Handler.getListGamingStatistics().entrySet()) {
            if (nameTeams.entrySet().equals(list.getKey().entrySet())) {
                addCouchOfList(list.getValue(), couch);
                break;
            }
        }
    }

    private static void addCouchOfList(List<Float> list, float couch) {
        list.add(list.size(), couch);
    }

    static <T extends Participant> void oneCouch(Map<Team<T>, Float> teamMap, Team<T> team) {
        for (Map.Entry<Team<T>, Float> m : teamMap.entrySet()) {
            if (m.getKey().equals(team)) {
                m.setValue(m.getValue() + 1);
            }
        }
    }


}