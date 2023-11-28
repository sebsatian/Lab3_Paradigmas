package TDAs;
import java.util.List;
import java.util.ArrayList;

public class Option {
    int code;
    String mensaje;
    int chatbotCodeLink;
    int initialFlowCodeLink;
    List<String> keywords;

    public Option(int code, String mensaje, int chatbotCodeLink, int initialFlowCodeLink, List<String> keywords) {
        this.code = code;
        this.mensaje = mensaje;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.keywords = keywords;
    }

    public int getCode() {
        return code;
    }

    public String getMensaje() {
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
