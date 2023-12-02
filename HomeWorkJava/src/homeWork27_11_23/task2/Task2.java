package homeWork27_11_23.task2;

import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {

        //  Дан массив/коллекция целых чисел. Необходимо подсчитать, сколько раз каждый элемент встречается в массив/коллекции.
        ArrayList<Integer> arrayList = new ArrayList<>();
        int x = 18;
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(1);
        int[] numbers = new int[]{17, 1, 2, 2, 4, 3, 3, 3};
        numberRepeatingElements(numbers);
        System.out.println("-------------");
        numberRepeatingElements(arrayList);
    }

    public static void numberRepeatingElements(ArrayList<Integer> numbers) {
        int[] repeating = new int[numbers.size()];
        ArrayList<Integer> newNumbers = (ArrayList<Integer>) numbers.clone();

        for (int i = 0; i < numbers.size(); ++i) {
            int temp = 0;

            for (int j = i; j < newNumbers.size(); ++j) {
                if ((Integer) numbers.get(i) != 0 && numbers.get(i) == newNumbers.get(j)) {
                    ++temp;
                    newNumbers.set(j, 0);
                    if (i < repeating.length) {
                        repeating[i] = temp;
                    }
                }
            }

            if (repeating[i] != 0) {
                System.out.println("Number " + numbers.get(i) + " is repeated " + repeating[i] + " times ");
            }
        }

    }

    public static void numberRepeatingElements(int[] numbers) {
        int[] repeating = new int[numbers.length];
        int[] newNumbers = numbers.clone();

        for (int i = 0; i < numbers.length; ++i) {
            int temp = 0;
            for (int j = i; j < newNumbers.length; ++j) {
                if (numbers[i] != 0 && numbers[i] == newNumbers[j]) {
                    ++temp;
                    newNumbers[j] = 0;
                    if (i < repeating.length) {
                        repeating[i] = temp;
                    }
                }
            }
            if (repeating[i] != 0)
                System.out.println("Number " + numbers[i] + " is repeated " + repeating[i] + " times ");
        }


    }
}
