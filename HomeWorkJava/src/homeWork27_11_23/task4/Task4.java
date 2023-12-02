package homeWork27_11_23.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int x = 18;
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(1);
        int[] numbers = new int[]{17, 1, 2, 2, 4, 3, 3, 3};
        //  Дан массив/коллекция. Удалить все дубликаты из массива/коллекции.
        System.out.println(Arrays.toString(numbers));
        removingDuplicates(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayList);
        removingDuplicates(arrayList);
        System.out.println(arrayList);
    }
    public static void removingDuplicates(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            for (int j = i + 1; j < numbers.size(); ++j) {
                if (numbers.get(i) == numbers.get(j)) {
                    numbers.set(j, 0);
                }
            }
        }

    }

    public static void removingDuplicates(int[] number) {
        for (int i = 0; i < number.length - 1; ++i) {
            for (int j = i + 1; j < number.length; ++j) {
                if (number[i] == number[j]) {
                    number[j] = 0;
                }
            }
        }

    }
}
