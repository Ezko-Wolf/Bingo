/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import exepctions.BingoExceptions;
import java.util.ArrayList;
import observer.ObservableJuego;
import observer.ObserverJuego;

/**
 *
 * @author Ezko
 */
public class Bingo extends ObservableJuego{
    ArrayList<Jugador> enEspera;
    ArrayList<Juego> juegos;
    Config configuracion;
    
    public Bingo(){
        this.configuracion = Config.getInstancia();
        enEspera = new ArrayList();
        juegos = new ArrayList();
    }
  
    public void iniciarJuego(){
        Juego juego = juegos.get(juegos.size() - 1);
        enEspera.clear(); 
        juego.iniciar();
    }  
  
    public void validarJuego(Jugador unJ){
        enEspera.add(unJ);
        Juego juego = this.getProximoJuego();
        juego.addJugador(unJ);
        notifyObservers(ObserverJuego.Eventos.JUGADOR_AGREGADO);
        juego.setPozo(unJ.getCartones().size());
        if(configuracion.getCantidadJugadores() == enEspera.size())          
            this.iniciarJuego();
    }
    
    public Juego getProximoJuego(){
        if(enEspera.isEmpty()){
            Juego juego = new Juego(configuracion, juegos.size()+1);
            juegos.add(juego);
            notifyObservers(ObserverJuego.Eventos.JUEGO_CREADO);
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
    
    public ArrayList<Juego> getJuegos(){
        return this.juegos;
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

    public double getValorCarton() {
        return this.configuracion.getValorCarton();
    }

}