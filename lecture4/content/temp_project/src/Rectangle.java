import java.awt.*;

public class Rectangle implements Drawable {
    public Point p1;
    public int width;
    public int height;

    public Rectangle(Point startPoint, int width, int height) {
        this.p1 = startPoint;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("This is rectangle");
    }
}
