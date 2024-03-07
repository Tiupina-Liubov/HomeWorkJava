package src._2024_02_28;

public class SynchEx1 {
    public static void main(String[] args) {

    }
}

class Counter {
    static long counter = 0;
}

class MRIE implements Runnable {
    public static void increment() {
        Counter.counter++;
        synchronized (MRIE.class) {
            System.out.println("COUNTER: " + Counter.counter);
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            increment();
        }
    }
}


