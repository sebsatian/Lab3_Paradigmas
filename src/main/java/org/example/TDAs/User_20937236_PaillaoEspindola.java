package org.example.TDAs;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz de user
 */
interface UserI{
    String getUsername();
    List<ChatHistory_20937236_PaillaoEspindola> getHistorial();
    String getUserStatus();
    String getUserPermissions();
    void setUserStatus(String status);
    void setUserPermissions(String username);
}
/**
 * Clase user
 */
public class User_20937236_PaillaoEspindola implements UserI{
    /* Atributos */
    private String username;
    private List<ChatHistory_20937236_PaillaoEspindola> historial;
    private String userStatus;
    private String userPermissions;

    /**
     * Constructor de un nuevo user, se inicializa como notLogged y permisos por defecto
     * @param username nombre de usuario
     */
    public User_20937236_PaillaoEspindola(String username) {
        this.username = username;
        this.historial = new ArrayList<>();
        this.userStatus = "notLogged";
        this.userPermissions = "default";
    }

    /**
     * Selector del nombre de usuario
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Selector del historial de usuario
     * @return historial
     */
    public List<ChatHistory_20937236_PaillaoEspindola> getHistorial() {
        return historial;
    }
    /**
     * Selector del estado de sesion de usuario
     * @return userStatus
     */
    public String getUserStatus() {
        return userStatus;
    }
    /**
     * Selector del permisos de usuario
     * @return userPermissions
     */
    public String getUserPermissions() {
        return userPermissions;
    }

    /**
     * Metodo para cambiar el estado de sesion
     * @return void
     */
    public void setUserStatus(String status) {
        this.userStatus = status;
    }
    /**
     * Metodo para cambiar los permisos del usuario
     * @return void
     */
    public void setUserPermissions(String username) {
        this.userPermissions = "admin";
    }
}
