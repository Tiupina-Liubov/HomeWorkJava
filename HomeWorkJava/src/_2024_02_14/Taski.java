package src._2024_02_14;

public class Taski {
    public static void main(String[] args) {
        double pow = Math.pow(6, 4);
        System.out.println(pow);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public double power(double base, int exponent) {
        double power = 1;
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0.0) {
            return (1 / Math.pow(base, (-1 * exponent)));
        } else if (base == 0.0) {
            return 0;
        } else {
            for (int i = 0; i < exponent; i++) {
                power *= base;
            }
            return power;
        }
    }

    public int factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException();
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public int absolute(int n){
        if(n<0){
           return n*-1;
        }else {
            return n;
        }
    }

    public double sqrt(int n){
        if(n<0){
            throw new ArithmeticException();
        }else{
            return Math.pow(n,0.5);
        }
    }
    public double logarithm(double number, double base) {

        if (number <= 0 || base <= 0 || base == 1){
            throw new IllegalArgumentException();
        }
        return Math.log(number)/ Math.log(base);
    }
    public  double convertDegreesToRadian(double degrees) {
        if (degrees < 0) {
            throw new IllegalArgumentException();
        }
        double result = degrees * Math.PI / 180.0;
        double multiplier = Math.pow(10, 3);
        result = Math.round(result * multiplier) / multiplier;

        return  result;
    }

    public double sin(double n) {
        double result = 0;
        int terms = 10;
        for (int i = 0; i < terms; i++) {
            result += Math.pow(-1, i) * Math.pow(n, 2 * i + 1) / factorial(2 * i + 1);
        }

        double multiplier = Math.pow(10, 3);
        result = Math.round(result * multiplier) / multiplier;
        return result;
    }

}
