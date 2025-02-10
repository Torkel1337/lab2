public class RepairShop<T extends Car> {
    FixedDeque<T> cars;


    public RepairShop(int capacity) {
        cars = new FixedDeque<>(capacity);
    }

    public void addCar(T car) {
        cars.addLast(car);
    }

    public boolean contains(T car) {
        return cars.contains(car);
    }

    public T removeCar() {
        return cars.removeFirst();
    }
}
