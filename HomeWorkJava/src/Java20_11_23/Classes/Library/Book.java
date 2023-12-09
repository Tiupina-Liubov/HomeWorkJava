package src.Java20_11_23.Classes.Library;


import java.time.LocalDate;

public class Book extends Library {
    private String name;
    private String author;
    private int yearOfPublishing;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public Book(String name, String author, int yearOfPublishing) {
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public static String displayInformationAboutHheBook(Book book) {
        return (" Book title: " + book.name + " \n Book author: " + book.author + "\n Year of book publication: " + book.yearOfPublishing+"\n");
    }

    public static boolean antiquityCheck(Book book) {
        boolean antiquity = false;
        LocalDate localDate = LocalDate.now();
        if ((localDate.getYear() - book.yearOfPublishing) >= 50) {
            antiquity = true;
        }
        return antiquity;
    }

    @Override
    public String toString() {
        return "Book title: " + name + ", Book author:" + author + ", Year of book publication: " + yearOfPublishing ;
    }
}
