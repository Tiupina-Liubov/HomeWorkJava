package java22_11_23.Classes.txt1;

public abstract class Employee implements EmployeeActions {
    String name;
    int age;
    String department;
    float salary;

    public Employee(String name, int age, String department, float salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }
}
interface EmployeeActions{
     void work();
     void takeBreak();
}
