/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteGrid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Dario
 */
public class Boton extends JButton implements ActionListener{
    private Object dato;
    private MarcadorBoton marcador;
    
    public Boton(Object dato, MarcadorBoton mb) throws GridLayoutException {
        if (dato == null) throw new GridLayoutException(("No puede proporcionarse un dato nulo."));
        
        setFont(new Font("Tahoma", 1, 16));
        this.dato = dato;
        marcador = mb;
        setToolTipText(marcador.getTextoAyuda(dato));
        setText(marcador.getTexto(dato));
        addActionListener(this);
    }
    public Object getDato() {
        return dato;
    }
    public void setDato(Object dato) {
        this.dato = dato;
    }
    public void marcar(){
        if(marcador.marcar(dato)){
            setBackground(new Color(0, 64, 0));
            setForeground(Color.WHITE);
        } else {
            setBackground(null);
            setForeground(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        marcador.click(dato);
    }
    
}
