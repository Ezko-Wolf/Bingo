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
    private double saldo;
    
    public Usuario(String ci, String pass, String nombre, int cantidadCartones, double saldo) {
        super(ci, pass, nombre);
        this.saldo = saldo;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double pagar(double monto) {
        this.setSaldo(saldo-monto);
        return monto;
    }

    double cobrar(double monto) {
        this.setSaldo(this.saldo+monto);
        return this.getSaldo();
    }
}
