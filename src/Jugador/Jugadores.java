
package Jugador;

import java.util.Scanner;
public class Jugadores {
    //Jugadores jugadores = new Jugadores();
public Jugadores(){

}


private int idJugador[]=new int[10];
private String nombreJugador[]=new String[10];
private int puntuacionVictorias[]=new int[10];
private int puntuacionDerrotas[]=new int[10];
private int contadorRegistro=0;
Scanner scanner = new Scanner(System.in);


public void registrarJugadores(){
    System.out.println("Ingrese el id del jugador:");
    idJugador[contadorRegistro]=scanner.nextInt();
    System.out.println("Ingrese el nombre del jugador:");
    nombreJugador[contadorRegistro]=scanner.next();
    contadorRegistro++;
}
public void mostrarJugadores(){
    System.out.println("Los jugadores Disponibles son:");
    for(int k=0;k<contadorRegistro;k++){
        System.out.println("ID:"+idJugador[k]+ " Nombre:"+nombreJugador[k]);
    }
}


public void mostrarEstadisticas(){
    System.out.println("Estadisticas de jugadores:");
    for(int i=0;i<contadorRegistro;i++){
        System.out.println("ID:"+idJugador[i]+ " Nombre:"+nombreJugador[i]+" Victorias:"+puntuacionVictorias[i]+" Derrotas: "+puntuacionDerrotas[i]);
    }
}
 }