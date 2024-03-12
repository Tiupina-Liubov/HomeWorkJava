package src._2024_03_11;

import java.util.Arrays;
import java.util.Scanner;

public class Constant {

    public static String getKaprykarConstant(String number) throws IllegalArgumentException{

        if((number.length() < 3) || (number == null)){
          throw new  IllegalArgumentException();
        }
        int result = 0;
        int temp;
        String str = number;
        do {
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

        } while (temp != result);

        return String.valueOf(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find a constant - " );
        String str= scanner.nextLine();
        System.out.println(Constant.getKaprykarConstant(str));
  }
}
