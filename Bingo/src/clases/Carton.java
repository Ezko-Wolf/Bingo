/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import exepctions.BingoExceptions;
import java.util.ArrayList;
import java.util.HashMap;

import interfaces.IFigura;

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
 
    public ArrayList<Celda> getCeldas(){
        return this.celdas;
    } 
  
    public int getFilas(){
        return this.filas;
    }

    public int getColumnas(){
        return this.columnas;
    }

    private void crearCeldas(){
        int largo = this.filas * this.columnas;
        for(int i = 0; i < largo; i++){
            celdas.add(new Celda());
        }
    }
    public ArrayList<Integer> getValores(){
        ArrayList<Integer> valores = new ArrayList();
        for(Celda c: celdas){
            c.getBolillaSinMarcar(valores);
        }
        return valores;
    }
    
    //deberia ser void?
    //ver logica como avisar si cumpli patron
    public boolean marcar(Bolilla b){
        boolean result = false;
        for(int i = 0; i < celdas.size() && result == false; i++){
            result = celdas.get(i).marcar(b);
        }
        return result;
    }

    public IFigura cumpleFigura(ArrayList<IFigura> figurasHabilitadas) {
            HashMap<String, IFigura> map = new HashMap<String,IFigura>();
            for(IFigura f: figurasHabilitadas){
                if(f.cumpleFigura(this)) map.put(f.getNombre(), f);
            }
            if(map.get("CartonLleno") != null) return map.get("CartonLleno");
            else if(map.get("Perimetro")!= null) return map.get("Perimetro");
            else if(map.get("Diagonal")!= null)return map.get("Diagonal");
            else if(map.get("Linea")!= null)return map.get("Linea");
            else return null;
 
    }
    
}