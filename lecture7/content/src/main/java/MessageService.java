public interface MessageService {
    void sendMessage(String message);
    String[] getAllMessages();
    String getMessage(int index);
}
