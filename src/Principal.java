import java.util.*;
import Jugador.*;
import Tablero.*;

public class Principal {
    public static void main(String[] args) {
       Principal principal = new Principal();  
    }
    Scanner scanner = new Scanner(System.in);
    Jugadores insJugadores= new Jugadores();
    Tablero t=new Tablero(8,8);
    
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
                t.PintarTablero();
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

        
    public void iniciarPartida(){
        System.out.println("Pintando tablero...");
        scanner.nextLine();
    }
    
}

