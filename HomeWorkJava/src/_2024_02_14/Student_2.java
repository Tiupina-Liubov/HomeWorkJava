package src._2024_02_14;

import lombok.Getter;

@Getter
public class Student_2 {
    int id;
   String lastName;
    String firstName;
    String email;
    double age;
    Enum Major ;

    public Student_2(int id, String lastName, String firstName, String email, double age, Enum major) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.age = age;
        Major = major;
    }
}
