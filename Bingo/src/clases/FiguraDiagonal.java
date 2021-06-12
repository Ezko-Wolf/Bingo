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
class FiguraDiagonal implements IFigura {
    @Override
    public boolean cumpleFigura(Carton carton) throws BingoExceptions {
        if (carton.getFilas() != carton.getColumnas())
            throw new BingoExceptions("La matriz no es cuadrada, no existe diagonal");
        boolean izquierdaADerecha = true;
        boolean derechaAIzquierda = true;
        
        int largoCol = carton.getColumnas();
        int totalCeldas = carton.getColumnas() * carton.getColumnas()+1;

        for (int i = 0; i < carton.getCeldas().size() && izquierdaADerecha; i = i + largoCol + 1) {
            if (carton.getCeldas().get(i).getBolilla() == null) izquierdaADerecha = false;
        }

        for(int i = totalCeldas-largoCol+1;i >= 0 && derechaAIzquierda; i= i-largoCol+1){
            if(carton.getCeldas().get(i).getBolilla() == null) derechaAIzquierda=false;
        }
        return izquierdaADerecha || derechaAIzquierda;
    }
}