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
public class ListaPaneles extends JPanel{

    private int filas,columnas;
    GridLayout gridLayout = new GridLayout();
    
    public ListaPaneles(int filas, int columnas) {
        this.filas=filas;
        this.columnas=columnas;
        this.setLayout(gridLayout);
	gridLayout.setColumns(1);
        gridLayout.setRows(0);
    }
    
    public void agregarPanel(Object[] datos,MarcadorBoton mb) throws GridLayoutException{
        agregarPanel(datos, mb, "PANEL Nº " + (gridLayout.getRows()+1) 
                          + " (" +filas + " X " + columnas+")");
    }
    
    public void agregarPanel(Object[] datos, MarcadorBoton mb, String titulo) throws GridLayoutException{
        if (datos.length != filas * columnas) throw new GridLayoutException("Los datos recibidos no coinciden con la cantidad de filas y columnas definidos para el panel.");
        
        gridLayout.setRows(gridLayout.getRows()+1);
        PanelBotones pb = new PanelBotones(filas, columnas);
        pb.cargar(datos, mb);
        add(new PanelConTitulo(titulo, pb));
    }

    public void marcar() {
        Component[] lista = getComponents();
        for(Component c:lista){
            ((PanelConTitulo)c).marcar();
        }
    }
    
    
    
}