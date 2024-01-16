package src.Stream_15_01_24;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsAndCollectionsTasks {

    public static void main(String[] args) {
        // Задача 1: Собрать элементы потока в список.
        List<Integer> integerList = Stream.of(1, 2, 3, 6, 8, 7, 7, 7, 8, 0, 0, 11, 9, 0, 1, 4, 6)
                .collect(Collectors.toList()); //.toList;
        System.out.println(integerList);
        // Задача 2: Удалить дубликаты из списка и собрать их в множество.
        Set<Integer> integers = integerList.stream()
                .collect(Collectors.toSet());// kak to po drugomu
        System.out.println(integers);
        // Задача 3: Группировка строк по длине.
        Map<Integer, List<String>> integerStringMap = Stream.of("Liubov", "Katya", "Sascha", "Kolja", "Petja", "Max", "Petja", "Petja", "Petja")
                .collect(Collectors.groupingBy(String::length));
        System.out.println(integerStringMap);

        // Задача 4: Подсчет повторяющихся элементов и создание мапа.
        Map<Integer, Long> integerIntegerMap = integerList.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        // Задача 5: Собрать только уникальные элементы в список.
        Set<Integer> stringSet = integerList.stream()
                .collect(Collectors.toSet());
        List<String> strings = Stream.of("Liubov", "Katya", "Sascha")
                .toList();

        // Задача 6: vernut string максимальной длиной.
        Optional<String> str = strings.stream()
                .max(Comparator.comparingInt(String::length));

        // Задача 7: Разбиение строки на символы и сбор их в множество.
        System.out.println(strings);
        Set<Character> characters = strings.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(characters);

        // Задача 8: Построение кастомной мапы из элементов.
        List<Integer> list = Stream.of(1, 2, 3, 4)
                .toList();
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(i -> i, String::valueOf));

        // Задача 9: Подсчет суммы значений объектов.
      List<Person>peoples= GeneratorPerson.generatPerson(5);
        System.out.println(peoples);
       long sum= peoples.stream()
                .collect(Collectors.summarizingInt(Person::getAge))
               .getSum();
        System.out.println(sum);
        // Задача 10: Группировка по критерию и подсчет среднего.



    }

}