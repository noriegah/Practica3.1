
package Tablero;
import java.util.*;
import Jugador.*;
public class Tablero {
    Scanner entrada=new Scanner(System.in);
    Jugadores Jugadores=new Jugadores();
    private Celda[][] tablero;
    private Ficha[][] fichas;
    private final int x,y;
    private int jugador1, jugador2;
    private boolean juegoEnBlancas;

    public Tablero(int x, int y){
        this.x=x;
        this.y=y;
        tablero=new Celda[x][y];
        fichas = new Ficha[2][(x*3)];
        inicializarTablero();
        inicializarFichas(0, 3, true, true);
        inicializarFichas(5, 8, false, false);
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


    public void pintarTablero(){

        for (int i = 0 ; i<x; i++){
            System.out.print("  "+componerNumeroString(i)+"  ");
        }
        System.out.println("");

        for ( int i = 0; i < y; i++) {            
            
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < x; j++) {
                    System.out.print(tablero[j][i].pintarCelda(k));
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
        System.out.println("1."+jugador1+" 2."+jugador2);
    } 
        
    public void DecidirJugador(){
        
        int bandera=0;
        
        //1. piedra 2.papel 3. tijera

        do{

            int opJugador1=((int)(Math.random()*3+1));
            int opJugador2=((int)(Math.random()*3+1));
             //pierdra vs papel

        if(opJugador1==1 & opJugador2==2){
            System.out.println("Jugador 1: piedra Jugador 2: papel ");
            System.out.println("El jugador 2 es el ganador...");
            //pierdra vs tijera
        }else if(opJugador1==1 & opJugador2==3){
            System.out.println("Jugador 1: piedra Jugador 2: tijera ");
            System.out.println("El jugador 1 es el ganador...");
            //papel vs pierdra
        }else if(opJugador1==2 & opJugador2==1){
            System.out.println("Jugador 1: papel Jugador 2: pierda ");
            System.out.println("El jugador 1 es el ganador...");
            //papel vs tijera
        }else if(opJugador1==2 & opJugador2==3){
            System.out.println("Jugador 1: papel Jugador 2: tijera ");
            System.out.println("El jugador 2 es el ganador...");
            //tijera vs pierdra
        }else if(opJugador1==3 & opJugador2==1){
            System.out.println("Jugador 1: tijera Jugador 2: piedra ");
            System.out.println("El jugador 2 es el ganador...");
            //tijera vs papel
        }else if(opJugador1==3 & opJugador2==2){
            System.out.println("Jugador 1: tijera Jugador 2: papel ");
            System.out.println("El jugador 1 es el ganador...");
        }else{
            System.out.println("ES UN EMPATE...");
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
                        fichas[tipoFicha][(cont-1)]=new Ficha(!esBlanca, componerNumeroString(cont), new Coordenada(j,i), debeAscender,this);
                        tablero[j][i].setFicha(fichas[tipoFicha][(cont-1)],j,i );
                        cont++;
                    }
                }
                
            }
        }
        public Celda getCelda(Coordenada posicion){
            Celda res = null;
            if ((posicion.getX()>=0&&posicion.getX()<x)&&(posicion.getY()>=0&&posicion.getY()<y)){
                res = tablero[posicion.getX()][posicion.getY()];
            }
            return res;
        }
    
        public Ficha getFicha(String id, boolean esBlanca){
            int tipoFicha=(esBlanca)?0:1;
            Ficha res = null;
            int cont = 0;
            while(cont<fichas[0].length && fichas[0][cont]!=null ){
                if ((res = fichas[tipoFicha][cont]).getId().equalsIgnoreCase(id)){
                    return res;
                }
                cont++;
            }
            return res;
        }

            public String componerNumeroString(int num){
                String res = ""+num;
                if(num<10)
                    res = "0"+res;
                return res;
            }
            public boolean moverFicha(int posXIni, int posYIni, int posXFin, int posYFin){
                boolean resultado = false;
                if (tablero[posXIni][posYIni].ocupadaPorFicha()){
                    if (!tablero[posXFin][posYFin].ocupadaPorFicha()){
                        tablero[posXFin][posYFin].setFicha(tablero[posXIni][posYIni].getFicha(), posXFin,posYFin);
                        resultado = true;
                    }
                }
                return resultado;

            } 
            
            

            public boolean moverFicha(String id, boolean esBlanca, Coordenada posicionFinal){
        
                return moverFicha(this.getFicha(id, esBlanca), posicionFinal);
            }
        
            public boolean moverFicha(Ficha ficha, Coordenada posicionFinal){
        
        
                boolean respuesta = false;
                Celda tmpCelda = null;
                
                if (ficha != null){
                    Celda iniCelda = this.getCelda(ficha.getCoordenada());
                    if (!(tmpCelda=tablero[posicionFinal.getX()][posicionFinal.getY()]).ocupadaPorFicha()){
        
                        //revisar si puede comer o no 
        
                        tmpCelda.setFicha(ficha, posicionFinal.getX(), posicionFinal.getY());
                        iniCelda.setFicha(ficha);
                        respuesta = true;
                    }
                    //comprobar
                }
        
                return respuesta;
            }

            
}

         
       