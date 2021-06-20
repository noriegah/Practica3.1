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
        System.out.println("-----BIENVENIDO AL JUEGO DE DAMAS----");
        System.out.println("     1. Entrar al juego");
        System.out.println("     2. Salir");
        System.out.println("Ingrese una Opción");
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
            System.out.println("----------MENU-----------");
            System.out.println("    1.Registrar Jugador ");
            System.out.println("    2. Estadísticas");
            System.out.println("    3. Iniciar Partida");
            System.out.println("    4. Salir");
            opMenuOpcionesJuego=scanner.nextInt();

            switch(opMenuOpcionesJuego){
            case 1:
                insJugadores.registrarJugadores();
            break;

            case 2:
                insJugadores.mostrarEstadisticas();
            break;

            case 3:
                t.EscogerJugadores();
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
}

