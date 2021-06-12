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
public class HelperLlenarCartones {

    static void llenarCartones(ArrayList<Bolilla> bolillas, ArrayList<Carton> cartones) {
        int indiceBolilla = 0;
        for(int i = 0; i < cartones.size(); i++){
            ArrayList<Celda> celdas = cartones.get(i).getCeldas();
            for(Celda c:celdas){
                c.setValor(bolillas.get(indiceBolilla).getValor());  
                indiceBolilla++;
            }
        }
        
    }   
}
