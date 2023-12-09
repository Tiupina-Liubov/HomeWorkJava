package src.java04_12_23;

import javax.swing.plaf.basic.BasicListUI;
import java.util.*;

public class Test {
    public static void main(String[] args) {
//        1HashMap<String, String>: Найдите количество пар ключ-значение, где длина ключа равна длине значения.
        Map<String, String> map = new HashMap<>();
        map.put("b", "A");
        map.put("c", "AA");
        map.put("ddd", "AAA");
        map.put("d", "A");
        map.put("e", "Aaaaa");
        keyEqualsVolues(map);
//       2 HashMap<String, Integer>: Подсчитайте сумму всех значений, соответствующих ключам, начинающимся на букву 'A'.
        Map<String, Integer> numbers1 = new HashMap<>();
        numbers1.put("A", 25);
        numbers1.put("a", 3);
        numbers1.put("BA", 2);
        numbers1.put("v", 13);
        numbers1.put("aa", 27);
        numbers1.put("AA", 10);
        numbers1.put("BB", 3);
        numbers1.put("AAA", 25);
        System.out.println(sumTheValuesAllKeysLetter(numbers1, 'A'));
//       3 HashMap<Integer, List<String>>: Для каждого ключа выведите все строки из соответствующего списка,
//       которые начинаются с гласной буквы.
        Map<Integer, List<String>> str = new HashMap<>();
        str.put(1, new ArrayList<>(Arrays.asList("Aallo", "main", "Liubov", "Tiupina")));
        str.put(2, new ArrayList<>(Arrays.asList("hallo", "Main", "iuda", "Tiupna")));
        str.put(9, new ArrayList<>(Arrays.asList("allo", "ani", "iola", "Tiuina")));
        str.put(3, new ArrayList<>(Arrays.asList("allo", "main", "Liubov", "tiupinana")));
        str.put(4, new ArrayList<>(Arrays.asList("you", "main", "iov", "Tipina")));
        meaningsThatBeginWithVowel(str);

        //4 HashMap<Integer, Integer>: Найдите ключ с максимальным значением и выведите эту пару.
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(3, 5);
        numbers.put(8, 4);
        numbers.put(9, 6);
        numbers.put(1, 9);
        numbers.put(4, 4);
        numbers.put(7, 5);
        numbers.put(0, 4);
        numbers.put(2, 6);
        maximumKeyValue(numbers);

//        5.HashMap<String, String>: Определите, содержит ли HashMap такую пару ключ-значение, где ключ является
//        обратной строкой значения (например, ключ "abc", значение "cba").
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("adda", "adda");
        stringMap.put("tree", "tree");
        stringMap.put("door", "rodo");
        stringMap.put("123", "321");
        stringMap.put("fish", "finish");
        stringMap.put("fire", "erif");
        stringMap.put("bumm", "mumb");
        keyReverseStringValue(stringMap);

//       6. HashMap<String, Integer>: Переберите HashMap и преобразуйте его в HashMap<String, String>,
//        где каждое значение - это строковое представление исходного числа, умноженного на 2.
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("1", 45);
        stringIntegerMap.put("2", 4);
        stringIntegerMap.put("3", 56);
        stringIntegerMap.put("4", 95);
        stringIntegerMap.put("5", 43);
        stringIntegerMap.put("6", 5);
        stringIntegerMap.put("7", 4);
        stringIntegerMap.put("8", 65);
        Map<String, String> newStringMap = stringRepresentationNumberMultiplied2(stringIntegerMap);
        System.out.println(newStringMap);

//       7. HashMap<Integer, List<String>>: Создайте второй HashMap<Integer, Integer>, где каждый ключ - это ключ из
//        исходного HashMap, а значение - общее количество символов во всех строках списка этого ключа.
        System.out.println(str);
        Map<Integer, Integer> lengthListStrings = new HashMap<>();
        lengthListStrings = valueLengthStrings(str);
        System.out.println(lengthListStrings);

//        8 HashMap<Integer, Integer>: Найдите все пары ключ-значение, где ключ минус значение является простым числом.
        System.out.println(numbers);
        findingSubtractionKeyValue(numbers);

//        9 HashMap<String, String>: Определите, можно ли преобразовать HashMap в List<String>, где каждый элемент -
//        это конкатенация ключа и значения, так, чтобы все элементы списка были уникальными.
        List<String> concatenationStrings = keyValueConcatenation(stringMap);
        System.out.println(concatenationStrings);

//        10 HashMap<String, Integer> и HashMap<Integer, List<String>>: Для каждого ключа в HashMap<String, Integer>
//        найдите соответствующие строки в HashMap<Integer, List<String>>, где ключ во втором HashMap - это значение из
//        первого, и выведите их.
        Map<String, Integer> stringIntegerMap1 = new HashMap<>();
        stringIntegerMap1.put("Anna", 1);
        stringIntegerMap1.put("E", 2);
        stringIntegerMap1.put("Cing", 3);
        stringIntegerMap1.put("Dima", 3);
        stringIntegerMap1.put("Kira", 5);
        stringIntegerMap1.put("F", 6);
        stringIntegerMap1.put("J", 7);
        Map<Integer, List<String>> stringMap1 = new HashMap<>();
        stringMap1.put(7, Arrays.asList("Liubov", "Anna", "Katya"));
        stringMap1.put(6, Arrays.asList("Kola", "Pepsi", "Fanta"));
        stringMap1.put(5, Arrays.asList("Liubov", "Nadya", "Katya"));
        stringMap1.put(4, Arrays.asList("Kris", "Dascha", "Kola"));
        stringMap1.put(3, Arrays.asList("Liuba", "Dima", "Andrey"));
        stringMap1.put(2, Arrays.asList("E", "Anna", "Katya"));
        stringMap1.put(1, Arrays.asList("Ludmila", "Anna", "Kira"));
        metod(stringIntegerMap1, stringMap1);

    }

