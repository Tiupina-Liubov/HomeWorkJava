package src._2024_01_17.Clases;

import java.util.List;

public class Project {
    private String name;
    private List<String> tasks;

    public Project(String name, List<String> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
