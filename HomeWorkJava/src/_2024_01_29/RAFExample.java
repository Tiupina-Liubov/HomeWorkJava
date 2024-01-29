package src._2024_01_29;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("prog.txt", "rw");

        int a = file.read();
        System.out.println((char) a);

        a = file.read();
        System.out.println((char) a);

        String s1 = file.readLine();
        System.out.println(s1);

        file.seek(222);
        String s2 = file.readLine();
        System.out.println(s2);

        long position = file.getFilePointer();
        System.out.println(position);

        file.seek(333);
        file.writeBytes("%%%JAVA%%%");
    }
}
