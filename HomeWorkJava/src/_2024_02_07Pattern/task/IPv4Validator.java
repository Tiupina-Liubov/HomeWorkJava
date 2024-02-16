package src._2024_02_07Pattern.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверьте, что строка представляет собой корректный IPv4 адрес.
 */
public class IPv4Validator {
    public static boolean isValidIPv4(String input) {
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(ipv4Regex);
        Matcher matcher= pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String ipAddress = "192.168.0.1.txt";
        boolean isValid = isValidIPv4(ipAddress);
        System.out.println("Is valid IPv4 address: " + isValid);
    }
}
