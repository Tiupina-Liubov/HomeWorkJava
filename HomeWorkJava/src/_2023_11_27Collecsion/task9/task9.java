package src._2023_11_27Collecsion.task9;

import java.util.ArrayList;
import java.util.List;

public class task9 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("orange");
        stringList.add("orange");
        stringList.add("orange");
        stringList.add("kivi");
        stringList.add("mango");
        stringList.add("mango");
        stringList.add("mango");
        stringList.add("mango");
        stringList.add("mango");
//        Разработать метод, который возвращает новый List, содержащий только уникальные элементы из исходного списка строк.
        System.out.println(stringList);
        List<String> uniqueStrings = returnUniqueStrings(stringList);
        System.out.println(uniqueStrings);
    }
    public static List<String> returnUniqueStrings(List<String> strings) {
        List<String> uniqueStrings = new ArrayList<>();
        for (String str : strings) {
            if (!uniqueStrings.contains(str)) {
                uniqueStrings.add(str);
            }
        }
        return uniqueStrings;
    }

}
