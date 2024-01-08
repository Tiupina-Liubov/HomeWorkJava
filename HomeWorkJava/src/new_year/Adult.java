package src.new_year;

public class Adult extends Participant {
    public Adult(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Adult{" + "name=" + this.getName() +
                ", age=" + this.getAge() +
                "}";
    }
}
