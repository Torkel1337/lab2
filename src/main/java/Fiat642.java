import java.awt.Color;

public class Fiat642 extends FlatbedTruck implements CarTransport {

    private static final double OPEN_ANGLE = 0;
    private static final double CLOSED_ANGLE = 45;
    FixedDeque<Car> loadedCars;

    public Fiat642() {
        super(2, Color.green, 200, "Fiat642", 0, new Point(0, 0));
        int size;

        loadedCars = new FixedDeque<>(3);
    }

    @Override
    protected double getMinAngle() {
        return OPEN_ANGLE;
    }

    @Override
    protected double getMaxAngle() {
        return CLOSED_ANGLE;
    }

    @Override
    protected double getAngleSpeed() {
        return CLOSED_ANGLE;
    }

    public boolean contains(Car car) {
        return loadedCars.contains(car);
    }

    public boolean carIsNear(Car car) {
        double xDiff = this.getPosition().x() - car.getPosition().x();
        double yDiff = this.getPosition().y() - car.getPosition().y();
        boolean result;
        result = Math.abs(xDiff) < 2 && Math.abs(yDiff) < 2;
        return result;
    }

    @Override
    public void loadCar(Car car) {
        if (this.getBedAngle() == getMinAngle() && carIsNear(car)) {
            loadedCars.addFirst(car);
            car.setPosition(this.getPosition());
            car.stopEngine();
        }
    }

    @Override
    public Car unloadCar() {
        if (this.getBedAngle() == getMinAngle()) {
            return loadedCars.removeFirst();
        }
        return null;
    }

    @Override
    public void move() {
        super.move();
        loadedCars.forEach(c -> c.setPosition(this.getPosition()));
    }
}

