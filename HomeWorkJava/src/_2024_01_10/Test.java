package src._2024_01_10;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> stringList= new ArrayList<>();
        stringList.add("qw");
        stringList.add("qqw");
        stringList.add("errw");
        stringList.add("qttw");
        stringList.add("qwyuu");
        String str= Stream.joinByComma(stringList);
        System.out.println(str);
        System.out.println(Stream.countContainingChar(stringList,'q'));

    }
}
