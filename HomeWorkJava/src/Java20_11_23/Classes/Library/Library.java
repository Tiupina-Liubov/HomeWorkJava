package Java20_11_23.Classes.Library;

public class Library {

    private String name;
    private String address;
    private Librarian[] librarians;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Library() {
    }

    public void setLibrarians(Librarian[] librarians) {
        this.librarians = librarians;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Librarian[] getLibrarians() {
        return librarians;
    }

    public static Librarian findALibrarianByName(Librarian[] librarians, String name) {

        Librarian librarian = null;
        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i].getName().equalsIgnoreCase(name)) {
                librarian = librarians[i];
                break;
            }
        }
        return librarian;
    }

    public static void addLibrarian(Librarian librarian, Librarian[] librarians) {
        for (int i = 0; i < librarians.length; i++) {
            if (librarians[i] == null) {
                librarians[i] = librarian;
            }
        }
    }

}
