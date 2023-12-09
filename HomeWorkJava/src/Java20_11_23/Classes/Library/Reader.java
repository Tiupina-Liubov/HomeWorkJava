package src.Java20_11_23.Classes.Library;

import java.util.Arrays;

public class Reader extends Library {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Reader{" +
                "Name='" + name + '\'' +
                ", Age=" + age +
                ", TakingABook=" + Arrays.toString(takingABook) +
                '}';
    }

    private Book[] takingABook;


    public Reader(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Book[] getTakingABook() {
        return takingABook;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setTakingABook(Book[] takingABook) {
        this.takingABook = takingABook;
    }

    public static Book[] takeABook(Reader reader, Book book) {
        if (reader.takingABook == null) {
            Book[] takingABook = new Book[10];
            takingABook[0] = book;
            reader.takingABook = takingABook;
        } else {
            for (int i = 0; i < reader.takingABook.length; i++) {
                if (reader.takingABook[i] == null) {
                    reader.takingABook[i] = book;
                    break;
                }
            }
        }
        return reader.takingABook;
    }

    public static Book[] returnABook(Reader reader, Book book) {
        for (int i = 0; i < reader.takingABook.length; i++) {
            if (reader.takingABook[i] == (book)) {
                reader.takingABook[i] = null;
            }
        }
        return reader.takingABook;
    }
}

