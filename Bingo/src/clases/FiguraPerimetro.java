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
    @Override
    public boolean cumpleFigura(Carton carton) {
        int largoCol = carton.getColumnas();     
        boolean puedeSeguir = true;  
        int i = 0;
        int auxTotalCeldas = carton.getCeldas().size()-1;
        while(i < largoCol-1){
            if(carton.getCeldas().get(i).getBolilla() == null || carton.getCeldas().get(auxTotalCeldas).getBolilla() == null) return false;
            i++;
            auxTotalCeldas--;
        }
        return true;
    }
    
    
}
