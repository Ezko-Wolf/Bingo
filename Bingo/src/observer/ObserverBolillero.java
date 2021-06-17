/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author Ezko
 */
public interface ObserverBolillero {
    public enum Eventos {
        SORTEA_BOLILLA
    }
    
    public void update(ObservableBolillero source, Object event);
}
