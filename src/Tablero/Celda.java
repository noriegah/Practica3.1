
package Tablero;

public class Celda{
    private boolean esColor;
    private Ficha ficha;
    public static final String ANSI_WHITE="\u001b[37m";
    public static final String ANSI_BLUE = "\u001B[34m";
    //private String celda="░";
    private final String celdaColor="█";

    public Celda(boolean esColor){
    this.esColor=esColor;
    this.ficha=null;
    }

    public String PintarCelda(int linea){
        String res = "";
        if(esColor){
            res=""+ANSI_WHITE+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor;
        }else{
            res=""+ANSI_BLUE+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor;
        }
        return res;
    }
}