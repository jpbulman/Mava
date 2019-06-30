import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class RealNumberOperationsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sum() {
        assertEquals(RealNumberOperations.sum(0, 1, 2, 3), 6);
        assertEquals(RealNumberOperations.sum(-5, 5, -1, 1), 0);
        assertEquals(RealNumberOperations.sum(Math.PI, 3, 1, -2), Math.PI+2);
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
        LinkedList<Number> empty = new LinkedList<Number>();

        assertEquals(RealNumberOperations.sum(array), Math.E + 12);
        assertEquals(RealNumberOperations.sum(linkedList), -441 + Math.PI);
        assertEquals(RealNumberOperations.sum(empty, linkedList), -441 + Math.PI);
    }
}