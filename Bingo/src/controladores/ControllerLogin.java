/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import UI.Ui_LoginAdministrador;
import UI.Ui_LoginJugador;
import clases.Administrador;
import clases.Jugador;
import exepctions.BingoExceptions;
import modelo.Fachada;

/**
 *
 * @author Ezko
 */
public class ControllerLogin {
    private Ui_LoginJugador vista;
    private Ui_LoginAdministrador vistaAdmin;
    
    public ControllerLogin(Ui_LoginJugador vista){
        this.vista = vista;
    }
    
    public ControllerLogin(Ui_LoginAdministrador vistaAdmin){
        this.vistaAdmin = vistaAdmin;
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

    public void loginAdministrador(String cedula, String password) throws BingoExceptions {
        try{
            Administrador a = Fachada.getInstancia().loginAdministrador(cedula, password);
            vistaAdmin.cerrarVentana();
            vistaAdmin.cargarPanelDeAdmin(a);
        }
        catch(BingoExceptions error){
            throw error;
        }
    }
}
