package org.example.TDAs;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.ArrayList;


public class System_20937236_PaillaoEspindola {
    /* Atributos */
    String name;
    int initialChatbotCodeLink;
    public List<Chatbot_20937236_PaillaoEspindola> systemChatbots;
    public List<User_20937236_PaillaoEspindola> systemUsers;
    int currentChatbotID;
    int currentFlowID;
    User_20937236_PaillaoEspindola loggedUser;

    /* Constructores */
    public System_20937236_PaillaoEspindola(String name, int initialChatbotCodeLink, List<Chatbot_20937236_PaillaoEspindola> systemChatbots) {
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
    public List<Chatbot_20937236_PaillaoEspindola> getChatbots() {
        return systemChatbots;
    }
    public User_20937236_PaillaoEspindola getLoggedUser() {
        return loggedUser;
    }

    /* Setters */
    public void setLoggedUser(User_20937236_PaillaoEspindola user) {
        this.loggedUser = user;
    }

    /* Metodo publico para añadir un chatbot a la lista de chatbots del sistema */
    public void systemAddChatbot(Chatbot_20937236_PaillaoEspindola newChatbot){
        if (!isChatbotInSystem(newChatbot)){
            systemChatbots.add(newChatbot);
        }
    }

    /* Metodo privado para comprobar si un chatbot existe dentro del sistema */
    private boolean isChatbotInSystem(Chatbot_20937236_PaillaoEspindola newChatbot){
        for (Chatbot_20937236_PaillaoEspindola chatbot : systemChatbots){
            if (chatbot.getID() == newChatbot.getID()){
                return true;
            }
        }
    return false;
    }

    /* Metodo publico para añadir un usuario a la lista de usuarios del sistema */
    public boolean systemAddUser(User_20937236_PaillaoEspindola newUser){
        if(!isUserInSystem(newUser)){
            systemUsers.add(newUser);
            return true; /* Usuario agregado exitosamente */
        } else {
            return false; /*  Usuario ya existe en el sistema */
        }
    }

    /* Metodo privado para comprobar si un usuario existe dentro del sistema */
    private boolean isUserInSystem(User_20937236_PaillaoEspindola newUser){
        for (User_20937236_PaillaoEspindola user : systemUsers){
            if ((user.getUsername()).equals(newUser.getUsername())){
                return true;
            }
        }
    return false;
    }

    /* Metodo publico para iniciar sesion a un usuario*/
    public boolean systemLogin(String username) {
        for (User_20937236_PaillaoEspindola user : systemUsers) {
            if (user.getUsername().equals(username) && user.getUserStatus().equals("notLogged")) {
                user.setUserStatus("logged");
                this.loggedUser = user;
                return true; // Inicio de sesión exitoso
            }
        }
        return false; // Inicio de sesión fallido
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
    public Chatbot_20937236_PaillaoEspindola findChatbotByID(int currentChatbotID) {
        for (Chatbot_20937236_PaillaoEspindola chatbot : this.systemChatbots) {
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
    private Option_20937236_PaillaoEspindola findOptionByNumber(String message, Flow_20937236_PaillaoEspindola currentFlow){
        for (Option_20937236_PaillaoEspindola option : currentFlow.getFlowOptions()) {
            if (option.getMessage().contains(message)) {
                return option;
            }
        }
        return null;
    }

    /* Metodo privado para encontrar la opcion segun la palabra de la entrada */
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

    /* Metodo publico para las interacciones del usuario, guarda las interacciones en el historial
    y actualiza el chatbot y flujo actuales para llevar al usuario a su proxima interaccion */
    public void systemTalk(String message) {
        /* Comprueba que haya un usuario loggeado */
        if (isAnyUserLogged()) {

            /* Se obtiene el chatbot actual */
            Chatbot_20937236_PaillaoEspindola currentChatbot = findChatbotByID(this.currentChatbotID);
            /* Se obtiene el flujo actual */
            Flow_20937236_PaillaoEspindola currentFlow = currentChatbot.findFlowByID(this.currentFlowID);
            /* Se inicializa selectedOption, para luego ser modificada segun la entrada del usuario */
            Option_20937236_PaillaoEspindola selectedOption = null;

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
                    Flow_20937236_PaillaoEspindola botAnswer = currentChatbot.findFlowByID(this.currentFlowID);

                /* Verificar si el botAnswer es válido antes de continuar */
                if (botAnswer != null) {
                    /* Crea la nueva entrada en ChatHistory para guardar la interacción del usuario */
                    ChatHistory_20937236_PaillaoEspindola userInteraction = new ChatHistory_20937236_PaillaoEspindola(
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


    /* Metodo systemSynthesis, imprime en pantalla un resumen sobre el historial de un usuario */
    public void systemSynthesis() {
        for (User_20937236_PaillaoEspindola user : systemUsers) {
            for (ChatHistory_20937236_PaillaoEspindola chatHistory : user.historial) {
                /*  Convierte LocalDateTime a Epoch Second */
                ZonedDateTime zonedDateTime = chatHistory.getTimestamp().atZone(ZoneId.systemDefault());
                long epochSeconds = zonedDateTime.toInstant().getEpochSecond();

                /* Imprime la marca de tiempo, el nombre de usuario, el mensaje del usuario y la opcion elegida*/
                System.out.println(epochSeconds + " - " + chatHistory.getSender() + ": " + chatHistory.getMessage());
                System.out.println(epochSeconds + " - " + "Opción Elegida: " + chatHistory.optionMessage);


                /* Imprime la respuesta del chatbot */
                if (chatHistory.currentFlow != null) {
                    System.out.println(epochSeconds + " - " + chatHistory.currentChatbotName + ": " + chatHistory.currentFlow.getMessage());
                    for (Option_20937236_PaillaoEspindola option : chatHistory.currentFlow.flowOptions) {
                        System.out.println(option.getCode() + ") " + option.getMessage());
                    }
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
