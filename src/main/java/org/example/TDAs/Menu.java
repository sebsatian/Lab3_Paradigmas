package org.example.TDAs;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Clase Menu que representa el menú principal del sistema de chatbots.
 */
public class Menu {
    private System_20937236_PaillaoEspindola system;
    private User_20937236_PaillaoEspindola currentUser;
    private Scanner scanner;

    /**
     * Constructor de la clase Menu.
     *
     * @param system sistema de chatbots.
     */
    public Menu(System_20937236_PaillaoEspindola system) {
        this.system = system;
        this.scanner = new Scanner(System.in);
        this.currentUser = null;
    }
    /**
     * Muestra el menú principal y permite que los usuarios elijan opciones para usar el programa.
     */
    public void displayMainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nBienvenido al Sistema de Chatbot");

            if (currentUser == null) {
                System.out.println("1. Iniciar Sesión");
                System.out.println("2. Registrar Usuario");
                System.out.println("0. Salir");
            } else {
                System.out.println("Usuario actual: " + currentUser.getUsername());
                displayUserMenu(); // Muestra el menú del usuario según el tipo de usuario

                // Opción de cierre de sesión
                System.out.println((currentUser.getUserPermissions().equals("admin") ? "5. " : "4. ") + "Cerrar Sesión");
            }

            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (currentUser == null) {
                        loginUser();
                    } else {
                        System.out.println("Ya has iniciado sesión.");
                    }
                    break;
                case 2:
                    registerUser();
                    break;
                case 4: // Opción de cierre de sesión para usuario normal
                    if (currentUser != null) {
                        logoutUser();
                    } else {
                        System.out.println("No hay ninguna sesión de usuario para cerrar.");
                    }
                    break;
                case 5: // Opción de cierre de sesión para usuario administrador
                    if (currentUser != null && currentUser.getUserPermissions().equals("admin")) {
                        logoutUser();
                    } else {
                        System.out.println("No hay ninguna sesión de usuario administrador para cerrar.");
                    }
                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }

    /**
     * Muestra el menú principal despues de loggear y permite que los usuarios elijan opciones para usar el programa.
     * Muestra opciones distintas segun el tipo de usuario que haya iniciado sesion
     */
    private void displayUserMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nOpciones de Usuario:");
            System.out.println("1. Interactuar con el chatbot");
            System.out.println("2. Consultar mi historial");
            System.out.println("3. Simular diálogo entre chatbots");

            if (currentUser.getUserPermissions().equals("admin")) {
                System.out.println("4. Crear y Agregar Chatbot al sistema");
                System.out.println("5. Crear y Agregar flujos a un Chatbot");
                System.out.println("6. Crear y Agregar opciones a un flujo");
            }

            System.out.println("0. Cerrar sesion (ingresar 0 dos veces)");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Realizando interacción con el chatbot...");
                    interaction();
                    break;
                case 2:
                    System.out.println("Consultando tu historial...");

                    if (currentUser != null) {
                        system.systemSynthesis(currentUser);
                    } else {
                        System.out.println("No hay ningún usuario loggeado para consultar la síntesis.");
                    }
                    break;

                case 3:
                    System.out.println("Esto no se implementó ฅ^•ﻌ•^ฅ");
                    break;
                case 4:
                    if (currentUser.getUserPermissions().equals("admin")) {
                        createAndAddChatbotToSystem();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 5:
                    if (currentUser.getUserPermissions().equals("admin")) {
                        createFlowSubMenu();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 6:
                    if (currentUser.getUserPermissions().equals("admin")) {
                        createOptionSubMenu();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
    /**
     * Crea y agrega un nuevo chatbot al sistema, usando systemAddChatbot.
     */
    private void createAndAddChatbotToSystem() {
        System.out.print("Ingrese el ID del chatbot: ");
        int chatbotID = scanner.nextInt();
        scanner.nextLine();

        // Comprobar si el ID del chatbot ya existe en el sistema
        if (isChatbotIDAlreadyExists(chatbotID)) {
            System.out.println("El ID del chatbot ya existe en el sistema. Por favor, ingrese otro ID.");
            return;
        }

        System.out.print("Ingrese el nombre del chatbot: ");
        String chatbotName = scanner.nextLine();

        System.out.print("Ingrese el mensaje de bienvenida del chatbot: ");
        String welcomeMessage = scanner.nextLine();

        System.out.print("Ingrese una lista de IDs de flujos separados por comas (por ejemplo, 1,2,3,4): ");
        String flowIDsInput = scanner.nextLine();

        String[] flowIDArray = flowIDsInput.split(",");
        List<Flow_20937236_PaillaoEspindola> chatbotFlows = new ArrayList<>();

        for (String flowIDStr : flowIDArray) {
            try {
                int flowID = Integer.parseInt(flowIDStr);
                Flow_20937236_PaillaoEspindola flow = system.findFlowByID(flowID);

                if (flow != null) {
                    chatbotFlows.add(flow);
                } else {
                    System.out.println("No se encontró un Flow con el ID: " + flowID);
                }
            } catch (NumberFormatException e) {
                System.out.println("ID de flujo no válido: " + flowIDStr);
            }
        }

        System.out.print("Ingrese el ID del flujo de inicio del chatbot: ");
        int startFlowID = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea pendiente

        Chatbot_20937236_PaillaoEspindola newChatbot = new Chatbot_20937236_PaillaoEspindola(chatbotID, chatbotName, welcomeMessage, startFlowID, chatbotFlows);

        // Agregar el nuevo chatbot al sistema
        system.systemAddChatbot(newChatbot);

        System.out.println("Chatbot creado y agregado al sistema con éxito:");
        System.out.println("ID del chatbot: " + newChatbot.getID());
        System.out.println("Nombre del chatbot: " + newChatbot.getName());
        System.out.println("Mensaje de bienvenida: " + newChatbot.getWelcomeMessage());
        System.out.println("ID del flujo de inicio: " + newChatbot.getStartFlowID());
        System.out.println("Flujos asociados:");

        for (Flow_20937236_PaillaoEspindola flow : newChatbot.getChatbotFlows()) {
            System.out.println("ID del flujo: " + flow.getId());

        }
    }
    /**
     * Verifica si un ID de chatbot ya existe en el sistema.
     *
     * @param chatbotID El ID del chatbot a verificar.
     * @return True si el ID ya existe, False si no.
     */
    private boolean isChatbotIDAlreadyExists(int chatbotID) {
        List<Chatbot_20937236_PaillaoEspindola> chatbots = system.getChatbots();
        for (Chatbot_20937236_PaillaoEspindola chatbot : chatbots) {
            if (chatbot.getID() == chatbotID) {
                return true;
            }
        }
        return false;
    }

    /**
     * Crea y agrega un nuevo flujo a un chatbot existente.
     */
    private void createAndAddFlowToChatbot() {
        // Pide argumentos
        System.out.print("Ingrese el ID del nuevo flujo: ");
        int newFlowID = scanner.nextInt();
        scanner.nextLine();

        // Comprueba si el ID del nuevo flujo ya existe en el sistema
        if (isFlowIDAlreadyExists(newFlowID)) {
            System.out.println("El ID del nuevo flujo ya existe en el sistema. Por favor, ingrese otro ID.");
            return;
        }

        System.out.print("Ingrese el mensaje del nuevo flujo: ");
        String newFlowMessage = scanner.nextLine();

        // Crea una lista vacía de opciones para el nuevo flujo
        List<Option_20937236_PaillaoEspindola> newFlowOptions = new ArrayList<>();

        // Instancia
        Flow_20937236_PaillaoEspindola newFlow = new Flow_20937236_PaillaoEspindola(newFlowID, newFlowMessage, newFlowOptions);

        // Agregar el nuevo flujo al chatbot actual
        if (currentUser != null && currentUser.getUserPermissions().equals("admin")) {
            System.out.print("Ingrese el ID del chatbot al que desea agregar el flujo: ");
            int chatbotID = scanner.nextInt();
            scanner.nextLine();

            Chatbot_20937236_PaillaoEspindola chatbot = system.findChatbotByID(chatbotID);

            if (chatbot != null) {
                chatbot.chatbotAddFlow(newFlow);
                System.out.println("Nuevo flujo agregado al chatbot con éxito.");
            } else {
                System.out.println("No se encontró el chatbot con el ID especificado.");
            }
        } else {
            System.out.println("Debe ser un usuario administrador para agregar flujos a un chatbot.");
        }
    }
    /**
     * Verifica si un ID de flujo ya existe en el sistema.
     *
     * @param flowID  ID del flujo a verificar.
     * @return True si el ID ya existe, False si no.
     */
    private boolean isFlowIDAlreadyExists(int flowID) {
        List<Chatbot_20937236_PaillaoEspindola> chatbots = system.getChatbots();
        for (Chatbot_20937236_PaillaoEspindola chatbot : chatbots) {
            for (Flow_20937236_PaillaoEspindola flow : chatbot.getChatbotFlows()) {
                if (flow.getId() == flowID) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Muestra el submenú para crear y agregar flujos a un chatbot.
     */
    private void createFlowSubMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSubmenú de Creación de Flujos:");
            System.out.println("1. Crear un nuevo flujo");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createAndAddFlowToChatbot();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
    /**
     * Crea y agrega una nueva opción a un flujo existente.
     */
    private void createAndAddNewOptionToFlow() {
        // Solicitar detalles de la nueva opción
        System.out.print("Ingrese el ID de la nueva opción: ");
        int newOptionCode = scanner.nextInt();
        scanner.nextLine();

        // Comprobar si el ID de la nueva opción ya existe en el sistema
        if (isOptionIDAlreadyExists(newOptionCode)) {
            System.out.println("El ID de la nueva opción ya existe en el sistema. Por favor, ingrese otro ID.");
            return;
        }

        System.out.print("Ingrese el mensaje de la nueva opción: ");
        String newOptionMessage = scanner.nextLine();

        System.out.print("Ingrese el código de enlace del chatbot: ");
        int chatbotCodeLink = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el código de enlace del flujo inicial: ");
        int initialFlowCodeLink = scanner.nextInt();
        scanner.nextLine();

        // Solicitar palabras clave separadas por comas y agregarlas a la lista de keywords
        System.out.print("Ingrese las palabras clave separadas por comas (por ejemplo, palabra1,palabra2,palabra3): ");
        String keywordsInput = scanner.nextLine();
        List<String> newKeywords = Arrays.asList(keywordsInput.split(","));

        System.out.print("Ingrese el ID del flujo al que desea agregar la opción: ");
        int selectedFlowID = scanner.nextInt();
        scanner.nextLine();

        // Buscar el flujo seleccionado por su ID en los chatbots del sistema
        Flow_20937236_PaillaoEspindola selectedFlow = system.findFlowByID(selectedFlowID);

        if (selectedFlow == null) {
            System.out.println("No se encontró el flujo seleccionado.");
            return;
        }

        // Crear una nueva instancia de Option_20937236_PaillaoEspindola con los detalles proporcionados
        Option_20937236_PaillaoEspindola newOption = new Option_20937236_PaillaoEspindola(newOptionCode, newOptionMessage, chatbotCodeLink, initialFlowCodeLink, newKeywords);

        // Agregar la nueva opción al flujo seleccionado
        selectedFlow.flowAddOption(newOption);

        System.out.println("Nueva opción agregada al flujo " + selectedFlow.getId() + " con éxito.");
    }
    /**
     * Verifica si un ID de opción ya existe en el sistema.
     *
     * @param optionID El ID de la opción a verificar.
     * @return True si el ID ya existe, False si no.
     */
    private boolean isOptionIDAlreadyExists(int optionID) {
        List<Chatbot_20937236_PaillaoEspindola> chatbots = system.getChatbots();
        for (Chatbot_20937236_PaillaoEspindola chatbot : chatbots) {
            for (Flow_20937236_PaillaoEspindola flow : chatbot.getChatbotFlows()) {
                for (Option_20937236_PaillaoEspindola option : flow.getFlowOptions()) {
                    if (option.getCode() == optionID) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Muestra el submenú para crear y agregar opciones a un flujo.
     */
    private void createOptionSubMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSubmenú de Creación de Opciones:");
            System.out.println("1. Crear y agregar una nueva opción a un flujo");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createAndAddNewOptionToFlow();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
    /**
     * Inicia sesión de usuario en el sistema.
     */
    private void loginUser() {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();

        boolean loginSuccessful = system.systemLogin(username);

        if (loginSuccessful) {
            currentUser = system.getLoggedUser();
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + currentUser.getUsername() + "!");
            displayUserMenu();
        } else {
            System.out.println("Inicio de sesión fallido. Verifique su nombre de usuario e inténtelo nuevamente.");
        }
    }
    /**
     * Registra un nuevo usuario en el sistema.
     */
    private void registerUser() {
        System.out.print("Ingrese un nombre de usuario para el registro: ");
        String username = scanner.nextLine();

        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Usuario Normal");
        System.out.println("2. Usuario Administrador");
        System.out.print("Seleccione una opción: ");
        int userTypeOption = scanner.nextInt();
        scanner.nextLine();

        String userPermissions;
        switch (userTypeOption) {
            case 1:
                userPermissions = "normal";
                break;
            case 2:
                userPermissions = "admin";
                break;
            default:
                System.out.println("Opción no válida. Creando usuario normal por defecto.");
                userPermissions = "normal";
        }

        User_20937236_PaillaoEspindola newUser = new User_20937236_PaillaoEspindola(username);

        if (system.systemAddUser(newUser)) {
            // Usuario creado
            if (userPermissions.equals("admin")) {
                newUser.setUserPermissions("admin");
            }

            System.out.println("Usuario creado con éxito:");
            System.out.println("Nombre de usuario: " + newUser.getUsername());
            System.out.println("Permisos: " + newUser.getUserPermissions());
        } else {
            // Usuario ya existe
            System.out.println("El usuario ya existe en el sistema. No se pudo crear.");
        }
    }
    /**
     * Cierra la sesión de usuario actual.
     */
    private void logoutUser() {
        if (currentUser != null) {
            System.out.println("Cerrando sesión de usuario: " + currentUser.getUsername());
            system.systemLogout();
            currentUser = null;
        } else {
            System.out.println("No hay ninguna sesión de usuario para cerrar.");
        }
    }
    /**
     * Realiza la interacción entre el usuario y el sistema actual.
     */
    private void interaction() {
        boolean keepInteracting = true;

        while (keepInteracting) {
            // Obtener el chatbot y flujo actual
            Chatbot_20937236_PaillaoEspindola currentChatbot = system.findChatbotByID(system.currentChatbotID);
            Flow_20937236_PaillaoEspindola currentFlow = system.findFlowByID(system.currentFlowID);

            // Mostrar mensaje del flujo actual
            System.out.println(currentFlow.getMessage());

            // Mostrar opciones disponibles
            for (Option_20937236_PaillaoEspindola option : currentFlow.getFlowOptions()) {
                System.out.println(option.getMessage());
            }

            // Pedir al usuario su elección
            System.out.print("Ingrese su elección (o escriba 'salir' para finalizar): ");
            String userInput = scanner.nextLine();

            // Verificar si el usuario desea salir
            if ("salir".equalsIgnoreCase(userInput)) {
                keepInteracting = false;
                break;
            }

            // Procesar la entrada del usuario a través de systemTalk
            system.systemTalk(userInput);
        }
    }

}
