
package Tablero;


public class Ficha {
    //private boolean esNegra;
    private boolean esNegra;
    private boolean debeAscender;

    // private int x,y;
    private Coordenada posicion;
    
    private Tablero tablero;

    public Ficha(boolean esNegra, String id, Coordenada posicion, boolean debeAscender, Tablero tablero) {
        this.debeAscender = debeAscender;
        this.tablero = tablero;
        this.posicion = posicion;
        this.esNegra = esNegra;
        this.id = id;
    }


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private String id;
    private char celda = '▄';
    
    public void CrearFichas(){
        
    }
    public String getCaracter() {
        String res = (esNegra) ? "" + ANSI_WHITE + celda : "" + ANSI_BLUE+ celda;
        return res;
    }
    public String getId() {
        return id;
    }
    public void setCoordenada(int x, int y){
        this.posicion.setX(x);
        this.posicion.setY(y);
    }
    
    
}