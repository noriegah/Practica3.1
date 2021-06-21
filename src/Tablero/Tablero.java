/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
import java.util.*;
import Jugador.*;
public class Tablero {
    Scanner entrada=new Scanner(System.in);
    Jugadores Jugadores=new Jugadores();
    private Celda[][] tablero;
    private final int x,y;
    private int jugador1, jugador2;
    private boolean juegoEnBlancas;
    private Ficha[][] fichas;
    public Tablero(int x, int y){
        this.x=x;
        this.y=y;
        fichas = new Ficha[2][(x*3)];
        tablero=new Celda[x][y];
        inicializarTablero();
    }

    private void inicializarTablero(){//solo sirve para primeros valores
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


public void pintarTablero(){

        for (int i = 0 ; i<x; i++){
            System.out.print("  "+componerNumeroString(i)+"  ");
        }
        System.out.println("");

        for ( int i = 0; i < y; i++) {            
            
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < x; j++) {
                    System.out.print(tablero[j][i].PintarCelda(k));
                    if((k ==1)&& ((j+1)==x))
                        System.out.print(" "+i);
                }
                System.out.println("");
            }

            
        }
        for (int i = 0 ; i<x; i++){
            System.out.print("  "+componerNumeroString(i)+"  ");
        }
        System.out.println("\n\n");
    }
    
    public void EscogerJugadores(){
        System.out.println("Ingrese el ID del primer Jugador");
        jugador1=entrada.nextInt();
        System.out.println("Ingrese el ID del segundo Jugador");
        jugador2=entrada.nextInt();
    }
    
        public void PiedraPapeloTijera(){
        //1. piedra, 2. papel, 3 tijera
        System.out.println("-----PIEDRA, PAPEL O TIJERA------");
        int bandera=0;
        do{
        int armaJugador1=((int)(Math.random()*3+1));
        int armaJugador2=((int)(Math.random()*3+1));
        if(armaJugador1==1 & armaJugador2==2){
            System.out.println("Jugador 1=Piedra, Jugador 2=Papel");
            System.out.println("El ganador es ID:"+jugador2);
        }else if(armaJugador1==1 & armaJugador2==3){
            System.out.println("Jugador 1=Piedra, Jugador 2=Tijera");
            System.out.println("El ganador es ID:"+jugador1);
        }else if(armaJugador1==2 & armaJugador2==1){
            System.out.println("Jugador 1=Papel, Jugador 2=Piedra");
            System.out.println("EL ganador es ID:"+jugador1);
        }else if(armaJugador1==2 & armaJugador2==3){
            System.out.println("Jugador 1=Papel, Jugador 2=Tijera");
            System.out.println("El ganador es ID:"+jugador2);
        }else if(armaJugador1==3 & armaJugador2==1){
            System.out.println("Jugador 1=Tijera, Jugador 2=Piedra");
            System.out.println("El ganador es ID:"+jugador2);
        }else if(armaJugador1==3 & armaJugador2==2){
            System.out.println("Jugador 1=Tijera, Jugador 2=Papel");
            System.out.println("EL ganador es ID:"+jugador1);
        }else{
            System.out.println("Es un Empate");
            bandera=1;
        }
        }while(bandera!=0);
 
    }
        
    private void inicializarFichas(int ini, int cant, boolean esBlanca, boolean debeAscender){
        int cont = 1;
        int tipoFicha=(esBlanca)?0:1;
        for (int i = ini; i < cant; i++) {
            for (int j = 0; j < x; j++) {
                if (tablero[j][i].getEsColor() == !juegoEnBlancas){     
                   // fichas[tipoFicha][(cont-1)]=new Ficha(!esBlanca, componerNumeroString(cont), new Coordenada(j,i), debeAscender,this);
                    tablero[j][i].setFicha(fichas[tipoFicha][(cont-1)],j,i );
                    cont++;
                }
            }
        }
    }

    public String componerNumeroString(int num){
        String res = ""+num;
        if(num<10)
            res = "0"+res;
        return res;
    }
}