package src.homeWork27_11_23.task13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task13 {
    public static void main(String[] args) {
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 5, 3, 4, 5, 6, 1, 6, 8, 9, 10, 56, 100, 4));
        int sum = findingSum(numbers1);
        System.out.println(sum);
        double median = findingMedian(numbers1);
        System.out.println(median);
        findingAverageMedianStandardDeviation(numbers1);
    }
    public static void findingAverageMedianStandardDeviation(List<Integer> numbers) {
        int sum = findingSum(numbers);
        double median = findingMedian(numbers);
        int length = numbers.size();
        double average = sum / length;
        float dispersion = 0.0F;
        double standardDeviation;
        for (int i = 0; i < numbers.size(); ++i) {
            float dispNum = (float) Math.pow((numbers.get(i) - average), 2.0);
            dispersion += dispNum;
        }
        dispersion = dispersion / (float) length - 1.0F;
        standardDeviation = Math.sqrt(dispersion);
        System.out.println("Mean = " + average + "\nMedian =" + median + "\nStandard deviation =" + standardDeviation);
    }

    public static double findingMedian(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
        double median;
        if (numbers.size() % 2 == 0) {
            int index = numbers.size() / 2;
            median = (numbers.get(index) + numbers.get(index + 1)) / 2;
        } else {
            median = numbers.get(numbers.size() / 2);
        }
        return median;
    }

    public static int findingSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); ++i) {
            sum += numbers.get(i);
        }
        return sum;
    }
}
