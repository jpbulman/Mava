package Test;

import Src.ComplexNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

    private final ComplexNumber a = new ComplexNumber(1.2, 3.14);
    private final ComplexNumber b = new ComplexNumber(5, 1.4);
    private final ComplexNumber justComplex = new ComplexNumber(0, 8);
    private final ComplexNumber justReal = new ComplexNumber(9, 0);
    private final ComplexNumber neither = new ComplexNumber(0, 0);
    private final ComplexNumber neitherAgain = new ComplexNumber(0, 0);

    //Decimal formatting gets rid of double errors
    //Otherwise, tests will will fail because 1.74 != 1.7400000000000000000001
    //Big decimals are still not completely accurate, so for testing purposes, this is fine
    private DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.000");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void plus() {
        ComplexNumber c = a.plus(b);
        assertEquals(c.getRealPart(), 6.2);
        assertEquals(c.getComplexPart(), 4.54);

        ComplexNumber d = justComplex.plus(justReal);
        assertEquals(d.getRealPart(), 9);
        assertEquals(d.getComplexPart(), 8);
    }

    @Test
    void times() {
        ComplexNumber c = a.times(b);
        assertEquals(Double.valueOf(DECIMAL_FORMAT.format(c.getRealPart())), 1.604);
        assertEquals(Double.valueOf(DECIMAL_FORMAT.format(c.getComplexPart())), 17.38);

        assertTrue(b.times(justReal).equals(new ComplexNumber(45, 12.6)));
        assertTrue(b.times(justComplex).equals(new ComplexNumber(-11.2, 40)));
        assertTrue(b.times(neither).equals(neither));
    }

    @Test
    void minus() {
        ComplexNumber z = a.minus(b);
        assertEquals(Double.valueOf(DECIMAL_FORMAT.format(z.getRealPart())), -3.8);
        assertEquals(Double.valueOf(DECIMAL_FORMAT.format(z.getComplexPart())), 1.74);

        ComplexNumber d = justComplex.minus(justReal);
        assertEquals(d.getRealPart(), -9);
        assertEquals(d.getComplexPart(), 8);
    }

    @Test
    void toStringTest() {
        assertEquals(a.toString(), "1.2 + 3.14i");
        assertEquals(justComplex.toString(), "8.0i");
        assertEquals(justReal.toString(), "9.0");
        assertEquals(neither.toString(), "");
    }

    @Test
    void conjugate() {
        assertEquals(b.conjugate().getRealPart(), 5);
        assertEquals(b.conjugate().getComplexPart(), -1.4);
        assertEquals(justReal.conjugate().getRealPart(), 9);
        assertEquals(justReal.conjugate().getComplexPart(), 0);
        assertEquals(justComplex.conjugate().getRealPart(), 0);
        assertEquals(justComplex.conjugate().getComplexPart(), -8);
    }

    @Test
    void equals(){
        assertTrue(neither.equals(neitherAgain));
        assertFalse(neither.equals(a));
        assertFalse(a.equals(b));
    }

}