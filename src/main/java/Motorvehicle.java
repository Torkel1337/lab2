import java.awt.Color;

public abstract class Motorvehicle implements Movable {

    // Direction array
    private final static Point NORTH = new Point(0, 1);
    private final static Point EAST = new Point(1, 0);
    private final static Point SOUTH = new Point(0, -1);
    private final static Point WEST = new Point(-1, 0);
    protected final static Point[] factors = {NORTH, EAST, SOUTH, WEST};


    protected final int nrDoors;
    protected final double enginePower;
    protected final String modelName;
    protected Color color;
    protected Point position = new Point(0, 0);
    int direction;
    private double currentSpeed; // The current speed of the car

    public Motorvehicle(int nrDoors, Color color, double enginePower, String modelName, int direction, Point position) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.direction = direction;
        this.position = position;
    }

    // Getters
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    // Setters
    public void setColor(Color clr) {
        color = clr;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point pos) {
        position = pos;
    }

    public void setDirection(int dir) {
        direction = Math.floorMod(dir, 4);
    }

    // Engine start/stop
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected double speedFactor() {
        return enginePower * 0.01;
    }

    // inc or dec speed
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);

    }

    // Movable
    public void move() {
        position = new Point(position.x() + getCurrentSpeed() * factors[direction].x(), position.y() + getCurrentSpeed() * factors[direction].y());
    }

    public void turnLeft() {
        direction = Math.floorMod(direction - 1, 4);
    }

    public void turnRight() {
        direction = Math.floorMod(direction + 1, 4);

    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }

    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
