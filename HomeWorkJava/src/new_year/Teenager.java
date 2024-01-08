package src.new_year;

public class Teenager extends Participant {

    public Teenager(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Teenager{" + "name=" + this.getName() +
                ", age=" + this.getAge() +
                "}";
    }
}
