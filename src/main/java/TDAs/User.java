package TDAs;

import java.util.List;
import java.util.ArrayList;
public class User {
    /* Atributos */
    String username;
    public List<ChatHistory> historial;
    String userStatus;
    String userPermissions;

    /* Constructores */
    public User(String username) {

        this.username = username;
        this.historial = new ArrayList<>();
        this.userStatus = "notLogged";
        this.userPermissions = "default";

    }

    /* Selectores */
    public String getUsername() {
        return username;
    }
    public List<ChatHistory> getHistorial() {
        return historial;
    }
    public String getUserStatus() {
        return userStatus;
    }
    public String getUserPermissions() {
        return userPermissions;
    }

    /* Metodo publico para cambiar el estado de sesion de un usuario */
    public void setUserStatus(String status){
        this.userStatus = status;

    }
}
