package src.dryKissYagni.taskiFinisch;//package PROF.dryKissYagni;

import src.dryKissYagni.taskiFinisch.User;
import java.util.List;
import java.util.function.ToIntFunction;

public class ProcessDate {
    // Нарушение DRY: Дублирование кода
    public void processNumberDate(List<Integer> numbers) {
        int sum = getSum(numbers,Integer::intValue);
        double average = getAverage(numbers,Integer::intValue);

        System.out.println("Sum: " + sum + "\nAverage: " + average);
    }

    public void processUserData(List<User> users) {
        int totalAge = getSum(users,User::getAge);
        double averageAge = getAverage(users,User::getAge);

        System.out.println("Total Age: " + totalAge +"\nAverage Age: " + averageAge);
    }

    private <T> int getSum (List<T> list, ToIntFunction <? extends T> function) {
        return list.stream()
                .mapToInt((ToIntFunction<? super T>) function)
                .sum();
    }
    private <T> double getAverage (List<T> list, ToIntFunction <? extends T> function) {
        return list.stream()
                .mapToInt((ToIntFunction<? super T>) function)
                .average()
                .orElse(0);
    }
}

