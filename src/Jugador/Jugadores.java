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
public void mostrarJugadoresDisponibles(){
    System.out.println("Los jugadores registrados son:");
    for(int i=0;i<contadorRegistro;i++){
        System.out.println("id: "+idJugador[i]+ "nombre: "+nombreJugador[i]);
    }
}
public void mostrarEstadisticas(){
    System.out.println("Estadisticas de jugadores:");
    puntuacionDerrotas[1]=2;
    puntuacionDerrotas[2]=1;
    puntuacionDerrotas[3]=0;
    puntuacionVictorias[1]=4;
    puntuacionVictorias[2]=1;
    puntuacionVictorias[3]=0;
    for(int i=0;i<contadorRegistro;i++){
        System.out.println(" id: " +idJugador[i]+ " nombre: "+nombreJugador[i]+ " victorias: "+puntuacionVictorias[i]+ " derrotaas: "+puntuacionDerrotas[i]);
    }
}

 }

