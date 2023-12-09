package Java29_11_23.libraryManagementSystem;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionProcessor {
    public static void main(String[] args) {
        Book book = new Book("Black Fire", "Shiku Nori", Genre.FANTASY, BookStatus.AVAILABLE, LocalDate.ofYearDay(2014, 1), 320);
        Book book1 = new Book("Gates of World", "Frederik Snou", Genre.FANTASY, BookStatus.BORROWED, LocalDate.ofYearDay(1994, 8), 217);
        Book book2 = new Book("War and Pac", "Lev Tolstoy", Genre.HISTORY, BookStatus.LOST, LocalDate.ofYearDay(1965, 6), 1300);
        Book book4 = new Book("War and Pac", "Lev Tolstoy", Genre.HISTORY, BookStatus.LOST, LocalDate.ofYearDay(1965, 6), 1300);
        Book book3 = new Book("Master and Margarita", "Michail Bulgakov", Genre.FANTASY, BookStatus.AVAILABLE, LocalDate.ofYearDay(1967, 4), 480);
        Book book5 = new Book("Master and Margarita", "Michail Bulgakov", Genre.FANTASY, BookStatus.AVAILABLE, LocalDate.ofYearDay(1967, 4), 480);
        Book book6 = new Book("Master and Margarita", "Michail Bulgakov", Genre.FANTASY, BookStatus.AVAILABLE, LocalDate.ofYearDay(1967, 4), 480);
        List<LibraryItem> items = new ArrayList<>();
        items.add(book1);
        items.add(book2);
        items.add(book3);
        items.add(book4);
        items.add(book5);
        items.add(book6);
        items.add(book1);

        printAllItems(items);
        System.out.println("----");
        listItemsByGenre(items, Genre.FANTASY);
        System.out.println("-------");
        System.out.println(items);
        sortByTitle(items);
        System.out.println(items);
        System.out.println("--------");
        filterByAuthor(items, "lev tolstoy");
        countItemsByStatus(items, BookStatus.BORROWED);
        updateStatus(items, BookStatus.BORROWED, BookStatus.AVAILABLE);
        System.out.println(items);
        listAvailableItems(items);
        findOldestItem(items);


    }

    static void printAllItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    static void listItemsByGenre(List<LibraryItem> items, Genre genre) {
        for (LibraryItem item : items) {
            if (item.getGenre().equals(genre)) {
                System.out.println(item);
            }
        }


    }

    static void sortByTitle(List<LibraryItem> items) {
        items.sort(Comparator.comparing(LibraryItem::getTitle));


    }

    static void filterByAuthor(List<LibraryItem> items, String author) {
        for (LibraryItem item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(item);

            }
        }

    }

    static void countItemsByStatus(List<LibraryItem> items, BookStatus status) {
        int countBook = 0;
        int countMagazine = 0;
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                if (((Book) item).getStatus().equals(status)) {
                    countBook++;
                }
            }
            if (item instanceof Magazine) {
                if (((Magazine) item).getStatus().equals(status)) {
                    countMagazine++;
                }
            }
        }
        System.out.println("Books with status " + status + " " + countBook);
        System.out.println("Magazine with status " + status + " " + countMagazine);

    }

    static void updateStatus(List<LibraryItem> items, BookStatus oldStatus, BookStatus newStatus) {
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                if (((Book) item).getStatus().equals(oldStatus)) {
                    ((Book) item).setStatus(newStatus);
                }
            }
            if (item instanceof Magazine) {
                if (((Magazine) item).getStatus().equals(oldStatus)) {
                    ((Magazine) item).setStatus(newStatus);
                }
            }
        }
    }

    static void listAvailableItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                if (((Book) item).getStatus().equals(BookStatus.AVAILABLE)) {
                    System.out.println(item);
                }
            }
        }
        for (LibraryItem item : items) {
            if (item instanceof Magazine) {
                if (((Magazine) item).getStatus().equals(BookStatus.AVAILABLE)) {
                    System.out.println(item);
                }
            }
        }
    }

    static void findOldestItem(List<LibraryItem> items) {
        LocalDate minDate = LocalDate.MAX;
        LibraryItem libraryItem=null;
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                if (((Book) item).getPublishDate().isBefore(minDate)) {
                    minDate = ((Book) item).getPublishDate();
                    libraryItem=item;
                }
            }
            if (item instanceof Magazine) {
                if (((Magazine) item).getReleaseDate().isBefore(minDate)) {
                    minDate = ((Magazine) item).getReleaseDate();
                    libraryItem=item;
                }
            }

        }
        System.out.println(libraryItem);

    }

    static void groupItemsByAuthor(List<LibraryItem> items) {

    }

    static void listItemsForRepair(List<LibraryItem> items) {

    }

    static void displayItemCount(List<LibraryItem> items) {

    }

    static void listBorrowedItemsByUser(List<LibraryItem> items, User user) {

    }

    static void removeLostItems(List<LibraryItem> items) {

    }

    static void addItemToList(List<LibraryItem> items, LibraryItem item) {

    }

    static void removeItemFromList(List<LibraryItem> items, LibraryItem item) {

    }

    static void sortItemsByPublicationDate(List<LibraryItem> items) {

    }

    static void findMostPopularGenre(List<LibraryItem> items) {

    }

    static void calculateAveragePageCount(List<Book> books) {

    }

    static void listMonthlyMagazines(List<Magazine> magazines) {

    }

    static void listItemsByCondition(List<LibraryItem> items, ItemCondition condition) {

    }
}
