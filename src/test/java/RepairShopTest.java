import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepairShopTest {
    RepairShop<Volvo240> volvoShop;
    RepairShop<Car> carShop;
    Volvo240 volvo1;
    Saab95 saab1;

    @BeforeEach
    void setUp() {
        volvoShop = new RepairShop<Volvo240>(2);
        carShop = new RepairShop<Car>(4);

        volvo1 = new Volvo240();
        saab1 = new Saab95();
    }

    @AfterEach
    void tearDown() {
        volvoShop = null;
        carShop = null;
        volvo1 = null;
        saab1 = null;
    }

    @Test
    void addCar() {
        volvoShop.addCar(volvo1);

        carShop.addCar(volvo1);
        carShop.addCar(saab1);
    }

    @Test
    void removeCar() {
        volvoShop.addCar(volvo1);
        volvoShop.removeCar(volvo1);
    }
}