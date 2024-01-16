package src.Stream_15_01_24;

import com.github.javafaker.Faker;
import src._2024_01_10.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorPerson {
    public static   final Faker FAKER = new Faker();
    public static final Random RANDOM= new Random();

    static List<Person> generatPerson(int quantity ){
        List<Person> peoples=new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            peoples.add(new Person(FAKER.name().fullName(), RANDOM.nextInt(60), generNumbers(10)));
        }
return peoples;
    }

static List<Integer> generNumbers(int number){
        List<Integer> numbers= new ArrayList<>();
    for (int i = 0; i < number; i++) {
        numbers.add(RANDOM.nextInt(13));
    }
    return numbers;
}
}
