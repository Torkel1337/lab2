import java.awt.Color;

public class Scania extends FlatbedTruck {

    public Scania() {
        super(2, Color.YELLOW, 200, "Scania Super 460 R", 0, new Point(0, 0));
    }


    @Override
    public void raiseBed() {
        if (bedAngle < 70 && this.getCurrentSpeed() == 0) {
            bedAngle += angleSpeed;
        }
        if (bedAngle > 70) {
            bedAngle = 70;
        }
    }

    @Override
    public void lowerBed() {
        if (bedAngle > 0 && this.getCurrentSpeed() == 0) {
            bedAngle -= angleSpeed;
        }
        if (bedAngle < 0) {
            bedAngle = 0;
        }
    }
}
