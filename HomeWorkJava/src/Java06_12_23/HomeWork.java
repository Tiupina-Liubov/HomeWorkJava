package src.Java06_12_23;
import src.Java06_12_23.User;
import com.github.javafaker.Faker;

import java.util.*;

public class HomeWork {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
//        **Создайте HashMap<String, Integer>, заполните его парами
//"имя-возраст". Используйте цикл for-each для удвоения возраста каждого человека.
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Anna", 24);
        stringIntegerMap.put("Katja", 17);
        stringIntegerMap.put("Kira", 19);
        stringIntegerMap.put("Nina", 2);
        stringIntegerMap.put("Kolja", 20);
        System.out.println(stringIntegerMap);

        for (Map.Entry<String, Integer> map : stringIntegerMap.entrySet()) {
            map.setValue(map.getValue() * 2);
        }
        System.out.println(stringIntegerMap);
//     ***Создайте HashMap<Integer, String>, представляющий
//"ID-имя пользователя". Используйте цикл для фильтрации
//пользователей с ID больше 100 и копируйте их в TreeMap.
        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, "Nika");
        integerStringMap.put(79, "Nika");
        integerStringMap.put(100, "Nika");
        integerStringMap.put(102, "Nika");
        integerStringMap.put(99, "Nika");
        integerStringMap.put(209, "Nika");
        Map<Integer, String> treeMap = new TreeMap<>(idGreaterThan100(integerStringMap));
        System.out.println(treeMap);
//       3**Создайте класс User с полями name и age, реализующий Comparable
//       для сортировки по возрасту. Используйте TreeMap<User, String>
//       для хранения информации о пользователях и переберите его, чтобы напечатать имена.
        Map<User, String> treeMap1 = new TreeMap<>();
        User id1 = new User("Anton", 27);
        User id2 = new User("Alina", 21);
        User id3 = new User("Dima", 13);
        User id4 = new User("Mark", 17);
        User id5 = new User("Nolan", 35);
        treeMap1.put(id1, "sasasa");
        treeMap1.put(id2, "dsdsds");
        treeMap1.put(id3, "fdfdfd");
        treeMap1.put(id4, "gfgfgf");
        treeMap1.put(id5, "hghghg");
        System.out.println(treeMap1);
//   **Создайте TreeMap<User, String> (класс User как в задаче 3), но на
//этот раз реализуйте Comparator<User>, чтобы сортировать пользователей по имени.
        Map<User, String> treeMap2 = new TreeMap<>(new NewSortUserName());
        User id10 = new User("Anton", 27);
        User id9 = new User("Alina", 21);
        User id6 = new User("Dima", 13);
        User id7 = new User("Mark", 17);
        User id8 = new User("Nolan", 35);
        treeMap2.put(id1, "sasasa");
        treeMap2.put(id2, "dsdsds");
        treeMap2.put(id3, "fdfdfd");
        treeMap2.put(id4, "gfgfgf");
        treeMap2.put(id5, "hghghg");
        System.out.println(treeMap2);
        System.out.println("________________");

//    **Создайте два HashMap<String, User> (класс User как в задаче 3) и
//объедините их в один, удалив дубликаты пользователей.

        Map<String, User> stringUserMap = new HashMap<String, User>();
        Map<String, User> stringUserMap1 = new HashMap<String, User>();
        stringUserMap.put("Student1", id1);
        stringUserMap.put("Student2", id2);
        stringUserMap.put("Student3", id3);
        stringUserMap1.put("Student1", id3);
        stringUserMap1.put("Student2", id4);
        stringUserMap1.put("Student3", id5);
        associationHashMaps(stringUserMap, stringUserMap1);
        System.out.println(stringUserMap1);
        System.out.println("___________");
//        **Создайте HashMap<Integer, String> и перепишите его в TreeMap<String, Integer>,
//инвертируя ключи и значения.
        Map<Integer, String> heshMap = new HashMap<>();
        heshMap.put(1, "Nika");
        heshMap.put(79, "Kipa");
        heshMap.put(100, "Nika");
        heshMap.put(102, "Zina");
        heshMap.put(99, "Katja");
        heshMap.put(209, "Nina");
        Map<String, Integer> invertingTreeMap = new TreeMap<>(invertingKeysValues(heshMap));
        System.out.println(invertingTreeMap);
