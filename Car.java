import java.awt.*;

public abstract class Car {

    public final static double trimFactor = 1.25; // med här eller i sub?
    private double currentSpeed; // The current speed of the car

    protected int nrDoors;
    protected Color color;
    protected double enginePower;
    protected boolean turboOn;
    protected String modelName;

    // init self. --> this.
    Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    // Getters
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){ return currentSpeed; }
    public Color getColor(){
        return color;
    }


    // Setters
    public void setColor(Color clr){
        color = clr;
    }

    // Engine start/stop
    public void startEngine(){ currentSpeed = 0.1; }
    public void stopEngine(){
        currentSpeed = 0;
    }


    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

}



