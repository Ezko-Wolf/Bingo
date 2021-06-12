/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Random;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Bolilla sortear() {
        if(bolillas.size()== 0) throw new Error("No hay mas bolillas para sortear");
        Random r = new Random();
        int low = 0;
        int high = bolillas.size();
        int indx = r.nextInt(high-low) + low;
        Bolilla boli = bolillas.remove(indx);
        bolillasSorteadas.add(boli);
        return boli;
    }
    
    private void crearBolillas(){
        
    }
    
    private int calcularCantidadBolillas(int fila, int columna, int cantCartones){
        return fila * columna * cantCartones;
    }
    
}
