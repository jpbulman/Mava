package Test;

import Src.Exceptions.Matrices.MatrixDimensionCreationException;
import Src.Exceptions.Matrices.MatrixDimensionMismatchException;
import Src.Exceptions.Matrices.MatrixMultiplicationArgumentsException;
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

    final double[][] d = {{19, 3, -2}, {32, 0, -10}};
    final Matrix m3 = new Matrix(d);

    final double[][] singleVals = {{1}};
    final Matrix single = new Matrix(singleVals);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rowColumnAndConstructorTest(){
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
        assertTrue(Matrix.getIdentityMatrix(1).times(Matrix.getIdentityMatrix(1)).equals(Matrix.getIdentityMatrix(1)));

        assertThrows(MatrixMultiplicationArgumentsException.class, () -> m1.times(Matrix.getIdentityMatrix(1)));
    }

    @Test
    void addAndSubtract(){
        //Subtract is just add under the hood, so one test uses both of them.
        Matrix res = m2.minus(m3);

        double[][] vals = {{-2, 5, 7}, {-26, 9, 22}};

        assertTrue(new Matrix(vals).equals(res));
        assertThrows(MatrixDimensionMismatchException.class, () -> m2.minus(Matrix.getIdentityMatrix(1)));
    }

    @Test
    void identityMatrixTest(){
        Matrix id3 = Matrix.getIdentityMatrix(3);
        Matrix id1 = Matrix.getIdentityMatrix(1);

        assertEquals(id3.toString(),"1.0 0.0 0.0\n0.0 1.0 0.0\n0.0 0.0 1.0");
        assertEquals(id1.toString(), "1.0");
    }

    @Test
    void equalsTest(){
        double [][] vals = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 0}};
        assertTrue(m1.equals(new Matrix(vals)));
    }

    @Test
    void transposeTest(){
        assertTrue(Matrix.getIdentityMatrix(1).transpose().equals(Matrix.getIdentityMatrix(1)));

        double[][] vals = {{1, 3, 5, 7, 9}, {2, 4, 6, 8, 0}};
        Matrix transpose = new Matrix(vals);

        assertTrue(transpose.equals(m1.transpose()));
    }

    @Test
    void augmentTest(){
        double[][] vals = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix m = new Matrix(vals);

        double[][] toAppend = {{4}, {7}, {0}};
        Matrix toAppendMatrix = new Matrix(toAppend);

        double[][] valsn = {{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 0}};
        Matrix n = new Matrix(valsn);

        assertTrue(m.augmentWith(toAppendMatrix).equals(n));
    }

}