package TDAs;

import java.util.List;
import java.util.ArrayList;
public class User_20937236_PaillaoEspindola {
    /* Atributos */
    String username;
    public List<ChatHistory_20937236_PaillaoEspindola> historial;
    String userStatus;
    String userPermissions;

    /* Constructores */
    public User_20937236_PaillaoEspindola(String username) {

        this.username = username;
        this.historial = new ArrayList<>();
        this.userStatus = "notLogged";
        this.userPermissions = "default";
    }

    /* Selectores */
    public String getUsername() {
        return username;
    }
    public List<ChatHistory_20937236_PaillaoEspindola> getHistorial() {
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
