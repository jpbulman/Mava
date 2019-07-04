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

    private DecimalFormat decimalFormat = new DecimalFormat("0.000");
    @Test
    void times() {
        ComplexNumber c = a.times(b);
        assertEquals(Double.valueOf(decimalFormat.format(c.getRealPart())), 1.604);
        assertEquals(Double.valueOf(decimalFormat.format(c.getComplexPart())), 17.38);
    }

    @Test
    void minus() {
    }

    @Test
    void toStringTest() {
        assertEquals(a.toString(), "1.2 + 3.14i");
        assertEquals(justComplex.toString(), "8.0i");
        assertEquals(justReal.toString(), "9.0");
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
}