/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.IFigura;

/**
 *
 * @author atrias
 */
public class FiguraPerimetro implements IFigura {
    private double multiploPozo = 1.5;
    private String nombre = "Perimetro";

    @Override
    public boolean cumpleFigura(Carton carton) {
        int largoCol = carton.getColumnas();  
        int largoFila = carton.getFilas();
        int largo = carton.getCeldas().size() - 1; 
        
        boolean puedeSeguirExtremo = true;  
        boolean puedeSeguirMedio = true;
        
        int i = 0;
        int auxTotalCeldas = carton.getCeldas().size()-1;
        
        while(i < largoCol-1 && puedeSeguirExtremo){
            if(carton.getCeldas().get(i).getBolilla() == null || carton.getCeldas().get(auxTotalCeldas).getBolilla() == null) puedeSeguirExtremo = false;
            i++;
            auxTotalCeldas--;
        }
        
        int j = largoFila;
        
        while(j < largo && puedeSeguirMedio){
            if(carton.getCeldas().get(j).getBolilla() == null || carton.getCeldas().get(j*2-1).getBolilla() == null) puedeSeguirMedio = false;
            j+=largoFila;
        }
        
        return puedeSeguirExtremo && puedeSeguirMedio;
    }   

    @Override
    public double getMultiploPozo() {
        return this.multiploPozo;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
