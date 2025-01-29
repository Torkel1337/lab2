import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    Volvo240 volvo;

    @BeforeEach
    void setUp() {
        volvo = new Volvo240();
    }

    @AfterEach
    void tearDown() {
        volvo = null;
    }

    @Test
    void speedFactor() {
        assertEquals(volvo.getEnginePower() * 0.01 * 1.25, volvo.speedFactor());
    }
}