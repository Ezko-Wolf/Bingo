/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteGrid;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Dario
 */
public class PanelBotones extends JPanel{
    
    public PanelBotones(int filas,int columnas){
        GridLayout gridLayout = new GridLayout();
	this.setLayout(gridLayout);
	gridLayout.setRows(filas);
	gridLayout.setColumns(columnas);
    }
    public void cargar(Object[] datos, MarcadorBoton mb) throws GridLayoutException{
        for(Object o:datos){
            Boton b = new Boton(o, mb);
            add(b);
        }
    }

    public void marcar() {
        Component[] lista = getComponents();
        for(Component c:lista){
            ((Boton)c).marcar();
        }
    }
}
