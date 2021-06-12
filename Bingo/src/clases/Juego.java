/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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
    
    public ArrayList<IFigura> getFigurasHabilitadas(){
        return this.figurasHabilitadas;
    }
    
    void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    public void iniciar(int fila, int columna){
        int cantCartones = this.obtenerCantCartones();
        this.bolillero = new Bolillero(fila, columna, cantCartones);
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
}
