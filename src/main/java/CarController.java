import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Motorvehicle> cars = new ArrayList<>();

    RepairShop<Volvo240> repairShop = new RepairShop<>(3);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        var c1 = new Volvo240();
        c1.setPosition(new Point(0, 0));
        cc.cars.add(c1);


        var c2 = new Saab95();
        c2.setPosition(new Point(0, 100));
        cc.cars.add(c2);


        var c3 = new Scania();
        c3.setPosition(new Point(0, 200));
        cc.cars.add(c3);


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Motorvehicle car : cars) {
                car.move();
                if (car.getPosition().x() > frame.drawPanel.getWidth() - frame.drawPanel.imageMap.get(car.getClass()).getWidth() || car.getPosition().y() > frame.drawPanel.getHeight() - frame.drawPanel.imageMap.get(car.getClass()).getHeight() || car.getPosition().x() < 0 || car.getPosition().y() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                int x = (int) Math.round(car.getPosition().x());
                int y = (int) Math.round(car.getPosition().y());
                frame.drawPanel.moveit(car, x, y);

                if ((car.getPosition().x() >= frame.drawPanel.pointMap.get(RepairShop.class).x() && car.getPosition().x() <= frame.drawPanel.pointMap.get(RepairShop.class).x() + frame.drawPanel.imageMap.get(RepairShop.class).getWidth()) &&
                        (car.getPosition().y() >= frame.drawPanel.pointMap.get(RepairShop.class).y() && car.getPosition().y() <= frame.drawPanel.pointMap.get(RepairShop.class).y() + frame.drawPanel.imageMap.get(RepairShop.class).getHeight())) {
                    if (car instanceof Volvo240) {

                        repairShop.addCar((Volvo240) car);
                        car.stopEngine();
                    }
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Motorvehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Motorvehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void startAllCars() {
        for (Motorvehicle car : cars
        ) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Motorvehicle car : cars
        ) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Motorvehicle car : cars
        ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Motorvehicle car : cars
        ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void raiseBed() {
        for (Motorvehicle car : cars
        ) {
            if (car instanceof Scania) {
                ((Scania) car).raiseBed();
            }
        }
    }

    void lowerBed() {
        for (Motorvehicle car : cars
        ) {
            if (car instanceof Scania) {
                ((Scania) car).lowerBed();
            }
        }
    }

}