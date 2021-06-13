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
    private ArrayList<IFigura> figurasHabilitadas = new ArrayList();
    private int auxFilas;
    private int auxColumnas;
    private int auxNumerosEnCarton;
        
    public Juego(ArrayList<Jugador> jugadores, ArrayList<IFigura> figurasHabilitadas, int numerosEnCarton, int filas, int columnas){
        this.jugadores = jugadores;
        this.ganador = null;
        this.figurasHabilitadas = figurasHabilitadas;
        this.auxFilas = filas;
        this.auxColumnas = columnas;
        this.auxNumerosEnCarton = numerosEnCarton;
        this.iniciar();
    }

    public ArrayList<IFigura> getFigurasHabilitadas(){
        return this.figurasHabilitadas;
    }
    
    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    public void iniciar(){
        int cantCartones = this.obtenerCantCartones();
        int cantidadNumeros = this.cantidadNumerosEnJuego(cantCartones, this.auxNumerosEnCarton);
        this.bolillero = new Bolillero(cantidadNumeros);
        this.dispararCreacionDeCartones();
        this.continuar();
    }
    
    public void continuar(){
        try{
            Bolilla sorteada = this.bolillero.sortear();
            for(int i = 0; i < jugadores.size() || ganador == null; i++){
                jugadores.get(i).anotarBolilla(sorteada);
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
        HelperCrearCartones.crearCartones(bolillero.getBolillas(), jugadores, auxFilas, auxColumnas);
    }

    public ArrayList<Jugador> getJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int cantidadNumerosEnJuego(int cantCartones, int numerosEnCarton) {
        return cantCartones * numerosEnCarton;
    }
}
