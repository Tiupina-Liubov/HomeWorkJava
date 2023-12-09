package homeWork27_11_23.task7;

import java.util.ArrayList;
import java.util.List;

public class task7 {
    public static void main(String[] args) {

//       Дан List 1,написать метод который создает List 2, содержащий только те числа из List 1, которые больше заданного значения.
        ArrayList<Integer> arrayList = new ArrayList<>();
        int x = 18;
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(1);
        List<Integer> higherValue = valueGreater(arrayList, 3);
        System.out.println(arrayList);
        System.out.println(higherValue);
    }
    public static List<Integer> valueGreater(List<Integer> numberList, int number) {
        List<Integer> valueNumbers = new ArrayList();
        for (int i = 0; i < numberList.size(); ++i) {
            if (numberList.get(i) > number) {
                valueNumbers.add(numberList.get(i));
            }
        }
        return valueNumbers;
    }
}
