package src._2024_02_07.task;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {
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
