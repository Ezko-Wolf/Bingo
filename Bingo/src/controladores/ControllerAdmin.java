/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import UI.Ui_Admin;
import clases.Administrador;
import exepctions.BingoExceptions;
import modelo.Fachada;

/**
 *
 * @author atrias
 */
public class ControllerAdmin {

    private Ui_Admin vista;
    private Administrador admin;
        
    public ControllerAdmin(Ui_Admin admin, Administrador a) {
        this.vista = admin;
        this.admin = a;
    }

    /*public ControllerAdmin(Ui_Admin aThis, Administrador a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public void loginAdministrador(String cedula, String password)  throws BingoExceptions {
     try{
         Fachada.getInstancia().loginAdministrador(cedula, password);
     }
     catch(BingoExceptions error){
         throw error;
     }
 }
    
}
