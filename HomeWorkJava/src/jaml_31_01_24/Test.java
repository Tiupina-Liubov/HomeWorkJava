package src.jaml_31_01_24;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import src.jaml_31_01_24.taski.UniversityContainer;
import src.jaml_31_01_24.taski.UniversityProcessor;

import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {


        UniversityContainer universityContainer;

        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            FileReader reader = new FileReader("/Users/luibov/Desktop/proekt/HomeWorkJava/HomeWorkJava/src/" +
                    "jaml_31_01_24/taski/resources/1.yaml");
             universityContainer = objectMapper.readValue(reader, UniversityContainer.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1. Получить список всех курсов в университете");
        System.out.println(UniversityProcessor.getAllCourses(universityContainer.getUniversity())+"\n");

        System.out.println("2. Найти количество курсов в каждом департаменте");
        System.out.println(UniversityProcessor.getCoursesCountByDepartment(universityContainer.getUniversity())+"\n");

        System.out.println("3. Получить список названий всех курсов, которые имеют более 3 кредитов");
        System.out.println(UniversityProcessor.getCoursesWithMoreThanThreeCredits(universityContainer.getUniversity())+"\n");

        System.out.println("4 Найти всех профессоров, которые ведут более одного курса");
        System.out.println(UniversityProcessor.getProfessorsTeachingMultipleCourses(universityContainer.getUniversity())+"\n");

        System.out.println("5. Получить мапу курсов, где ключ - название курса, значение - список тем");
        System.out.println(UniversityProcessor.getCourseTopicsMap(universityContainer.getUniversity())+"\n");

        System.out.println("6. Найти департаменты, где все курсы имеют более 3 кредитов");
        System.out.println(UniversityProcessor.getDepartmentsWithAllCoursesMoreThanThreeCredits(universityContainer.getUniversity())+"\n");

        System.out.println(" 7. Получить список курсов, сгруппированных по количеству кредитов");
        System.out.println(UniversityProcessor.getCoursesGroupedByCredits(universityContainer.getUniversity())+"\n");

        System.out.println("8. Найти департамент с самым большим количеством курсов");
        System.out.println(UniversityProcessor.getDepartmentWithMostCourses(universityContainer.getUniversity())+"\n");

        System.out.println("9. Получить мапу, где ключ - название департамента, а значение - среднее " +
                "количество кредитов курсов в департаменте");
        System.out.println(UniversityProcessor.getAverageCreditsPerDepartment(universityContainer.getUniversity())+"\n");

        System.out.println("10. Найти курсы, у которых более 2 тем и профессор начинается на 'Dr.'");
        System.out.println(UniversityProcessor.getCoursesWithMoreThanTwoTopicsAndDrProfessor(universityContainer.getUniversity()));

    }
}
