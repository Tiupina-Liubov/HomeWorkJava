package src._2024_02_14;

public class TE1 {
    public String getAsString(int num) {
        return String.valueOf(num);
    }

    public int dev(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
}
