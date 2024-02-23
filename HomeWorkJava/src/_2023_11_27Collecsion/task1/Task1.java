package src._2023_11_27Collecsion.task1;

import java.util.ArrayList;



public class Task1 {
    public static void main(String[] args) {
        //  Дан массив/коллекция целых чисел и целое число X. Найти пару чисел в массиве/коллекции, сумма которых равна X.
        ArrayList<Integer> arrayList = new ArrayList<>();
        int x = 18;
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(1);
        int[] numbers = new int[]{17, 1, 2, 2, 4, 3, 3, 3};
        findPainNumber(arrayList, x);
        findPainNumber(numbers, x);
    }
    public static void findPainNumber(ArrayList<Integer> arrayList, int x) {
        for (int i = 0; i < arrayList.size(); ++i) {
            for (int j = i + 1; j < arrayList.size(); ++j) {
                if (arrayList.get(i) + arrayList.get(j) == x) {
                    System.out.println("fine numbers = " + arrayList.get(i) + " and " + arrayList.get(j));
                    break;
                }
            }
        }

    }

    public static void findPainNumber(int[] arrays, int x) {
        for (int i = 0; i < arrays.length; ++i) {
            for (int j = i + 1; j < arrays.length; ++j) {
                if (arrays[i] + arrays[j] == x) {
                    System.out.println("fine numbers = " + arrays[i] + " and " + arrays[j]);
                    break;
                }
            }
        }
    }
}


