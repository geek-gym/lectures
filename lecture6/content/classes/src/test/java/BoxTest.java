import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void getVolume() {
        // создание объекта Box
        Box box = new Box();

        // посчитаем объем объекта и сравним с -1
        assert -1 == box.getVolume();
    }
}