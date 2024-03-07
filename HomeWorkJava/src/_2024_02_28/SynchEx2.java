package src._2024_02_28;

public class SynchEx2 {
    private  static final Object LOCK = new Object();

    void m1() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("METHOD_1 START");
            Thread.sleep(2222);
            System.out.println("METHOD_1 END");
        }
    }

    void m2() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("METHOD_2 START");
            Thread.sleep(3333);
            System.out.println("METHOD_2 END");
        }
    }

    void m3() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("METHOD_3 START");
            Thread.sleep(1234);
            System.out.println("METHOD_3 END");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new M1());
        Thread thread2 = new Thread(new M2());
        Thread thread3 = new Thread(new M3());

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class M1 implements Runnable {

    @Override
    public void run() {
        try {
            new SynchEx2().m1();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class M2 implements Runnable {

    @Override
    public void run() {
        try {
            new SynchEx2().m2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class M3 implements Runnable {

    @Override
    public void run() {
        try {
            new SynchEx2().m3();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}