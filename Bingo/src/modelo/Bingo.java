/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Config;
import clases.Juego;
import clases.Jugador;
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
  
    public void iniciarJuego() throws BingoExceptions{
       //try{
           Juego juego = juegos.get(juegos.size() - 1);
           enEspera.clear(); 
           juego.iniciar();
       /*}catch(BingoExceptions error){
           throw error;
       }*/
    }  
  
    public void validarJuego(Jugador unJ) throws BingoExceptions{
        try{
            enEspera.add(unJ);
            Juego juego = this.getProximoJuego();
            juego.addJugador(unJ);
            juego.setPozo(unJ.getCartones().size());
            
            
            if(configuracion.getCantidadJugadores() == enEspera.size())          
                this.iniciarJuego();
        }catch(BingoExceptions error){
            throw error;
        }
    }
    
    public Juego getProximoJuego(){
        if(enEspera.size() == 0){
            Juego juego = new Juego(configuracion, juegos.size()+1);
            juegos.add(juego);
        }
        return juegos.get(juegos.size() - 1);            
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

    //ESTO SE VA
    public void continuar() throws BingoExceptions{
        //try{
            juegos.get(0).continuar();
        /*}catch(BingoExceptions error){
            throw error;
        }*/
    }
    
    public boolean ganador(){
        return juegos.get(0).getGanador() == null ? false : true;
    }
}