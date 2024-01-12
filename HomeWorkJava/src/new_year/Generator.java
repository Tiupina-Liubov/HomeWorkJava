package src.new_year;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Generator {
    private static final Faker FAKER = new Faker();

    @Override
    public String toString() {
        return "Generator{}\n";
    }

    public static <T extends Participant> Set<Team<? extends Participant>> genTeams(int teams, int participant, Class<T> t) {
        Set<Team<? extends Participant>> setTeams = new HashSet<>();
        if (teams <= 0 || participant <= 0) {
            System.out.println("Please enter the correct data");
            return setTeams;
        }
        for (int i = 0; i < teams; i++) {
            setTeams.add(newTeam(FAKER.team().name(), genParticipant(t, participant)));
        }
        Handler.sortingParameterWritingToHandler(setTeams);
        return setTeams;
    }

    private static <T extends Participant> List<T> genParticipant(Class<T> t, int participant) {

        List<T> list = new ArrayList<>();
        if (t.isNestmateOf(Adult.class)) {
            while (participant != 0) {
                list.add((T) new <T>Adult(FAKER.name().fullName(), (int) (Math.random() * (18 + 1) + 18)));
                participant--;
            }
        } else if (t.isNestmateOf(Teenager.class)) {
            while (participant != 0) {
                list.add((T) new <T>Teenager(FAKER.name().fullName(), (int) (Math.random() * (8 + 1) + 10)));
                participant--;
            }
        } else if (t.isNestmateOf(Pupil.class)) {
            while (participant != 0) {
                list.add((T) new <T>Pupil(FAKER.name().fullName(), (int) (Math.random() * (3 + 1) + 6)));
                participant--;
            }
        }
        Handler.setAllParticipants((List<Participant>) list);
        return list;
    }

    private static <T extends Participant> Team<T> newTeam(String str, List<T> listMap) {
        Team<T> team = new Team<>(str, listMap);
        return team;
    }

    public static <T extends Participant> void getPrintTeam(Set<Team<T>> set) {
        if (!set.isEmpty()) {
            for (Team<T> m : set) {
                System.out.println("Name team: " + m);
            }
        } else {
            System.out.println(" Set is empty elements");

        }
    }
}

