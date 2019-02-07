import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MessengerTest {

    @Test
    void hasMessages() {
        // Создали мок-объект интерфейса MessageService
        MessageService service = mock(MessageService.class);
        // Определили, что при вызове метода getAllMessages мок-объект вернет не пустой массив
        when(service.getAllMessages()).thenReturn(new String[1]);

        // далее передели мок-объект тестируемому классу
        Messenger messenger = new Messenger(service);
        // проверяем, что если сервис возвращает не пустой список сообщений, наш класс вернет корктный результат
        assertTrue(messenger.hasMessages());

        // проверяем, что у мок-объекта был вызван метод getAllMessages
        verify(service).getAllMessages();
    }

    @Test
    void getFirstMessage() {
        // создаем мок-объект
        MessageService service = mock(MessageService.class);
        // определим, что когда вызвыаем мет getMessage с аргументом типа int, должны вернуть стоковое представление самого этого аргумента
        when(service.getMessage(anyInt())).thenAnswer(invocationOnMock ->  {
            return invocationOnMock.getArguments()[0].toString();
        });

        // передали мок-объект целевому тестируемому классу
        Messenger messenger = new Messenger(service);
        // проверяем, что сообщение будт содержать нулевой индекс, котрый запросит метод getFirstMessage
        assertEquals("0", messenger.getFirstMessage());
    }

    @Test
    void getWithException() {
        MessageService service = mock(MessageService.class);
        // определили, что при запросе сообщений метод getAllMessages выкинет исключение
        when(service.getAllMessages()).thenThrow(IOException.class);

        Messenger messenger = new Messenger(service);
        // проверяем, что наш мессенджер обработает это исключение и не пробросит дальше
        assertDoesNotThrow(() -> {
            messenger.hasMessages();
        });
    }
}