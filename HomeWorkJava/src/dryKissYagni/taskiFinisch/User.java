package src.dryKissYagni.taskiFinisch;

import lombok.Getter;

@Getter
public class User {

    private String Name;

    private int Age;

    public User(String name,int age) {
        Name=name;
        Age = age;
    }
}
