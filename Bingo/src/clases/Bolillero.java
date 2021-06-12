/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
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
        this.generarBolillas();
    }
    
    public ArrayList<Bolilla> getBolillas() {
        return bolillas;
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

    private void generarBolillas() {
        for(int i = 0; i < this.cantidadBolillas; i++){
            bolillas.add(new Bolilla(i));
        }        
        Collections.shuffle(bolillas);
    }    
}
