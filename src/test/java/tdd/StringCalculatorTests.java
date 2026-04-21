package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTests {

    private final StringCalculator calc = new StringCalculator();

    @Test
    void emptyReturnsZero() {
        assertEquals(0, calc.add(""));
        assertEquals(0, calc.add(null));
        assertEquals(0, calc.add("   "));
    }

    @Test
    void singleNumber() {
        assertEquals(5, calc.add("5"));
        assertEquals(42, calc.add("42"));
    }

    @Test
    void twoNumbersCommaSeparated() {
        assertEquals(3, calc.add("1,2"));
        assertEquals(7, calc.add("3,4"));
    }

    @Test
    void ignoreNumbersGreaterThan1000() {
        assertEquals(2, calc.add("2,1001"));
        assertEquals(1002, calc.add("2,1000"));
    }

    @Test
    void negativesThrowWithList() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calc.add("1,-2,3,-5"));
        assertTrue(ex.getMessage().contains("[-2, -5]"));
    }
}

