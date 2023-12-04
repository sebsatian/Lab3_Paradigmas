package TDAs;
import java.time.LocalDateTime;
public class ChatHistory {
    /* Atributos */
    LocalDateTime timestamp;
    String username;
    String message;
    String optionMessage;
    String currentChatbotName;
    Flow currentFlow;


    /* Constructores */
    public ChatHistory(LocalDateTime timestamp, String username, String message, String optionMessage, String currentChatbotName, Flow currentFlow) {
        this.timestamp = timestamp;
        this.username = username;
        this.message = message;
        this.optionMessage = optionMessage;
        this.currentChatbotName = currentChatbotName;
        this.currentFlow = currentFlow;
    }

    /* Selectores */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getSender() {
        return username;
    }

    /* Setters */
    public void setSender(String sender) {
        this.username = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
