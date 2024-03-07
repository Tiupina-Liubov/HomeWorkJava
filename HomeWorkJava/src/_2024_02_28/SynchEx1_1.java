package src._2024_02_28;

public class SynchEx1_1 extends Thread {
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("COUNTER: " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAIN START");
        SynchEx1_1 synchEx11 = new SynchEx1_1();
        synchEx11.start();

        Thread.sleep(1500);
        synchEx11.b = false;

        synchEx11.join();
        System.out.println("MAIN END");
    }
}