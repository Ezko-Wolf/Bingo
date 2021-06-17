/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Ezko
 */
public class Administrador extends User {
    private String email;
    private boolean enLinea;
    private Bingo bingo;
    
    public Administrador(String ci, String pass, String nombre, String email, Bingo bingo){
        super(ci, pass, nombre);
        this.email = email;
        this.enLinea = false;
        this.bingo = bingo;
    }

    public void setMail(String mail) {
        this.email = mail;
    }
    
    public void setEnLinea(Boolean enL){
        this.enLinea = enL;
    }

    public boolean getEnLinea() {
        return this.enLinea;
    }

    public Bingo getBingo(){
        return this.bingo;
    }
}
