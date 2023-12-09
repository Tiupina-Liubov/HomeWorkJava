package HomeWorkJava.src.Java06_12_23;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HomeWork {
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
        Map<Integer,String> integerStringMap=new HashMap<>();
        integerStringMap.put(1,"Nika");
        integerStringMap.put(79,"Nika");
        integerStringMap.put(100,"Nika");
        integerStringMap.put(102,"Nika");
        integerStringMap.put(99,"Nika");
        integerStringMap.put(209,"Nika");
        Map<Integer,String> treeMap=new TreeMap<>(idGreaterThan100(integerStringMap));
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


//    **Создайте два HashMap<String, User> (класс User как в задаче 3) и
//объедините их в один, удалив дубликаты пользователей.

        Map<String,User>stringUserMap=new HashMap<String,User>();
        Map<String,User>stringUserMap1=new HashMap<String,User>();
        stringUserMap.put("Student1",id1);
        stringUserMap.put("Student2",id2);
        stringUserMap.put("Student3",id3);

        stringUserMap1.put("Student1",id3);
        stringUserMap1.put("Student2",id4);
        stringUserMap1.put("Student3",id5);
//        associationHashMaps(stringUserMap,stringUserMap1);
//        System.out.println(stringIntegerMap);







    }
//    public static void associationHashMaps(Map<String,User>stringUserMap,Map<String,User> stringUserMap1){
//        for(Map.Entry<String,User>map:stringUserMap.entrySet()){
//            for (Map.Entry<String,User>map1:stringUserMap1.entrySet()){
//                if(!map.getKey().equals(map1.getKey())){
//                    if(!map.getValue().equals(map1.getValue())){
//                        stringUserMap.put(map1.getKey(),map1.getValue());
//                    }
//
//                } else {
//                    if(!map.getValue().equals(map1.getValue())){
//                      int numberStudent= stringUserMap.keySet().size()+1;
//                      stringUserMap.put("Student"+numberStudent,map1.getValue());
//                    }
//
//                }
//            }
//        }
//    }
    public static void sortUserName(Map<User, String> treeMap){


    }
    public static Map<Integer,String> idGreaterThan100(Map<Integer,String> integerStringMap){
        Map <Integer,String> treeMap= new TreeMap<>();
        for(Map.Entry<Integer,String>map:integerStringMap.entrySet()){
            if(map.getKey()>100){
                treeMap.put(map.getKey(),map.getValue());
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
