package src._2024_02_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Taski1Test {
    private static final Taski1 TASKI_1 = new Taski1();

    private static final int A_6 = 6;
    private static final int B_4 = 4;

    @Test
    void addTest() {
        Assertions.assertEquals(10, TASKI_1.add(A_6, B_4));
    }

    @Test
    void subtractTest() {
        Assertions.assertEquals(2, TASKI_1.subtract(A_6, B_4));

    }

    @Test
    void multiplyTest() {
        Assertions.assertEquals(24, TASKI_1.multiply(A_6, B_4));
    }

    @Test
    void dividePositiveTest() {
        Assertions.assertEquals(6 / 4, TASKI_1.divide(A_6, B_4));
    }

    @Test
    void divideNegativeTest() {
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> TASKI_1.divide(A_6, 0));
    }

    @Test
    void powerTest() {
        Assertions.assertEquals(1296, TASKI_1.power(A_6,B_4));
        Assertions.assertEquals(1, TASKI_1.power(A_6,0));
        Assertions.assertEquals(0.027777777777777776, TASKI_1.power(A_6,-2));
        Assertions.assertEquals(0, TASKI_1.power(0,B_4));
    }


    @Test
    void factorialTest() {
        Assertions.assertEquals(1, TASKI_1.factorial(0));
        Assertions.assertEquals(1, TASKI_1.factorial(1));
        Assertions.assertEquals(720, TASKI_1.factorial(A_6));
    }
    @Test
    void factorialNegativeTest(){
        Assertions.assertThrowsExactly(ArithmeticException.class,()-> TASKI_1.factorial(-1));
    }

    @Test
    void absoluteTest() {
        Assertions.assertEquals(A_6, TASKI_1.absolute(A_6));
        Assertions.assertEquals(A_6, TASKI_1.absolute(-A_6));
    }

    @Test
    void sqrtPositiveTest() {
        Assertions.assertEquals(2, TASKI_1.sqrt(4));
    }

    @Test
    void logarithm() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TASKI_1.logarithm(0, 1));
        Assertions.assertEquals(3, TASKI_1.logarithm(64, B_4));
    }

    @Test
    void convertDegreesToRadianTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TASKI_1.convertDegreesToRadian(-1));
        Assertions.assertEquals(0.524, TASKI_1.convertDegreesToRadian(30));
    }

    @Test
    void sinTest() {
        Assertions.assertEquals(0.5, TASKI_1.sin(0.524));

    }
}