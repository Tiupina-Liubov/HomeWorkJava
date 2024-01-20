package src._2024_01_17;

import com.github.javafaker.Faker;
import src._2024_01_17.Clases.*;

import java.util.*;

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
        List<Integer> integerList = StreamFlatMap.flattenListOfLists(list);
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
        List<String> strings = StreamFlatMap.getAllSkills(listUser);
        System.out.println(strings);

        //3. Напишите метод, который объединяет строки из списка объектов.
        List<Book> listBook = List.of(
                new Book(FAKER.book().title(), List.of(
                        FAKER.book().author(),
                        FAKER.book().author(),
                        FAKER.book().author()
                )),
                new Book(FAKER.book().title(), List.of(
                        FAKER.book().author(),
                        FAKER.book().author(),
                        FAKER.book().author()
                )),
                new Book(FAKER.book().title(), List.of(
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
        List<List<Integer>> listOfLists = Generator1.generListOfLists(4, 3);
        System.out.println(listOfLists);
        System.out.println(StreamFlatMap.processAndFilter(listOfLists));


        //6. Преобразование и фильтрация объектов в списках
        //Задание: Напишите метод, который фильтрует список объектов по некоторому условию,// todo nado dodelat
        //а затем извлекает и объединяет определённые атрибуты этих объектов в один список.
        List<Employee> employees = Generator1.genListEmployees(3);
        System.out.println(employees);

        //7: Напишите метод, который принимает список списков списков чисел и преобразует его в один список чисел.
        List<List<List<Integer>>> deepList = Generator1.genList2OfList(2, 3, 2);
        System.out.println(deepList);
        System.out.println(StreamFlatMap.flattenDeepListOfLists(deepList));

        //8: Напишите метод, который принимает список объектов с вложенными коллекциями,
        //сортирует вложенные элементы и возвращает отсортированный список всех элементов.
        List<Project> projects = Generator1.genListProjects(6);
        System.out.println(projects);
        StreamFlatMap.getSortedTasks(projects);

        // 9: Напишите метод, который преобразует карту, где ключи - это строки, а значения -
        //списки объектов, в один список уникальных строк, извлечённых из атрибутов объектов.
        Map<String, List<Product>> categoryMap = Generator1.gencategoryMap(3, 3);
        System.out.println(categoryMap);
        System.out.println(StreamFlatMap.getUniqueProductNames(categoryMap));

        // 10: Напишите метод, который объединяет данные из нескольких списков и
        //преобразует их в один список, применяя к каждому элементу определённую функцию.
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Double> doubles = List.of(1.2, 2.3, 3.4, 5.6, 7.8, 9.0);
        System.out.println(StreamFlatMap.combineAndTransform(integers, doubles, String::valueOf));

//11: Обработка вложенных структур с условными фильтрами
//Задание: Напишите метод, который обрабатывает вложенные структуры данных
//(например мапы, содержащих списки), фильтрует элементы по условию и объединяет их в один список.
        List<Order>orders= Generator1.genOrdersList(3);
        System.out.println(orders);
        System.out.println(StreamFlatMap.getItemsByCustomerName(orders, orders.get(1).getCustomerName()));

        //12: Напишите метод, который объединяет данные из вложенных коллекций разных объектов и считает сумму некоторого числового атрибута.
        List<Department> departments=Generator1.genDepartmentsList(3);
        System.out.println(departments);
        System.out.println(StreamFlatMap.getTotalSalaryByDepartment(departments,departments.get(2).getName()));

    }

}
