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

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return this.ci;
    }

    public Object getPassword() {
        return this.pass;
    }




    
    
}
