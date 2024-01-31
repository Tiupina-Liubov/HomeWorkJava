package src.jaml_31_01_24._2024_31_01.taski;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UniversityProcessor {

    // 1. Получить список всех курсов в университете
    public List<Course> getAllCourses(University university) {
        return university.getDepartments().stream()
                .flatMap(department -> department.getCourses().stream())
                .distinct()
                .toList();

    }

    // 2. Найти количество курсов в каждом департаменте
    public Map<String, Long> getCoursesCountByDepartment(University university) {
        return university.getDepartments().stream()
                .collect(Collectors.toMap(Department::getName, department -> (long) department.getCourses().size()));
    }

    // 3. Получить список названий всех курсов, которые имеют более 3 кредитов
    public List<String> getCoursesWithMoreThanThreeCredits(University university) {
        return university.getDepartments().stream()
                .flatMap(department -> department.getCourses().stream())
                .filter(course -> course.getCredits() > 3)
                .map(Course::getTitle)
                .toList();
    }

    // 4. Найти всех профессоров, которые ведут более одного курса
    public Set<String> getProfessorsTeachingMultipleCourses(University university) {
        return university.getDepartments().stream()
                .flatMap(department -> department.getCourses().stream())
                .collect(Collectors.groupingBy(Course::getProfessor, Collectors.counting()))
                .entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    // 5. Получить мапу курсов, где ключ - название курса, значение - список тем
    public Map<String, List<String>> getCourseTopicsMap(University university) {

        return university.getDepartments().stream()
                .flatMap(department -> department.getCourses().stream())
                .collect(Collectors.toMap(course -> course.getTitle(),
                        course -> course.getTopics()));
    }

    // 6. Найти департаменты, где все курсы имеют более 3 кредитов
    public List<String> getDepartmentsWithAllCoursesMoreThanThreeCredits(University university) {
        return university.getDepartments().stream()
                .filter(department -> department.getCourses().stream()
                        .allMatch(course -> course.getCredits()>3))
                .map(Department::getName)
                .toList();
    }

    // 7. Получить список курсов, сгруппированных по количеству кредитов
    public Map<Integer, List<Course>> getCoursesGroupedByCredits(University university) {
        return university.getDepartments().stream()
                .flatMap(department -> department.getCourses().stream())
                .collect(Collectors.groupingBy(Course::getCredits));
    }

    // 8. Найти департамент с самым большим количеством курсов
    public String getDepartmentWithMostCourses(University university) {
        return university.getDepartments().stream()
                .max(Comparator.comparingInt(department ->department.getCourses().size()))
                .map(Department::getName)
                .orElse(null);
    }

    // 9. Получить мапу, где ключ - название департамента, а значение - среднее количество кредитов курсов в департаменте
    public Map<String, Double> getAverageCreditsPerDepartment(University university) {
        return null;
    }

    // 10. Найти курсы, у которых более 2 тем и профессор начинается на 'Dr.'
    public List<Course> getCoursesWithMoreThanTwoTopicsAndDrProfessor(University university) {
        return null;
    }
}
