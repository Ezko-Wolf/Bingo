/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.IFigura;
import java.util.ArrayList;

/**
 *
 * @author atrias
 */
public class Pozo {
    private static double monto;

    public Pozo() {
    }
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    void agregarSaldo(int cantCartones, double valorCarton) {
        this.monto += cantCartones * valorCarton;
    }
    
    private void agregarPremio(double costoPremio){
        this.monto += costoPremio;
    }
    
    private double calcularPremio(int cantCartones, double valorCarton, double multiploPozo){
        return cantCartones * valorCarton * multiploPozo;
    }

    public void liquidar(Jugador ganador, ArrayList<Jugador> jugadores,double valorCarton) {
        IFigura figuraGanadora = ganador.getFiguraGanadora();
        double multiploPozo = figuraGanadora.getMultiploPozo();
        for(Jugador j : jugadores){
            if(!ganador.equals(j)) {
                double costoPremio = this.calcularPremio(j.getCantidadCartones(),valorCarton,multiploPozo);
                this.agregarPremio(costoPremio);
                j.pagar(this.getMonto());
                
            }
        }
        ganador.cobrar(this.getMonto());
    }  
}
