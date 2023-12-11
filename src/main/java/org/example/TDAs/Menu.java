package org.example.TDAs;

import java.util.Scanner;

public class Menu {
    private System_20937236_PaillaoEspindola system;
    private User_20937236_PaillaoEspindola currentUser;
    private Scanner scanner;

    public Menu(System_20937236_PaillaoEspindola system) {
        this.system = system;
        this.scanner = new Scanner(System.in);
        this.currentUser = null;
    }

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
                if ("admin".equals(currentUser.getUserPermissions())) {
                    displayAdminMenu();
                } else {
                    displayUserMenu();
                }
                System.out.println("9. Cerrar Sesión");
            }

            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (currentUser == null) {
                        loginUser();
                    } else {
                        interaction();
                    }
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    consultInteractionsHistory();
                    break;
                case 4:
                    simulate();
                    break;
                case 5:
                    if ("admin".equals(currentUser.getUserPermissions())) {
                        createOrAddChatbots();
                    }
                    break;
                case 6:
                    if ("admin".equals(currentUser.getUserPermissions())) {
                        createOrAddFlows();
                    }
                    break;
                case 7:
                    if ("admin".equals(currentUser.getUserPermissions())) {
                        createOrAddOptions();
                    }
                    break;
                case 9:
                    logoutUser();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }

    private void displayAdminMenu() {
        // Menú para usuario administrador
        System.out.println("1. Interactuar con el chatbot");
        System.out.println("2. Consultar historial de interacciones");
        System.out.println("3. Simular");
        System.out.println("4. Crear/Agregar Chatbots al sistema");
        System.out.println("5. Crear/Agregar flujos a un chatbot");
        System.out.println("6. Crear/Agregar opciones a un flujo");
    }

    private void displayUserMenu() {
        // Menú para usuario normal
        System.out.println("1. Interactuar con el chatbot");
        System.out.println("2. Consultar historial de interacciones");
        System.out.println("3. Simular");
    }

    private void interaction() {
        boolean keepInteracting = true;
        while (keepInteracting) {
            // Obtener el chatbot y flujo actual
            Chatbot_20937236_PaillaoEspindola currentChatbot = system.findChatbotByID(system.currentChatbotID);
            Flow_20937236_PaillaoEspindola currentFlow = currentChatbot.findFlowByID(system.currentFlowID);

            // Mostrar mensaje y opciones del flujo actual
            System.out.println(currentFlow.getMessage());
            for (Option_20937236_PaillaoEspindola option : currentFlow.getFlowOptions()) {
                System.out.println(option.getCode() + ") " + option.getMessage());
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



    private void consultInteractionsHistory() {
        // logica a implementar
    }

    private void simulate() {
        // logica a implementar
    }

    private void createOrAddChatbots() {
        // logica a implementar
    }

    private void createOrAddFlows() {
        // logica a implementar
    }

    private void createOrAddOptions() {
        // logica a implementar
    }

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

    private void loginUser() {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();

        boolean loginSuccessful = system.systemLogin(username);

        if (loginSuccessful) {
            currentUser = system.getLoggedUser();
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + username + "!");
        } else {
            System.out.println("Inicio de sesión fallido. Verifique su nombre de usuario e inténtelo nuevamente.");
        }
    }

    private void logoutUser() {
        if (currentUser != null) {
            System.out.println("Cerrando sesión de usuario: " + currentUser.getUsername());
            system.systemLogout();
            currentUser = null;
        } else {
            System.out.println("No hay ninguna sesión de usuario para cerrar.");
        }
    }
}
