/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsistemas;

import clases.Administrador;
import clases.Jugador;

/**
 *
 * @author Ezko
 */
public class Fachada {
    ControladorUsuarios cu;

    public Fachada() {
        this.cu = new ControladorUsuarios();
    }
    
    public void loginUsuario(String ci, String pass, int cantCartones, double saldo) {
        Jugador unJ = cu.loginUsuario(ci, pass, cantCartones, saldo);
    }

    public void loginAdministrador(String ci, String pass, String mail) {
        Administrador unA = cu.loginAdministrador(ci, pass, mail);        
    }
    
}
