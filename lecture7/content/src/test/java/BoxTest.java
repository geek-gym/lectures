import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class BoxTest {

    @Test
    void getVolume() {
        Box spyBox = spy(new Box());
        spyBox.getVolume();

        verify(spyBox).getVolume();
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void testAdd(int left, int right, int result) {
        assertEquals(result, left + right);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "3"})
    void testSimpleParameter(String str) {
        assertEquals("1", str);
    }

    private static Stream<Arguments> getArgs() {
        return Stream.of(Arguments.of(0, 0, 0), Arguments.of(1, 10, 11), Arguments.of(5, 6, 2));
    }
}