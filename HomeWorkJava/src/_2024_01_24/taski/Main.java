package src._2024_01_24.taski;

import java.io.*;
import java.util.List;

public class Main {

    /**
     * Создайте объекты класса Book для каждой строки.
     * Используйте Stream API для преобразования строк в объекты.
     * Сериализуйте список книг в файл с использованием ObjectOutputStream.
     */
    public static void main(String[] args) throws RuntimeException {
//прочитать текст из файла и достать строки
        //достать строку и витянуть нужною информацыю
        //создать 5 новых робектов класа
        // записвть дание в поля класа
        // зделать сермалмзацыю обекта
        //провести десериализацыю

//            List<Book> books = scanner.useDelimiter("\\A").next().lines()
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/luibov/Desktop/proekt/HomeWorkJava/HomeWorkJava/src/_2024_01_24/taski/taski.txt"))) {
            FileOutputStream fileOut = new FileOutputStream("books.ser");//out -> это куда то отдает наружу....в какой то файл..
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            List<Book> books = reader.lines()
                    .map(line -> {
                        String[] parcts = line.split(", ");
                        return new Book(Integer.parseInt(parcts[0]), parcts[1], parcts[2], Integer.parseInt(parcts[3]), Double.parseDouble(parcts[4]));
                    })
                    .toList();
            out.writeObject(books);
            fileOut.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main1 {

    /**
     * Десериализуйте список книг из файла,
     * созданного в предыдущем задании, используя ObjectInputStream.
     * Используйте Stream API для фильтрации книг, например, по автору или году издания.
     * Результаты сохраните в новый сериализованный файл
     */
    public static void main(String[] args) throws RuntimeException {

        try(ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream("books.ser"));
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("filterByDate.ser"))){
            

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main2 {

    /**
     * Отфильтруйте книги с ценой выше определенной суммы. Сериализуйте отфильтрованный список книг в файл.
     */
    public static void main(String[] args) {

    }
}

class Main3 {

    /**
     Агрегируйте данные, например, подсчитайте среднюю цену книг по каждому автору. Сериализуйте результаты в файл.
     */
    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream("data.txt");
//             Scanner scanner = new Scanner(fis);
//             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("authorAveragePrice.ser"))) {
//
//            Map<String, Double> authorAveragePrice = scanner.useDelimiter("\\A").next().lines()
//                    .skip(1)
//                    .map(line -> line.split(", "))
//
    }
}