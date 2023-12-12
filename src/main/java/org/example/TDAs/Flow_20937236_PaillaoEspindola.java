package org.example.TDAs;

import java.util.List;

/**
 * Interfaz para el flujo
 */
interface FlowI {
    int getId();
    String getMessage();
    List<Option_20937236_PaillaoEspindola> getFlowOptions();
    void flowAddOption(Option_20937236_PaillaoEspindola newOption);

}
/**
 * Clase flujo
 */
public class Flow_20937236_PaillaoEspindola implements FlowI {
    /* Atributos */
    int id;
    String message;
    public List<Option_20937236_PaillaoEspindola> flowOptions;

    /**
     * Metodo cosntructor de un flujo
     * @param id es el ID unico del flujo
     * @param message es el mensaje del flujo
     * @param flowOptions son las opciones del flujo
     */
    public Flow_20937236_PaillaoEspindola(int id, String message, List<Option_20937236_PaillaoEspindola> flowOptions) {
        this.id = id;
        this.message = message;
        /* Se inicializa una lista*/
        this.flowOptions = flowOptions;
    }

    /**
     * Metodo selector del ID del flujo
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo selector del mensaje del flujo
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Metodo selector de la lista de opciones del flujo
     * @return flowOptions
     */
    public List<Option_20937236_PaillaoEspindola> getFlowOptions() {
        return flowOptions;
    }

    /**
     * Metodo para agregar una opcion al flujo
     * @param newOption nueva opcion a agregar
     */
    public void flowAddOption(Option_20937236_PaillaoEspindola newOption){
        if (!isOptionInFlow(newOption)){
            flowOptions.add(newOption);
        }
    }

    /**
     * Metodo privado para comprobar la pertenencia de la opcion en el flujo
     * @param newOption nueva opcion a agregar
     * @return boolean
     */
    private boolean isOptionInFlow(Option_20937236_PaillaoEspindola newOption){
        for (Option_20937236_PaillaoEspindola option : flowOptions){
            if (option.getCode() == newOption.getCode()){
                return true;
            }
        }
        return false;
    }

}
