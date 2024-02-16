package src._2024_02_07Pattern.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Найдите все строковые литералы в коде Java,
 * заключенные в двойные кавычки, исключая символы экранирования.
 */
public class StringLiteralFinder {
    public static List<String> findStringLiterals(String input) {
        List<String> stringLiterals = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"((\\\\\"|[^\"])+)\"");
        Matcher matcher =pattern.matcher(input);
        matcher.results()
                .map(MatchResult::group)
                .forEach(stringLiterals::add);

        return stringLiterals;
    }

    public static void main(String[] args) {
        String code = "String message = \"Hello, world!\";\n" +
                      "String path = \"C:\\\\Program Files\\\\Java\";";
        List<String> stringLiterals = findStringLiterals(code);
        for (String literal : stringLiterals) {
            System.out.println(literal);
        }
    }

    public static class Test {
        public static final Random RANDOM = new Random();

        public static void main(String[] args) {
            String cardNumber= validCardNumber();
            System.out.println(cardNumber);
        }

        public static String validCardNumber() {
            int[] numbers = new int[16];

            for (int i = 0; i < 16; i++) {
                numbers[i] = RANDOM.nextInt(10);
            }
            if (!isValidCardNumber(numbers)) {
             return validCardNumber();
            }
            return numbersToString(numbers);
        }


        public static String numbersToString(int[] numbers) {
            StringBuilder newString = new StringBuilder();

            for (int i = 0; i < numbers.length; i++) {
                newString.append(numbers[i]);
            }

            return newString.toString();
        }


        public static boolean isValidCardNumber(int[] numbers) {
            long sum = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (i % 2 == 0) {

                    int temp = numbers[i] * 2;

                    if (temp > 9) {
                        temp -= 9;
                        sum += temp;
                    } else {
                        sum += temp;
                    }

                } else {
                    sum += numbers[i];
                }
            }

            return sum % 10 == 0;
        }
    }
}
