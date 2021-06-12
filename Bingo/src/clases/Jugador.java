/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Ezko
 */
public class Jugador {
    private double saldo;
    private ArrayList<Carton> cartones = new ArrayList();
    private int cantCartones;
    private Juego juego;
    private Usuario usuario;
    
    public Jugador(double saldo, Usuario usuario){
        this.saldo = saldo;
        this.usuario = usuario;
    }
    
 
    //public setJuego
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public boolean anotarBolilla(Bolilla b){
        boolean marco = false;
        for(int i = 0; i < cartones.size() && marco == false; i++){
            marco = cartones.get(i).marcar(b);
            if(marco){
                b.setJugador(this);
                this.isGanador(cartones.get(i));
            }
        }
        return marco;
    }
    
    public int getCantidadCartones(){
        return this.cartones.size();
    }

    private void isGanador(Carton carton) {
        boolean isGanador = carton.cumpleFigura(juego.getFigurasHabilitadas());
        if(isGanador) juego.setGanador(this);
    }
}
