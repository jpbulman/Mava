package Test;

import Src.Vectors.ColumnVector;
import Src.Vectors.RowVector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void getAtPositionTest(){
        assertEquals(columnVectorLenFive.getAtPosition(1), -1);
        assertEquals(rowVectorLenSeven.getAtPosition(6), 13);
    }

}