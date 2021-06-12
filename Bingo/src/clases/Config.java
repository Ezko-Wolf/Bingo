/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.IFigura;
import java.util.ArrayList;

/**
 *
 * @author Ezko
 */
public class Config {
    private int filas;
    private int columnas;
    private int maxCartonesJugador;
    private int maxJugadoresJuego;
    private int valorCarton;
    private ArrayList<IFigura> figuras;

    public Config(int filas, int columnas, int maxCartonesJugador, int maxJugadoresJuego, int valorCarton, ArrayList<IFigura> figuras) {
        this.filas = filas;
        this.columnas = columnas;
        this.maxCartonesJugador = maxCartonesJugador;
        this.maxJugadoresJuego = maxJugadoresJuego;
        this.valorCarton = valorCarton;
        this.figuras = figuras;
    }
    

    public int getCantidadJugadores() {
        return this.maxJugadoresJuego;
    }
    
    public int getColumnas() {
        return this.columnas;
    }
    public int getFilas() {
      return this.filas;
    }

    public ArrayList<IFigura> getFigurasHabilitadas() {
        return this.figuras;
    }
    
    
    
    
}
