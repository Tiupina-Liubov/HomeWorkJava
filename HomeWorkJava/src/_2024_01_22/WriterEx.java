package src._2024_01_22;

import java.io.FileWriter;
import java.io.IOException;

public class WriterEx {
    public static void main(String[] args) {
        String task = "SocketChannel goes to Vladislav. CharsetEncoder - -> Lana";
        try (FileWriter writer = new FileWriter("999.txt")) {

            for (int i = 0; i < task.length(); i++) {
                writer.write(task.charAt(i));
            }

            System.out.println("\n");
            System.out.println("!!!DONE!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}