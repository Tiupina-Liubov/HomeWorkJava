package src.java11_12_23;

import com.github.javafaker.Faker;

import java.util.*;

public class MapsWork {
    public final static Faker FAKER = new Faker();

    public static void main(String[] args) {
        Map<String, String> names = new HashMap<>();
        Map<String, String> names1 = new HashMap<>();
        filingMap(names);
        filingMap(names1);
        names.put("Hagen", "Britta");
        names.put("Hagn", "Britta");
        names.put("Haen", "Britta");
        names1.put("Hagen", "Brit");
        names1.put("Hagn", "Britta");
        names1.put("Haen", "Britta");
        System.out.println(names);
        int count = countUniqueValues(names);
        System.out.println(count);
        printMap(names);
        Set<String> name = findKeysByValue(names, "Britta");
        System.out.println(name);
        System.out.println(invertMap(names));
        System.out.println("___________");
        System.out.println(names);
        System.out.println(names1);
        Map<String,String> allNames=mergeMapsIfUniqueKeys(names1,names);
        System.out.println(allNames);
        System.out.println("_________");
        Map<Integer,String> mapIntStr=new HashMap<>();
        Map<Integer,String> mapIntStr1=new HashMap<>();
        Map<Integer,String> mapIntStr2=new HashMap<>();
        Map<Integer,String> mapIntStr3=new HashMap<>();
        filingMapIntStr(mapIntStr);
        System.out.println(mapIntStr);
        Set<Map<Integer,String>>setMap=new HashSet<>();
        setMap.add(filingMapIntStr(mapIntStr1));
        setMap.add(filingMapIntStr(mapIntStr2));
        setMap.add(filingMapIntStr(mapIntStr3));
        mapIntStr1.put(10,"Anna");
        System.out.println(setMap);
        Set <String>stringSet=findAllValues(setMap);
        System.out.println(stringSet);
        int sumKeys=sumAllKeys(setMap);
        System.out.println(sumKeys);
        System.out.println("________");
        String str="Anna";
        boolean b =containsValue(setMap,str);
        System.out.println(b);
        Set<Map<Character, Set<String>>> complexSet= mapSet();
        System.out.println(complexSet);
        Set<String> stringSet1=findAllStringsWithChar(complexSet,'A');
        System.out.println(stringSet1);
        System.out.println("________");
        Map<Character, Integer> map=countStringOccurrences(complexSet);
        System.out.println(map);




    }
    public static Set<Map<Character, Set<String>>>mapSet(){
        Set<Map<Character, Set<String>>> mapSet=new HashSet<>();
        for (int i = 0; i < 3; i++) {
            mapSet.add(filingcharacterSetMap());

        }
        return mapSet;
    }
    public static Map<Character,Set<String>> filingcharacterSetMap(){
        Map<Character,Set<String>> characterSetMap=new HashMap<>();
        char letter= 'A';
        for (int i = 0; i < 3; i++) {
            characterSetMap.put(letter,nameSet());
            letter++;
        }
       return characterSetMap;
    }
    public static Set<String> nameSet(){
        Set<String> nameSet= new HashSet<>();
        for (int i = 0; i < 5; i++) {
            nameSet.add(FAKER.animal().name());
        }
        return nameSet;
    }

    public static Map<Integer, String> filingMapIntStr(Map<Integer, String> map) {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int numb =random.nextInt(10);
            map.put(numb, FAKER.name().firstName());
        }
        return map;
    }
    public static void filingMap(Map<String, String> map) {
        for (int i = 0; i < 5; i++) {
            map.put(FAKER.name().lastName(), FAKER.name().firstName());
        }
    }

    public static void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println("Key: " + m.getKey() + ", Value: " + m.getValue());
        }
    }

    public static Set<String> findKeysByValue(Map<String, String> map, String value) {
        Set<String> stringSet = new HashSet<>();
        for (Map.Entry<String, String> m : map.entrySet()) {
            if (m.getValue().equals(value)) {
                stringSet.add(m.getKey());
            }
        }
        return stringSet;
    }

    public static Map<String, String> mergeMapsIfUniqueKeys(Map<String, String> map1, Map<String, String> map2) {
        Map <String,String> cloneMap1 =new HashMap<>(map1);

        for (Map.Entry<String, String> m : map1.entrySet()) {
            for (Map.Entry<String, String> m1 : map2.entrySet()) {
                if (!m.getKey().equals(m1.getKey())) {
                    cloneMap1.put(m1.getKey(), m1.getValue());//попробивать через контейнц
                }
            }
        }
        return cloneMap1;
    }

    public static Map<String, String> invertMap(Map<String, String> map) {
        ;
        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> m : map.entrySet()) {
            reverseMap.put(m.getValue(), m.getKey());
        }
        return reverseMap;
    }

    public static int countUniqueValues(Map<String, String> map) {
        Set<String> set = new HashSet<>(map.values());
        int count = set.size();
        for (String s : set) {
            int num = 0;
            for (String m : map.values()) {
                if (m.equals(s)) {
                    num++;
                }
            }
            if (num > 1) {
                count--;
            }
        }
        return count;
    }

    public static Set<String> findAllValues(Set<Map<Integer, String>> setOfMaps) {
        Set<String> findAllValue = new HashSet<>();
        for (Map<Integer, String> s : setOfMaps) {
            findAllValue.addAll(s.values());
        }
        return findAllValue;
    }

    public static int sumAllKeys(Set<Map<Integer, String>> setOfMaps) {
        int sum = 0;
        for (Map<Integer, String> s : setOfMaps) {
            sum += sumKeysMap(s);
        }
        return sum;
    }

    public static int sumKeysMap(Map<Integer, String> map) {
        int sum = 0;
        for (Integer m : map.keySet()) {
            sum += m;

        }
        return sum;
    }

    public static boolean containsValue(Set<Map<Integer, String>> setOfMaps, String value) {
        boolean b = false;
        for (Map<Integer, String> map : setOfMaps) {
            for (String s : map.values()) {
                if (value.equals(s)) {
                    b = true;
                }
            }
        }
        return b;
    }

    public static Set<String> findAllStringsWithChar(Set<Map<Character, Set<String>>> complexSet, char c) {
        Set<String> setStrings = new HashSet<>();
        for (Map<Character, Set<String>> set : complexSet) {
            for (Set<String> s : set.values()) {
                for (String str : s) {
                    if (String.valueOf(str.charAt(0)).equalsIgnoreCase(String.valueOf(c))) {
                        setStrings.add(str);
                    }
                }
            }
        }

        return setStrings;
    }

    public static Map<Character, Integer> countStringOccurrences(Set<Map<Character, Set<String>>> complexSet) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (Map<Character, Set<String>> m : complexSet) {
            for (Map.Entry<Character, Set<String>> mapCharSet : m.entrySet()) {
                count=0;
                char charsKey = mapCharSet.getKey();
                Set<String> stringsValue = mapCharSet.getValue();
                for (String str : stringsValue) {
                    if(String.valueOf(charsKey).equalsIgnoreCase(String.valueOf(str.charAt(0)))){
                        count++;
                        map.put(charsKey,count);
                    }
                    }

            }
        }

        return map;
    }

}

