package src._2023_11_27Collecsion.task6;

import java.util.ArrayList;
import java.util.List;

public class task6 {
    public static void main(String[] args) {

//      Составить метод, который объединяет все строки из List в одну большую строку.
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
        String concatenatesStrList = concatenatesStrings(stringList);
        System.out.println(concatenatesStrList);
}
    public static String concatenatesStrings(List<String> stringList) {
        StringBuilder resultStringBuilder = new StringBuilder();
        if (stringList.size() == 0) {
            System.out.println("Not string");
        } else {
            for (String str : stringList) {
                resultStringBuilder.append(str).append(" ");
            }
        }
        String finishString = resultStringBuilder.toString();
        return finishString;
    }
}
