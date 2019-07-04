package Test;

import Src.NaturalNumberOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberOperationsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void factorial(){
        Assertions.assertEquals(NaturalNumberOperations.factorial(0), NaturalNumberOperations.factorial(1));
        Assertions.assertEquals(NaturalNumberOperations.factorial(6), 720);

        assertThrows(IndexOutOfBoundsException.class, () -> NaturalNumberOperations.factorial(-1));
    }
}