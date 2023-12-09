package src.Java29_11_23.libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalogue implements Searchable{
    List<Book> books;
    List<Magazine> magazines;

    @Override
    public List<LibraryItem> findByTitle(String title) {
        List<LibraryItem> items=new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getTitle().equalsIgnoreCase(title)){
                items.add(books.get(i));
            }

        }
        return items;
    }

    @Override
    public List<LibraryItem> findByAuthor(String author) {
        List<LibraryItem> items=new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getAuthor().equalsIgnoreCase(author)){
                items.add(books.get(i));
            }
        }
        return items;
    }

    @Override
    public List<LibraryItem> findByGenre(Genre genre) {
        List<LibraryItem> items=new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getGenre()==(genre)){
                items.add(books.get(i));
            }
        }
        return null;
    }
}
