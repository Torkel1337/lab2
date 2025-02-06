import java.awt.Color;

public class Fiat642 extends FlatbedTruck {

    public Fiat642() {
        super(2, Color.green, 200, "Fiat642", 0, new Point(0, 0));
        int size = 2;
    }

    @Override
    public void raiseBed() {
        if (this.getCurrentSpeed() == 0) {
            bedAngle = 0;
        }
    }

    @Override
    public void lowerBed() {
        if (this.getCurrentSpeed() == 0) {
            bedAngle = 45;
        }
    }


}
