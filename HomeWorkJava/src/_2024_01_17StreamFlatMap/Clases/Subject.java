package src._2024_01_17StreamFlatMap.Clases;

public class Subject {
    private String name;
    private double score;

    public Subject(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
