package src._2024_01_17;

import com.github.javafaker.Faker;
import src._2024_01_17.Clases.Book;
import src._2024_01_17.Clases.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        //1: Напишите метод, который принимает список списков целых чисел
        //и преобразует его в один список

        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6),
                Arrays.asList(7, 8),
                Arrays.asList(9, 10)
        );
        List<Integer> integerList=StreamFlatMap.flattenListOfLists(list);
        System.out.println(integerList);

        // 2. Напишите метод, который преобразует список объектов с вложенными списками в один список всех вложенных элементов.
        //class User {
        //    private String name;
        //    private List<String> skills;
        //}

        List<User> listUser = Arrays.asList(
                new User("Lana", Arrays.asList("Lana", "Lara")),
                new User("Tom", Arrays.asList("Tom", "Sara")),
                new User("Artur", Arrays.asList("Artur", "Lara")));
        List<String> strings=StreamFlatMap.getAllSkills(listUser);
        System.out.println(strings);

        //3. Напишите метод, который объединяет строки из списка объектов.
        List<Book>listBook= List.of(
                new Book( FAKER.book().title(), List.of(
                        FAKER.book().author(),
                        FAKER.book().author(),
                        FAKER.book().author()
                )),
                new Book( FAKER.book().title(), List.of(
                        FAKER.book().author(),
                        FAKER.book().author(),
                        FAKER.book().author()
                        )),
                new Book( FAKER.book().title(), List.of(
                        FAKER.book().author(),
                        FAKER.book().author(),
                        FAKER.book().author()
                )));
        System.out.println(listBook);
        System.out.println(StreamFlatMap.getAuthorsTitles(listBook));

        //4: Напишите метод, который преобразует Map в список значений.
        Map<String, List<String>> map1 = new HashMap<>();
        map1.put("Собака", Arrays.asList("Зубы", "Хвост"));
        map1.put("Кошка", Arrays.asList("Когти", "Зрачки"));
        map1.put("Корова", Arrays.asList("Рога", "Молоко"));
        map1.put("Лошадь", Arrays.asList("Копыта", "Мощь"));
        System.out.println(StreamFlatMap.flattenMap(map1));

        //5: Напишите метод, который принимает список списков и фильтрует все четные числа, а затем умножает их на 2.


        //6. Преобразование и фильтрация объектов в списках
        //Задание: Напишите метод, который фильтрует список объектов по некоторому условию,
        //а затем извлекает и объединяет определённые атрибуты этих объектов в один список.


        //7: Напишите метод, который принимает список списков списков чисел и преобразует его в один список чисел.
    }
}
