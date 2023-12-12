package org.example.TDAs;
import java.util.List;

/**
 * Interfaz de option
 */
interface OptionI {
    int getCode();
    String getMessage();
    int getChatbotCodeLink();
    int getInitialFlowCodeLink();
    List<String> getKeywords();
}

/**
 * Clase Option
 */
public class Option_20937236_PaillaoEspindola implements OptionI{
    int code;
    String mensaje;
    int chatbotCodeLink;
    int initialFlowCodeLink;
    List<String> keywords;

    /**
     * Constructor de una opcion
     * @param code es el codigo unico de una opcion
     * @param mensaje es el mensaje de la opcion
     * @param chatbotCodeLink es el ID del chatbotlink
     * @param initialFlowCodeLink es el ID del flowlink inicial
     * @param keywords son la palabra clave de la opcion
     */
    public Option_20937236_PaillaoEspindola(int code, String mensaje, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.mensaje = mensaje;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }

    /**
     * Metodo selector del codigo de la opcion
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * Metodo selector del mensaje de la opcion
     * @return message
     */
    public String getMessage() {
        return mensaje;
    }
    /**
     * Metodo selector del ID del chatbotLink
     * @return chatbotCodeLink
     */
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }
    /**
     * Metodo selector del codigo inicial de la opcion
     * @return initialFlowCodeLink
     */
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }
    /**
     * Metodo selector del codigo de la opcion
     * @return code
     */
    public List<String> getKeywords() {
        return keywords;
    }
}
