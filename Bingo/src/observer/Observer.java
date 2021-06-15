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
public interface Observer {
    public enum Eventos {
        JUEGO_INICIADO
    }
    
    public void update(Observable source, Object event);
}
