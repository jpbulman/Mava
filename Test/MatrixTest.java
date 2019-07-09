package Test;

import Src.Exceptions.Matrices.MatrixDimensionCreationException;
import Src.Matrix;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    final double[][] a = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}};
    final Matrix m1 = new Matrix(a);

    final double[][] b = {{17, 8, 5}, {6, 9, 12}};
    final Matrix m2 = new Matrix(b);

    final double[][] c = {{-1, 2, 3}, {4, -5, 6}, {7, 8, -9}};
    final Matrix square = new Matrix(c);

    final double[][] singleVals = {{1}};
    final Matrix single = new Matrix(singleVals);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rowAndColumnTest(){
        assertEquals(m1.getNumberOfRows(), 5);
        assertEquals(m1.getNumberOfColumns(), 2);

        double[][] c = {{}};
        assertThrows(MatrixDimensionCreationException.class, () -> new Matrix(0,0));
        assertThrows(MatrixDimensionCreationException.class, () -> new Matrix(-1,0));
        assertThrows(MatrixDimensionCreationException.class, () -> new Matrix(c));
    }

    @Test
    void toStringTest(){
        assertEquals(m1.toString(), "1.0 2.0\n3.0 4.0\n5.0 6.0\n7.0 8.0\n9.0 0.0");
        assertEquals(single.toString(), "1.0");
    }

    @Test
    void multiply(){
        Matrix m = m1.times(m2);

        double[][] dbs = {{29, 26, 29}, {75, 60, 63}, {121, 94, 97}, {167, 128, 131}, {153, 72, 45}};
        assertTrue(m.equals(new Matrix(dbs)));

        Matrix scalarResult = square.times(-1);

        double[][] scalarVals = {{1, -2, -3}, {-4, 5, -6}, {-7, -8, 9}};
        Matrix scalarMatrix = new Matrix(scalarVals);

        assertTrue(scalarResult.equals(scalarMatrix));
    }



}