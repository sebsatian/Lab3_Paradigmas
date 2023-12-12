package org.example.TDAs;
import java.util.List;

/**
 * Interfaz para la clase chatbot
 */
interface ChatbotI {
    int getID();
    String getName();
    String getWelcomeMessage();
    int getStartFlowID();
    List<Flow_20937236_PaillaoEspindola> getChatbotFlows();
    void chatbotAddFlow(Flow_20937236_PaillaoEspindola newFlow);
}

/**
 * Clase chatbot
 */
public class Chatbot_20937236_PaillaoEspindola implements ChatbotI{
    /**
     * Atributos
     */
    int ID;
    String name;
    String welcomeMessage;
    int startFlowID;
    public List<Flow_20937236_PaillaoEspindola> chatbotFlows;

    /**
     * Constructor clase chatbot
     * @param ID numero identificador unico del chatbot
     * @param name nombre del chatbot
     * @param welcomeMessage mensaje para el usuario del chatbot
     * @param startFlowID id del flujo inicial del chatbot
     * @param chatbotFlows lista de flujos del chatbot
     */
    public Chatbot_20937236_PaillaoEspindola(int ID, String name, String welcomeMessage, int startFlowID, List<Flow_20937236_PaillaoEspindola> chatbotFlows) {
        this.ID = ID;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowID = startFlowID;
        this.chatbotFlows = chatbotFlows;
    }

    /**
     * Metodo selector del ID del chatbot
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Metodo selector del nombre del chatbot
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Metodo selector del mensaje de bienvenida del chatbot
     * @return welcomeMessage
     */
    public String getWelcomeMessage() {
        return welcomeMessage;
    }
    /**
     * Metodo selector del ID flujo inicial del chatbot
     * @return startFlowID
     */
    public int getStartFlowID() {
        return startFlowID;
    }
    /**
     * Metodo selector de la lista de flujos del chatbot
     * @return chatbotFlows
     */
    public List<Flow_20937236_PaillaoEspindola> getChatbotFlows() {
        return chatbotFlows;
    }

    /**
     * Metodo para añadir un nuevo flujo al chatbot
     * @param newFlow
     */
    public void chatbotAddFlow(Flow_20937236_PaillaoEspindola newFlow){
        if (!isFlowInChatbot(newFlow)){
            chatbotFlows.add(newFlow);
        }
    }

    /**
     * Metodo privado para comprobar existencia del flujo en el chatbot
     * @param newFlow
     * @return
     */
    private boolean isFlowInChatbot(Flow_20937236_PaillaoEspindola newFlow) {
        for (Flow_20937236_PaillaoEspindola flow : chatbotFlows) {
            if (flow.getId() == newFlow.getId()) {
                return true;
            }
        }
        return false;
    }


}
