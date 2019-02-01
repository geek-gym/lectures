import java.io.IOException;

//Класс наследует все поля и методы родительского класса Box
// НАСЛЕДОВАНИЕ - при наследовании поведение базового класса переносится потомку
public class HeavyBox extends Box {

    // добавляем свойство вес
    private int weight;

    public HeavyBox(int width, int height, int depth, int weight) {
        // вызываем конструктор родительско, чтобы значения длинны ширины были не пустыми
        super(width, height, depth);
        this.weight = weight;
    }

    public HeavyBox() {
        // выываем конструктор по умолчанию базового класса
        super();
        this.weight = 0;
    }

    public void temp() {
        this.width = 100;
    }

    // сообщаем вызывающему коду, что возможно возникновение исключений типа Exception
    public int divide(int left, int right) throws Exception {
        if (right == 0) {
            // можем подать сигнал вызвающему клиенту об исключительной ситуации
            throw new Exception("Division by 0.");
        }
        return left / right;
    }

    public void client_method() throws Exception {

        // try содержит критическую секцию, которая может вызвать исключение
        try {
            // должны обработать исключение или переложить отвественность выше
            int res = this.divide(100, 0);
        }
        // ловит исключение, проверяет тип. если соответсвует то обрабатывем, если нет идем дальше
        // ловим исключение от часных к более общим
        catch (IOException e) {
            // переподключимся к устройству вывода
            // если нужно перебросить исключение
            throw e;
        }
        //
        catch (Exception e) {
            // если не хотим выбоасывать исключение наверх - можем его проглотить
            System.out.println(e.getMessage());
        }
        // сюда попадаем в любом случае: даже если исключение не было
        finally {
            // есть возможность освободить ресурсы, даже если произошло исключение
        }
    }
}
