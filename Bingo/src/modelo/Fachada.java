/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import clases.Bingo;
import clases.Juego;
import clases.Jugador;
import clases.Usuario;
import exepctions.BingoExceptions;

/**
 *
 * @author Ezko
 */
public class Fachada {   
    private static Fachada instance = null;
    private ControladorUsuarios cu;
    private ControladorBingo cb;

   
    private Fachada() {
        this.cu = new ControladorUsuarios();
        this.cb = new ControladorBingo();
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
            cb.puedeJugar(unJ);
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    public void loginAdministrador(String ci, String pass) throws BingoExceptions {
        try{
            cu.loginAdministrador(ci, pass);        
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    public void agregarAJuego(Jugador unJ) {
        cb.validarJuego(unJ);        
    }
    
    public void addUsuario(Usuario usuario){
        cu.addUser(usuario);
    }
    
    public Juego getProximoJuego(){
        return cb.getProximoJuego();
    }
    
    public void setBingo(Bingo bingo){
        cb.setBingo(bingo);
    }
    
    public Bingo getBingo(){
        return cb.getBingo();
    }
}
