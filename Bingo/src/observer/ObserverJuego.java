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
public interface ObserverJuego {
    public enum Eventos {
        JUEGO_INICIADO,
        ACTUALIZA_ESTADO_JUEGO,
        JUGADOR_ABANDONO,
        HAY_GANADOR
    }
    
    public void update(ObservableJuego source, Object event);
}
