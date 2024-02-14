package main.java.org.example._2024_02_07.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверьте, что строка представляет
 * собой корректный адрес электронной почты (email).
 */
public class EmailValidator {
    public static boolean isValidEmail(String input) {

        return false;
    }

    public static void main(String[] args) {
        String email = "user@example.com";
        boolean isValid = isValidEmail(email);
        System.out.println("Is valid email address: " + isValid);
    }
}
