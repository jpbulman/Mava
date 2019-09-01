package Test;

import Src.Vectors.ColumnVector;
import Src.Vectors.RowVector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VectorTest {

    private final double[] colVectorLengthFiveValues = {0, -1, 1, 2, 3};
    private final ColumnVector columnVectorLenFive = new ColumnVector(colVectorLengthFiveValues);
    private final double[] rowVectorLengthSevenValues = {1, 2, 3, 5, 7, 11, 13};
    private final RowVector rowVectorLenSeven = new RowVector(rowVectorLengthSevenValues);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void lengthTest(){
        assertEquals(columnVectorLenFive.length(), 5);
        assertEquals(rowVectorLenSeven.length(), 7);
    }

    @Test
    void plusTest(){
        final double[] colVectorLengthFiveValues2 = {-1, 1, 0, 1, 1 };
        final ColumnVector columnVectorLenFive2 = new ColumnVector(colVectorLengthFiveValues2);

        final double[] resultValues = {-1, 0, 1, 3, 4 };
        final ColumnVector resultColumn = new ColumnVector(resultValues);
        assertTrue(columnVectorLenFive2.plus(columnVectorLenFive).equals(resultColumn));
    }

    @Test
    void transposeTest(){
        final double[] colValues = {1, 2, 3, 4};
        final ColumnVector initColVector = new ColumnVector(colValues);
        final RowVector rowVector = initColVector.transpose();

        final double[] rowValues = {1, 2, 3, 4};
        final RowVector initRowVector = new RowVector(rowValues);
        final ColumnVector colVector = initRowVector.transpose();

        assertTrue(rowVector.equals(initRowVector));
        assertTrue(colVector.equals(initColVector));
    }

    @Test
    void getAtPositionTest(){
        assertEquals(columnVectorLenFive.getAtPosition(1), -1);
        assertEquals(rowVectorLenSeven.getAtPosition(6), 13);
    }

    @Test
    void areLinearlyIndependentTest(){
        final double[] linIndepVals1 = {1, -5};
        final ColumnVector col1 = new ColumnVector(linIndepVals1);
        final double[] linIndepVals2 = {2, 3};
        final ColumnVector col2 = new ColumnVector(linIndepVals2);
        assertTrue(ColumnVector.areLinearlyIndependent(col1, col2));

        final double[] depVals1 = {2, 3, 5};
        final double[] depVals2 = {-1, -4, -10};
        final double[] depVals3=  {1, -2, -8};
        final ColumnVector depCol1 = new ColumnVector(depVals1);
        final ColumnVector depCol2 = new ColumnVector(depVals2);
        final ColumnVector depCol3 = new ColumnVector(depVals3);
        assertFalse(ColumnVector.areLinearlyIndependent(depCol1, depCol2, depCol3));
    }

}