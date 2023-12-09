package src.homeWork27_11_23.task14;

import java.util.ArrayList;
import java.util.List;

public class Task14 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList();
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
        List<String> repeatingLine= returnRowsGreaterGivenNumber(stringList,2);
        System.out.println(repeatingLine);

    }
    public static List<String> returnRowsGreaterGivenNumber(List<String> stringList, int number) {
        List<String> returnList = new ArrayList<>();

        for(int i = 0; i < stringList.size(); ++i) {
            int temp = 0;

            for(int j = i; j < stringList.size(); ++j) {
                if (((stringList.get(j)).equals(stringList.get(i)))){
                    ++temp;
                }
            }

            if (number < temp) {
                if(!returnList.contains(stringList.get(i))){
                    returnList.add(stringList.get(i));
                }else{
                    break;
                }
            }
        }

        return returnList;
    }
}
