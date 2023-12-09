package TDAs;

import java.util.List;

public class Chatbot_20937236_PaillaoEspindola {
    /* Atributos */
    int ID;
    String name;
    String welcomeMessage;
    int startFlowID;
    public List<Flow_20937236_PaillaoEspindola> chatbotFlows;

    /* Constructores */
    public Chatbot_20937236_PaillaoEspindola(int ID, String name, String welcomeMessage, int startFlowID, List<Flow_20937236_PaillaoEspindola> chatbotFlows) {
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
    public List<Flow_20937236_PaillaoEspindola> getChatbotFlows() {
        return chatbotFlows;
    }

    /* Metodo publico chatbotAddFlow*/
    public void chatbotAddFlow(Flow_20937236_PaillaoEspindola newFlow){
        if (!isFlowInChatbot(newFlow)){
            chatbotFlows.add(newFlow);
        }
    }
    /* Metodo privado para comprobar existencia del flujo en el chatbot*/
    private boolean isFlowInChatbot(Flow_20937236_PaillaoEspindola newFlow){
        for (Flow_20937236_PaillaoEspindola flow : chatbotFlows){
            if (flow.getId() == newFlow.getId()){
                return true;
            }
        }
    return false;
    }
    public Flow_20937236_PaillaoEspindola findFlowByID(int currentFlowID) {
        for (Flow_20937236_PaillaoEspindola flow : chatbotFlows) {
            if (flow.getId() == currentFlowID) {
                return flow;
            }
        }
        return null; // Retorna null si no se encuentra el chatbot
    }
}
