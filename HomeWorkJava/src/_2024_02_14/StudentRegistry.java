package src._2024_02_14;

import lombok.Getter;
import lombok.Setter;
import src._2024_02_14.exsepshen.ObjectNotFound;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class StudentRegistry {
   private Map<Integer, Student> students= new HashMap<>();

    public Map<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }

    //addStudent(Student student) - добавляет студента в реестр.
    public void addStudent(Student student){
        students.put(student.getId(),student);
    }
    public void removeStudent(int id) throws ObjectNotFound{
        if(students.containsKey(id)){
            students.remove(id);
        }else {
            throw new ObjectNotFound(ErrorMasseger.SUCH_A_KEY_DOES_NOT_EXIST);
        }
    }

    public List<Student> findStudentsByMajor(String major){
        return students.values().stream()
                .filter(student -> String.valueOf(student.getMajor()).equalsIgnoreCase(major))
                .toList();
    }

    public static void main(String[] args) {
        Student student= new Student(12345,"Nikoluk","Nika",
                "nikolik_nika@gmail.com",0.0,Major.BIOLOGY,
                1,true);
        StudentRegistry studentRegistry= new StudentRegistry();
        studentRegistry.addStudent(student);
        System.out.println(studentRegistry.students);
        studentRegistry.removeStudent(student.getId());
        System.out.println(studentRegistry.students);
    }


}
