package JavaAdvancedLevel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationsTest {

    Operations oper;

    @BeforeEach
    public void setUp() {
        oper = new Operations();
    }

    @Test
    void addition() {
        Operations oper = new Operations();
        int expected  = 15;
        int result = oper.addition(10, 5);
        assertEquals(expected , result);
    }

    @Test
    void subtraction() {
        Operations oper = new Operations();
        int expected  = 5;
        int result = oper.subtraction(10, 5);
        assertEquals(expected , result);
    }

    @Test
    void multiplication() {
        Operations oper = new Operations();
        int expected  = 50;
        int result = oper.multiplication(10, 5);
        assertEquals(expected , result);
    }

    @Test
    void division() {
        Operations oper = new Operations();
        int expected  = 2;
        int result = oper.division(10, 5);
        assertEquals(expected , result);
    }

    @AfterEach
    public void close() {
        oper = null;
    }
}