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
public class FiguraCartonLleno implements IFigura {

    private double multiploPozo = 2 ;
    private String nombre = "CartonLleno";
    
    @Override
    public boolean cumpleFigura(Carton carton) {
        for (int i = 0; i < carton.getCeldas().size(); i++) {
            if (carton.getCeldas().get(i).getBolilla() == null) return false;
        }
        return true;
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
