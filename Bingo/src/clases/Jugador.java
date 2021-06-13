/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import exepctions.BingoExceptions;
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
    
    public Jugador(double saldo, Usuario usuario, int cantCartones){
        this.saldo = saldo;
        this.usuario = usuario;
        this.juego = null;
        this.cantCartones = cantCartones;
    }
    
 
    public void setJuego(Juego unJ){
        this.juego = unJ;
    } 
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void setCartones(ArrayList<Carton> cartones){
        this.cartones.addAll(cartones);
    }
    
    public int getCantidadCartones(){
        return this.cantCartones;
    }

    public ArrayList<Carton> getCartones() {
        return this.cartones;
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
    
    private void isGanador(Carton carton) {
        try{
            boolean isGanador = carton.cumpleFigura(juego.getFigurasHabilitadas());
            if(isGanador) juego.setGanador(this);
        }catch(Error error){
            //Capturar el error y mostrarlo en la vista
        }
    }

    public boolean puedeJugar(int maximoCartones, double valorCarton) throws BingoExceptions {
        try{
            return this.cantidadCartonesValidas(maximoCartones) && this.saldoSuficiente(valorCarton);  
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    private boolean cantidadCartonesValidas(int maximoCartones) throws BingoExceptions {
        if(this.cantCartones <= 0)
            throw new BingoExceptions("Indique con cuantos cartones desea jugar");
        else if(maximoCartones < this.cantCartones)
            throw new BingoExceptions("No se puede participar con más de: "+ maximoCartones + " cartones");
        
        return true;
    }

    private boolean saldoSuficiente(double valorCarton) throws BingoExceptions{
        if(this.saldoInsuficiente(valorCarton))
            throw new BingoExceptions("Saldo insuficiente");
        return true;
    }
    
    private boolean saldoInsuficiente(double valorCarton){
        return saldo < valorCarton * 3 * this.cantCartones;
    }

    public Juego getJuego() {
        return this.juego;
    }

    public String getCi() {
        return this.usuario.getCedula();
    }
}
