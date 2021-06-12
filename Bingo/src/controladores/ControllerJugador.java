/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Usuario;
import exepctions.BingoExceptions;
import subsistemas.Fachada;

/**
 *
 * @author Ezko
 */
public class ControllerJugador {

    public void loginUsuario(String cedula, String password, int cantCartones)  throws BingoExceptions {
        try{
            Fachada.getInstancia().loginUsuario(cedula, password, cantCartones);
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    
}
