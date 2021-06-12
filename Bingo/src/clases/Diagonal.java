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
class Diagonal implements Figura{
    @Override
    public boolean valido(Carton carton) {
        if(carton.getFilas() != carton.getColumnas())throw new Error("La matriz no es cuadrada, no existe diagonal");
        for(int i= 0;i<carton.getCeldas().size();i++){
            
        }
        return false;
    }
    
}
