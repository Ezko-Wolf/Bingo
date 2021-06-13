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
public class HelperCrearCartones {
    static private int indiceBolilla = 0;

    static void crearCartones(ArrayList<Bolilla> bolillas, ArrayList<Jugador> jugadores, int filas, int columnas) {
        for(Jugador j:jugadores){
            int canCartones = j.getCantidadCartones();
            ArrayList<Carton> cartones = new ArrayList();
            for(int i = 0; i < canCartones; i++){
                cartones.add(new Carton(filas, columnas));
            }
            HelperCrearCartones.llenarCartones(cartones, bolillas);
            j.setCartones(cartones);
        }
        indiceBolilla = 0;
    } 
    
    static private void llenarCartones(ArrayList<Carton> cartones, ArrayList<Bolilla> bolillas){
        for(int i = 0; i < cartones.size(); i++){
            ArrayList<Celda> celdas = cartones.get(i).getCeldas();
            for(Celda c:celdas){
                c.setValor(bolillas.get(indiceBolilla).getValor());  
                indiceBolilla++;
            }
        }
    }
}
