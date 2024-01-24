package src.new_year;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        Handler.setParticipantTeams(Generator.genTeams(6, 4, Teenager.class));
        Handler.setParticipantTeams(Generator.genTeams(6, 4, Pupil.class));
        Handler.setParticipantTeams(Generator.genTeams(6, 4, Adult.class));


        Map<Team<Participant>, Float> map1;
        map1 = Handler.allTeamMap(Handler.getMapTeenager());
        map1 = Handler.allTeamMap(Handler.getMapPupil());
        map1 = Handler.allTeamMap(Handler.getMapAdult());

        System.out.println(Handler.getTeamMap());

        Team<Adult>winnerPlayAdult = Game.resultTournament(Handler.getMapAdult());
        Team<Pupil>winnerPlayPupil = Game.resultTournament(Handler.getMapPupil());
       Team<Teenager> winnerPlayTeenager = Game.resultTournament(Handler.getMapTeenager());

        System.out.println(winnerPlayAdult);
        System.out.println(winnerPlayPupil);
        System.out.println(winnerPlayTeenager);

        System.out.println(Handler.getListGamingStatistics());

        for (Map<String,String> m: Handler.getListGamingStatistics().keySet()){
            System.out.println(m);
        }

        Set<String> listTeams = Utility.listOfTeams(Handler.getTeamMap());
        System.out.println(listTeams);
        System.out.println("Средний возраст участников в каждой команде:");
        Utility.averageAge(Handler.getTeamMap());
        System.out.println(Utility.aboveTheAverage(Handler.getTeamMap()));
        System.out.println("Команды с определенной категорией участников: Вывести команды, где все участники " +
                "принадлежат к одной категории (например, только Adult). Через клас");
        Utility.conclusionParticipantsCategoryOfClass(Handler.getTeamMap(), Adult.class);
        System.out.println("Команды с определенной категорией участников: Вывести команды, где все участники " +
                "принадлежат к одной категории (например, только Adult). Через перечисление");
        Utility.conclusionParticipantsCategory(Handler.getTeamMap(), Category.TEENAGER);
        System.out.println("Команды с участниками в определенном возрастном диапазоне:");
        Utility.outputParticipantsCertainAgeRange(Handler.getTeamMap(), 21, 35);
        System.out.println("Имена участников по убыванию возраста:");
        Utility.showParticipantsDescendingOrderAge(Handler.getAllParticipants());
        System.out.println("Самая опытная команда: Определить команду с наибольшим суммарным возрастом участников.");
        Team<Participant> maxAgeTeam = Utility.greatestTotalAge(Handler.getTeamMap());
        System.out.println(maxAgeTeam);
        System.out.println("Найти все пары команд, чьи участники имеют одинаковый суммарный возраст.");
        Map<Map<String, String>, Integer> mapTeam = Utility.haveSameTotalAge(Handler.getTeamMap());
        System.out.println(mapTeam);
        System.out.println("___________");
        System.out.println("Вычислить средний балл для команд в каждой категории участников (Adult, Teenager, Pupil).");
        Utility.showTeamAverageScores();
        System.out.println("Выявить команды, которые не имеют проигрышей.");
        System.out.println(Utility.undefeatedTeamList(Handler.getListGamingStatistics()));
        System.out.println("Определить команды с самой длинной последовательностью побед.");
        Map<String,Integer> longestWinningStreak= Utility.showLongestWinningStreak();



    }


}
