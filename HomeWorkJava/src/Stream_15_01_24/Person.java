package src.Stream_15_01_24;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int age;
    List<Integer> numbers = new ArrayList<>();

    public Person(String name, int age, List<Integer> numbers) {
        this.name = name;
        this.age = age;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", numbers=" + numbers +
                '}';
    }
}
