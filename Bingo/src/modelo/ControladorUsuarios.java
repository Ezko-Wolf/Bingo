/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    
    public Jugador loginUsuario(String ci, String pass, int cantCartones) throws BingoExceptions{
        try{
            Usuario usuario = (Usuario) loginGenerico(ci, pass, (ArrayList) usuarios);
            Fachada fachada = Fachada.getInstancia();
            this.usuarioEnJuego(usuario);
            Jugador unJ = new Jugador(usuario, cantCartones);
            double valorCarton = fachada.getValorCarton();
            unJ.setSaldo(valorCarton);
            fachada.puedeJugar(unJ);
            jugadores.add(unJ);
            unJ.setJuego(fachada.getProximoJuego());
            unJ.crearCartones();
            fachada.agregarAJuego(unJ);            
            return unJ;
        }
        catch(BingoExceptions error){
            throw error;
        }
           
    }
    
    public Administrador loginAdministrador(String ci, String pass) throws BingoExceptions {
        try{            
            Administrador admin = (Administrador) loginGenerico(ci, pass, (ArrayList) administradores);
            administradorEnLinea(admin);
            admin.setEnLinea(true);   
            return admin;
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    private User loginGenerico(String usuario, String password, ArrayList<User> listaUsuarios) throws BingoExceptions {
        for (User u : listaUsuarios) {
            if (u.getCi().equals(usuario) && u.getPassword().equals(password)) {
                return u;
            }
        }
        throw new BingoExceptions("Acceso denegado.");
    }

    private void usuarioEnJuego(Usuario unU) throws BingoExceptions {
        if(jugadores.size() > 0){
            for(Jugador j: jugadores){
                if(unU.getCi().equals(j.getCi())) throw new BingoExceptions("El jugador: " + unU.getCi() + " ya está participando del Bingo.");
            }
        }        
        
    }

    private void administradorEnLinea(Administrador admin) throws BingoExceptions  {
        if(admin.getEnLinea() == true) 
            throw new BingoExceptions("El administrador: " + admin.getCedula() + " ya inicio sesión.");
    }

    public void addAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }
}
