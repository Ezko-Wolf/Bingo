/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteGrid;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dario
 */
public class PanelConTitulo extends JPanel{

    public PanelConTitulo(String titulo,PanelBotones pb) {
        setLayout(new BorderLayout());
        JLabel lb = new JLabel(titulo);
        lb.setFont(new Font("Tahoma", 1, 18));
        lb.setHorizontalAlignment(JLabel.CENTER);
        add(lb,BorderLayout.NORTH);
        add(pb,BorderLayout.CENTER);
    }

    public void marcar() {
        ((PanelBotones)getComponent(1)).marcar();
    }
}
