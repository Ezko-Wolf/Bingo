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
    
    public Bingo(Config config){
        this.configuracion = config;
        enEspera = new ArrayList();
    }
  
    public void iniciarJuego(Juego juego){        
          juegos.add(juego);
          enEspera.clear();   
    }

    public Bingo() {}
    
    
    public void validarJuego(Jugador unJ) throws BingoExceptions{
        try{
            enEspera.add(unJ);
            if(this.puedeJugar(unJ)){
                Juego juego = new Juego(enEspera, configuracion.getFigurasHabilitadas(), configuracion.getFilas(), configuracion.getColumnas());
                this.iniciarJuego(juego);
            }  
        }
        catch(BingoExceptions error){
            throw error;
        }
   
    }
    
    private boolean puedeJugar(Jugador unJ) throws BingoExceptions{
        try{
            return configuracion.getCantidadJugadores() == enEspera.size() && unJ.puedeJugar(configuracion.getCantidadCartones(), configuracion.getValorCarton()) && !this.estaJugando(unJ);
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    private boolean estaJugando(Jugador unJ) throws BingoExceptions{
        if(unJ.getJuego() == null)
            return true;
        
        throw new BingoExceptions("El jugador: " + unJ.getCi() + " ya está participando del Bingo.");
    }


}