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
        jugadores = new ArrayList();
    }
    
    public void addUser(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void loginUsuario(String ci, String pass, int cantCartones) throws BingoExceptions{
        Usuario usuario = (Usuario) loginGenerico(ci, pass, (ArrayList) usuarios);
        if(usuario != null){
            if(usuarioEnJuego(usuario))
               throw new BingoExceptions("El jugador: " + usuario.getCi() + " ya está participando del Bingo.");
            
            Jugador unJ = new Jugador(usuario.getSaldo(), usuario, cantCartones);
            jugadores.add(unJ);
            Fachada.getInstancia().agregarAJuego(unJ);
        }
        
        throw new BingoExceptions("Acceso denegado.");
    }
    
    public Administrador loginAdministrador(String ci, String pass) throws BingoExceptions {
        Administrador admin = (Administrador) loginGenerico(ci, pass, (ArrayList) usuarios);
        if(admin != null)         
            return admin;
        
        throw new BingoExceptions("Acceso denegado.");
    }


   private User loginGenerico(String usuario, String password, ArrayList<User> listaUsuarios) {
        for (User u : listaUsuarios) {
            if (u.getCi().equals(usuario) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    private boolean usuarioEnJuego(Usuario unU) {
        if(jugadores.size() > 0){
            for(Jugador j: jugadores){
                if(unU.getCi().equals(j.getCi())) return true;
            }
            return false;
        }        
        return false;
    }
}
