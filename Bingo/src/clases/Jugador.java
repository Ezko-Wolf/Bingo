/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import exepctions.BingoExceptions;
import interfaces.IFigura;

import java.util.ArrayList;
import observer.ObservableJugador;
import observer.ObserverJugador;

/**
 *
 * @author Ezko
 */
public class Jugador extends ObservableJugador {

  



    public enum EstadoJugador {
        Esperando,
        Continuar,
        Abandona
    }
    
    private double saldo;
    private ArrayList<Carton> cartones = new ArrayList();
    private IFigura figuraGanadora;
    private int cantCartones;
    private Juego juego;
    private Usuario usuario;
    private EstadoJugador estado;
            
    public Jugador(Usuario usuario, int cantCartones){
        this.usuario = usuario;
        this.cantCartones = cantCartones;
        this.juego = null;
        this.estado = EstadoJugador.Esperando;
    } 
    
    public void setSaldo(double valorCarton) {
        this.saldo = this.usuario.getSaldo() - (valorCarton * this.cantCartones);
    }
    
    public void cobroAbandono(){
        this.usuario.cobrar(usuario.getSaldo()-this.saldo);
    }
  
    public double pagar(double monto){
        return usuario.pagar(monto);
    }
    
    public double cobrar(double monto) {
        return usuario.cobrar(monto);
    }
    
    public double getSaldoUsuario(){
        return this.usuario.getSaldo();
    }
    
    public void setFiguraGanadora(IFigura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }
    public IFigura getFiguraGanadora() {
        return this.figuraGanadora;
    }
    
    public void setJuego(Juego unJ){
        this.juego = unJ;
    } 
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void setEstado(EstadoJugador estado){
        this.estado = estado;
    } 
    
    public EstadoJugador getEstado(){
        return this.estado;
    }
    
    public String getNombre() {
        return this.usuario.getNombre();
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
    
    public Juego getJuego() {
        return this.juego;
    }

    public String getCi() {
        return this.usuario.getCedula();
    }
    
    public boolean anotarBolilla(Bolilla b){        
        boolean marco = false;
        for(int i = 0; i < cartones.size() && marco == false; i++){
            marco = cartones.get(i).marcar(b);
            if(marco){
                b.setJugador(this);                
                notifyObservers(ObserverJugador.Eventos.MARCA_BOLILLA);
                this.isGanador(cartones.get(i));
            }
        }
        return marco;
    }
    
    private void isGanador(Carton carton) {
            IFigura figGanadora = carton.cumpleFigura(juego.getFigurasHabilitadas());
            if(figGanadora != null){
                this.setFiguraGanadora(figGanadora);             
                juego.setGanador(this);
            }
    }

    public void crearCartones() {
        for(int i = 0; i < this.cantCartones; i++){
            Carton cart = new Carton(this.juego.getFilas(), this.juego.getColumnas());
            this.cartones.add(cart);
        }
    }
    
    private ArrayList<Integer> getBolillasJugador(){
        ArrayList<Integer> bolillas = new ArrayList();
        for(Carton c:cartones){
            bolillas.addAll(c.getValores());
        }
        return bolillas;
    }
    
    public void abandonar() {
        this.getJuego().abandonar(this,this.getBolillasJugador());
    }
    
    @Override
    public String toString(){
      return this.getNombre();
    }
    
    public void continuar(){
        this.estado = EstadoJugador.Continuar;
        this.juego.continuar();
    }
}
