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
        this.juego = null;
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
        /*boolean isGanador = carton.cumpleFigura(juego.getFigurasHabilitadas());
        if(isGanador) juego.setGanador(this);*/
    }

    public ArrayList<Carton> getCartones() {
        return this.cartones;
    }

    public boolean puedeJugar(int maximoCartones, double valorCarton) {
        try{
            return this.cantidadCartonesValidas(maximoCartones) && this.saldoSuficiente(valorCarton);  
        }
        catch(Error error){
            throw error;
        }
    }

    private boolean cantidadCartonesValidas(int maximoCartones) {
        if(this.cantCartones <= 0)
            throw new Error("Indique con cuantos cartones desea jugar");
        else if(maximoCartones < this.cantCartones)
            throw new Error("No se puede participar con más de: "+ maximoCartones + " cartones");
        
        return true;
    }

    private boolean saldoSuficiente(double valorCarton) {
        if(this.saldoInsuficiente(valorCarton))
            throw new Error("Saldo insuficiente");
        
        return true;
             
    }
    
    private boolean saldoInsuficiente(double valorCarton){
        return saldo < valorCarton*3*this.cantCartones;
    }

    public Juego getJuego() {
        return this.juego;
    }

    public String getCi() {
        return this.usuario.getCedula();
    }

}
