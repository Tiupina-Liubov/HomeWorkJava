package src._2024_01_17StreamFlatMap.Clases;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator1 {
    public static final Faker FAKER = new Faker();
    public static final Random RANDOM = new Random();

    public static List<List<Integer>> genListOfLists(int quantityList, int countNumbers) {
        List<List<Integer>> newList = new ArrayList<>();
        for (int j = 0; j < quantityList; j++) {
            newList.add(genListInteger(countNumbers));
        }
        return newList;
    }

    public static List<Integer> genListInteger(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(RANDOM.nextInt(50));
        }
        return list;
    }


    public static List<Employee> genListEmployees(int quantityEmployee) {
        return Stream.generate(() -> new Employee(FAKER.commerce().department(), genListLanguages(RANDOM.nextInt(6))))
                .limit(quantityEmployee)
                .toList();
    }

    public static List<String> genListLanguages(int quantityLanguages) {
        return Stream.generate(() -> FAKER.programmingLanguage().name())
                .limit(quantityLanguages)
                .toList();
    }

    public static List<List<List<Integer>>> genList2OfList(int quantityList, int quantityListOfList, int countNumbers) {
        return Stream.generate(() -> Generator1.genListOfLists(quantityListOfList, countNumbers))
                .limit(quantityList)
                .toList();
    }

    public static List<Project> genListProjects(int quantityProject) {
        return Stream.generate(() -> new Project(FAKER.name().title(), genStringsList(RANDOM.nextInt(11))))
                .limit(quantityProject)
                .toList();

    }

    private static List<String> genStringsList(int tasks) {
        return Stream.generate(() -> FAKER.book().title())
                .limit(tasks)
                .toList();
    }

    public static Map<String, List<Product>> gencategoryMap(int quantity, int quantityProduct) {
        return Stream.generate(() -> FAKER.country().name())
                .limit(quantity)
                .collect(Collectors.toMap(
                        country -> country,
                        product -> genListProduct(quantityProduct)
                ));
    }

    private static List<Product> genListProduct(int quantityProduct) {
        return Stream.generate(() -> new Product(FAKER.country().name(), FAKER.country().capital(), RANDOM.nextInt(50) * 10.4))
                .limit(quantityProduct)
                .toList();
    }

    public static List<Order> genOrdersList(int quantityOrders) {
        return Stream.generate(() -> new Order(FAKER.name().fullName(), genListItem(RANDOM.nextInt(5)), genListProduct(RANDOM.nextInt(5))))
                .limit(quantityOrders)
                .toList();
    }

    private static List<Item> genListItem(int quantityItem) {
        return Stream.generate(() -> new Item(FAKER.animal().name(), RANDOM.nextInt(50) * 100.4))
                .limit(quantityItem)
                .toList();
    }

    public static List<Department> genDepartmentsList(int quantityDepartment) {
        return Stream.generate(() -> new Department(FAKER.medical().medicineName(), genListEmployees()))
                .limit(quantityDepartment)
                .toList();
    }

    private static List<Employee1> genListEmployees() {
        return Stream.generate(() -> new Employee1(FAKER.name().fullName(), RANDOM.nextInt(100) * 20.4))
                .limit(3)
                .toList();
    }

    public static List<Company> genListOfCompanies(int quantityCompany) {
        return Stream.generate(() -> new Company(FAKER.company().name(), genDepartmentsList(3)))
                .limit(quantityCompany)
                .toList();
    }

    public static List<School> genListSchools(int quantitySchool) {
        return Stream.generate(() -> new School(FAKER.team().state(),genMapOfStudents()))
                .limit(quantitySchool)
                .toList();
    }

    public static Map<String, List<Student>> genMapOfStudents() {
        AtomicInteger count= new AtomicInteger(1);

        return Stream.generate(()-> {
       String str= "Class".concat(String.valueOf(count.get()));
       count.getAndIncrement();
           return str;})
                .limit(4)
                .collect(Collectors.toMap(
                        c -> c,
                        s -> genListOfStudents()
                ));

    }

    public static List<Student> genListOfStudents() {
        return Stream.generate(() -> new Student(FAKER.name().fullName(), genListSubjects()))
                .limit(4)
                .toList();
    }

    public static List<Subject> genListSubjects() {
        AtomicInteger count = new AtomicInteger(0);

        return Arrays.stream(Subjects.values()).map(
                subject -> new Subject(subject.getValue(), RANDOM.nextDouble() * 12)
        ).toList();

        //return Stream.generate(() -> new Subject(Subjects.values()[count.getAndIncrement()].name(), RANDOM.nextDouble() * 12.0))
                //.limit(Subjects.values().length - 1)
                //.toList();
    }
}
