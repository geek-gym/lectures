import java.awt.*;

public class Circle implements Drawable {
    public Point center;
    public int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("This is circle!");
    }
}
