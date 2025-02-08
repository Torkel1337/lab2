import java.awt.Color;

public class Scania extends FlatbedTruck {

    public Scania() {
        super(2, Color.YELLOW, 200, "Scania Super 460 R", 0, new Point(0, 0));
    }


    @Override
    protected double getMinAngle() {
        return 0;
    }

    @Override
    protected double getMaxAngle() {
        return 70;
    }

    @Override
    protected double getAngleSpeed() {
        return 5;
    }
}
