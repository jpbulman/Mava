package Test;

import Src.Exception.CombinatoricsArgumentsException;
import Src.Exception.NegativeArgumentException;
import Src.NaturalNumberOperations;
import org.junit.jupiter.api.AfterEach;
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
        assertEquals(NaturalNumberOperations.factorial(0), NaturalNumberOperations.factorial(1));
        assertEquals(NaturalNumberOperations.factorial(6), 720);

        assertThrows(IndexOutOfBoundsException.class, () -> NaturalNumberOperations.factorial(-1));
    }

    @Test
    void permutations() throws Exception{
        assertEquals(NaturalNumberOperations.permutations(0, 0), 1);
        assertEquals(NaturalNumberOperations.permutations(5, 3), 60);

        assertThrows(CombinatoricsArgumentsException.class, () -> NaturalNumberOperations.permutations(3, 6));
        assertThrows(NegativeArgumentException.class, () -> NaturalNumberOperations.permutations(-1, 4));
    }

}