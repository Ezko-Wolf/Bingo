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
public class Carton {
    private ArrayList<Celda> celdas = new ArrayList();
    private int filas;
    private int columnas;

    public Carton(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.crearCeldas();
    }
    
    //Esto ewsta de atrevido, hay que ver que onda cuando tengamos realmente los numeros
    private void crearCeldas(){
        int largo = this.filas * this.columnas;
        for(int i = 0; i < largo; i++){
            celdas.add(new Celda());
        }
    }
    
    //deberia ser void?
    //ver logica como avisar si cumpli patron
    public boolean marcar(Bolilla b){
        boolean result = false;
        for(int i = 0; i < celdas.size() && result == false; i++){
            result = celdas.get(i).marcar(b);
        }
        if(result == true){} // tengo que ver si complete figura
        return result;
    }

    public boolean cumpleFigura(ArrayList<Figura> figurasHabilitadas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
