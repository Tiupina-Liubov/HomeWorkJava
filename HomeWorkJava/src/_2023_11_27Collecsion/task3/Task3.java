package src._2023_11_27Collecsion.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
//        Дан массив/коллекция целых чисел. Необходимо переставить элементы массив/коллекции в обратном порядке.
        ArrayList<Integer> arrayList = new ArrayList<>();
        int x = 18;
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(1);
        int[] numbers = new int[]{17, 1, 2, 2, 4, 3, 3, 3};
        System.out.println(Arrays.toString(numbers));
        sortReverse(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayList);
        sortReverse(arrayList);
        System.out.println(arrayList);
        System.out.println("______");
        System.out.println(Arrays.toString(numbers));
        sortBubbleReverse(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayList);
        sortBubbleReverse(arrayList);
        System.out.println(arrayList);
    }
    public static void sortReverse(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); ++i) {
            int j = arrayList.size() - 1 - i;
            if (j > i) {
                int temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
            }
        }

    }

    public static void sortReverse(int[] numbers) {
        for (int i = 0; i < numbers.length; ++i) {
            int j = numbers.length - 1 - i;
            if (j > i) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

    }

    public static void sortBubbleReverse(ArrayList<Integer> numbers) {
        for (int j = 0; j < numbers.size(); ++j) {
            for (int i = 1 + j; i < numbers.size(); ++i) {
                if (numbers.get(j) < numbers.get(i)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }

    }

    public static void sortBubbleReverse(int[] numbers) {
        for (int j = 0; j < numbers.length; ++j) {
            for (int i = 1 + j; i < numbers.length; ++i) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

    }
}
