/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
public class Tablero {
    
    private Celda[][] tablero;
    private final int x,y;
    public Tablero(int x, int y){
        this.x=x;
        this.y=y;
        tablero=new Celda[x][y];
        inicializarTablero();
    }

    private void inicializarTablero(){
        boolean esColorInicio=false;
        boolean esColorIteracion=false;
        for(int i=0; i<y;i++){
            esColorIteracion=!esColorInicio;
            for(int j=0; j<x; j++){
                tablero[j][i]=new Celda(esColorIteracion);
                esColorIteracion=!esColorIteracion;
            }
            esColorInicio=!esColorInicio;
        }
    }


    public void PintarTablero(){
        for(int i=0; i<y;i++){
            for(int k=0; k<3; k++){
                for(int j=0; j<x; j++){
                System.out.print(tablero[j][i].PintarCelda(k));
                }
            System.out.println("");
            }
        }
    }

}