/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import exepctions.BingoExceptions;
import subsistemas.Fachada;

/**
 *
 * @author atrias
 */
public class ControllerAdmin {

    public void loginAdministrador(String cedula, String password)  throws BingoExceptions {
     try{
         Fachada.getInstancia().loginAdministrador(cedula, password);
     }
     catch(BingoExceptions error){
         throw error;
     }
 }
    
}
