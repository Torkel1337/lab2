import java.awt.Color;

public abstract class FlatbedTruck extends Motorvehicle implements Flatbed {
    //private boolean isStopped;
    protected double angleSpeed = 5;
    protected double bedAngle = 0;

    public FlatbedTruck(int nrDoors, Color color, double enginePower, String modelName, int direction, Point position) {
        super(nrDoors, color, enginePower, modelName, direction, position);
    }


    public abstract void raiseBed();

    public abstract void lowerBed();

    public double getBedAngle() {
        return bedAngle;
    }

    @Override
    public void gas(double amount) {
        if (getBedAngle() == 0) {
            super.gas(amount);
        }
    }
}
