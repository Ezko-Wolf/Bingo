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


public class FiguraLinea implements IFigura {
    private double multiploPozo = 0;
    private String nombre = "Linea";
    @Override
    public boolean cumpleFigura(Carton carton) {
        boolean cumpleHorizontal = true;
        boolean cumpleVertical = true;
        
        int largoCol = carton.getColumnas();  
        int largo = carton.getCeldas().size(); 
        int largoFijo = largoCol;
      
        int j = 0;        
        int i = 0;  
        while(j<largo){
            while(i < largoCol){
                if(carton.getCeldas().get(i).getBolilla() == null)
                    cumpleHorizontal = false;
                
                i++;
            }
            if(cumpleHorizontal == true)
                return true;
            
            cumpleHorizontal = true;
            
            largoCol = i+largoFijo;
            j+=largoFijo;
        }
        
        
        int h = 0;
        int k = 0;
        while(h < largoFijo){
            while(k < largo) {
                if (carton.getCeldas().get(k).getBolilla() == null)
                    cumpleVertical = false;
                
                k += largoCol;
            }
            
            if(cumpleVertical == true)
                return true;
            
            cumpleVertical = true;
            
            h++;
            k=h;
        }
            
        
        return false;
        
    }
    @Override
    public String toString(){
        return this.nombre;
    }


    @Override
    public double getMultiploPozo() {
        return this.multiploPozo;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
    
}
