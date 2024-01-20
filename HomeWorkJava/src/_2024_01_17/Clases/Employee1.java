package src._2024_01_17.Clases;

public class Employee1 {
    private  String name;
    private  double salary;

    public Employee1(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
