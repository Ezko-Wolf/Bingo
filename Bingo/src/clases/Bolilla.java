/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Ezko
 */
class Bolilla {
    private int valor;    
    private Jugador jugador;
    
    public Bolilla(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }

    void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
}
