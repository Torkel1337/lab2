import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4, Color.black, 100,  "Volvo240", new Point(0,0), 0);
    }

    @Override
    protected double speedFactor() {
        return super.speedFactor() * trimFactor;
    }
}