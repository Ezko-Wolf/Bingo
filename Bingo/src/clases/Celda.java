/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Ezko
 */
public class Celda {
    private int valor;
    private Bolilla bolilla;
    private boolean cargada = false;
    
    public Celda(){
    }
    
    public Celda(int valor){
        this.valor = valor;
        this.cargada = true;
    }

    public Bolilla getBolilla(){
        return this.bolilla;
    }
    
    public void setValor(int valor){
        this.valor = valor;
        this.cargada = true;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public boolean getCargada(){
        return this.cargada;
    }
    
    public boolean marcar(Bolilla b) {
        if(this.valor == b.getValor()){
            this.bolilla = b;
            return true;
        }
        return false;
    }
    
    public void getBolillaSinMarcar( ArrayList<Integer> valores){
        if (this.getBolilla() == null) valores.add(this.getValor());
    }
}
