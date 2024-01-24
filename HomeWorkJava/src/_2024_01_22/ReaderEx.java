package src._2024_01_22;

import java.io.FileReader;
import java.io.IOException;

//txt
public class ReaderEx {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("prog.txt")) {
            int ch;

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            System.out.println("\n");
            System.out.println("!!!DONE!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}