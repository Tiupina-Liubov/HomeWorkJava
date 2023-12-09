package src.homeWork27_11_23.task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
// Реализовать метод, который удаляет все вхождения заданной строки из List<String>.
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
        String str = "apple";
        System.out.println(stringList);
        removeOccurrencesString(stringList, str);
        System.out.println(stringList);

}
    public static void removeOccurrencesString(List<String> stringList, String string) {
        for (int i = 0; i < stringList.size(); ++i) {
            if ((stringList.get(i)).equalsIgnoreCase(string)) {
                stringList.remove(i);
                break;
            }
        }

    }

}
