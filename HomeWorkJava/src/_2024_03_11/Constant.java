package src._2024_03_11;

import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Constant {

    public static String getKaprykarConstant(String number) throws IllegalArgumentException {

        Set<String> setHistory = new HashSet<>();

        if ((number.length() < 3) || (number == null)) {
            throw new IllegalArgumentException();
        }

        int result = 0;
        int temp;
        String str = number;

        do {
            boolean add = setHistory.add(str);

            if (add) {
                StringBuilder string = new StringBuilder();
                temp = result;
                char[] cars = str.toCharArray();
                Arrays.sort(cars);

                for (Character c : cars) {
                    string.append(c);
                }

                String ink = String.valueOf(string);
                String dek = String.valueOf(string.reverse());
                result = Integer.parseInt(dek) - Integer.parseInt(ink);
                str = String.valueOf(result);

            } else {
                System.out.println("This number has no constant ");
                return String.valueOf(0);

            }

        } while (temp != result);

        return String.valueOf(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find a constant - ");
        String str = scanner.nextLine();
        System.out.println(Constant.getKaprykarConstant(str));
    }
}
