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
public class Observable {
     private HashSet<Observer> observers;

    public Observable() {
        observers = new HashSet();
    }
    
    public void addObserver(Observer obs) {
        observers.add(obs);
    }
    
    public void deleteObserver(Observer obs) {
        observers.remove(obs);
    }
    
    public void notifyObservers(Object event) {
        for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext();) {
            Observer o = iterator.next();
            o.update(this, event);
        }
    }
}