    //10
    public static void metod(Map<String, Integer> stringIntegerMap, Map<Integer, List<String>> integerListMap) {
        for (Map.Entry<String, Integer> map : stringIntegerMap.entrySet()) {
            for (Map.Entry<Integer, List<String>> intMap : integerListMap.entrySet()) {
                if ((map.getValue() == intMap.getKey()) && (checkForIdenticalLines(map.getKey(), intMap.getValue()))) {
                    System.out.println(map + " and " + intMap);
                }
            }
        }
    }

    public static boolean checkForIdenticalLines(String str, List<String> stringList) {

        for (String listStr : stringList) {
            if (str.equals(listStr)) {
                return true;
            }
        }
        return false;
    }

    //9
    public static List<String> keyValueConcatenation(Map<String, String> stringMap) {
        List<String> strings = new ArrayList<>();
        StringBuilder stringBuilder;
        for (Map.Entry<String, String> map : stringMap.entrySet()) {
            stringBuilder = new StringBuilder(map.getKey() + map.getValue());
            strings.add(stringBuilder.toString());
        }
        return strings;
    }

    //8
    public static void findingSubtractionKeyValue(Map<Integer, Integer> integerMap) {
        String length;
        for (Map.Entry<Integer, Integer> map : integerMap.entrySet()) {
            length = String.valueOf(map.getKey() - map.getValue());
            if (length.length() == 1) {
                System.out.println(map.getKey() + " and " + map.getValue());
            }
        }
    }

    //7
    public static Map<Integer, Integer> valueLengthStrings(Map<Integer, List<String>> integerListMap) {
        Map<Integer, Integer> newValueStringsLeugth = new HashMap<>();
        for (Map.Entry<Integer, List<String>> map : integerListMap.entrySet()) {
            int length = lengthAllStrings(map.getValue());
            newValueStringsLeugth.put(map.getKey(), length);
        }
        return newValueStringsLeugth;
    }

    public static int lengthAllStrings(List<String> stringList) {
        int length = 0;
        for (String str : stringList) {
            length += str.length();
        }
        return length;
    }

    //6
    public static Map<String, String> stringRepresentationNumberMultiplied2(Map<String, Integer> stringIntegerMap) {
        Map<String, String> stringMap = new HashMap<>();
        for (Map.Entry<String, Integer> map : stringIntegerMap.entrySet()) {
            String newValue = String.valueOf((map.getValue() * 2));
            stringMap.put(map.getKey(), newValue);
        }
        return stringMap;
    }

    //5
    public static void keyReverseStringValue(Map<String, String> stringMap) {
        for (Map.Entry<String, String> str : stringMap.entrySet()) {
            if (examinationKeyReverseStringValue(str.getKey(), str.getValue())) {
                System.out.println(str);
            }
        }
    }

    public static boolean examinationKeyReverseStringValue(String key, String value) {
        if (key.length() != value.length()) {
            return false;
        }
        char[] keyChar = key.toCharArray();
        char[] valueChar = value.toCharArray();
        for (int i = 0; i < keyChar.length; i++) {
            if (keyChar[i] != valueChar[keyChar.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //    3.
    public static void meaningsThatBeginWithVowel(Map<Integer, List<String>> integerListMap) {
        for (Map.Entry<Integer, List<String>> map : integerListMap.entrySet()) {
            System.out.print("Key " + map.getKey() + " : ");
            checkFirstVowel(map.getValue());

        }

    }

    public static void checkFirstVowel(List<String> stringList) {
        List<String> letterVowel = new ArrayList<>(Arrays.asList("A", "a", "O", "o", "U", "u", "E", "e", "I", "i", "Y", "y"));
        for (String srt : stringList) {
            for (String letter : letterVowel)
                if (srt.startsWith(letter)) {
                    System.out.print(srt + ", ");
                    break;

                }
        }
        System.out.println(" ");
    }

    //2
    public static int sumTheValuesAllKeysLetter(Map<String, Integer> numbers, char letter) {
        int sum = 0;
        for (Map.Entry<String, Integer> numb : numbers.entrySet()) {
            if (numb.getKey().startsWith(String.valueOf(letter))) {
                sum += numb.getValue();

            }
        }
        return sum;
    }

    //4
    public static void maximumKeyValue(Map<Integer, Integer> numbers) {
        int key = 0;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> num : numbers.entrySet()) {
            if (maxValue < num.getValue()) {
                key = num.getKey();
                maxValue = num.getValue();
            }
        }
        System.out.println("Max value = " + maxValue + " and has the key = " + key);

    }

    //1
    public static void keyEqualsVolues(Map<String, String> stringMap) {
        int count = 0;
        for (Map.Entry<String, String> m : stringMap.entrySet()) {
            if (m.getValue().length() == m.getKey().length()) {
                count++;

            }

        }
        System.out.println(count);
    }
}





