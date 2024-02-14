package main.java.org.example._2024_02_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReGex1 {
    public static void main(String[] args) {
        String str = "AeAweADDD AGAG_AD@ADA ABCABACD QA*----CD5ACN";
//        String regex = "AD";
//        String regex = "[AD]";
//        String regex = "A[DBG]A";
//        String regex = "A[A-Za-z]A";
//        String regex = "D[0-9]A";
//        String regex = "D[^0-9]A";
//        String regex = "D(@|e)A";
//        String regex = "AB..";
//        String regex = "^AB";
//        String regex = "\\D";
//        String regex = "A\\W+";
//        String regex = "\\w+";
//        String regex = "\\w{4}";
        String regex = "\\D{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("INDEX: " + matcher.start() + " : " + matcher.group());
        }
    }
}
