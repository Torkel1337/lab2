import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

public class CarTest {
    TestCar car;

    private class TestCar extends Car {
        public TestCar() {
            super(4, Color.blue, 130, "Volvo142", new Point(0, 0), 0);
        }
    }

    @BeforeEach
    void setUp() {
        car = new TestCar();
    }

    @AfterEach
    void tearDown() {
        car = null;
    }

    @Test
    void getNrDoors() {
        assertEquals(4, car.getNrDoors());

    }

    @Test
    void getEnginePower() {
        assertEquals(130, car.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.blue, car.getColor());
    }

    @Test
    void setColor() {
        car.setColor(Color.green);
        assertEquals(Color.green, car.getColor());
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
        assertEquals(car.getEnginePower() * 0.01, car.speedFactor());

    }

    @Test
    void moveNORTH() {
        car.startEngine();
        double prevX = car.getPosition().x();
        car.move();
        assertEquals(prevX, car.getPosition().x());
        assertEquals(0.1, car.getPosition().y());

    }

    @Test
    void moveEAST() {
        car.startEngine();
        car.turnRight();
        double prevY = car.getPosition().y();
        car.move();
        assertEquals(prevY, car.getPosition().y());
        assertEquals(0.1, car.getPosition().x());
    }

    @Test
    void moveSOUTH() {
        car.startEngine();
        car.turnRight();
        car.turnRight();
        double prevX = car.getPosition().x();
        car.move();
        assertEquals(prevX, car.getPosition().x());
        assertEquals(-0.1, car.getPosition().y());
    }

    @Test
    void moveWEST() {
        car.startEngine();
        car.turnLeft();
        double prevY = car.getPosition().y();
        car.move();
        assertEquals(prevY, car.getPosition().y());
        assertEquals(-0.1, car.getPosition().x());
    }


    @Test
    void turnLeft() {
        car.turnLeft();
        assertEquals(3, car.direction);
    }

    @Test
    void turnRight() {
        car.turnRight();
        assertEquals(1, car.direction);
    }

    @Test
    void gas() {
        car.startEngine();
        car.gas(3);
        assertEquals(0.1, car.getCurrentSpeed());
    }

    @Test
    void increase() {
        car.startEngine();
        double prev_speed = car.getCurrentSpeed();
        car.gas(1);
        assertTrue(prev_speed < car.getCurrentSpeed());

    }

    @Test
    void currentSpeed() {
        car.startEngine();
        for (int i = 0; i < 100; i++) {
            car.gas(1);
        }
        assertTrue(car.getCurrentSpeed() <= car.getEnginePower() && 0 <= car.getCurrentSpeed());
    }

    @Test
    void brake() {
        car.startEngine();
        car.brake(3);
        assertEquals(0.1, car.getCurrentSpeed());
    }

    @Test
    void decrease() {
        car.startEngine();
        for (int i = 0; i < 30; i++) {
            car.gas(1);
            double prev_speed = car.getCurrentSpeed();
            car.brake(1);
            assertTrue(prev_speed > car.getCurrentSpeed());
        }
    }
}