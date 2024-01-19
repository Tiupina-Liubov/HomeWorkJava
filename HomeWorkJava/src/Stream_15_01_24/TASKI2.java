package src.Stream_15_01_24;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//уровень 7
public class TASKI2 {
    public static void main(String[] args) {
        //Напишите метод, который принимает список чисел и возвращает сумму квадратов всех нечетных чисел в списке.
        List<Integer> integerList= Stream.of(1,2,3,4,5,6,7,8,9,0,11,12)
                .toList();
        int sum=sumOfSquaresOfOddNumbers(integerList);
        System.out.println(sum);

        //Напишите метод, который принимает список строк и возвращает список уникальных слов, отсортированных в лексикографическом порядке.
        List<String>list= Stream.of("Kola","Pepsi","Fanta","Spreit","Kola","Fanta","Apple","Aaple")
                .toList();
        List<String> string= uniqueSortedWords(list);
        System.out.println(string);
//
//        Напишите метод, который принимает список объектов и возвращает новый список, содержащий
//         только объекты, у которых определенное поле имеет заданное значение.


        //Напишите метод, который принимает список строк и возвращает список строк, содержащих
        // только уникальные символы (т.е. символы, которые не повторяются в строке).
        List<String> unigueStr=uniqueChars(list);
        System.out.println(unigueStr);

        //Напишите метод, который принимает список строк и возвращает самую длинную строку в списке.
        String str= longestString(list);
        System.out.println(str);

        //Напишите метод, который принимает список объектов и
        // возвращает среднее значение заданного числового поля всех объектов в списке.



    }

    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n-> n%2!=0)
                .map(n->n*n)
                .reduce(Integer::sum)
                .get();
    }

    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .distinct()
                .sorted()
                .toList();
    }

//    public static <T> List<T> filterByField(List<T> objects, String fieldName, Object value) throws NoSuchFieldException {
//        return objects.stream()
//                  ;
//    }
    public static List<String> uniqueChars(List<String> strings) {
        return strings.stream()
                .filter(s->s.length()==(s.toLowerCase(Locale.ROOT).chars().distinct().count()))
                .collect(Collectors.toList());
    }

    public static String longestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }


    public static <T> double averageFieldValue(List<T> objects, String fieldName) throws NoSuchFieldException {
        return 0;
    }
}
