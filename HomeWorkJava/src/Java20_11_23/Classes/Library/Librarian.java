package src.Java20_11_23.Classes.Library;

import java.util.Arrays;

public class Librarian extends Library {
    private String name;
    private float workExperience;
    private Book[] listOfAvailableBooks;

    public Librarian(String name, float workExperience) {
        this.name = name;
        this.workExperience = workExperience;
    }

    public void setListOfAvailableBooks(Book[] listOfAvailableBooks) {
        this.listOfAvailableBooks = listOfAvailableBooks;
    }

    public String getName() {
        return name;
    }

    public float getWorkExperience() {
        return workExperience;
    }

    public Book[] getListOfAvailableBooks() {
        return listOfAvailableBooks;
    }

    private static boolean booksAvailable(Book[] listOfAvailableBooks, Book book) {
        boolean a = false;
        for (int i = 0; i < listOfAvailableBooks.length; i++) {
            if (listOfAvailableBooks[i].equals(book)) {
                a = true;
                break;
                }

        }
        return a;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", workExperience=" + workExperience +
                ", listOfAvailableBooks=" + Arrays.toString(listOfAvailableBooks) +
                '}';
    }

    public void issueABook(Reader reader, Book book) {
        boolean booksAvailable = Librarian.booksAvailable(listOfAvailableBooks, book);
        if (booksAvailable == true) {
            for (int i = 0; i < listOfAvailableBooks.length; i++) {
                if (listOfAvailableBooks[i].equals(book)) {
                    Reader.takeABook(reader, book);
                    listOfAvailableBooks[i] = null;
                    System.out.println("The book has been issued");
                    break;
                }
            }
        } //else {
           // System.out.println("----");
       // }
    }

    public void returnBook(Reader reader, Book book) {
        for (int i = 0; i < listOfAvailableBooks.length; i++) {
            if (listOfAvailableBooks[i] == null) {
                listOfAvailableBooks[i] = book;
                Reader.returnABook(reader, book);
                System.out.println("The book has been returned");
                break;
            }
        }
    }


}

