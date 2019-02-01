import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    @Test
    void getVolume() {
        Cube cube = new Cube();
        assert cube.getVolume() == -1;
    }
}