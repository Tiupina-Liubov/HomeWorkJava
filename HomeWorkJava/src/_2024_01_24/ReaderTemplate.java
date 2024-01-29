package src._2024_01_24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ReaderTemplate {
    public static void main(String[] args) {
        PersonTemplate personTemplate = new PersonTemplate();
        System.out.println("Before Serialization");
        System.out.println("Name: " + personTemplate.getName());
        System.out.println("Age: " + personTemplate.getAge());
        System.out.println("Salary: " + personTemplate.getSalary());

        //Serial to file
        try {
            FileOutputStream fileOut = new FileOutputStream("template.ser");//out -> это куда то отдает наружу....в какой то файл..
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(personTemplate);
            fileOut.close();
            out.close();

            System.out.println("Serialized");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}