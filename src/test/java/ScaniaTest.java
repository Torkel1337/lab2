import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScaniaTest {
    Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @AfterEach
    void tearDown() {
        scania = null;
    }

    @Test
    void MinAngle() {
        scania.stopEngine();
        scania.lowerBed();
        assertEquals(scania.getBedAngle(), scania.getMinAngle());
    }

    @Test
    void MaxAngle() {
        for (int i = 0; i < 20; i++) {
            scania.raiseBed();
        }
        assertEquals(scania.getBedAngle(), scania.getMaxAngle());
    }

    @Test
    void raiseWhileMoving() {
        scania.startEngine();
        scania.raiseBed();
        assertEquals(0, scania.getBedAngle());
    }

    @Test
    void raiseWhileStopped() {
        scania.stopEngine();
        scania.raiseBed();
        assertEquals(5, scania.getBedAngle());
    }

    @Test
    void CantMoveWhileRaised() {
        scania.raiseBed();
        scania.startEngine();
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed());
    }

}