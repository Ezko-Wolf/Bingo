/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteGrid;

/**
 *
 * @author Dario
 */
public interface MarcadorBoton {

    /**
     * @return el texto a renderizar para un dato.
     */
    public String getTexto(Object dato);

    /**
     * @return true si dato se encuentra marcado.
     */
    public boolean marcar(Object dato);

    /**
     * @return un String contextual referido al dato.
     */
    public String getTextoAyuda(Object dato);

    /**
     * Implementa la accion a ejecutar cuando se hace click en un dato.
     */
    public void click(Object dato);

}
