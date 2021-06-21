/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;


public class Ficha {
    //private boolean esNegra;
    private boolean esNegra;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private char celda = '▄';
    private String id;

    public Ficha(boolean esNegra){
        this.esNegra=esNegra;
    }
    
    public void CrearFichas(){
        
    }
    public String getCaracter() {
        String res = (esNegra) ? "" + ANSI_RED + celda : "" + ANSI_YELLOW + celda;
        return res;
    }
    public String getId() {
        return id;
    }
}