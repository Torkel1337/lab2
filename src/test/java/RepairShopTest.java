import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepairShopTest {
    RepairShop<Volvo240> volvoShop;
    RepairShop<Car> carShop;
    Volvo240 volvo1;
    Saab95 saab1;
    Volvo240 volvo2;

    @BeforeEach
    void setUp() {
        volvoShop = new RepairShop<Volvo240>(2);
        carShop = new RepairShop<Car>(2);

        volvo1 = new Volvo240();
        saab1 = new Saab95();
        volvo2 = new Volvo240();
    }

    @AfterEach
    void tearDown() {
        volvoShop = null;
        carShop = null;
        volvo1 = null;
        saab1 = null;
        volvo2 = null;
    }

    @Test
    void addCar() {
        carShop.addCar(volvo1);
        carShop.addCar(saab1);
        assertTrue(carShop.contains(volvo1));
    }

    @Test
    void maxSize() {
        carShop.addCar(volvo1);
        carShop.addCar(volvo2);
        carShop.addCar(saab1);
        assertFalse(carShop.contains(saab1));
    }

    @Test
    void removeCar() {
        carShop.addCar(volvo1);
        carShop.addCar(saab1);
        Car c = carShop.removeCar();
        assertFalse(carShop.contains(volvo1));
        assertInstanceOf(Volvo240.class, c);
    }
}
