package org.example;

import org.example.TDAs.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Clase principal que inicia el sistema de chatbots y muestra el menú principal al usuario.
 */
public class Main {
    public static void main(String[] args) {
        // Crear opciones
        Option_20937236_PaillaoEspindola option1 = new Option_20937236_PaillaoEspindola(
                1, "1) Comprar en línea", 1, 2, new ArrayList<>(Arrays.asList("comprar", "en línea", "shop", "online"))
        );
        Option_20937236_PaillaoEspindola option2 = new Option_20937236_PaillaoEspindola(
                2, "2) Buscar aventuras", 1, 3, new ArrayList<>(Arrays.asList("aventuras", "deportes extremos", "viajes"))
        );

        Option_20937236_PaillaoEspindola option3 = new Option_20937236_PaillaoEspindola(
                3, "1) Comprar comida", 2, 4, new ArrayList<>(Arrays.asList("comida", "restaurante", "pedido"))
        );
        Option_20937236_PaillaoEspindola option4 = new Option_20937236_PaillaoEspindola(
                4, "2) Comprar tecnología", 2, 3, new ArrayList<>(Arrays.asList("tecnología", "dispositivos", "gadgets"))
        );

        Option_20937236_PaillaoEspindola option5 = new Option_20937236_PaillaoEspindola(
                5, "1) Deportes extremos", 3, 2, new ArrayList<>(Arrays.asList("deportes extremos", "adrenalina", "aventura"))
        );
        Option_20937236_PaillaoEspindola option6 = new Option_20937236_PaillaoEspindola(
                6, "2) Viajar", 3, 5, new ArrayList<>(Arrays.asList("viajar", "turismo", "destinos"))
        );

        Option_20937236_PaillaoEspindola option7 = new Option_20937236_PaillaoEspindola(
                7, "1) Hamburguesa", 4, 7, new ArrayList<>(Arrays.asList("hamburguesa", "comida", "almuerzo"))
        );
        Option_20937236_PaillaoEspindola option8 = new Option_20937236_PaillaoEspindola(
                8, "2) Papas Fritas", 4, 7, new ArrayList<>(Arrays.asList("papas fritas", "comida rápida", "aperitivo"))
        );

        Option_20937236_PaillaoEspindola option9 = new Option_20937236_PaillaoEspindola(
                9, "1) Viajar al Sur", 5, 8, new ArrayList<>(Arrays.asList("sur", "playas", "ciudades del sur"))
        );
        Option_20937236_PaillaoEspindola option10 = new Option_20937236_PaillaoEspindola(
                10, "2) Viajar al Norte", 5, 8, new ArrayList<>(Arrays.asList("norte", "montañas", "ciudades del norte"))
        );

        Option_20937236_PaillaoEspindola option11 = new Option_20937236_PaillaoEspindola(
                11, "1) Salto en Bungee", 6, 7, new ArrayList<>(Arrays.asList("bungee", "saltar", "adrenalina"))
        );
        Option_20937236_PaillaoEspindola option12 = new Option_20937236_PaillaoEspindola(
                12, "2) Paracaidismo", 6, 7, new ArrayList<>(Arrays.asList("paracaidismo", "saltar en paracaídas", "aventura en el aire"))
        );

        Option_20937236_PaillaoEspindola option13 = new Option_20937236_PaillaoEspindola(
                13, "Finalizar interacción (Escribe salir)", 6, 7, new ArrayList<>(Arrays.asList("finalizar", "salir", "historial"))
        );

        Option_20937236_PaillaoEspindola option14 = new Option_20937236_PaillaoEspindola(
                14, "1) Ya me dio hambre", 6, 4, new ArrayList<>(Arrays.asList("comer", "comida"))
        );
        Option_20937236_PaillaoEspindola option15 = new Option_20937236_PaillaoEspindola(
                15, "2) Quiero adrenalina!", 6, 6, new ArrayList<>(Arrays.asList("deportes", "extremos"))
        );

        // Crear flujo para el historial
        Flow_20937236_PaillaoEspindola flow7 = new Flow_20937236_PaillaoEspindola(
                7, "\nListo! Ya puedes revisar tus interacciones en tu historial, escribe 'salir' para finalizar.", new ArrayList<>(Arrays.asList(option13))
        );

        // Crear flujo para el opción 8
        Flow_20937236_PaillaoEspindola flow8 = new Flow_20937236_PaillaoEspindola(
                8, "Flujo Terminar?\n¿Te interesa algo más?", new ArrayList<>(Arrays.asList(option14, option15))
        );

        // Crear flujos
        Flow_20937236_PaillaoEspindola flow1 = new Flow_20937236_PaillaoEspindola(
                1, "Flujo Principal Chatbot\nBienvenido\n¿Qué te gustaría hacer?", new ArrayList<>(Arrays.asList(option1, option2))
        );

        Flow_20937236_PaillaoEspindola flow2 = new Flow_20937236_PaillaoEspindola(
                2, "Flujo Comprar en línea\n¿Qué te gustaría comprar en línea?", new ArrayList<>(Arrays.asList(option3, option4))
        );

        Flow_20937236_PaillaoEspindola flow3 = new Flow_20937236_PaillaoEspindola(
                3, "Flujo Buscar Aventuras\n¿Qué tipo de aventuras te gustaría buscar?", new ArrayList<>(Arrays.asList(option5, option6))
        );

        Flow_20937236_PaillaoEspindola flow4 = new Flow_20937236_PaillaoEspindola(
                4, "Flujo Comida\n¿Qué tipo de comida te gustaría comprar?", new ArrayList<>(Arrays.asList(option7, option8))
        );

        Flow_20937236_PaillaoEspindola flow5 = new Flow_20937236_PaillaoEspindola(
                5, "Flujo Destinos\n¿A dónde te gustaría viajar?", new ArrayList<>(Arrays.asList(option9, option10))
        );

        Flow_20937236_PaillaoEspindola flow6 = new Flow_20937236_PaillaoEspindola(
                6, "Flujo Deportes Extremos\n¿Qué deporte extremo te gustaría hacer?", new ArrayList<>(Arrays.asList(option11, option12))
        );

        // Crear chatbots
        Chatbot_20937236_PaillaoEspindola chatbot0 = new Chatbot_20937236_PaillaoEspindola(
                0, "Inicial", "Bienvenido\n¿Qué te gustaría hacer?", 1, new ArrayList<>(Arrays.asList(flow1))
        );

        Chatbot_20937236_PaillaoEspindola chatbot1 = new Chatbot_20937236_PaillaoEspindola(
                1, "Actividades", "Bienvenido\n¿Qué actividad te gustaría elegir?", 2, new ArrayList<>(Arrays.asList(flow2, flow3))
        );

        Chatbot_20937236_PaillaoEspindola chatbot2 = new Chatbot_20937236_PaillaoEspindola(
                2, "Comida", "Bienvenido\n¿Qué tipo de comida te gustaría comprar?", 4, new ArrayList<>(Arrays.asList(flow4))
        );

        Chatbot_20937236_PaillaoEspindola chatbot3 = new Chatbot_20937236_PaillaoEspindola(
                3, "Destinos", "Bienvenido\n¿A dónde te gustaría viajar?", 5, new ArrayList<>(Arrays.asList(flow5))
        );

        Chatbot_20937236_PaillaoEspindola chatbot4 = new Chatbot_20937236_PaillaoEspindola(
                4, "Deportes Extremos", "Bienvenido\n¿Qué deporte extremo te gustaría hacer?", 6, new ArrayList<>(Arrays.asList(flow6))
        );

        Chatbot_20937236_PaillaoEspindola chatbot5 = new Chatbot_20937236_PaillaoEspindola(
                5, "Historial", "Bienvenido al Historial de Interacciones", 7, new ArrayList<>(Arrays.asList(flow7))
        );

        Chatbot_20937236_PaillaoEspindola chatbot6 = new Chatbot_20937236_PaillaoEspindola(
                6, "Terminar", "¿Te interesa algo más?", 8, new ArrayList<>(Arrays.asList(flow8))
        );

        // Crear sistema
        System_20937236_PaillaoEspindola system = new System_20937236_PaillaoEspindola(
                "Chatbots Paradigmas", 0, new ArrayList<>(Arrays.asList(chatbot0, chatbot1, chatbot2, chatbot3, chatbot4, chatbot5, chatbot6))
        );

        // Crear un usuario llamado "admin" y asignarle permisos de administrador
        User_20937236_PaillaoEspindola adminUser = new User_20937236_PaillaoEspindola("admin");
        adminUser.setUserPermissions("admin");

        // Añadir el usuario administrador al sistema
        system.systemAddUser(adminUser);

        // Llamar al menú principal
        Menu menu = new Menu(system);
        menu.displayMainMenu();
    }
}


