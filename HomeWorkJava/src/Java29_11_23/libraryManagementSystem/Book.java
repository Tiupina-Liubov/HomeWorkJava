package src.Java29_11_23.libraryManagementSystem;

import java.time.LocalDate;
import java.util.List;

public class Book extends LibraryItem implements Borrowable, Maintainable {
    private BookStatus status;
    private LocalDate publishDate;
    private int pageCount;

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Book(String title, String author, Genre genre, BookStatus status, LocalDate publishDate, int pageCount) {
        super(title, author, genre);
        this.status = status;
        this.publishDate = publishDate;
        this.pageCount = pageCount;

    }


    @Override
    public String toString() {
        return "\nBook{" +
                "status=" + status +
                ", publishDate=" + publishDate +
                ", pageCount=" + pageCount +
                ", title='" + getTitle()+ '\'' +
                ", author='" + getAuthor() + '\'' +
                ", genre=" + getGenre() + "}";
    }
    @Override
    public void borrowItem(User user) {
        user.getBorrowedItems().add(this);
        this.status=BookStatus.BORROWED;
    }

    @Override
    public void returnItem(User user) {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void repairItem() {

    }

    @Override
    public void updateItemCondition(ItemCondition condition) {

    }

    @Override
    public ItemCondition checkCondition() {
        return null;
    }
}
