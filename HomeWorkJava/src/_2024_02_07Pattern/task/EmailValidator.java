package src._2024_02_07Pattern.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверьте, что строка представляет
 * собой корректный адрес электронной почты (email).
 */
public class EmailValidator {
    public static boolean isValidEmail(String input) {
        String regex = "\\w+@\\w+\\.(com|ru|de)";// Можно перечислить все доступные доменны
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String email = "user@example.com";
        boolean isValid = isValidEmail(email);
        System.out.println("Is valid email address: " + isValid);
    }
}
