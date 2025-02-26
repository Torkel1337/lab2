import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {


    HashMap<Class<?>, BufferedImage> imageMap = new HashMap<>();


    HashMap<Object, Point> pointMap = new HashMap<>();


    void moveit(Motorvehicle car, double x, double y) {

        pointMap.put(car.getClass(), new Point(x, y));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            loadImage(Volvo240.class, "pics/Volvo240.jpg");
            loadImage(Scania.class, "pics/Scania.jpg");
            loadImage(Saab95.class, "pics/Saab95.jpg");
            loadImage(RepairShop.class, "pics/VolvoBrand.jpg");

            setPoint(Volvo240.class, 0, 0);
            setPoint(Scania.class, 0, 100);
            setPoint(Saab95.class, 0, 200);
            setPoint(RepairShop.class, 300, 300);


            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // volvoWorkshopImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setPoint(Object o, double x, double y) {
        pointMap.put(o, new Point(x, y));
    }

    private void loadImage(Class<?> c, String imagePath) throws IOException {
        imageMap.put(c, ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream(imagePath))));
    }

    private void drawImage(Graphics g, Class<?> c) {
        g.drawImage(imageMap.get(c), (int) pointMap.get(c).x(), (int) pointMap.get(c).y(), null);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g, Volvo240.class);
        drawImage(g, Saab95.class);
        drawImage(g, Scania.class);
        drawImage(g, RepairShop.class);
    }
}