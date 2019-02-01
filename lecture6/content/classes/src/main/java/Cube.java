public class Cube extends Box {
    // свойство типичное для куба
    private int length;

    // будем инициализировать куб только длинной его стороны
    public Cube(int length) {
        // в конструктор родительского класса передадим равные значения нашей длинны
        super(length, length, length);
        // инициализируем собственное поле
        this.length = length;
    }

    // конструктор по умолчанию
    public Cube() {
        // вызывает конструктор нашего куба, который мы определили ранее
        this(-1);
    }

    // ПОЛИМОРФИЗМ - переопределили поведение базового класса
    @Override
    public int getVolume() {
        return (int) Math.pow(length, 3);
    }
}
