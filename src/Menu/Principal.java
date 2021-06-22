package Menu;
import java.util.*;

import Jugador.*;
import Tablero.Coordenada;
import Tablero.Ficha;
//import src.Tablero.*;
import Tablero.Tablero;



public class Principal {
    public static void main(String[] args) {
       Principal principal = new Principal();  
    }
    Scanner scanner = new Scanner(System.in);
    Tablero insTablero = new Tablero(8,8);
    Jugadores insJugadores= new Jugadores();
    
    
    
    public Principal(){
        menuInicio();
    }
    public void menuInicio(){
        int opMenuInicio;
        System.out.println("Bienvenido al juego DAMAS IPC1");
        System.out.println("1. EntrarJuego 2.Salir");
        opMenuInicio=scanner.nextInt();

        if(opMenuInicio==1){
            entrarJuego();
        }else if(opMenuInicio==2){
            System.exit(1);
        }else{
            System.out.println("Seleccione una opcion valida por favor...");
        }
    }
    public void entrarJuego(){
        System.out.println("Entrando al juego...");
        scanner.nextLine();
        menuOpcionesJuego();
    }
    public void menuOpcionesJuego(){
        int opMenuOpcionesJuego;
        int banderaMenu=1;

        do{ 
            System.out.println("1.Registrar Jugador 2.Estadisticas del Juego 3.Iniciar Partida 4.Salir");
            opMenuOpcionesJuego=scanner.nextInt();

            switch(opMenuOpcionesJuego){
            case 1:
                insJugadores.registrarJugadores();
            break;

            case 2:
                insJugadores.mostrarEstadisticas();
            break;

            case 3:
            int banderaJugar=0;
        
                insJugadores.mostrarJugadoresDisponibles();
                insTablero.EscogerJugadores();
                insTablero.DecidirJugador();
                insTablero.pintarTablero();
                do{
                //moviendo fichas:
                mover();
                insTablero.moverFicha(xIni,yIni,xFin,yFin);
                insTablero.pintarTablero();
                }while(banderaJugar==0);
                 
            break;

            case 4:
                banderaMenu=0;
            break;

            default:
                System.out.println("Ingrese una opcion valida...");
            break;    
        }
    }while(banderaMenu!=0);
     }

        
     int xIni,xFin,yIni,yFin;
     public void mover(){
         System.out.println("Ingrese la posicion inicial de la ficha que desea mover en X:");
             xIni=scanner.nextInt();
             System.out.println("Ingrese la posicion inicial de la ficha que desea mover en Y:");
             yIni=scanner.nextInt();
             System.out.println("Ingrese la posicion final de la ficha que desea mover en X:");
             xFin=scanner.nextInt();
             System.out.println("Ingrese la posicion inicial de la ficha que desea mover en Y:");
             yFin=scanner.nextInt();
     } 
     public static String readString(String mensaje){
        String res = "";
        Scanner entrada = new Scanner(System.in);

        boolean lecturaCorrecta = false;

        while(!lecturaCorrecta){
            System.out.print(mensaje + " ");

            res = entrada.nextLine();
            res = res.trim();
            if (res.length()>0){
                lecturaCorrecta = true;
            }
            else{
                System.out.println("Debe ingresar al menos un caracter para continuar.");
            }

        }

        return res;
    }

     private void turno(boolean esBlanca){
        
        Ficha fichaAMover = null;
        Coordenada[] coordenadasPosibles = null;
        String advertencia = "";

        while (fichaAMover== null) {
            insTablero.pintarTablero();
            System.out.println(advertencia);
            advertencia = "";
            System.out.println("TURNO DE LAS "+((esBlanca)?"BLANCAS":"NEGRAS"));
            fichaAMover = insTablero.getFicha(readString("Seleccione la ficha que desea mover "), esBlanca);
            if (fichaAMover == null){
                advertencia +="Debe seleccionar una ficha valida";
            }
            else{
                coordenadasPosibles = fichaAMover.getMovimientosPosibles();

                if (coordenadasPosibles!=null){
                    String mensaje = "\nCoordenadas posibles para la ficha seleccionada: \n";
                    int cantidadPosibilidades = 0;
                    int i = 0;
                    while (coordenadasPosibles[i]!=null) {
                        if (coordenadasPosibles[i] != null) {
                            mensaje+= i+") "+coordenadasPosibles[i].toString()+"\n";
                            cantidadPosibilidades++;
                        }
                        i++;
                    }
                    mensaje += "\nSeleccione la coordenada a la que desea moverse: ";
                    int seleccion = -1;
                    while ((seleccion < 0)||(seleccion >= cantidadPosibilidades)){
                        seleccion = readInt(mensaje, true);
                    }

                    insTablero.moverFicha(fichaAMover, coordenadasPosibles[seleccion]);

                }
                else{
                    
                    advertencia += "La ficha "+fichaAMover.getId()+" que selecciono no tiene movimientos posibles";
                    fichaAMover = null;
                }
            }
        }
}
public static int readInt(String mensaje, boolean soloPositivo){
    Scanner entrada = new Scanner(System.in);
    int res = 0 ;
    String lectura = "";
    boolean lecturaCorrecta = false;
    while(!lecturaCorrecta){
        System.out.print(mensaje+" ");
        lectura = entrada.nextLine();

        try {
            res = Integer.valueOf(lectura);
            lecturaCorrecta = true;
            if (soloPositivo && res<0){
                lecturaCorrecta = false;
                System.out.println("Debe ingresar un número positivo. ");
            }
        } catch (Exception e) {
            lecturaCorrecta = false;
        }    
    }
    
    return res;
}
 }

