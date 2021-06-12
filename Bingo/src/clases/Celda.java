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
class Celda {
    private int valor;
    private Bolilla bolilla;
    
    public Celda(){
    }
    
    public Celda(int valor){
        this.valor = valor;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public boolean marcar(Bolilla b) {
        if(this.valor == b.getValor()){
            this.bolilla = b;
            return true;
        }
        return false;
    }
    
}
