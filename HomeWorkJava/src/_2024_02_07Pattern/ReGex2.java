package src._2024_02_07Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReGex2 {
    public static void main(String[] args) {
        String str = "Revienta el precio de la tablet con " +
                "una excelente@pantalla.com de 11 pulgadas Xiaomi Redmi Pad " +
                "6: baja 100 euros";

        String regex = "\\w+@\\w+\\.(com|ru)";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("INDEX: " + matcher.start() + " : " + matcher.group());
        }
    }
}
