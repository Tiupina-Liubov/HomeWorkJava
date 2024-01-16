package src._2024_01_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        System.out.println(strings + "\nФильтрация списка строк по длине.");
        System.out.println(Stream.filterByLength(strings, 6));
        System.out.println("Преобразование всех строк в верхний регистр");
        System.out.println(Stream.toUpperCase(strings));
        System.out.println("Поиск первой строки, начинающейся на заданную букву");
        System.out.println(Stream.findFirstStartingWith(strings, 'c'));
        System.out.println("Соединение строк через запятую");
        System.out.println(Stream.joinByComma(strings));
        System.out.println("Подсчёт количества строк, содержащих заданный символ");
        System.out.println(Stream.countContainingChar(strings, 'q'));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 14, 8, 9, 7, 28, 9, 13);
        System.out.println("Найти сумму всех чисел в списке\n" + numbers);
        System.out.println(Stream.sumOfList(numbers));
        System.out.println("Получить список квадратов чисел");
        System.out.println(Stream.getSquares(numbers));
        System.out.println("Фильтрация чисел, больших заданного значения - 10");
        System.out.println(Stream.filterGreaterThan(numbers, 10));
        System.out.println("Проверка, содержит ли список заданное число - 18");
        System.out.println(Stream.containsNumber(numbers, 18));
        System.out.println("Найти максимальное число в списке\n" + numbers);
        System.out.println(Stream.findMax(numbers));
        List<Character> characterList = Arrays.asList('a', 'B', 'c', 'c', 'F', 'g', 'v', 'q');
        System.out.println("Преобразование списка символов в список строк \n" + characterList);
        System.out.println(Stream.convertToStringList(characterList));
        System.out.println("Фильтрация символов по ASCII-значению.");
        System.out.println(Stream.filterByAsciiValue(characterList, 'c'));
        System.out.println("Проверка, все ли символы в списке заглавные");
        System.out.println(Stream.areAllUpperCase(characterList));
        System.out.println("Найти первый повторяющийся символ");
        System.out.println(Stream.findFirstDuplicate(characterList));
        System.out.println("Получить обратный список символов.");
        System.out.println(Stream.reverseList(characterList));
        List<Float> floatList = Arrays.asList(1.1f, 2.9f, 3.0f, 0.001f, -0.03f);
        List<Float>floatList1=Arrays.asList(0.0f,1.0f,1.1f,2.0f);
        System.out.println("Найти минимальное число в списке \n" + floatList);
        System.out.println(Stream.findMin(floatList));
        System.out.println("Получить список чисел, умноженных на заданное число <5>");
        System.out.println(Stream.multiplyBy(floatList, 5));
        System.out.println("Отфильтровать числа, меньшие заданного значения <2.5>");
        System.out.println(Stream.filterLessThan(floatList, 2.5F));
        System.out.println("Проверить, содержит ли список отрицательные числа");
        System.out.println(Stream.containsNegative(floatList));
        System.out.println("Округление всех чисел в списке до ближайшего целого");
        System.out.println(Stream.roundNumbers(floatList));
        System.out.println("Найти количество уникальных элементов в списке.");
        System.out.println(Stream.countUnique(floatList));
        System.out.println("Определить, является ли список отсортированным.");
        System.out.println(floatList);
        System.out.println(Stream.isSorted(floatList));
        System.out.println(floatList1);
        System.out.println(Stream.isSorted(floatList1));
        System.out.println("Получить последний элемент списка, если он существует " + characterList);
        System.out.println(Stream.getLastElement(characterList));
        System.out.println("Перемешать элементы списка.");
        System.out.println(Stream.shuffleList(characterList));
        System.out.println("Подсчитать частоту каждого элемента в списке");
        Map<Character, Long> number = Stream.countFrequency(characterList);
        for (Map.Entry<Character, Long> m : number.entrySet()) {
            System.out.println("Character " + m.getKey() + " количество повторений в списке = " + m.getValue());
        }


    }
}
