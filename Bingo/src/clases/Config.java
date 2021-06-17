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
    private int numerosPorCarton;
    private static Config instancia = null;

    private Config(int filas, int columnas, int maxCartonesJugador, int maxJugadoresJuego, int valorCarton, ArrayList<IFigura> figuras) {
        this.filas = filas;
        this.columnas = columnas;
        this.maxCartonesJugador = maxCartonesJugador;
        this.maxJugadoresJuego = maxJugadoresJuego;
        this.valorCarton = valorCarton;
        this.figuras = figuras;
        this.numerosPorCarton = filas * columnas;
    }

    public synchronized static Config getInstancia(){
        if(instancia == null){
            ArrayList<IFigura> figuritas = new ArrayList();
            //figuritas.add(new FiguraDiagonal());
            //figuritas.add(new FiguraPerimetro());
            figuritas.add(new FiguraCartonLleno());
            //figuritas.add(new FiguraLinea());
            instancia = new Config(3, 3, 3, 2, 50, figuritas);
        }
        return instancia;
    }
    
    public int getNumerosPorCarton() {
        return numerosPorCarton;
    }

    public int getCantidadJugadores() {
        return this.maxJugadoresJuego;
    }
    
    public int getCantidadCartones(){
        return this.maxCartonesJugador;
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

    public double getValorCarton() {
       return this.valorCarton;
    }
}
