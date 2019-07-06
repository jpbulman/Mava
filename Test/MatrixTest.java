package Test;

import Src.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    final int[][] a = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}};
    final Matrix m1 = new Matrix(a);
    final Matrix m2 = new Matrix(3, 3);

    @Test
    void rowAndColumnTest(){
        assertEquals(m1.getNumberOfRows(), 5);
        assertEquals(m1.getNumberOfColumns(), 2);
    }

    @Test
    void toStringTest(){
        assertEquals(m1.toString(), "1 2 3\n4 5 6\n7 8 9");
    }
}