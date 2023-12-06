package Java29_11_23.libraryManagementSystem;

import java.time.LocalDate;

public class Magazine extends LibraryItem {
   private int issueNumber;
   private LocalDate releaseDate;
   private boolean isMonthly;
   private BookStatus status;

    public Magazine(String title, String author, Genre genre, int issueNumber, LocalDate releaseDate, boolean isMonthly,BookStatus status) {
        super(title, author, genre);
        this.issueNumber = issueNumber;
        this.releaseDate = releaseDate;
        this.isMonthly = isMonthly;
        this.status=status;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    public void setMonthly(boolean monthly) {
        isMonthly = monthly;
    }
}
