package homeWork27_11_23.task10;

import java.util.ArrayList;
import java.util.List;

public class Task10 {
    public static void main(String[] args) {
//       Реализовать метод, который удаляет из List<String> те элементы, длина которых меньше заданного числа символов.
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
        System.out.println(stringList);

        removeSpringLengthFeatures(stringList, "asfgv");
        System.out.println(stringList);
    }
    public static void removeSpringLengthFeatures(List<String> stringList, String str) {
        for (int i = 0; i < stringList.size(); ++i) {
            if ((stringList.get(i)).length() < str.length()) {
                stringList.remove(i);
                --i;
            }
        }

    }
}
