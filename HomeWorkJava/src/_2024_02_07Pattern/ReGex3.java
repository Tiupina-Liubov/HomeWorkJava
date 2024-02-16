package src._2024_02_07Pattern;

public class ReGex3 {
    public static void main(String[] args) {
        Tem tem = new Tem(123, "PAR2", "PAR3", 123.456d);
        System.out.printf("%03d \t %-4s \t %-15s \t %,.1f \n",
                           tem.id, tem.param2, tem.param3, tem.param4);
    }
}

class Tem {
    int id;
    String param2;
    String param3;

    double param4;

    public Tem(int id, String param2, String param3, double param4) {
        this.id = id;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
    }
}