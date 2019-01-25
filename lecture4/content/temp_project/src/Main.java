import java.awt.*;

public class Main extends Object {

    public static void main(String[] args) {

        Drawable[] geometries = {
                new Triangle(new Point(1,2), new Point(3,4), new Point(5,6)),
                new Rectangle(new Point(1,2), 50, 100),
                new Circle(new Point(1,2), 20)};

        Scene canvas = new Scene(geometries);
        canvas.draw();
    }
}

