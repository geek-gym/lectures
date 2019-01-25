public class Scene {
    private Drawable[] geometries;

    public Scene(Drawable[] geometries) {
        this.geometries = geometries;
    }

    public void draw() {
        for (Drawable obj: this.geometries) {
            obj.draw();
        }
    }
}
