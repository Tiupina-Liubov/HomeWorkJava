package src.Java29_11_23.libraryManagementSystem;

public interface Borrowable {
    void borrowItem(User user);
    void returnItem(User user);
    boolean isAvailable();
}
