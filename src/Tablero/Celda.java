
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
    
    private String Imprimir(String color, int linea){
        String res = "";
        if(ficha!=null){
            if ((linea == 0)||(linea == 2))
                res=""+ color+celdaColor+celdaColor+   ficha.getCaracter()+ficha.getCaracter()+    color+celdaColor+celdaColor;
            if (linea == 1)
                res=""+ color+celdaColor+  ficha.getCaracter()+    ficha.getId()      +ficha.getCaracter()       +color+ celdaColor;
                //res=""+ color+celdaColor+  ficha.getCaracter()+ficha.getCaracter()+ficha.getCaracter()+ficha.getCaracter()       +color+ celdaColor;
            
        }else{
            res =""+ color+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor+celdaColor;
        }
        return res;
    }
    
    public boolean getEsColor(){
        return this.esColor;
    }

    public void setFicha(){
        this.ficha = null;
    }
    
    public void setFicha(Ficha f, int x, int y){
        this.ficha = f;
        this.ficha.setCoordenada(x, y);
    }
}