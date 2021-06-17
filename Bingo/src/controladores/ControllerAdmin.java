/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import UI.Ui_Admin;
import clases.Administrador;
import clases.Juego;
import clases.Bolilla;
import clases.Bolillero;
import java.util.ArrayList;
import java.util.Comparator;
import observer.ObservableJuego;
import observer.ObserverJuego;

/**
 *
 * @author atrias
 */
public class ControllerAdmin implements ObserverJuego{

    private Ui_Admin vista;
    private Administrador admin;
    private Juego juegoAnterior = null;
        
    public ControllerAdmin(Ui_Admin vistaAdmin, Administrador admin) {
        this.vista = vistaAdmin;
        this.admin = admin;
        admin.getBingo().addObserver(this);
    }
    
    public void cargarDatos(Object obj){
        Juego juego = (Juego)obj;  
        if(this.juegoAnterior != null) this.juegoAnterior.deleteObserver(this); 
        this.juegoAnterior = juego;
        juego.addObserver(this);
        vista.cargarJugadores(juego);    
        vista.cargarNumero(juego);
        vista.cargarGanador(juego);
        this.cargarEstadoCantidadBolillasYBolillero(juego);
    }   
    
    public void jugadorQueAnoto(Object obj) {
        Bolilla boli = (Bolilla)obj;
        vista.cargarJugadorQueAnoto(boli.getJugador() == null ? "-" : boli.getJugador().toString());
    }
    
    private void cargarEstadoCantidadBolillasYBolillero(Juego juego){
        ArrayList<Bolilla> bolillas = new ArrayList();
        Bolillero bolillero = juego.getBolillero();
        this.agruparYOrdenarBolillas(bolillero, bolillas);
        vista.cargarEstadoCantidadBolillasYBolillero(juego, bolillero.getCantidadBolillas(), bolillas);
    }

    private void agruparYOrdenarBolillas(Bolillero bolillero, ArrayList<Bolilla> bolillas) {
        bolillas.addAll(bolillero.getBolillasSoretadas());
        bolillas.addAll(bolillero.getBolillas());
        bolillas.sort(new Comparator<Bolilla>() {
            @Override
            public int compare(Bolilla b1, Bolilla b2) {
                int ret = 0;
                if(b1.getValor() > b2.getValor()) ret = 1;
                if(b1.getValor() < b2.getValor()) ret = -1;
                return ret;
            }
        });
    }

    @Override
    public void update(ObservableJuego source, Object event) {
        switch((ObserverJuego.Eventos)event) {
            case JUEGO_CREADO : 
                vista.cargarJuegos();
            break;
            case JUGADOR_ABANDONO : 
                vista.cargarJugadores((Juego)source);
                this.cargarEstadoCantidadBolillasYBolillero((Juego)source);
            break;
            case JUEGO_INICIADO:
            case ACTUALIZA_ESTADO_JUEGO:
                vista.cargarJuegos();
                this.cargarEstadoCantidadBolillasYBolillero((Juego)source);
            break;
            case HAY_GANADOR :
                vista.cargarGanador((Juego)source);
            break;
        }
    }

    
    
}
