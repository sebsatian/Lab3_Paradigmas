package org.example.TDAs;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * Interfaz para el sistema
 */
interface SystemI {
    String getName();
    int getInitialChatbotCodeLink();
    List<Chatbot_20937236_PaillaoEspindola> getChatbots();
    User_20937236_PaillaoEspindola getLoggedUser();
    void setLoggedUser(User_20937236_PaillaoEspindola user);
    void systemAddChatbot(Chatbot_20937236_PaillaoEspindola newChatbot);
    boolean systemAddUser(User_20937236_PaillaoEspindola newUser);
    boolean systemLogin(String username);
    void systemLogout();
    Chatbot_20937236_PaillaoEspindola findChatbotByID(int currentChatbotID);
    Flow_20937236_PaillaoEspindola findFlowByID(int currentFlowID);
    Flow_20937236_PaillaoEspindola systemTalk(String message);
    void systemSynthesis(User_20937236_PaillaoEspindola user);
}

/**
 * Clase System
 */
public class System_20937236_PaillaoEspindola implements SystemI{
    /* Atributos */
    String name;
    int initialChatbotCodeLink;
    public List<Chatbot_20937236_PaillaoEspindola> systemChatbots;
    public List<User_20937236_PaillaoEspindola> systemUsers;
    int currentChatbotID;
    int currentFlowID;
    User_20937236_PaillaoEspindola loggedUser;

    /**
     * Constructor de un sistema
     * @param name nombre del sistema
     * @param initialChatbotCodeLink ID del chatbot inicial
     * @param systemChatbots lista de chatbots en el sistema
     */
    public System_20937236_PaillaoEspindola(String name, int initialChatbotCodeLink, List<Chatbot_20937236_PaillaoEspindola> systemChatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.systemChatbots = systemChatbots;
        this.systemUsers = new ArrayList<>();
        this.currentChatbotID = initialChatbotCodeLink;
        this.currentFlowID = 1;
        this.loggedUser = null;
    }

    /**
     * Metodo para seleccionar el nombre del sistema
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Metodo para seleccionar el ID del chatbot inicial del sistema
     * @return initialChatbotCodeLink
     */
    public int getInitialChatbotCodeLink() {
        return initialChatbotCodeLink;
    }
    /**
     * Metodo para seleccionar la lista de chatbots del sistema
     * @return systemChatbots
     */
    public List<Chatbot_20937236_PaillaoEspindola> getChatbots() {
        return systemChatbots;
    }
    /**
     * Metodo para seleccionar el usuario loggeado del sistema
     * @return loggedUser
     */
    public User_20937236_PaillaoEspindola getLoggedUser() {
        return loggedUser;
    }

    /**
     * Metodo para cambiar al usuario loggeado en el sistema
     * @param user usuario a loggear
     */
    public void setLoggedUser(User_20937236_PaillaoEspindola user) {
        this.loggedUser = user;
    }

    /**
     * Metodo para añandir un nuevo chatbot al sistema
     * @param newChatbot nuevo chatbot agregar
     */
    public void systemAddChatbot(Chatbot_20937236_PaillaoEspindola newChatbot){
        if (!isChatbotInSystem(newChatbot)){
            systemChatbots.add(newChatbot);
        }
    }

