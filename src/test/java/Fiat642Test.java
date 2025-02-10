import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Fiat642Test {
    Fiat642 fiat;
    Volvo240 volvo;
    Saab95 saab;
    Fiat642 fiat2;


    @BeforeEach
    void setUp() {
        fiat = new Fiat642();
        volvo = new Volvo240();
        saab = new Saab95();
        fiat2 = new Fiat642();
    }

    @AfterEach
    void tearDown() {
        fiat = null;
        volvo = null;
    }

    @Test
    void twoPositions() {
        fiat.raiseBed();
        assertEquals(fiat.getMaxAngle(), fiat.getBedAngle());
        fiat.lowerBed();
        assertEquals(fiat.getMinAngle(), fiat.getBedAngle());
    }

    @Test
    void cantMoveWhileRaised() {
        fiat.raiseBed();
        fiat.startEngine();
        fiat.gas(5);
        assertEquals(0, fiat.getCurrentSpeed());
    }

    @Test
    void loadCarOnlyWhenNear() {
        volvo.setPosition(new Point(3, 0));
        fiat.setPosition(new Point(0, 0));
        fiat.loadCar(volvo);
        assertFalse(fiat.contains(volvo));

        volvo.setPosition(new Point(1, 0));
        fiat.loadCar(volvo);
        assertTrue(fiat.contains(volvo));
    }

    @Test
    void loadCarWhenRampIsLowerd() {
        volvo.setPosition(new Point(1, 1));
        fiat.setPosition(new Point(0, 0));
        fiat.raiseBed();
        fiat.loadCar(volvo);
        assertFalse(fiat.contains(volvo));

        fiat.lowerBed();
        fiat.loadCar(volvo);
        assertTrue(fiat.contains(volvo));
    }

    @Test
    void unloadCarWhenRampIsLowerd() {
        volvo.setPosition(new Point(1, 1));
        fiat.setPosition(new Point(0, 0));
        fiat.loadCar(volvo);
        fiat.raiseBed();
        fiat.unloadCar();
        assertTrue(fiat.contains(volvo));

        fiat.lowerBed();
        fiat.unloadCar();
        assertFalse(fiat.contains(volvo));
    }

    @Test
    void FILO() {
        volvo.setPosition(new Point(1, 0));
        saab.setPosition(new Point(1, 0));
        fiat.setPosition(new Point(0, 0));
        fiat.lowerBed();
        fiat.loadCar(volvo);
        fiat.loadCar(saab);
        assertEquals(saab, fiat.unloadCar());
        assertEquals(volvo, fiat.unloadCar());
    }

    @Test
    void loadedCarPosition() {
        volvo.setPosition(new Point(1, 0));
        fiat.setPosition(new Point(0, 0));
        fiat.loadCar(volvo);
        fiat.startEngine();
        fiat.gas(5);
        assertEquals(fiat.getPosition(), volvo.getPosition());
    }

    @Test
    void cantLoadFiat() {
        //fiat.loadCar(fiat2); //can't compile
    }

}