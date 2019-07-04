package Test;

import Src.RealNumberOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RealNumberOperationsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sum() {
        Assertions.assertEquals(RealNumberOperations.sum(0, 1, 2, 3), 6);
        Assertions.assertEquals(RealNumberOperations.sum(-5, 5, -1, 1), 0);
        Assertions.assertEquals(RealNumberOperations.sum(Math.PI, 3, 1, -2), Math.PI+2);
    }

    @Test
    void sum1() {
        Number[] array = {-1, 0, 1, 4, 8, Math.E};
        LinkedList<Number> linkedList = new LinkedList<Number>(){{
            add(-987);
            add(3);
            add(543);
            add(Math.PI);
        }};
        LinkedList<Number> empty = new LinkedList<>();

        Assertions.assertEquals(RealNumberOperations.sum(array), Math.E + 12);
        Assertions.assertEquals(RealNumberOperations.sum(linkedList), -441 + Math.PI);
        Assertions.assertEquals(RealNumberOperations.sum(empty, linkedList), -441 + Math.PI);
    }

    @Test
    void product(){
        Assertions.assertEquals(RealNumberOperations.product(0, 9),0);
        Assertions.assertEquals(RealNumberOperations.product(1, 5), 5);
        Assertions.assertEquals(RealNumberOperations.product(5, 2, 8, 2), 160);
        Assertions.assertEquals(RealNumberOperations.product(1.5, 2.97), 4.455);
    }

}