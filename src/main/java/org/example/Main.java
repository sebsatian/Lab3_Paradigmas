package org.example;

import org.example.TDAs.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear opciones
        Option_20937236_PaillaoEspindola option1 = new Option_20937236_PaillaoEspindola(
                1, "1) Viajar", 2, 1, new ArrayList<>(Arrays.asList("viajar", "turistear", "conocer"))
        );
        Option_20937236_PaillaoEspindola option2 = new Option_20937236_PaillaoEspindola(
                2, "2) Estudiar", 3, 1, new ArrayList<>(Arrays.asList("estudiar", "aprender", "perfeccionarme"))
        );

        Option_20937236_PaillaoEspindola option3 = new Option_20937236_PaillaoEspindola(
                3, "1) Deportes extremos", 4, 1, new ArrayList<>(Arrays.asList("extremos", "deportes", "adrenalina", "aventura"))
        );
        Option_20937236_PaillaoEspindola option4 = new Option_20937236_PaillaoEspindola(
                4, "2) Compra en línea", 4, 2, new ArrayList<>(Arrays.asList("comprar", "en línea", "shop", "online"))
        );

        Option_20937236_PaillaoEspindola option5 = new Option_20937236_PaillaoEspindola(
                5, "1) Carrera Técnica", 5, 1, new ArrayList<>(Arrays.asList("técnica"))
        );
        Option_20937236_PaillaoEspindola option6 = new Option_20937236_PaillaoEspindola(
                6, "2) Postgrado", 5, 1, new ArrayList<>(Arrays.asList("Doctorado", "Magister", "Postgrado"))
        );

        // Crear flujos
        Flow_20937236_PaillaoEspindola flow1 = new Flow_20937236_PaillaoEspindola(
                1, "Flujo Principal Chatbot 1\nBienvenido\n¿Qué te gustaría hacer?", new ArrayList<>(Arrays.asList(option1, option2, option2, option2, option2, option1))
        );

        Flow_20937236_PaillaoEspindola flow2 = new Flow_20937236_PaillaoEspindola(
                2, "Flujo 1 Chatbot1\n¿Dónde te Gustaría ir?", new ArrayList<>(Arrays.asList(option3, option4, option5))
        );

        Flow_20937236_PaillaoEspindola flow3 = new Flow_20937236_PaillaoEspindola(
                3, "Flujo 2 Chatbot1\n¿Qué atractivos te gustaría visitar?", new ArrayList<>(Arrays.asList(option6))
        );

        Flow_20937236_PaillaoEspindola flow4 = new Flow_20937236_PaillaoEspindola(
                4, "Flujo 3 Chatbot1\n¿Vas solo o acompañado?", new ArrayList<>(Arrays.asList(option3))
        );

        // Crear chatbots
        Chatbot_20937236_PaillaoEspindola chatbot0 = new Chatbot_20937236_PaillaoEspindola(
                0, "Inicial", "Bienvenido\n¿Qué te gustaría hacer?", 1, new ArrayList<>(Arrays.asList(flow1, flow1, flow1, flow1))
        );

        Chatbot_20937236_PaillaoEspindola chatbot1 = new Chatbot_20937236_PaillaoEspindola(
                1, "Agencia Viajes", "Bienvenido\n¿Dónde quieres viajar?", 1, new ArrayList<>(Arrays.asList(flow2, flow3, flow4))
        );

        Chatbot_20937236_PaillaoEspindola chatbot2 = new Chatbot_20937236_PaillaoEspindola(
                2, "Orientador Académico", "Bienvenido\n¿Qué te gustaría estudiar?", 1, new ArrayList<>(Arrays.asList(flow1))
        );

        // Crear sistema
        System_20937236_PaillaoEspindola system = new System_20937236_PaillaoEspindola(
                "Chatbots Paradigmas", 0, new ArrayList<>(Arrays.asList(chatbot0, chatbot0, chatbot0))
        );

        // Añadir chatbots al sistema
        system.systemAddChatbot(chatbot1);
        system.systemAddChatbot(chatbot2);

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
