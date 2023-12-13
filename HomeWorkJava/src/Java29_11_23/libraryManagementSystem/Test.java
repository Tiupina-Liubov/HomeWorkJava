package src.Java29_11_23.libraryManagementSystem;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final Faker FAKER = new Faker();
    public static void main (String [] args){
        Book book=new Book("Black Fire","Shiku Nori",Genre.FANTASY,BookStatus.AVAILABLE, LocalDate.of(2014,01,1),320);
        Book book1=new Book("Gates of World","Frederik Snou",Genre.FANTASY,BookStatus.BORROWED, LocalDate.of(1994,8,24),217);
        Book book2=new Book("War and Pac","Lev Tolstoy",Genre.HISTORY,BookStatus.AVAILABLE, LocalDate.of(1965,6,15),1300);
        Book book3=new Book("Master and Margarita","Michail Bulgakov",Genre.FANTASY,BookStatus.AVAILABLE, LocalDate.of(1967,4,13),480);
        List<LibraryItem> items= new ArrayList<>();
        items.add(book1);
        items.add(book2);
        items.add(book3);
        items.add(book);






    }
}
