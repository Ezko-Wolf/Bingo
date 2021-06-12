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
public class Jugador extends User {
    private double saldo;
    private ArrayList<Carton> cartones = new ArrayList();
    private int cantCartones;
    private Juego juego;
    
    public Jugador(String ci, String pass, String nombre, double saldo, int cantCartones){
        super(ci, pass, nombre);
        this.saldo = saldo;
        this.cantCartones = cantCartones;
    }
    
    @Override
    public boolean Login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //public setJuego
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public boolean anotarBolilla(Bolilla b){
        boolean marco = false;
        for(int i = 0; i < cartones.size() && marco == false; i++){
            marco = cartones.get(i).marcar(b);
            if(marco) this.isGanador(cartones.get(i));
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
