package src.new_year;

public class Pupil extends Participant{
    public Pupil(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Pupil{" + "name=" + this.getName() +
                ", age=" + this.getAge() +
                "}";
    }
}
