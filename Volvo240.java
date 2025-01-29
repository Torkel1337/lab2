import java.awt.*;

public class Volvo240 extends Car{

    // private final static double trimFactor = 1.25; finns i Car

    
    private Volvo240(){
        super(4, Color.black, 100, false, "Volvo240");
    }
    
    public double speedFactor(){ return enginePower * 0.01 * trimFactor; }

    // inc or dec speed
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
