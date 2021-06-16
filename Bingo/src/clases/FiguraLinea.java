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
        return false;
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
