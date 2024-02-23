package src._2024_01_22BufferedReaderAndFileWriter;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Double.*;

public class Metod {
    public static void main(String[] args) {

        //1 Прочитайте файл и посчитайте средний рейтинг всех стримов.
        // Запишите результат в новый файл.

        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
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

        // Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("2Task.txt"))) {

            List<String> list = reader.lines()
                    .filter(line -> parseDouble(line.split(", ")[1]) > 4.5)
                    .toList();
            writer.write("Cтримы, имеющие рейтинг выше 4.5" + "\n");

            for (String l : list) {
                writer.append(l).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//

        // Найдите стримы с минимальным рейтингом и выведите их в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task_5.txt"))) {

            List<String> lines = reader.lines().toList();

            double min = lines.stream().map(line -> Double.parseDouble(line.split(", ")[1]))
                    .min(Comparator.naturalOrder())
                    .orElseThrow();

            writer.write(String.valueOf( lines.stream()
                    .filter(line -> Double.parseDouble(line.split(", ")[1]) == min)
                    .map(str-> "\n"+str)
                    .toList()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Отсортируйте стримы по рейтингу от наибольшего к наименьшему и запишите результаты в новый файл.//todo peredelat
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result_Task_4.txt"))) {

            bufferedReader.lines()
                    .sorted(Comparator.comparing((s) -> Double.parseDouble(s.split(", ")[1])))
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line);
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //6 Соберите статистику по рейтингам (минимальный, максимальный, средний) и запишите ее в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(" result_task_6"))) {
            List<String> strings = reader.lines()
                    .toList();

            double middleCount = strings.stream()
                    .map(str -> str.split(", ")[1])
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0.0);

            double minCount = strings.stream()
                    .map(str -> Double.parseDouble(str.split(", ")[1]))
                    .reduce(Double::min)
                    .orElse(0.0);
            double maxCount = strings.stream()
                    .map(str -> Double.parseDouble(str.split(", ")[1]))
                    .reduce(Double::max)
                    .orElse(0.0);
            writer.write(("Статистику по рейтингам: \nминимальный = " + minCount + "\nмаксимальный = " + maxCount + "\nсредний = " + middleCount));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Измените названия всех стримов, добавив к ним префикс "Stream-" и запишите обновленные названия в новый файл.

        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task_7.txt"))) {

            writer.write(String.valueOf(reader.lines()
                    .map(str -> "\nStream-" + str)
                    .toList()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Отфильтруйте стримы с рейтингом ниже 4.7 и преобразуйте их названия, добавив в конец "- Low Rated". Запишите результаты в новый файл.

        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_Task_8.txt"))) {

            writer.write(String.valueOf(reader.lines()
                    .filter(str -> parseDouble(str.split(", ")[1]) < 4.7)
                    .map(str -> "\n" + str.split(", ")[0] + "- Low Rated")
                    .toList()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Создайте сводку, включающую идентификатор стрима, название и рейтинг, и запишите ее в новый файл в формате "ID: Название - Рейтинг".

        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_Task_9.txt"))) {

            writer.write(String.valueOf(reader.lines()
                    .map(str -> "\n" + str.replace(", ", " - "))
                    .toList()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //10 Соберите все названия стримов в одну длинную строку, разделяя их запятыми, и запишите эту строку в новый файл.
        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("result_task_10"))) {
            writer.write(String.valueOf(reader.lines()
                    .map(str -> str.split(": ")[1])
                    .map(str -> String.join(", ", str.split(", ")[0]))
                    .toList()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Сгруппируйте стримы по названию и запишите количество стримов в каждой группе в новый файл.
        try  (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
              BufferedWriter writer = new BufferedWriter(new FileWriter("result_task_3.txt"))) {

            writer.write(String.valueOf(reader.lines()
                    .map(str->str.split(": ")[1])
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
