/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import UI.Ui_LoginJugador;
import clases.Jugador;
import exepctions.BingoExceptions;
import modelo.Fachada;

/**
 *
 * @author Ezko
 */
public class ControllerLogin {
    private Ui_LoginJugador vista;
    
    public ControllerLogin(Ui_LoginJugador vista){
        this.vista = vista;
    }
    public void loginUsuario(String cedula, String password, int cantCartones)  throws BingoExceptions {
        try{
            Jugador j = Fachada.getInstancia().loginUsuario(cedula, password, cantCartones);
            vista.cerrarVentana();
            vista.cargarPanelDeJuego(j);
        }
        catch(BingoExceptions error){
            throw error;
        }
    }
}
