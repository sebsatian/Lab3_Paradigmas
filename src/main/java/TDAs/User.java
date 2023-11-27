package TDAs;

import java.util.List;
import java.util.ArrayList;
public class User {
    /* Atributos */
    String username;
    public List<ChatHistory> historial;
    String userStatus;
    String userPermissions;

    public User(String username) {

        this.username = username;
        this.historial = new ArrayList<>();
        this.userStatus = "notLogged";
        this.userPermissions = "default";

    }

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
}
