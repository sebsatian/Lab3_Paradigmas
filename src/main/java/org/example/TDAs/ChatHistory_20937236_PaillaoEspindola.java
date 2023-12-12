package org.example.TDAs;
import java.time.LocalDateTime;

/**
 * Interfaz para ChatHistory
 */
interface ChatHistoryI {
    LocalDateTime getTimestamp();

    String getSender();

    void setSender(String sender);

    String getMessage();

    void setMessage(String message);
}

/**
 * Clase ChatHistory
 */
public class ChatHistory_20937236_PaillaoEspindola implements ChatHistoryI{
    /* Atributos */
    LocalDateTime timestamp;
    String username;
    String message;
    String optionMessage;
    String currentChatbotName;
    Flow_20937236_PaillaoEspindola currentFlow;


    /**
     * Constructor de un ChatHistory
     * @param timestamp x username x es la marca de tiempo
     * @param username es el usuario al cual pertenece este historial
     * @param message es el mensaje del usuario
     * @param optionMessage es el mensaje de la opcion elegida
     * @param currentChatbotName es el nombre del chatbot actual
     * @param currentFlow es el flujo actual
     */
    public ChatHistory_20937236_PaillaoEspindola(LocalDateTime timestamp, String username, String message, String optionMessage, String currentChatbotName, Flow_20937236_PaillaoEspindola currentFlow) {
        this.timestamp = timestamp;
        this.username = username;
        this.message = message;
        this.optionMessage = optionMessage;
        this.currentChatbotName = currentChatbotName;
        this.currentFlow = currentFlow;
    }

    /**
     * Metodo selector de la marca de tiempo
     * @return timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Metodo selector del nombre de usuario
     * @return username
     */
    public String getSender() {
        return username;
    }

    /**
     * Metodo para definir un remitente
     * @param sender es el username a definir como remitente
     */
    public void setSender(String sender) {
        this.username = sender;
    }

    /**
     * Metodo para seleccionar el mensaje
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Metodo para seleccionar el mensaje
     * @param message mensaje del usuario
     */
    public void setMessage(String message) {
        this.message = message;
    }


}
