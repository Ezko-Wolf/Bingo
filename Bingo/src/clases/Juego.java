/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.IFigura;
import java.util.ArrayList;
import interfaces.IFigura;

/**
 *
 * @author Ezko
 */
public class Juego {
    private ArrayList<Jugador> jugadores = new ArrayList();
    private Jugador ganador;
    private Bolillero bolillero;
    private Config cfg;
        
    public Juego(ArrayList<Jugador> jugadores, Config cfg){
        this.jugadores = jugadores;
        this.ganador = null;
        this.cfg = cfg;
    }

    public ArrayList<IFigura> getFigurasHabilitadas(){
        return this.cfg.getFigurasHabilitadas();
    }
    
    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    public Jugador getGanador(){
        return this.ganador;
    }
    
    public void iniciar(){
        int cantCartones = this.obtenerCantCartones();
        int cantidadNumeros = this.cantidadNumerosEnJuego(cantCartones, this.cfg.getNumerosPorCarton());
        this.bolillero = new Bolillero(cantidadNumeros);
        this.dispararCreacionDeCartones();
        this.continuar();
    }
    
    public void continuar(){
        try{
            Bolilla sorteada = this.bolillero.sortear();
            boolean bolillaMarcada = false;
            for(int i = 0; i < jugadores.size() && ganador == null && !bolillaMarcada; i++){
                bolillaMarcada = jugadores.get(i).anotarBolilla(sorteada);
            }
        }catch(Error error){
            //Capturar el error y mostrarlo en la vista
        }
    }

    private int obtenerCantCartones() {
        int cant = 0;
        for(int i = 0; i < jugadores.size(); i++){
            cant += jugadores.get(i).getCantidadCartones();
        }
        return cant;
    }    
  
    private void dispararCreacionDeCartones() {
        HelperCrearCartones.crearCartones(bolillero.getBolillas(), jugadores, cfg.getFilas(), cfg.getColumnas());
    }

    private int cantidadNumerosEnJuego(int cantCartones, int numerosEnCarton) {
        return cantCartones * numerosEnCarton;
    }
}
