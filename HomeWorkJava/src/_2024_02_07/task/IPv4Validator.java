package main.java.org.example._2024_02_07.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверьте, что строка представляет собой корректный IPv4 адрес.
 */
public class IPv4Validator {
    public static boolean isValidIPv4(String input) {

        return false;
    }

    public static void main(String[] args) {
        String ipAddress = "192.168.0.1.txt";
        boolean isValid = isValidIPv4(ipAddress);
        System.out.println("Is valid IPv4 address: " + isValid);
    }
}
