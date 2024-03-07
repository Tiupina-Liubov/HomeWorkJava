package src._2024_02_28;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DThread {
    public static void main(String[] args) {
        System.out.println("MAIN START");
        N1 n1 = new N1();
        N2 n2 = new N2();
        n2.setDaemon(true);

        n1.start();
        n2.start();


        System.out.println("MAIN END");


    }

}

class N1 extends Thread {

    @Override
    public void run() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("N1.txt"))) {
            for (char c = '!'; c < 'z'; c++) {
                bufferedWriter.write(c);
            }
        } catch (RuntimeException |  IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class N2 extends Thread {

    @Override
    public void run() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("N2.txt"))) {
            for (int i = 0; i < 999; i++) {
                bufferedWriter.write(i);
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);


        }
    }
}