/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import UI.Ui_Jugador;
import clases.Carton;
import clases.Celda;
import clases.Jugador;
import componenteGrid.GridLayoutException;
import componenteGrid.ListaPaneles;
import componenteGrid.MarcadorBoton;
import java.util.ArrayList;
import java.util.Observer;
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
    private Jugador j;
    private ListaPaneles listaPaneles;
    
    public ControllerJugador(Ui_Jugador vista, Jugador j){
        this.vista = vista;
        this.j = j;        
        j.getJuego().addObserver(this);      
        j.addObserver(this);
    }

    public void generarCarton(ListaPaneles listaPaneles) {
        this.listaPaneles = listaPaneles;
        ArrayList<Carton> cartones = j.getCartones();
        for(int i = 0; i < j.getCantidadCartones(); i++){
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
        return ((Celda) dato).getBolilla() == null ? false : true;
    }

    @Override
    public String getTextoAyuda(Object dato) {
        return "el otro texto";
    }

    @Override
    public void click(Object dato) {
        int i = 0;
    }    

    public void continuar() {
        j.continuar();
    }
    
    private void cerrar(){
        j.getJuego().deleteObserver(this);
        j.deleteObserver(this);
        vista.cerrarVentana();
    }
    
    @Override
    public void update(ObservableJuego source, Object event) {
        switch((ObserverJuego.Eventos)event) {
            case JUEGO_INICIADO : 
                vista.generarCarton(); 
                vista.actualizarInterfaz();
            break;
            case ACTUALIZA_ESTADO_JUEGO:
                vista.actualizarInterfaz();  
            break;
            case HAY_GANADOR :
                System.out.println("Tenemos ganador");
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
}
