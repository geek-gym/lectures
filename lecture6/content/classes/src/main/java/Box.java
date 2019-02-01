// базовый класс Box
public class Box {

    //основные свойства коробки - длинна, глубина, высота
    // protected - поле доступно наследникам этого класса
    protected int width;

    //private - позволяет скрыть реализацию
    private int height;
    private int depth;

    //конструктор по умолчанию, вызывается конструируем объект new Box()
    public Box() {
        this.width = -1;
        this.height = -1;
        this.depth = -1;
    }

    //конструктор вызовется, когда new Box(1,2,3)
    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    //метод расчета объема - можно вызвать только у экземплра коробки
    public int getVolume() {
        return this.depth * this.height * this.width;
    }

}
