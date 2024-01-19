package src._2024_01_17;

import src._2024_01_17.Clases.Product;
import src._2024_01_17.Clases.Project;
import src._2024_01_17.Clases.User;

import java.util.*;

public class FlatMapExample {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("mama", "myla", "ramu");
        List<String> characters = words.stream()
                .flatMap(str -> Arrays.stream(str.split("")))
                .filter(el -> el.equals("m"))
                .toList();

//      System.out.println(characters);

        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6),
                Arrays.asList(7, 8),
                Arrays.asList(9, 10)
        );
        List<Integer> integerList=StreamFlatMap.flattenListOfLists(list);
        System.out.println(integerList);

//        list.stream()
//                .flatMap(Collection::stream)
//                .filter(n -> n % 2 == 0)
//                .forEach(System.out::println);

        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<Integer> listB = Arrays.asList(4, 5, 6);

        listA.stream() // 1 2 3
                .flatMap(numA -> listB.stream().map(numB -> numA + numB))
                .forEach(System.out::println);

        List<User> listUser = Arrays.asList(
                new User("Lana", Arrays.asList("Lana", "Lara")),
                new User("Tom", Arrays.asList("Tom", "Sara")),
                new User("Artur", Arrays.asList("Artur", "Lara")));

        Map<String, List<String>> map1 = new HashMap<>();
        map1.put("Собака", Arrays.asList("Зубы", "Хвост"));
        map1.put("Кошка", Arrays.asList("Когти", "Зрачки"));
        map1.put("Корова", Arrays.asList("Рога", "Молоко"));
        map1.put("Лошадь", Arrays.asList("Копыта", "Мощь"));

        System.out.println(StreamFlatMap.flattenMap(map1));

        List<Project> projects = new ArrayList<>();
        projects.add(new Project("CW Projekt", Arrays.asList("Work", "CashOut")));
        projects.add(new Project("Discord", Arrays.asList("Call", "Talk")));
        projects.add(new Project("TelRan", Arrays.asList("Learn", "WorkTogether")));
        System.out.println(StreamFlatMap.getSortedTasks(projects));

        Map<String, List<Product>> category = new HashMap<>();
        category.put("Key1", List.of(new Product("ContainsMilk", "Milk",2.45)));
        category.put("Key2", List.of(new Product("Meat/Fish", "Salmon",9.7)));
        category.put("Key3", List.of(new Product("Drinks", "CocaCola", 1.5)));
        category.put("Key4", List.of(new Product("Snacks", "Mini-Snickers",0.99)));


    }
}
