/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import clases.Administrador;
import clases.Celda;
import clases.Juego;
import clases.Jugador;
import clases.Usuario;
import exepctions.BingoExceptions;
import java.util.ArrayList;

/**
 *
 * @author Ezko
 */
public class Fachada {   
    private static Fachada instance = null;
    private ControladorUsuarios cu;
    private Bingo bingo;

   
    private Fachada() {
        this.cu = new ControladorUsuarios();
        this.bingo = new Bingo();
    }

    public synchronized static Fachada getInstancia() {
        if(instance == null) {
            instance =  new Fachada();
        }
        return instance;
    }
    
    public Jugador loginUsuario(String ci, String pass, int cantCartones) throws BingoExceptions {
        try{
            return cu.loginUsuario(ci, pass, cantCartones);
        }
        catch(BingoExceptions error){
            throw error;
        } 
    }
    
    public void puedeJugar(Jugador unJ) throws BingoExceptions{
        try{
            bingo.puedeJugar(unJ);
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    public Administrador loginAdministrador(String ci, String pass) throws BingoExceptions {
        try{
            return cu.loginAdministrador(ci, pass);        
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    public void agregarAJuego(Jugador unJ) throws BingoExceptions {
       try{
           bingo.validarJuego(unJ);        
       }catch(BingoExceptions error){
           throw error;
       }
    }
    
    public void addUsuario(Usuario usuario){
        cu.addUser(usuario);
    }
    
    public Juego getProximoJuego(){
        return bingo.getProximoJuego();
    }
    
    //ESTO SE VA
    public void continuar() throws BingoExceptions{
        try{
            bingo.continuar();
        }catch(BingoExceptions error){
            throw error;
        } 
    }
    
    public boolean ganador(){
        return bingo.ganador();
    }

    public void addAdministrador(Administrador administrador) {
        cu.addAdministrador(administrador);
    }
}
