package src._2024_01_29File;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
       File file = new File("fileExample.txt");

        try {
            boolean created = file.createNewFile();
            if(created) {
                System.out.println("File name: " + file.getName());
                System.out.println("File was created: " + file.getAbsolutePath());
                System.out.println("File size: " + file.length());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Is directory: -> " + file.isDirectory());

        //todo
        File renamedFile = new File("java.txt");
        boolean renamed = file.renameTo(renamedFile);

        if(renamed) {
            System.out.println("New name: " + file.getName());
        } else {
            System.out.println("WTF");
        }
    }
}