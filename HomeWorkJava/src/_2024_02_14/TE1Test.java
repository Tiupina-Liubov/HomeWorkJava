package src._2024_02_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class git pullTE1Test {

    private static final TE1 TE_1 = new TE1();
    private static int NUM_100 = 100;

    @Test
    void getAsStringTest() {
        String expected = "100";
        Assertions.assertEquals(expected, TE_1.getAsString(NUM_100));
    }

    @Test
    void devPositiveTest() {
        Assertions.assertEquals(10, TE_1.dev(NUM_100, 10));
        Assertions.assertEquals(-10, TE_1.dev(NUM_100, -10));
    }

    @Test
    void devWithArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> TE_1.dev(NUM_100, 0));
    }
}