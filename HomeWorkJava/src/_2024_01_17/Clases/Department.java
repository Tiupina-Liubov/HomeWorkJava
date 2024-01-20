package src._2024_01_17.Clases;

import java.util.List;

public class Department {
    private String name;
    private List<Employee1> employees;

    public Department(String name, List<Employee1> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee1> getEmployees1() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
