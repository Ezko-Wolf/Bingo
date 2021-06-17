/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Bingo;
import clases.Juego;
import clases.Jugador;
import exepctions.BingoExceptions;

/**
 *
 * @author gmedina
 */
public class ControladorBingo {
    private Bingo bingo;
    
    public ControladorBingo(){
    }
    
    public void setBingo(Bingo bingo){
        this.bingo = bingo;
    }
    
    public Bingo getBingo(){
        return this.bingo;
    }

    public Juego getProximoJuego() {
        return bingo.getProximoJuego();
    }

    public void validarJuego(Jugador unJ) {
        bingo.validarJuego(unJ);
    }

    public void puedeJugar(Jugador unJ) throws BingoExceptions{
        bingo.puedeJugar(unJ);
    }
    public double getValorCarton() {
        return bingo.getValorCarton();
    }
}
