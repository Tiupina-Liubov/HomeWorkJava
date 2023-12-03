package Java29_11_23.libraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main (String [] args){
        Book book=new Book("AAa","asdd",Genre.BIOGRAPHY,BookStatus.LOST, LocalDate.now(),1);
        Book book1=new Book("dfgn","tgf",Genre.HISTORY,BookStatus.LOST, LocalDate.now(),2);
        Book book2=new Book("cvb","sxdf",Genre.FANTASY,BookStatus.LOST, LocalDate.now(),3);
        Book book3=new Book("/.lj","asd",Genre.BIOGRAPHY,BookStatus.LOST, LocalDate.now(),4);
        List<LibraryItem> items= new ArrayList<>();
        items.add(book1);
        items.add(book2);
        items.add(book3);
        items.add(book);
        Librarian librarian=new Librarian("zb","asdfgh");

    }
}
