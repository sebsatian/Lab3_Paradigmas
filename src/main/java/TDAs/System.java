package TDAs;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


public class System {
    /* Atributos */
    String name;
    int initialChatbotCodeLink;
    public List<Chatbot> systemChatbots;
    public List<User> systemUsers;
    int currentChatbotID;
    int currentFlowID;
    User loggedUser;

    /* Constructores */
    public System(String name, int initialChatbotCodeLink, List<Chatbot> systemChatbots) {
        this.name = name;
        this.initialChatbotCodeLink = initialChatbotCodeLink;
        this.systemChatbots = systemChatbots;
        this.systemUsers = new ArrayList<>();
        this.currentChatbotID = initialChatbotCodeLink;
        this.currentFlowID = -1;
        this.loggedUser = null;
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
    public User getLoggedUser() {
        return loggedUser;
    }

    /* Setters */
    public void setLoggedUser(User user) {
        this.loggedUser = user;
    }

    /* Metodo publico para añadir un chatbot a la lista de chatbots del sistema */
    public void systemAddChatbot(Chatbot newChatbot){
        if (!isChatbotInSystem(newChatbot)){
            systemChatbots.add(newChatbot);
        }
    }

    /* Metodo privado para comprobar si un chatbot existe dentro del sistema */
    private boolean isChatbotInSystem(Chatbot newChatbot){
        for (Chatbot chatbot : systemChatbots){
            if (chatbot.getID() == newChatbot.getID()){
                return true;
            }
        }
    return false;
    }

    /* Metodo publico para añadir un usuario a la lista de usuarios del sistema */
    public void systemAddUser(User newUser){
        if(!isUserInSystem(newUser)){
            systemUsers.add(newUser);
        }
    }

    /* Metodo privado para comprobar si un usuario existe dentro del sistema */
    private boolean isUserInSystem(User newUser){
        for (User user : systemUsers){
            if ((user.getUsername()).equals(newUser.getUsername())){
                return true;
            }
        }
    return false;
    }

    /* Metodo publico para iniciar sesion a un usuario*/
    public void systemLogin(String username){
        for (User user : systemUsers){
            if (user.getUsername().equals(username) && user.getUserStatus().equals("notLogged")){
                user.setUserStatus("logged");
                this.loggedUser = user;
                break;
            }
        }
    }

    /* Metodo privado para comprobar si hay un usuario loggeado */
    private boolean isAnyUserLogged(){
        return this.loggedUser != null;
    }


    /* Metodo publico para cerrar la sesion del usuario que la tenga iniciada */
    public void systemLogout(){
        if (this.loggedUser != null && this.loggedUser.getUserStatus().equals("logged")){
            this.loggedUser.setUserStatus("notLogged");
            this.loggedUser = null;
        }
    }

    /* Metodo privado para encontrar el flujo y el chatbot actuales */
    private Chatbot findChatbotByID(int currentChatbotID) {
        for (Chatbot chatbot : this.systemChatbots) {
            if (chatbot.getID() == currentChatbotID) {
                return chatbot;
            }
        }
        return null; // Retorna null si no se encuentra el chatbot
    }


    /* Metodo privado para saber si la entrada del usuario es un numero o no */
    private boolean isNumber(String message){
        try {
            Integer.parseInt(message);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* Metodo privado para encontrar la opcion segun el numero de la entrada */
    private Option findOptionByNumber(String message, Flow currentFlow){
        for (Option option : currentFlow.getFlowOptions()) {
            if (option.getMessage().contains(message)) {
                return option;
            }
        }
        return null;
    }

    /* Metodo privado para encontrar la opcion segun la palabra de la entrada */
    private Option findOptionByKeyword(String message, Flow currentFlow){
        String lowerCaseMessage = message.toLowerCase();
        for (Option option : currentFlow.getFlowOptions()) {
            List<String> keywords = option.getKeywords();

            for (String keyword : keywords) { //
                if (keyword.toLowerCase().contains(lowerCaseMessage)) {
                    return option;
                }
            }
        }
        return null;
    }

    /* Metodo publico para las interacciones del usuario, guarda las interacciones en el historial
    y actualiza el chatbot y flujo actuales para llevar al usuario a su proxima interaccion */
    public void systemTalk(String message) {
        /* Comprueba que haya un usuario loggeado */
        if (isAnyUserLogged()) {

            /* Se obtiene el chatbot actual */
            Chatbot currentChatbot = findChatbotByID(this.currentChatbotID);
            /* Se obtiene el flujo actual */
            Flow currentFlow = currentChatbot.findFlowByID(this.currentFlowID);
            /* Se inicializa selectedOption, para luego ser modificada segun la entrada del usuario */
            Option selectedOption = null;

            /* Determina la opción seleccionada en base al tipo de mensaje */
            if (isNumber(message)) {
                selectedOption = findOptionByNumber(message, currentFlow);
            } else {
                selectedOption = findOptionByKeyword(message, currentFlow);
            }

            /* Proceso común una vez que el ususrio elige la opción */
            if (selectedOption != null) {
                /* Actualizar el estado del sistema */
                this.currentChatbotID = selectedOption.getChatbotCodeLink();
                this.currentFlowID = selectedOption.getInitialFlowCodeLink();

                /* Encuentra el nuevo flujo que sera considerado como la respuesta del chatbot */
                Flow botAnswer = currentChatbot.findFlowByID(this.currentFlowID);

                /* Verificar si el botAnswer es válido antes de continuar */
                if (botAnswer != null) {
                    /* Crea la nueva entrada en ChatHistory para guardar la interacción del usuario */
                    ChatHistory userInteraction = new ChatHistory(
                            LocalDateTime.now(),
                            getLoggedUser().getUsername(),
                            message,
                            selectedOption.getMessage(),
                            currentChatbot.getName(),
                            botAnswer);
                    /* Añadir la nueva entrada de ChatHistory al historial del usuario */
                    getLoggedUser().getHistorial().add(userInteraction);
                }
            }
        }
    }

}

// LO MISMO PERO DUPLICADO, SI HAY PROBLEMAS CON LO REDUNDANTE DE SELECTEDOPTION, SE OPTARA POR ESTA OPCION
//    public void systemTalk(String message) {
//  if (isAnyUserLogged()) {
//            Chatbot currentChatbot = findChatbotByID(this.currentChatbotID);
//
//            Flow currentFlow = currentChatbot.findFlowByID(this.currentFlowID);
//            if (isNumber(message)) {
//                Option selectedOption = findOptionByNumber(message, currentFlow);
//                /* Actualizar el estado del sistema */
//                this.currentChatbotID = selectedOption.getChatbotCodeLink();
//                this.currentFlowID = selectedOption.getInitialFlowCodeLink();
//
//                /* Encuentra el nuevo flujo que será la respuesta del chatbot */
//                Flow botAnswer = currentChatbot.findFlowByID(this.currentFlowID);
//
//                /* Crea la nueva entrada en ChatHistory para guardar la interacción del usuario */
//                ChatHistory userInteraction = new ChatHistory(
//                        LocalDateTime.now(),
//                        getLoggedUser().getUsername(),
//                        message,
//                        selectedOption.getMessage(),
//                        currentChatbot.getName(),
//                        botAnswer);
//                getLoggedUser().getHistorial().add(userInteraction);
//            }
//            else{
//                Option selectedOption = findOptionByKeyword(message, currentFlow);
//                /* Actualizar el estado del sistema */
//                this.currentChatbotID = selectedOption.getChatbotCodeLink();
//                this.currentFlowID = selectedOption.getInitialFlowCodeLink();
//
//                /* Encuentra el nuevo flujo que será la respuesta del chatbot */
//                Flow botAnswer = currentChatbot.findFlowByID(this.currentFlowID);
//
//                /* Crea la nueva entrada en ChatHistory para guardar la interacción del usuario */
//                ChatHistory userInteraction = new ChatHistory(
//                        LocalDateTime.now(),
//                        getLoggedUser().getUsername(),
//                        message,
//                        selectedOption.getMessage(),
//                        currentChatbot.getName(),
//                        botAnswer);
//                getLoggedUser().getHistorial().add(userInteraction);
//            }
//        }
//    }
