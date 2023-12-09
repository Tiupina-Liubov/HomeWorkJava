package src.homeWork27_11_23.task8;

import java.util.ArrayList;
import java.util.List;

public class Task8 {
    public static void main(String[] args) {
//         Написать метод, который преобразует List<String> в List<Integer>, представляющих длину каждой строки.
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
        List<Integer> lengthLine = lengthStrings(stringList);
        System.out.println(lengthLine);
    }
    public static List<Integer> lengthStrings(List<String> strings) {
        List<Integer> lengths = new ArrayList();
        for (int i = 0; i < strings.size(); ++i) {
            int length = (strings.get(i)).length();
            lengths.add(length);
        }
        return lengths;
    }
}
