package src._2024_01_17;

import src._2024_01_17.Clases.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFlatMap {
    public static List<Integer> flattenListOfLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public static List<String> getAllSkills(List<User> users) {
        return users.stream()
                .flatMap(user -> user.getSkills().stream())
                .toList();
    }

    public static List<String> getAuthorsTitles(List<Book> books) {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .toList()
                ;
    }

    public static List<String> flattenMap(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .flatMap(stringListEntry -> stringListEntry.getValue().stream())//todo cerez mapppppp
                .toList();
    }

    public static List<Integer> processAndFilter(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(listOfLists1 -> listOfLists1.stream().filter(n -> n % 2 == 0).map(n -> n * n))
                .toList();
    }

    public static List<Integer> flattenDeepListOfLists(List<List<List<Integer>>> deepList) {
        return deepList.stream()
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .toList();
    }

    public static List<String> getSortedTasks(List<Project> projects) {
        return projects.stream()
                .flatMap(p -> p.getTasks().stream())
                .sorted()
                .toList();
    }

    public static List<String> getUniqueProductNames(Map<String, List<Product>> categoryMap) {
        return categoryMap.entrySet().stream()
                .flatMap(p -> p.getValue().stream())
                .map(Product::getName)
                .distinct()
                .toList();
    }

    public static List<String> combineAndTransform(List<Integer> list1, List<Double> list2, Function<Number, String> transformer) {
        return list1.stream()
                .flatMap(l1 -> list2.stream().map(l2 -> l1 + l2))
                .map(transformer)
                .toList();
    }



    public static List<String> getLanguagesFromDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .flatMap(employee -> employee.getLanguages().stream())
                .toList();

    }

    public static List<Item> getItemsByCustomerName(List<Order> orders, String customerName) {
        return orders.stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .flatMap(order -> order.getItems().stream())
                .toList();
    }

    public static double getTotalSalaryByDepartment(List<Department> departments, String departmentName) {
        return departments.stream()
                .filter(department -> department.getName().equals(departmentName))
                .flatMap(department -> department.getEmployees1().stream())
                .mapToDouble(Employee1::getSalary)
                .sum();
    }

    public static List<String> combineAndTransformComplex(List<Integer> integers, List<String> strings, List<Double> doubles) {
        return integers.stream()
                .map(String::valueOf)
                .toList();// todo: ne nravitsa kak rabotaet
    }

    public static Map<String, Double> averageSalaryByCompany(List<Company> companies) {
        return companies.stream()
                .collect(Collectors.toMap(Company::getName,
                        company -> company.getDepartments().stream()
                                .flatMap(department -> department.getEmployees1().stream())
                                .mapToDouble(Employee1::getSalary)
                                .average()
                                .orElse(0.0)
                ));
    }

    public static Map<String, List<String>> highValueProductsByCustomer(List<Order> orders, double threshold) {
        return orders.stream()
                .collect(Collectors.toMap(Order::getCustomerName,
                        order -> order.getProducts().stream()
                                .filter(product -> product.getPrice() > threshold)
                                .map(Product::getCategory)
                                .toList()));
    }

    public static Map<String, Map<String, Double>> averageScoreBySubjectForTopStudents(List<School> schools, double threshold) {
        return schools.stream()
                .collect(Collectors.toMap(School::getName,
                        school -> school.getStudentsByClass()
                                .entrySet()
                                .stream()
                                .flatMap(classEntry -> classEntry.getValue().stream())
                                .filter(student -> student.getSubjects().stream()
                                        .mapToDouble(Subject::getScore)
                                        .average()
                                        .orElse(0.0) > threshold)
                                .collect(Collectors.toMap(
                                        Student::getName,
                                        student -> student.getSubjects().stream()
                                                .mapToDouble(Subject::getScore)
                                                .average()
                                                .orElse(0.0)
                                ))));


    }
}
