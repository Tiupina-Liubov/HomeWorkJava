package src._2024_01_22;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Double.*;

public class Metod {
    public static void main(String[] args) {

        //1 Прочитайте файл и посчитайте средний рейтинг всех стримов.
        // Запишите результат в новый файл.

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/luibov/Desktop/proekt/HomeWorkJava/HomeWorkJava/src/_2024_01_22/f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("1Task.txt"))) {


            double middleCount = reader.lines()
                    .map(str -> str.split(", ")[1])
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0.0);
            System.out.println(middleCount);

            writer.write("Cредний рейтинг всех стримов " + (middleCount) + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //2 Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/luibov/Desktop/proekt/HomeWorkJava/HomeWorkJava/src/_2024_01_22/f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("2Task.txt"))) {

            List<String> list = reader.lines()
                    .filter(line -> parseDouble(line.split(", ")[1]) > 4.5)
                    .toList();
writer.write("Cтримы, имеющие рейтинг выше 4.5"+"\n");
            for (String l : list) {
                writer.append(l).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //3 Найдите стримы с минимальным рейтингом и выведите их в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/luibov/Desktop/proekt/HomeWorkJava/HomeWorkJava/src/_2024_01_22/f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task_5.txt"))) {
            List<String> lines = reader.lines().toList();

            double min = lines.stream().map(line -> Double.parseDouble(line.split(", ")[1]))
                    .min(Comparator.naturalOrder())
                    .orElseThrow();

            List<String> strings = lines.stream()
                    .filter(line -> Double.parseDouble(line.split(", ")[1]) == min)
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
