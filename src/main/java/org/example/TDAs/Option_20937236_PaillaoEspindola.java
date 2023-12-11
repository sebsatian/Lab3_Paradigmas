package org.example.TDAs;
import java.util.List;

public class Option_20937236_PaillaoEspindola {
    int code;
    String mensaje;
    int chatbotCodeLink;
    int initialFlowCodeLink;
    List<String> keywords;

    public Option_20937236_PaillaoEspindola(int code, String mensaje, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.mensaje = mensaje;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return mensaje;
    }
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }
    public List<String> getKeywords() {
        return keywords;
    }
}
