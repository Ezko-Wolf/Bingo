/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ezko
 */
public class Bolillero {
    private ArrayList<Bolilla> bolillas = new ArrayList();
    private ArrayList<Bolilla> bolillasSorteadas = new ArrayList();
    private int cantidadBolillas;
    
    public Bolillero(int fila, int columna, int cantCartones) {
        this.cantidadBolillas = calcularCantidadBolillas(fila, columna, cantCartones);
        this.generarBolillas();
    }
    
    public ArrayList<Bolilla> getBolillas() {
        return bolillas;
    }

    public Bolilla sortear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void crearBolillas(){
       
    }
    
    private int calcularCantidadBolillas(int fila, int columna, int cantCartones){
        return fila * columna * cantCartones;
    }

    private void generarBolillas() {
        for(int i = 0; i < this.cantidadBolillas; i++){
            bolillas.add(new Bolilla(i));
        }        
        Collections.shuffle(bolillas);
    }    
}
