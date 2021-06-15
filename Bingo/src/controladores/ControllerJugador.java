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
import observer.Observable;
import observer.Observer;
import static observer.Observer.Eventos.JUEGO_INICIADO;

/**
 *
 * @author Ezko
 */
public class ControllerJugador implements MarcadorBoton, Observer {
    private Ui_Jugador vista;
    private Jugador j;
    
    public ControllerJugador(Ui_Jugador vista, Jugador j){
        this.vista = vista;
        this.j = j;
        j.getJuego().addObserver(this);
    }

    public void generar(ListaPaneles listaPaneles) {
        ArrayList<Carton> cartones = j.getCartones();
        for(int i = 0; i < j.getCantidadCartones(); i++){
            try {            
                ArrayList<Celda> celdas = cartones.get(i).getCeldas();
                listaPaneles.agregarPanel(celdas.toArray(), this);
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
        return true;
    }

    @Override
    public String getTextoAyuda(Object dato) {
        return "el otro texto";
    }

    @Override
    public void click(Object dato) {
        int i = 0;
    }

    @Override
    public void update(Observable source, Object event) {
        switch((Observer.Eventos)event) {
            case JUEGO_INICIADO : vista.generar(); break;
        }
    }
    
}
