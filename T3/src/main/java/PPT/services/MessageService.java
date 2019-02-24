package PPT.services;

public class MessageService {
    private static final MessageService instance = new MessageService();
    private boolean hasMessage;
    private String message;

    private MessageService() {
    }

    public static MessageService getInstance() {
        return instance;
    }

    public String getMessage() {
        if (!hasMessage) {
            return null;
        } else {
            hasMessage = false;
            return message;
        }
    }

    public void sendMessage(String msg) {
        message = msg;
        hasMessage = true;
    }
}
