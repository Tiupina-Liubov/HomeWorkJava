package src._2024_02_28;

public class DeadLog {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    void m1() throws InterruptedException {
        synchronized (LOCK2) {
            System.out.println("METHOD_1 START");
            synchronized (LOCK1) {
                System.out.println("METHOD_1 END");
            }
        }
    }

    void m2() throws InterruptedException {
        synchronized (LOCK1) {
            System.out.println("METHOD_2 START");
            synchronized (LOCK2) {
                System.out.println("METHOD_2 END");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ML());
        Thread thread2 = new Thread(new ML1());
        thread1.start();
        thread2.start();
    }
}

class ML implements Runnable {

    @Override
    public void run() {
        try {
            new DeadLog().m1();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ML1 implements Runnable {

    @Override
    public void run() {
        try {
            new DeadLog().m2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

