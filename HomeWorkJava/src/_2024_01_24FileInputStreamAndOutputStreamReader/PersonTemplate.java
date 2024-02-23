package src._2024_01_24FileInputStreamAndOutputStreamReader;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PersonTemplate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String name = "Nik";
    public final int age = 999;
    private transient final double salary = 3500;

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getAge() {
        return age;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }

    public double getSalary() {
        return salary;
    }

//    public void setSalary(double salary) {
//        this.salary = salary;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonTemplate that)) return false;
        return age == that.age && Double.compare(salary, that.salary) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return "PersonTemplate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}