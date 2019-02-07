import java.io.IOException;

public class Messenger {
    private MessageService service;

    public Messenger(MessageService service) {
        this.service = service;
    }

    public boolean hasMessages() {
        try {
            return this.service.getAllMessages().length > 0;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public String getFirstMessage() {
        return this.service.getMessage(0);
    }
}
