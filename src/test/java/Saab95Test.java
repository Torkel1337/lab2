import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 saab;

    @BeforeEach
    void setUp() {
        saab = new Saab95();
    }

    @AfterEach
    void tearDown() {
        saab = null;
    }

    @Test
    void speedFactorTurboOn() {
        saab.setTurboOn();
        assertEquals(saab.getEnginePower() * 0.01 * 1.3, saab.speedFactor());
    }

    @Test
    void speedFactorTurboOff() {
        saab.setTurboOff();
        assertEquals(saab.getEnginePower() * 0.01, saab.speedFactor());
    }
}