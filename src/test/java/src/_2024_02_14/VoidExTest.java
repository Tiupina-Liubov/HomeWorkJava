package src._2024_02_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VoidExTest {
    private static final VoidEx VOID_EX = new VoidEx();
    private static final String S_1 = "1";
    private static final String S_2 = "2";
    private static final String S_3 = "3";

    @BeforeEach
    public void setUp() {
        VOID_EX.getList().clear();
        VOID_EX.addToList(S_1);
        VOID_EX.addToList(S_2);
        VOID_EX.addToList(S_3);
    }

    @Test
    void addToListTest() {
        assertEquals(3, VOID_EX.getList().size());
    }

    @Test
    void modifyListTest() {
        VOID_EX.modifyList();
        assertEquals(Arrays.asList("1*", "2*", "3*"), VOID_EX.getList());
    }
}