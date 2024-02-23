package src._2024_01_24FileInputStreamAndOutputStreamReader;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PersonTemplate1 implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;
    private final String name = "II";
    public final int age = 100000;
    private transient final double salary = 9;

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
        if (!(o instanceof PersonTemplate1 that)) return false;
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