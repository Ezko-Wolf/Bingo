/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Ezko
 */
public class ObservableBolillero {
     private HashSet<ObserverBolillero> observers;

    public ObservableBolillero() {
        observers = new HashSet();
    }
    
    public void addObserver(ObserverBolillero obs) {
        observers.add(obs);
    }
    
    public void deleteObserver(ObserverBolillero obs) {
        observers.remove(obs);
    }
    
    public void notifyObservers(Object event) {
        for (Iterator<ObserverBolillero> iterator = observers.iterator(); iterator.hasNext();) {
            ObserverBolillero o = iterator.next();
            o.update(this, event);
        }
    }
}
