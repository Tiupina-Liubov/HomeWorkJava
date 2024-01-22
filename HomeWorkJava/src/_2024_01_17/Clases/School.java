package src._2024_01_17.Clases;

import java.util.List;
import java.util.Map;

public class School {
    private String name;
    private Map<String, List<Student>> studentsByClass;

    public School(String name, Map<String, List<Student>> studentsByClass) {
        this.name = name;
        this.studentsByClass = studentsByClass;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Student>> getStudentsByClass() {
        return studentsByClass;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", studentsByClass=" + studentsByClass +
                '}';
    }
}
