/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import exepctions.BingoExceptions;
import interfaces.IFigura;
import java.util.ArrayList;

/**
 *
 * @author Ezko
 */
public class Bingo {
    ArrayList<Jugador> enEspera;
    ArrayList<Juego> juegos;
    Config configuracion;
    
    public Bingo(){
        this.configuracion = Config.getInstancia();
        enEspera = new ArrayList();
        juegos = new ArrayList();
    }
  
    public void iniciarJuego(Juego juego){        
        juegos.add(juego);
        enEspera.clear(); 
        juego.iniciar();
    }    
    
    public void validarJuego(Jugador unJ){ //throws BingoExceptions{
        //try{
            enEspera.add(unJ);
            if(this.puedeJugar(unJ)){
                Juego juego = new Juego(new ArrayList(enEspera), configuracion);
                for(Jugador j : enEspera){
                    j.setJuego(juego);
                }                   
                this.iniciarJuego(juego);
                
                //solo se setea el juego al ultimo jugador
            }  
        //}
        //catch(BingoExceptions error){
        //    throw error;
        //}
   
    }
    
    private boolean puedeJugar(Jugador unJ){ //throws BingoExceptions{
        //try{
            // && unJ.puedeJugar(configuracion.getCantidadCartones(), configuracion.getValorCarton())
            return configuracion.getCantidadJugadores() == enEspera.size();
        //}
        //catch(BingoExceptions error){
        //    throw error;
        //}
    }

    //ESTO SE VA
    public void continuar(){
        juegos.get(0).continuar();
    }
    
    public boolean ganador(){
        return juegos.get(0).getGanador() == null ? false : true;
    }
}