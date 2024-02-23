package src._2024_01_29File.filePathRandomTaski;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationExamples {

    public static void main(String[] args) throws IOException {
        copyFileUsingFileStreams();
        copyFileUsingPath();
        copyFileUsingRandomAccessFile();
    }

    // Задание 1: Работа с классом File

    /**
     * Написать метод, который создает файл с именем
     * "example.txt" в текущей директории, затем считывает
     * этот файл с использованием FileInputStream и записывает
     * его содержимое в новый файл "copy_example.txt" с использованием FileOutputStream.
     */
    public static void copyFileUsingFileStreams() throws IOException {
        File file = new File("example.txt");
        boolean newFile = file.createNewFile();
        try (FileInputStream input = new FileInputStream(file.getName());
             FileOutputStream outputStream = new FileOutputStream("copy_example.txt")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }

    // Задание 2: Работа с классом Path

    /**
     * Написать метод, который использует Path и Files
     * для копирования файла "example.txt" в новый файл "copy_example_path.txt".
     * Проверить, существует ли файл "example.txt" перед копированием.
     */
    public static void copyFileUsingPath() throws IOException {
        Path path= Paths.get("example.txt");


    }

    // Задание 3: Работа с классом RandomAccessFile

    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, читает первые 20 байт и записывает
     * их в новый файл "random_access_copy.txt".
     */
    public static void copyFileUsingRandomAccessFile() throws IOException {


    }
}
