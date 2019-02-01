import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class HeavyBoxTest {

    @Test
    void getVolume() {
        HeavyBox box = new HeavyBox();
        assert box.getVolume() == -1;
    }

    @Test
    void assert_test() {

        // сравнение по значению
        assertEquals(1,1);
        assertNotEquals(1, 2);

        // сравнение по ссылке
        Object a = new Object();
        Object b = a;
        assertSame(a, b);
        assertNotSame(a, new Object());

        // проверка истины
        assertTrue(1 == 1);
        assertFalse(1 == 2);

        // проверка на пустоту
        Object c = null;
        assertNull(c);
        assertNotNull(a);

        // проверка массивов
        String[] arr1 = { "1", "2", "3" };
        String[] arr2 = { "1", "2", "3" };
        assertArrayEquals(arr1, arr2);

        assertTimeout(Duration.ofMillis(2000), () -> { Thread.sleep(3000); });

    }
}