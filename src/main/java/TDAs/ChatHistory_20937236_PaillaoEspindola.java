package TDAs;
import java.time.LocalDateTime;
public class ChatHistory_20937236_PaillaoEspindola {
    /* Atributos */
    LocalDateTime timestamp;
    String username;
    String message;
    String optionMessage;
    String currentChatbotName;
    Flow_20937236_PaillaoEspindola currentFlow;


    /* Constructores */
    public ChatHistory_20937236_PaillaoEspindola(LocalDateTime timestamp, String username, String message, String optionMessage, String currentChatbotName, Flow_20937236_PaillaoEspindola currentFlow) {
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
