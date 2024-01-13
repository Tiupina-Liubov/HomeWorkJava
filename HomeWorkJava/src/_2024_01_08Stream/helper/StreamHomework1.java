package src._2024_01_08Stream.helper;

import java.util.*;

public class StreamHomework1 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Просуммировать все числа");

        int sum = numbers.stream()
                .reduce(Integer::sum)
                .get();

        System.out.println(sum);
        System.out.println("Отфильтровать на четные или не четные");

        List<Integer> numEven = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();

        System.out.println(numEven);
        System.out.println("Найти суммы чисел кратных 3 и 5");

        Optional<Integer> sum1 = numbers.stream().map(num -> {
                    if (num % 3 == 0 && num % 5 == 0) {
                        return num;
                    }
                    return null;
                }).filter(Objects::nonNull)
                .reduce(Integer::sum);

        System.out.println(sum1);
        System.out.println("Получить среднее значение");

        double ave = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println(ave);
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println("Преобразовать список строк в список чисел \n" + strings);

        List<Integer> integerList = strings.stream()
                .map(Integer::parseInt)
                .toList();

        System.out.println(integerList);
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        System.out.println(words + "\nОтфильтровать строки на те которые начинаются на 'a' и преобразовать из в верхний регистр");

        List<String> wordsA = words.stream()
                .filter("a"::startsWith)
                .map(String::toUpperCase).toList();

        System.out.println(wordsA);
        System.out.println("Получить список слов которые содержат только уникальные символы");

        List<String> uniqueSymbols = words.stream()
                .filter(w -> w.chars().distinct().count() == w.length())
                .toList();

        System.out.println(uniqueSymbols);
        System.out.println(numbers + "\nЗадание 1: Фильтрация списка целых чисел на нечетные числа");
        List<Integer> oddNum = filteringOddNumbers(numbers);
        System.out.println(oddNum);

        System.out.println("Задание 2: Преобразование списка строк в список чисел");
        List<Integer> integers = m2(strings);
        System.out.println(integers);

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Суммирование списка чисел");
        int n = m3(num);
        System.out.println(n);

        System.out.println("Получение списка уникальных слов из списка строк, длина которых больше 4 символов");
        List<String> list = m4(words, 3);
        System.out.println(list);

        System.out.println("Преобразование списка объектов класса в список их имен, отсортированных по возрасту");
        List<Person> people = Arrays.asList(new Person("John", 25), new Person("Alice", 22), new Person("Bob", 30));
        List<String> nameSortBuAge = displayingPeoplesNamesByAge(people);
        System.out.println(nameSortBuAge);

        System.out.println("Нахождение суммы чисел, кратных 3 и 5, из списка чисел");
        int sumNumbersMultiples3And5 = findingSumNumbersMultiples3And5(numbers);
        System.out.println(sumNumbersMultiples3And5);

        System.out.println("Получение списка слов, содержащих только уникальные символы, из списка строк");
        List<String> wordsUniqueCharacters = returnWordsUniqueCharacters(words);
        System.out.println(wordsUniqueCharacters);


    }

    private static List<Integer> filteringOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0).toList();
    }

    private static List<Integer> m2(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static int m3(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::sum)
                .get();
    }

    private static List<String> m4(List<String> strings, int length) {
        return strings.stream()
                .filter(str -> str.length() > length)
                .distinct()
                .toList();
    }

    public static List<String> displayingPeoplesNamesByAge(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparingInt(p -> p.age))
                .map(Person::getName).toList();

    }

    public static int findingSumNumbersMultiples3And5(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .reduce(Integer::sum)
                .get();
    }

    public static List<String> returnWordsUniqueCharacters(List<String> words) {
        return words.stream()
                .filter(str -> str.chars().distinct().count() == str.length())
                .toList();
    }
}

