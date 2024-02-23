package src._2024_01_24FileInputStreamAndOutputStreamReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderTemplate1 {
    public static void main(String[] args) {
        PersonTemplate1 person1;

        try {
            FileInputStream fileIn = new FileInputStream("template.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            person1 = (PersonTemplate1) in.readObject();

            fileIn.close();
            in.close();

            System.out.println("DE ---- Serialized");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("**************************************************************");

        System.out.println("After Serialization");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Salary: " + person1.getSalary());
    }
}