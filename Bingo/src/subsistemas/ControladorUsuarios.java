/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsistemas;

import clases.Administrador;
import clases.Jugador;
import clases.User;
import clases.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Ezko
 */
public class ControladorUsuarios {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Administrador> administradores;
    
    public ControladorUsuarios(){
        usuarios = new ArrayList();
        administradores = new ArrayList();
    }
    
    
    
    public Jugador loginUsuario(String ci, String pass, int cantCartones, double saldo){
        Usuario usuario = (Usuario) loginGenerico(ci, pass, (ArrayList) usuarios);
        Jugador unJ = null;
        if(usuario != null){
            usuario.setCantidadCartones(cantCartones);
            usuario.setSaldo(saldo);
            unJ = new Jugador(saldo, usuario);            
            Fachada.getInstancia().agregarAJuego(unJ);
        }
        
        return unJ;
    }
    
    public Administrador loginAdministrador(String ci, String pass, String mail){
        Administrador admin = (Administrador) loginGenerico(ci, pass, (ArrayList) usuarios);
        if(admin != null)
            admin.setMail(mail);
        
        return admin;
    }


   private User loginGenerico(String usuario, String password, ArrayList<User> listaUsuarios) {
        for (User u : listaUsuarios) {
            if (u.getCi().equals(usuario) && u.getPassword().equals(usuario)) {
                return u;
            }
        }
        return null;
    }
    
    
}
