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
import exepctions.BingoExceptions;
import java.util.ArrayList;

/**
 *
 * @author Ezko
 */
public class ControladorUsuarios {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Administrador> administradores;
    private ArrayList<Jugador> jugadores;
    
    public ControladorUsuarios(){
        usuarios = new ArrayList();
        administradores = new ArrayList();
    }
    
    public Jugador loginUsuario(String ci, String pass, int cantCartones, double saldo) throws BingoExceptions{
        Usuario usuario = (Usuario) loginGenerico(ci, pass, (ArrayList) usuarios);
        if(usuario != null){
            usuario.setCantidadCartones(cantCartones);
            usuario.setSaldo(saldo);
            
            if(existeJugador(usuario))
               throw new BingoExceptions("El jugador: " + usuario.getCi() + " ya está participando del Bingo.");
            
            Jugador unJ = new Jugador(saldo, usuario, cantCartones);
            Fachada.getInstancia().agregarAJuego(unJ);
            return unJ;
        }
        
        throw new BingoExceptions("Acceso denegado.");
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

    private boolean existeJugador(Usuario unU) {
        for(Jugador j: jugadores){
            if(unU.getCi().equals(j.getCi())) return true;
        }
        
        
        return false;
    }
    
    
}
