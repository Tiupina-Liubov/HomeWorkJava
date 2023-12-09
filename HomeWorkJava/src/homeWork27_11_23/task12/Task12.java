package homeWork27_11_23.task12;

import java.util.ArrayList;
import java.util.List;

public class Task12 {
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
        System.out.println(stringList);
        enumerationElementsList(stringList);
        System.out.println(stringList);
    }
    public static String enumerationElementsList(List<String> stringList) {
        StringBuilder resultStringBuilder = new StringBuilder();
        if (stringList.size() == 0) {
            System.out.println("Not string");
        } else {
            for (int i = 0; i < stringList.size(); i++) {
                if (stringList.size() == i) {
                    resultStringBuilder.append(i);
                }
                resultStringBuilder.append(i).append(", ");
            }
        }
        String finishString = String.valueOf(resultStringBuilder);
        return finishString;
    }
}
