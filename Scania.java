import java.awt.*;

public class Scania extends Car {

    public Scania() { super(2, Color.YELLOW, 200, "Scania Super 460 R", new Point(0, 0), 0); }

    //private boolean isStopped;
    private int angleSpeed = 5;
    private int bedAngle = 0;

    public void tiltBed() {
        if (bedAngle < 70 && Scania.getCurrentSpeed() <= 0.1) { bedAngle += angleSpeed; }
        if (bedAngle > 70) { bedAngle = 70; }
    }
    public void lowerBed() {
        if (bedAngle > 0 && isStopped) { bedAngle += angleSpeed; }
        if (bedAngle < 0) { bedAngle = 0; }
    }
}
