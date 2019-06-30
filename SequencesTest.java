import org.junit.jupiter.api.AfterEach;
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
        assertEquals(Sequences.getNthTriangleNumber(1), 1);
        assertEquals(Sequences.getNthTriangleNumber(67), 2278);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            Sequences.getNthTriangleNumber(-1);
        });
    }
}