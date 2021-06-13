/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsistemas;
import clases.Bingo;
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
    
    public void loginUsuario(String ci, String pass, int cantCartones) throws BingoExceptions {
        try{
            cu.loginUsuario(ci, pass, cantCartones);
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

    public void loginAdministrador(String ci, String pass) throws BingoExceptions {
        try{
            cu.loginAdministrador(ci, pass);        
        }
        catch(BingoExceptions error){
            throw error;
        }
    }

    public void agregarAJuego(Jugador unJ) {
        bingo.validarJuego(unJ);        
    }
    
    public void addUsuario(Usuario usuario){
        cu.addUser(usuario);
    }
    
}
