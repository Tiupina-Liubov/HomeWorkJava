package src._2024_02_26Mnogopotochyjcn;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MT1 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= 10000; i++) {
            numbers.add(i);
        }

        T1 T1 = new T1(numbers, 0, 2499);
        T1 T2 = new T1(numbers, 2500, 4999);
        T1 T3 = new T1(numbers, 5000, 7499);
        T1 T4 = new T1(numbers, 7500, 10000);

        T1.start();
        T2.start();
        T3.start();
        T4.start();
        T4.join();
        T1.join();
        T3.join();
        T2.join();

        long sum = T1.getSum() + T2.getSum() + T3.getSum() + T4.getSum();
        System.out.println("sum of all Threads = " + sum);
    }
}
    class T1 extends Thread {
        private List<Integer> numbers;
        private int start;
        private int end;
        @Getter
        private long sum;

        public T1(List<Integer> numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                sum += numbers.get(i);
            }
            System.out.println("T1 sum from " + start + " to " + end + " = " + sum);
        }
    }

