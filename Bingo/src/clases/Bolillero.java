/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import observer.ObservableBolillero;

/**
 *
 * @author Ezko
 */
public class Bolillero extends ObservableBolillero{
    private ArrayList<Bolilla> bolillas = new ArrayList();
    private ArrayList<Bolilla> bolillasSorteadas = new ArrayList();
    private int cantidadBolillas;
    
    public Bolillero(int cantidadBolillas) {
        this.cantidadBolillas = cantidadBolillas;
        this.generarBolillas();
    }
    
    public ArrayList<Bolilla> getBolillas() {
        return bolillas;
    }
    
    public int getCantidadBolillas(){
        return this.cantidadBolillas;
    }

    public Bolilla sortear() {
        if(bolillas.isEmpty()) throw new Error("No hay mas bolillas para sortear");
        Random r = new Random();
        int low = 0;
        int high = bolillas.size();
        int indx = r.nextInt(high-low) + low;
        Bolilla boli = bolillas.remove(indx);
        bolillasSorteadas.add(boli);
        return boli;
    }  

    private void generarBolillas() {
        for(int i = 0; i < this.cantidadBolillas; i++){
            bolillas.add(new Bolilla(i));
        }        
        Collections.shuffle(bolillas);
    }    

    public ArrayList<Bolilla> getBolillasSoretadas() {
        return this.bolillasSorteadas;
    }
    
    public Bolilla getUltimaBolillaSorteada(){
        if(bolillasSorteadas.isEmpty())
            return null;
        return bolillasSorteadas.get(bolillasSorteadas.size()-1);
    }
    
    void sacarBolillas(ArrayList<Integer> bolillasAbandono) {
        for(int i = 0; i < bolillas.size();i++){
            if(bolillasAbandono.contains(bolillas.get(i).getValor())){
                bolillas.remove(bolillas.get(i));
            }
        }
    }
}
