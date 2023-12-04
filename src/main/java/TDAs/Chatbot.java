package TDAs;

import java.util.List;
import java.util.ArrayList;
public class Chatbot {
    /* Atributos */
    int ID;
    String name;
    String welcomeMessage;
    int startFlowID;
    public List<Flow> chatbotFlows;

    /* Constructores */
    public Chatbot(int ID, String name, String welcomeMessage, int startFlowID, List<Flow> chatbotFlows) {
        this.ID = ID;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowID = startFlowID;
        this.chatbotFlows = chatbotFlows;
    }
    /* Selectores */
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    public String getWelcomeMessage() {
        return welcomeMessage;
    }
    public int getStartFlowID() {
        return startFlowID;
    }
    public List<Flow> getChatbotFlows() {
        return chatbotFlows;
    }

    /* Metodo publico chatbotAddFlow*/
    public void chatbotAddFlow(Flow newFlow){
        if (!isFlowInChatbot(newFlow)){
            chatbotFlows.add(newFlow);
        }
    }
    /* Metodo privado para comprobar existencia del flujo en el chatbot*/
    private boolean isFlowInChatbot(Flow newFlow){
        for (Flow flow : chatbotFlows){
            if (flow.getId() == newFlow.getId()){
                return true;
            }
        }
    return false;
    }
    public Flow findFlowByID(int currentFlowID) {
        for (Flow flow : chatbotFlows) {
            if (flow.getId() == currentFlowID) {
                return flow;
            }
        }
        return null; // Retorna null si no se encuentra el chatbot
    }
}
