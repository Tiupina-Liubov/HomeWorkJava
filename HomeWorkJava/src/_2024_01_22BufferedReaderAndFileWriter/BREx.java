package src._2024_01_22BufferedReaderAndFileWriter;

import java.io.*;

public class BREx {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("prog.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("33333.txt"))) {
            String l;
//            reader.lines()


            while ((l = reader.readLine()) != null) {
                writer.write(l + "\n");
            }

            System.out.println("!!!DONE!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
