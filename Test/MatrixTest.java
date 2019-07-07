package Test;

import Src.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    final double[][] a = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}};
    final Matrix m1 = new Matrix(a);
    final Matrix m2 = new Matrix(0, 0);

    @Test
    void rowAndColumnTest(){
        assertEquals(m1.getNumberOfRows(), 5);
        assertEquals(m1.getNumberOfColumns(), 2);
    }

    @Test
    void toStringTest(){
        assertEquals(m1.toString(), "1.0 2.0\n3.0 4.0\n5.0 6.0\n7.0 8.0\n9.0 0.0");
    }

    @Test
    void multiply(){
        Matrix m = m1.times(m2);
    }
}