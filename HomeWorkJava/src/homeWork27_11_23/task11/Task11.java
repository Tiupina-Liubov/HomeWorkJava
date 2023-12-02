package homeWork27_11_23.task11;

import java.util.ArrayList;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
//        Разработать метод, который создает List, содержащий первые уникальные элементы исходного List до первого повторения.
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
        List<String> firstElement=firstUniqueElements(stringList);
        System.out.println(firstElement);
    }
    public static List<String> firstUniqueElements(List<String> stringList){
        List<String> listFirstUniqueElements=new ArrayList<>();
        for(String str: stringList){
            if(!listFirstUniqueElements.contains(str)){
                listFirstUniqueElements.add(str);
            }else {
                break;
            }
        }
        return listFirstUniqueElements;
    }
}
