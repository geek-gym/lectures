import java.awt.*;

public class Triangle implements Drawable {
    public Point p1;
    public Point p2;
    public Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void draw() {
        System.out.println("This is Triangle!");
    }
}
