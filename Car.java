import java.awt.Color;

public abstract class Car extends Motorvehicle {


    // init self. --> this.
    Car(int nrDoors, Color color, double enginePower, String modelName, Point position, int direction) {
        super(nrDoors, color, enginePower, modelName, direction, position);
        stopEngine();
    }


}



