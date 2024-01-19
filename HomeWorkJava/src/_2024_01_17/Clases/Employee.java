package src._2024_01_17.Clases;

import java.util.List;

public class Employee {
    private String department;
    private List<String> languages;

    public Employee(String department, List<String> languages) {
        this.department = department;
        this.languages = languages;
    }

    public String getDepartment() {
        return department;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
