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
public class ObservableJugador {
     private HashSet<ObserverJugador> observers;

    public ObservableJugador() {
        observers = new HashSet();
    }
    
    public void addObserver(ObserverJugador obs) {
        observers.add(obs);
    }
    
    public void deleteObserver(ObserverJugador obs) {
        observers.remove(obs);
    }
    
    public void notifyObservers(Object event) {
        for (Iterator<ObserverJugador> iterator = observers.iterator(); iterator.hasNext();) {
            ObserverJugador o = iterator.next();
            o.update(this, event);
        }
    }
}
