public class RepairShop<T extends Car> {
    FixedStack<T> stack;


    public RepairShop(int capacity) {
        stack = new FixedStack<T>(capacity);
    }

    public void addCar(T car) {
        stack.push(car);
    }

    public void removeCar(T car) {
        stack.remove(car);
    }
}
