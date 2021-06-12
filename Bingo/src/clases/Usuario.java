/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author atrias
 */
public class Usuario extends User {
    private int cantidadCartones;
    private double saldo;
    
    public Usuario(String ci, String pass, String nombre, int cantidadCartones, double saldo) {
        super(ci, pass, nombre);
        this.cantidadCartones = cantidadCartones;
        this.saldo = saldo;
    }

    public void setCantidadCartones(int cantCartones) {
        this.cantidadCartones = cantCartones;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}
