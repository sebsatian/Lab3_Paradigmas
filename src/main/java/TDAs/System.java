package TDAs;

import java.util.List;
import java.util.ArrayList;
public class System {
    /* Atributos */
    String name;
    int initialChatbotCodeLink;
    public List<Chatbot> systemChatbots;

    public List<User> systemUsers;

    /* Constructores */
    public System(String name, int initialChatbotCodeLink, List<Chatbot> systemChatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.systemChatbots = systemChatbots;
        this.systemUsers = new ArrayList<>();

    }

    /* Selectores*/
    public String getName() {
        return name;
    }

    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }

    public List<Chatbot> getChatbots() {
        return systemChatbots;
    }

    public void systemAddChatbot(Chatbot newChatbot){
        if (!isChatbotInSystem(newChatbot)){
            systemChatbots.add(newChatbot);
        }
    }
    private boolean isChatbotInSystem(Chatbot newChatbot){
        for (Chatbot chatbot : systemChatbots){
            if (chatbot.getID() == newChatbot.getID()){
                return true;
            }
        }
    return false;
    }

    public void systemAddUser(User user){

    }
    private boolean isUserInSystem(User newUser){
        for (User user : systemUsers){
            if ((user.getUsername()).equals(newUser.getUsername())){
                return true;
            }
        }
    return false;
    }
}
