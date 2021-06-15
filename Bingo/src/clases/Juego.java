/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.IFigura;
import java.util.ArrayList;
import interfaces.IFigura;
import observer.Observable;
import observer.Observer;

/**
 *
 * @author Ezko
 */
public class Juego extends Observable{
    private ArrayList<Jugador> jugadores = new ArrayList();
    private Jugador ganador;
    private Bolillero bolillero;
    private Pozo pozo;
    private Config cfg;
    private int numeroJuego;
        
    public Juego(Config cfg, int numero){
        this.ganador = null;
        this.cfg = cfg;
        this.pozo = new Pozo();
        this.numeroJuego = numero;
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
    
    
    public void addJugador(Jugador unJ) {
        this.jugadores.add(unJ);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public int getFilas(){
        return this.cfg.getFilas();
    }
    
    public int getColumnas(){
        return this.cfg.getColumnas();
    }
    
    public void iniciar(){
        int cantCartones = this.obtenerCantCartones();
        int cantidadNumeros = this.cantidadNumerosEnJuego(cantCartones, this.cfg.getNumerosPorCarton());
        this.bolillero = new Bolillero(cantidadNumeros);
        this.dispararCreacionDeCartones();
        notifyObservers(Observer.Eventos.JUEGO_INICIADO);
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
        ArrayList<Carton> auxCartones = new ArrayList();
        for(Jugador j:jugadores){
            auxCartones.addAll(j.getCartones());
        }
        HelperCrearCartones.llenarCartones(auxCartones, this.bolillero.getBolillas());
    }

    private int cantidadNumerosEnJuego(int cantCartones, int numerosEnCarton) {
        return cantCartones * numerosEnCarton;
    }

    public void setPozo(int cartones) {
        pozo.agregarSaldo(cartones, cfg.getValorCarton());
    }

    public double getPozo() {
        return this.pozo.getMonto();
    }

    public int getNumero() {
        return this.numeroJuego;
    }
}
