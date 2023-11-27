package TDAs;

import java.util.List;
import java.util.ArrayList;

public class Flow {
    /* Atributos */
    int id;
    String message;
    public List<Option> flowOptions;

    /*  */
    /* Constructores */
    public Flow(int id, String message, List<Option> flowOptions) {
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
    public List<Option> getFlowOptions() {
        return flowOptions;
    }

    /* Método público flowAddOption*/
    public void flowAddOption(Option newOption){

        /* Verifica pertenencia usando isOptionInFLow */
        if (!isOptionInFlow(newOption)){

            /* Si la opción no pertenece al flujo, la agrega */
            flowOptions.add(newOption);
        }
    }
    /* Método privado para comprobar pertenencia */
    private boolean isOptionInFlow(Option newOption){
        for (Option option : flowOptions){
            if (option.getCode() == newOption.getCode()){
                return true;
            }
        }
        return false;
    }
}
