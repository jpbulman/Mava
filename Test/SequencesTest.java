package Test;

import Src.Sequences;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequencesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNthTriangleNumber() {
        Assertions.assertEquals(Sequences.getNthTriangleNumber(1), 1);
        Assertions.assertEquals(Sequences.getNthTriangleNumber(67), 2278);

        assertThrows(IndexOutOfBoundsException.class, () -> Sequences.getNthTriangleNumber(-1));
    }

    @Test
    void Fibonacci(){
        Assertions.assertEquals(Sequences.getNthFibonacciNumber(1), Sequences.getNthFibonacciNumber(2));
        Assertions.assertEquals(Sequences.getNthFibonacciNumber(6), 8);

        assertThrows(IndexOutOfBoundsException.class, () -> Sequences.getNthFibonacciNumber(0));
    }
}