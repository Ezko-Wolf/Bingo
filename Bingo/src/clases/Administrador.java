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
    
    public Administrador(String ci, String pass, String nombre, String email){
        super(ci, pass, nombre);
        this.email = email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }
    

    
    
}
