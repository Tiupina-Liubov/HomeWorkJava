package src._2024_02_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src._2024_02_14.exsepshen.ObjectNotFound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class StudentRegistryTest {
   private static final Student STUDENT= new Student(12345,"Nikoluk","Nika",
            "nikolik_nika@gmail.com",0.0,Major.BIOLOGY);
    private static  final StudentRegistry STUDENT_REGISTRY =new StudentRegistry();




    @Test
    void addStudentTest() {
        STUDENT_REGISTRY.addStudent(STUDENT);
        Assertions.assertEquals(1, STUDENT_REGISTRY.getStudents().size());
    }

    @Test
    void removeStudentPositiveTest() {
        STUDENT_REGISTRY.addStudent(STUDENT);
        STUDENT_REGISTRY.removeStudent(STUDENT.getId());
        Assertions.assertEquals(0,STUDENT_REGISTRY.getStudents().size());
    }
    @Test
    void removeStudentNegativeTest() {
        Assertions.assertThrows(ObjectNotFound.class,()-> STUDENT_REGISTRY.removeStudent(STUDENT.getId()));
    }

    @Test
    void findStudentsByMajor() {
        List<Student>students= new ArrayList<>();
        STUDENT_REGISTRY.addStudent(STUDENT);

//        Assertions.assertEquals();
    }
}