    /**
     * Metodo para comprobar si hay un chatbot en el sistema
     * @param newChatbot nuevo chatbot a agregar
     * @return True si se encuentra al chatbot en el sistema, False si no
     */
    public boolean isChatbotInSystem(Chatbot_20937236_PaillaoEspindola newChatbot){
        for (Chatbot_20937236_PaillaoEspindola chatbot : systemChatbots){
            if (chatbot.getID() == newChatbot.getID()){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para registrar un usuario
     * @param newUser usuario a añadir
     * @return True si se agrega, False si no
     */
    public boolean systemAddUser(User_20937236_PaillaoEspindola newUser){
        if(!isUserInSystem(newUser)){
            systemUsers.add(newUser);
            return true; /* Usuario agregado exitosamente */
        } else {
            return false; /*  Usuario ya existe en el sistema */
        }
    }

    /**
     * Metodo privado para comprobar si un usuario existe dentro del sistema
     * @param newUser usuario a comprobar
     * @return True si el usuario esta en el sistema, False si no
     */
    private boolean isUserInSystem(User_20937236_PaillaoEspindola newUser){
        for (User_20937236_PaillaoEspindola user : systemUsers){
            if ((user.getUsername()).equals(newUser.getUsername())){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para iniciar sesion a un usuario
     * @param username nombre de usuario
     * @return True si se inicio sesion, False si no
     */
    public boolean systemLogin(String username) {
        for (User_20937236_PaillaoEspindola user : systemUsers) {
            if (user.getUsername().equals(username) && user.getUserStatus().equals("notLogged")) {
                user.setUserStatus("logged");
                this.loggedUser = user;
                return true;
            }
        }
        return false;
    }


    /**
     * Metodo que comprueba si hay algun usuario loggeado
     * @return True si hay un user loggeado, False si no
     */
    private boolean isAnyUserLogged(){
        return this.loggedUser != null;
    }

    /**
     * Metodo publico para cerrar la sesion del usuario que la tenga iniciada
     */
    public void systemLogout(){
        if (this.loggedUser != null && this.loggedUser.getUserStatus().equals("logged")){
            this.loggedUser.setUserStatus("notLogged");
            this.loggedUser = null;
        }
    }

    /**
     * Metodo privado para encontrar el flujo y el chatbot actuales
      * @param currentChatbotID ID del chatbot actual
     * @return chatbot
     */
    public Chatbot_20937236_PaillaoEspindola findChatbotByID(int currentChatbotID) {
        for (Chatbot_20937236_PaillaoEspindola chatbot : this.systemChatbots) {
            if (chatbot.getID() == currentChatbotID) {
                return chatbot;
            }
        }
        return null;
    }

    /**
     * Metodo para comprobar si la entrada del usuario es un numero
     * @param message mensaje del usuario
     * @return True si es un numero, False si no
     */
    private boolean isNumber(String message){
        try {
            Integer.parseInt(message);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Metodo privado para encontrar la opcion segun el numero de la entrada
     * @param message mensaje del usuario
     * @param currentFlow flujo actual
     * @return option
     */
    private Option_20937236_PaillaoEspindola findOptionByNumber(String message, Flow_20937236_PaillaoEspindola currentFlow){
        for (Option_20937236_PaillaoEspindola option : currentFlow.getFlowOptions()) {
            if (option.getMessage().contains(message)) {
                return option;
            }
        }
        return null;
    }

    /**
     * Metodo privado para encontrar la opcion segun la palabra de la entrada
     * @param message mensaje del usuario
     * @param currentFlow flujo actual
     * @return option
     */
    private Option_20937236_PaillaoEspindola findOptionByKeyword(String message, Flow_20937236_PaillaoEspindola currentFlow){
        String lowerCaseMessage = message.toLowerCase();
        for (Option_20937236_PaillaoEspindola option : currentFlow.getFlowOptions()) {
            List<String> keywords = option.getKeywords();

            for (String keyword : keywords) { //
                if (keyword.toLowerCase().contains(lowerCaseMessage)) {
                    return option;
                }
            }
        }
        return null;
    }

    /**
     * Metodo para comprobar si ya existe un flujo segun la ID
     * @param currentFlowID ID del flujo actual
     * @return flow
     */
    public Flow_20937236_PaillaoEspindola findFlowByID(int currentFlowID) {
        for (Chatbot_20937236_PaillaoEspindola chatbot : systemChatbots) {
            List<Flow_20937236_PaillaoEspindola> chatbotFlows = chatbot.getChatbotFlows();

            for (Flow_20937236_PaillaoEspindola flow : chatbotFlows) {
                if (flow.getId() == currentFlowID) {
                    return flow;
                }
            }
        }
        return null;
    }

    /**
     * Metodo publico para las interacciones del usuario, guarda las interacciones en el historial
     *  y actualiza el chatbot y flujo actuales para llevar al usuario a su proxima interaccion
     * @param message mensaje del usuario
     * @return botAnswer
     */
    public Flow_20937236_PaillaoEspindola systemTalk(String message) {
        /* Comprobar si hay un usuario loggeado */
        if (isAnyUserLogged()) {
            /* Obtener el chatbot actual */
            Chatbot_20937236_PaillaoEspindola currentChatbot = findChatbotByID(this.currentChatbotID);

            /* Obtener el flujo actual */
            Flow_20937236_PaillaoEspindola currentFlow = findFlowByID(this.currentFlowID);

            /* Inicializar selectedOption, que luego se modificará según la entrada del usuario */
            Option_20937236_PaillaoEspindola selectedOption = null;

            /* Determinar la opción seleccionada en función del tipo de mensaje */
            if (isNumber(message)) {
                selectedOption = findOptionByNumber(message, currentFlow);
            } else {
                selectedOption = findOptionByKeyword(message, currentFlow);
            }

            if (selectedOption != null) {
                /* Actualizar el estado del sistema */
                this.currentChatbotID = selectedOption.getChatbotCodeLink();
                this.currentFlowID = selectedOption.getInitialFlowCodeLink();

                /* Encontrar el nuevo flujo que se considerará como la respuesta del chatbot */
                Flow_20937236_PaillaoEspindola botAnswer = findFlowByID(this.currentFlowID);

                /* Verificar si botAnswer es válido antes de continuar */
                if (botAnswer != null) {
                    /* Crear una nueva entrada en ChatHistory para guardar la interacción del usuario */
                    ChatHistory_20937236_PaillaoEspindola userInteraction = new ChatHistory_20937236_PaillaoEspindola(
                            LocalDateTime.now(),
                            getLoggedUser().getUsername(),
                            message,
                            selectedOption.getMessage(),
                            currentChatbot.getName(),
                            botAnswer);
                    /* Agregar la nueva entrada de ChatHistory al historial del usuario */
                    getLoggedUser().getHistorial().add(userInteraction);

                    /* Actualizar el flujo actual con botAnswer */
                    this.currentFlowID = botAnswer.getId();
                    /* Devolver botAnswer como resultado */
                    return botAnswer;
                }
            }
        }

        return null;
    }

    /**
     * Metodo systemSynthesis, imprime en pantalla un resumen sobre el historial de un usuario
     * @param user usuario al cual imprimir el historial, es el usuario loggeado actual
     */
    public void systemSynthesis(User_20937236_PaillaoEspindola user) {
        if (user == null) {
            System.out.println("No hay usuario loggeado.");
            return;
        }

        System.out.println("Historial de interacciones para el usuario: " + user.getUsername());

        for (ChatHistory_20937236_PaillaoEspindola chatHistory : user.getHistorial()) {
            /* Imprime la marca de tiempo, el nombre de usuario, el mensaje del usuario y la opcion elegida*/
            System.out.println(chatHistory.getTimestamp() + " - " + chatHistory.getSender() + ": " + chatHistory.getMessage());
            System.out.println(chatHistory.getTimestamp() + " - " + "Opción Elegida: " + chatHistory.optionMessage);

            /* Imprime la respuesta del chatbot */
            if (chatHistory.currentFlow != null) {
                System.out.println(chatHistory.getTimestamp() + " - " + chatHistory.currentChatbotName + ": " + chatHistory.currentFlow.getMessage());
                for (Option_20937236_PaillaoEspindola option : chatHistory.currentFlow.flowOptions) {
                    System.out.println(option.getCode() + ") " + option.getMessage());
                }
            }
        }
    }
}