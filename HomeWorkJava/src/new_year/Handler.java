package src.new_year;

import java.util.*;

public class Handler {
    private static Set<Team<? extends Participant>> participantTeams;
    private static Set<Team<Adult>> setAdult;
    private static Set<Team<Teenager>> setTeenager;
    private static Set<Team<Pupil>> setPupil;
    private static Map<Team<Teenager>, Float> mapTeenager = new LinkedHashMap<>();
    private static Map<Team<Adult>, Float> mapAdult = new LinkedHashMap<>();
    private static Map<Team<Pupil>, Float> mapPupil = new LinkedHashMap<>();
    private static Map<Team<Participant>, Float> teamsMap = new LinkedHashMap<>();
    private static List<Participant> allParticipants = new ArrayList<>();
    private static Map<Map<String, String>, List<Float>> listGamingStatistics = new LinkedHashMap<>();

    public static Set<Team<? extends Participant>> getParticipantTeams() {
        return participantTeams;
    }

    public static void setParticipantTeams(Set<Team<? extends Participant>> participantsTeams) {
        if (getParticipantTeams() == null) {
            participantTeams = participantsTeams;
        } else {
            participantTeams.addAll(participantsTeams);

        }
    }

    public static Set<Team<Adult>> getSetAdult() {
        return setAdult;
    }

    public static void setSetAdult(Set<Team<Adult>> setAdults) {
        setAdult = setAdults;
    }

    public static Set<Team<Teenager>> getSetTeenager() {
        return setTeenager;
    }

    public static void setSetTeenager(Set<Team<Teenager>> setTeenagers) {
        setTeenager = setTeenagers;
    }

    public static Set<Team<Pupil>> getSetPupil() {
        return setPupil;
    }

    public static void setSetPupil(Set<Team<Pupil>> setPupils) {
        setPupil = setPupils;
    }

    public static Map<Team<Teenager>, Float> getMapTeenager() {
        return mapTeenager;
    }

    public static void setMapTeenager(Map<Team<Teenager>, Float> mapTeenagers) {
        mapTeenager = mapTeenagers;
    }

    public static Map<Team<Adult>, Float> getMapAdult() {
        return mapAdult;
    }

    public static void setMapAdult(Map<Team<Adult>, Float> mapAdults) {
        mapAdult = mapAdults;
    }

    public static Map<Team<Pupil>, Float> getMapPupil() {
        return mapPupil;
    }

    public static void setMapPupil(Map<Team<Pupil>, Float> mapPupils) {
        mapPupil = mapPupils;
    }

    public static Map<Team<Participant>, Float> getTeamMap() {
        return teamsMap;
    }

    public static Map<Team<Participant>, Float> getTeamsMap() {
        return teamsMap;
    }

    public static void setTeamsMap(Map<Team<Participant>, Float> teamsMap) {
        Handler.teamsMap = teamsMap;
    }

    public static List<Participant> getAllParticipants() {
        return allParticipants;
    }


    public static void setAllParticipants(List<Participant> allParticipant) {
        if (allParticipants == null) {
            allParticipants = allParticipant;
        } else {
            allParticipants.addAll(allParticipant);
        }
    }

    public static void setTeamMap(Map<Team<Participant>, Float> teamIntegerMaps) {
        if (teamsMap == null) {
            teamsMap = teamIntegerMaps;
        } else {
            teamsMap.putAll(teamIntegerMaps);
        }
    }

    public static Map<Map<String, String>, List<Float>> getListGamingStatistics() {
        return listGamingStatistics;
    }

    public static void setListGamingStatistics(Map<Map<String, String>, List<Float>> listGamingStatistic) {
        if (listGamingStatistics.size() ==0) {
            listGamingStatistics = listGamingStatistic;
        } else {
            listGamingStatistics.putAll(listGamingStatistic);
        }
    }


    public static <T extends Participant> Map<Team<Participant>, Float> allTeamMap(Map<Team<T>, Float> map) {
        for (Map.Entry<Team<T>, Float> m : map.entrySet()) {
            teamsMap.put((Team<Participant>) m.getKey(), m.getValue());
        }
        return teamsMap;
    }

    public static  void sortingParameterWritingToHandler(Set<Team<? extends Participant>> setParticipant) {
        Set<Team<Adult>> adultSet = new HashSet<>();
        Set<Team<Teenager>> teenagerSet = new HashSet<>();
        Set<Team<Pupil>> pupilSet = new HashSet<>();
        for (Team<? extends Participant> t : setParticipant) {
            if (t.getParticipants().get(0) instanceof Adult) {
                adultSet.add((Team<Adult>) t);
                setAdult = adultSet;
                mapAdult = Utility.addNewMap(setAdult);
                t.setCategory(Category.ADULT);
            } else if (t.getParticipants().get(0) instanceof Teenager) {
                teenagerSet.add((Team<Teenager>) t);
                setTeenager = teenagerSet;
                mapTeenager = Utility.addNewMap(setTeenager);
                t.setCategory(Category.TEENAGER);
            } else if (t.getParticipants().get(0) instanceof Pupil) {
                pupilSet.add((Team<Pupil>) t);
                setPupil = pupilSet;
                mapPupil = Utility.addNewMap(setPupil);
                t.setCategory(Category.PUPIL);
            }
        }
    }

}