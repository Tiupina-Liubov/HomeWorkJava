package src._2024_01_17.Clases;

public enum Subjects {
    ALGEBRA("ALGEBRA"),
    BIOLOGY("BIOLOGY"),
    DRAWING("DRAWING"),
    CHEMISTRY("CHEMISTRY"),
    GEOGRAPHY("GEOGRAPHY"),
    GEOMETRY("GEOMETRY"),
    HISTORY("HISTORY"),
    LITERATURE("LITERATURE");

    private final String value;


    Subjects(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
