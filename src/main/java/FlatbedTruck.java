import java.awt.Color;

public abstract class FlatbedTruck extends Motorvehicle implements Flatbed {

    protected double bedAngle = 0;

    public FlatbedTruck(int nrDoors, Color color, double enginePower, String modelName, int direction, Point position) {
        super(nrDoors, color, enginePower, modelName, direction, position);
    }

    boolean canMove() {
        return bedAngle == 0;
    }

    boolean canRaiseBed() {
        return bedAngle < getMaxAngle() && this.getCurrentSpeed() == 0;
    }

    boolean canLowerBed() {
        return bedAngle > getMinAngle() && this.getCurrentSpeed() == 0;
    }

    protected abstract double getMinAngle();

    protected abstract double getMaxAngle();

    protected abstract double getAngleSpeed();

    public void raiseBed() {
        if (canRaiseBed()) {
            bedAngle = Math.min(getMaxAngle(), bedAngle + getAngleSpeed());
        }
    }

    public void lowerBed() {
        if (canLowerBed()) {
            bedAngle = Math.max(getMinAngle(), bedAngle - getAngleSpeed());
        }
    }

    public double getBedAngle() {
        return bedAngle;
    }

    @Override
    public void gas(double amount) {
        if (canMove()) {
            super.gas(amount);
        }
    }

    @Override
    public void startEngine() {
        if (canMove()) {
            super.startEngine();
        }
    }
}
