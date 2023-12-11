package org.example.TDAs;

import java.util.List;

public class Flow_20937236_PaillaoEspindola {
    /* Atributos */
    int id;
    String message;
    public List<Option_20937236_PaillaoEspindola> flowOptions;

    /*  */
    /* Constructores */
    public Flow_20937236_PaillaoEspindola(int id, String message, List<Option_20937236_PaillaoEspindola> flowOptions) {
        this.id = id;
        this.message = message;
        /* Se inicializa una lista*/
        this.flowOptions = flowOptions;
    }


    /* Selectores */
    public int getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public List<Option_20937236_PaillaoEspindola> getFlowOptions() {
        return flowOptions;
    }

    /* Método público flowAddOption*/
    public void flowAddOption(Option_20937236_PaillaoEspindola newOption){

        /* Verifica pertenencia usando isOptionInFLow */
        if (!isOptionInFlow(newOption)){

            /* Si la opción no pertenece al flujo, la agrega */
            flowOptions.add(newOption);
        }
    }
    /* Método privado para comprobar pertenencia */
    private boolean isOptionInFlow(Option_20937236_PaillaoEspindola newOption){
        for (Option_20937236_PaillaoEspindola option : flowOptions){
            if (option.getCode() == newOption.getCode()){
                return true;
            }
        }
        return false;
    }

}
