package src.new_year;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    public static final Random RANDOM = new Random();


    public static <T extends Participant> Team<T> resultTournament(Map<Team<T>, Float> teams) {
        Map<Team<T>, Float> resultQualifyingStage = playAllWithAll(teams);
        Map<Team<T>, Float> resultSemifinalsGame = playAllWithAll(getTopLimitTeams(resultQualifyingStage, 5));
        Map<Team<T>, Float> resultFinalGame = playAllWithAll(getTopLimitTeams(resultSemifinalsGame, 3));

        return getLastTeam(resultFinalGame, 1);
    }

    public static <T extends Participant> Map<Team<T>, Float> playAllWithAll(Map<Team<T>, Float> teams) {

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
        Utility.sortBuPoints(teams);
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

    private static <T extends Participant> void collectionStatisticalData(Team<T> team1, Team<T> team2,
                                                                          float couchTeam1,
                                                                          float couchTeam2) {

        if (Handler.getListGamingStatistics().isEmpty()) {
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

    public static <T extends Participant> Map<Team<T>, Float> getTopLimitTeams(Map<Team<T>, Float> teams, int topLimit) {

        if (topLimit <= 1) {
            System.err.println("Limit cannot be 0 ");
        }

        if (checkingElements(teams, topLimit - 1, topLimit)) {
            return teams.keySet().stream()
                    .limit(topLimit)
                    .collect(Collectors.toMap(team -> team, team -> 0.0f));
        }

        Map<Team<T>, Float> top5Teams = teams.keySet().stream()
                .limit(topLimit - 1)
                .collect(Collectors.toMap(team -> team, team -> 0.0f));

        top5Teams.put(getLastTeam(teams, topLimit), 0.0f);

        return top5Teams;
    }

    private static <T extends Participant> Team<T> getLastTeam(Map<Team<T>, Float> teams, int topLimit) {
        float verifiablePoints = teams.get(getTeam(teams, topLimit - 1));
        Team<T> winner = null;
        Map<Team<T>, Float> semValues = teams.entrySet().stream()
                .filter(teamFloatEntry -> teamFloatEntry.getValue() != verifiablePoints)
                .peek(teamFloatEntry -> teamFloatEntry.setValue(0.0f))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));

        if (semValues.size() == 1) {
            winner = getTeam(semValues, 0);
            return winner;

        } else if (semValues.size() > 1) {
            if (teams.get(getTeam(semValues, 0)).equals(teams.get(getTeam(semValues, 1)))) {
                winner = replay(getTeam(semValues, 0), getTeam(semValues, 1));
            }
        }
        return winner;
    }


    private static <T extends Participant> Team<T> replay(Team<T> team, Team<T> team1) {
        Team<T> winner = play(team, team1);

        if (winner != null) {
            return winner;
        }
        return replay(team, team1);
    }


    public static <T extends Participant> Team<T> getTeam(Map<Team<T>, Float> teams, int index) {

        List<Team<T>> teamsList = teams.keySet().stream().toList();
        if (!teamsList.isEmpty()) {
            return teamsList.get(index);
        }

        return null;
    }

    private static <T extends Participant> boolean checkingElements(Map<Team<T>, Float> teams, int indexFirst, int indexSecond) {
        List<Float> floats = teams.values().stream()
                .toList();
        return floats.get(indexFirst) > (floats.get(indexSecond));
    }

}