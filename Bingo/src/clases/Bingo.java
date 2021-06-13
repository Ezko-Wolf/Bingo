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
    
    public void validarJuego(Jugador unJ){
        enEspera.add(unJ);
        if(configuracion.getCantidadJugadores() == enEspera.size()){
            Juego juego = new Juego(enEspera, configuracion.getFigurasHabilitadas(), configuracion.getNumerosPorCarton(), configuracion.getFilas(), configuracion.getColumnas());
            for(Jugador enEspera : enEspera){
                enEspera.setJuego(juego);
            }
            this.iniciarJuego(juego);

        }  
    }
    
    public void puedeJugar(Jugador unJ) throws BingoExceptions {
        try{
            cantidadCartonesValidas(configuracion.getCantidadCartones(), unJ);
            saldoSuficiente(configuracion.getValorCarton(), unJ);  
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    private void cantidadCartonesValidas(int maximoCartones, Jugador unJ) throws BingoExceptions {
        if(unJ.getCantidadCartones() <= 0)
            throw new BingoExceptions("Indique con cuantos cartones desea jugar");
        else if(maximoCartones < unJ.getCantidadCartones())
            throw new BingoExceptions("No se puede participar con más de: "+ maximoCartones + " cartones");
    }

    private void saldoSuficiente(double valorCarton, Jugador unJ) throws BingoExceptions{
        if(this.saldoInsuficiente(valorCarton, unJ))
            throw new BingoExceptions("Saldo insuficiente");
    }
    
    private boolean saldoInsuficiente(double valorCarton, Jugador unJ){
        return unJ.getSaldo() < valorCarton * 3 * unJ.getCantidadCartones();
    }

}