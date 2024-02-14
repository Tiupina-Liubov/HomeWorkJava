package src._2024_02_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskiTest {
    private static final Taski TASKI = new Taski();

    private static final int A_6 = 6;
    private static final int B_4 = 4;

    @Test
    void addTest() {
        Assertions.assertEquals(10, TASKI.add(A_6, B_4));
    }

    @Test
    void subtractTest() {
        Assertions.assertEquals(2, TASKI.subtract(A_6, B_4));

    }

    @Test
    void multiplyTest() {
        Assertions.assertEquals(24, TASKI.multiply(A_6, B_4));
    }

    @Test
    void dividePositiveTest() {
        Assertions.assertEquals(6 / 4, TASKI.divide(A_6, B_4));
    }

    @Test
    void divideNegativeTest() {
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> TASKI.divide(A_6, 0));
    }

    @Test
    void powerTest() {
        Assertions.assertEquals(1296,TASKI.power(A_6,B_4));
        Assertions.assertEquals(1,TASKI.power(A_6,0));
        Assertions.assertEquals(0.027777777777777776,TASKI.power(A_6,-2));
        Assertions.assertEquals(0,TASKI.power(0,B_4));
    }


    @Test
    void factorialTest() {
        Assertions.assertEquals(1,TASKI.factorial(0));
        Assertions.assertEquals(1,TASKI.factorial(1));
        Assertions.assertEquals(720,TASKI.factorial(A_6));
    }
    @Test
    void factorialNegativeTest(){
        Assertions.assertThrowsExactly(ArithmeticException.class,()->TASKI.factorial(-1));
    }

    @Test
    void absoluteTest() {
        Assertions.assertEquals(6,TASKI.absolute(A_6));
        Assertions.assertEquals(6,TASKI.absolute(-A_6));
    }

    @Test
    void sqrtPositiveTest() {
        Assertions.assertEquals(2,TASKI.sqrt(4));
    }

    @Test
    void logarithm() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TASKI.logarithm(0, 1));
        Assertions.assertEquals(3, TASKI.logarithm(64, B_4));
    }

    @Test
    void convertDegreesToRadianTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TASKI.convertDegreesToRadian(-1));
        Assertions.assertEquals(0.524, TASKI.convertDegreesToRadian(30));
    }

    @Test
    void sinTest() {
        Assertions.assertEquals(0.5, TASKI.sin(0.524));

    }
}