//**Создайте HashMap<String, Integer>, переберите её и создайте List<Integer>,
//содержащий все значения HashMap.
        Map<String,Integer> map1=new HashMap<>();
        map1.put("Anna", 24);
        map1.put("Katja", 17);
        map1.put("Kira", 19);
        map1.put("Nina", 2);
        map1.put("Kolja", 20);
        System.out.println(getListValue(map1));
//        **Создайте TreeMap<String, Integer> и переберите его, создавая HashMap<Integer, String>,
//        включающий только те записи, где значение больше 50.
       Map <String,Integer> strTreeMap= new TreeMap<>();
       strTreeMap.put("1",11);
       strTreeMap.put("2",45);
       strTreeMap.put("4",51);
       strTreeMap.put("3",60);
       strTreeMap.put("5",25);
       strTreeMap.put("6",43);
       strTreeMap.put("7",100);
       strTreeMap.put("8",85);
        System.out.println(valueGreaterNumber(strTreeMap, 50));
//        **Создайте HashMap<String, List<Integer>>, где ключ - это имя, а значение - список оценок.
//Используйте TreeMap<Integer, List<String>> для создания отображения
//"средняя оценка - список студентов с этой оценкой".
        Map<String,List<Integer>> listGradesStudents=new HashMap<>();
        fillingHashMap(listGradesStudents);
        System.out.println(listGradesStudents);
        System.out.println(averageStudentList(listGradesStudents));

    }
    public static  Map<Integer,List<String>>averageStudentList(Map<String,List<Integer>>stringListMap){
        Map<Integer,List<String>> averageStudentList=new TreeMap<>();
        for(Map.Entry<String,List<Integer>>map:stringListMap.entrySet()){
            int average=average(map.getValue());
            averageStudentList.put(average,averageStudentList.computeIfAbsent(average,k->new ArrayList<>())).
                    add(map.getKey());
        }
        return averageStudentList;
    }
    public static int average(List<Integer> listGrade){
        int average=0;
        for (Integer numb:listGrade) {
            average+=numb;
        }
        return average/listGrade.size();
    }
    public static Map<Integer,List<String>>averageRatingStudent(Map<String,List<Integer>> stringListMap){
        Map<Integer,List<String>> averageRating=new TreeMap<>();

        return averageRating;
    }
    public static void fillingHashMap(Map<String,List<Integer>>stringListMap){
        for (int i = 0; i < 5; i++) {
            stringListMap.put(FAKER.name().fullName(),listGrades());
        }
    }
    public static List<Integer>listGrades(){
        List <Integer> grades =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int grade = RANDOM.nextInt(13);
            grades.add(grade);
        }
        return grades;
    }
    public static Map<Integer,String> valueGreaterNumber(Map<String,Integer> stringIntegerMap,int number){
        Map<Integer,String>valueGreaterNumber=new HashMap<>();
       for(Map.Entry<String,Integer>map:stringIntegerMap.entrySet()){
           if(number<map.getValue()){
               valueGreaterNumber.put(map.getValue(),map.getKey());
           }
       }
       return valueGreaterNumber;
    }
    public static List<Integer> getListValue(Map<String,Integer>stringIntegerMap){
        List<Integer> listValue=new ArrayList<>(stringIntegerMap.values());
        return listValue;
    }

    public static Map<String, Integer> invertingKeysValues(Map<Integer, String> heshMap) {
        Map<String, Integer> invertingMap = new TreeMap<>();
        for (Map.Entry<Integer, String> map : heshMap.entrySet()) {
            invertingMap.put(map.getValue(), map.getKey());
        }
        return invertingMap;
    }

    public static Map<String, User> associationHashMaps(Map<String, User> first, Map<String, User> second) {
        int key = second.size() + 1;
        for (Map.Entry<String, User> entry : first.entrySet()) {
            if (!second.containsKey(entry.getKey())) {
                if (!second.containsValue(entry.getValue())) {
                    second.put(entry.getKey(), entry.getValue());
                }
            } else {
                if (!second.containsValue(entry.getValue())) {
                    second.put("Student" + key, entry.getValue());
                    key++;
                }
            }
        }
        return second;
//
    }

    public static void sortUserName(Map<User, String> treeMap) {


    }

    public static Map<Integer, String> idGreaterThan100(Map<Integer, String> integerStringMap) {
        Map<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, String> map : integerStringMap.entrySet()) {
            if (map.getKey() > 100) {
                treeMap.put(map.getKey(), map.getValue());
            }
        }
        return treeMap;
    }


    static void ageMultiplier(Map<String, Integer> map) {
        for (String entry : map.keySet()) {
            map.put(entry, map.get(entry) * 2);
        }
    }
}
