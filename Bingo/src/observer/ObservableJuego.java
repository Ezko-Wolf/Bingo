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
public class ObservableJuego {
     private HashSet<ObserverJuego> observers;

    public ObservableJuego() {
        observers = new HashSet();
    }
    
    public void addObserver(ObserverJuego obs) {
        observers.add(obs);
    }
    
    public void deleteObserver(ObserverJuego obs) {
        observers.remove(obs);
    }
    
    public void notifyObservers(Object event) {
        for (Iterator<ObserverJuego> iterator = observers.iterator(); iterator.hasNext();) {
            ObserverJuego o = iterator.next();
            o.update(this, event);
        }
    }
}
