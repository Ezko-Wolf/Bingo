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
public abstract class User {
    private String ci;
    private String pass;
    private String nombre;
    
    public User(String ci, String pass, String nombre){
        this.ci = ci;
        this.pass = pass;
        this.nombre = nombre;
    }
    
    public abstract boolean Login();
}
