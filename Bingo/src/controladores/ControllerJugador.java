/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import UI.Ui_GanadorPerdedor;
import UI.Ui_Jugador;
import clases.Carton;
import clases.Celda;
import clases.Juego;
import clases.Jugador;
import componenteGrid.GridLayoutException;
import componenteGrid.ListaPaneles;
import componenteGrid.MarcadorBoton;
import exepctions.BingoExceptions;
import java.util.ArrayList;
import observer.ObservableJuego;
import observer.ObservableJugador;
import static observer.ObserverJuego.Eventos.JUEGO_INICIADO;
import observer.ObserverJuego;
import observer.ObserverJugador;

/**
 *
 * @author Ezko
 */
public class ControllerJugador implements MarcadorBoton, ObserverJuego, ObserverJugador {
    private Ui_Jugador vista;
    private Jugador jugador;
    private Ui_GanadorPerdedor vistaFinal;
    private ListaPaneles listaPaneles;
    
    public ControllerJugador(Ui_Jugador vista, Jugador jugador){
        this.vista = vista;
        this.jugador = jugador;        
        jugador.getJuego().addObserver(this);      
        jugador.addObserver(this);
    }

    public void generarCarton(ListaPaneles listaPaneles) {
        this.listaPaneles = listaPaneles;
        ArrayList<Carton> cartones = jugador.getCartones();
        for(int i = 0; i < jugador.getCantidadCartones(); i++){
            try {            
                ArrayList<Celda> celdas = cartones.get(i).getCeldas();
                this.listaPaneles.agregarPanel(celdas.toArray(), this);
            } catch (GridLayoutException ex) {
                System.out.println(ex.getMessage());
                System.exit(0);
            }
        }
    }
    
    @Override
    public String getTexto(Object dato) {
        return !((Celda) dato).getCargada() ? "Esperando numeros" : "|"+((Celda) dato).getValor()+"|";
    }

    @Override
    public boolean marcar(Object dato) {
        return ((Celda) dato).getBolilla() != null;
    }

    @Override
    public String getTextoAyuda(Object dato) {
        return "el otro texto";
    }

    @Override
    public void click(Object dato) {
        int i = 0;
    }    

    public void continuar() throws BingoExceptions {
       //try{
           jugador.continuar();
       /*}catch(BingoExceptions error){
           throw error;
       }*/
    }
    
    private void cerrar(){
        jugador.getJuego().deleteObserver(this);
        jugador.deleteObserver(this);
        vista.cerrarVentana();
    }
    
    @Override
    public void update(ObservableJuego source, Object event) {
        switch((ObserverJuego.Eventos)event) {
            case JUEGO_INICIADO : 
                vista.generarCarton(); 
                vista.actualizarInterfaz();
             
            break;
            case JUGADOR_ABANDONO : 
                vista.actualizarInterfaz();
                
            break;
            case ACTUALIZA_ESTADO_JUEGO:
                vista.actualizarInterfaz();  
            break;
            case HAY_GANADOR :
                Juego juego = (Juego)source;
                vista.ganadorPerdedor(this.jugador, juego.getMontoPozo(), juego.getGanador());
                jugador.getJuego().deleteObserver(this);          
            break;
        }
    }

    @Override
    public void update(ObservableJugador source, Object event) {
        switch((ObserverJugador.Eventos)event) {
            case MARCA_BOLILLA :                 
                this.listaPaneles.marcar();
            break;
        }  
    }
    public void abandonar() {        
        jugador.abandonar();
        jugador.getJuego().deleteObserver(this);   
        jugador.cobroAbandono();
        vista.cerrarVentana();
    }
    


}