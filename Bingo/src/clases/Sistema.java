/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import UI.Ui_ElegirLogin;
import modelo.Fachada;

/**
 *
 * @author Ezko
 */
public class Sistema {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fachada facha = Fachada.getInstancia();
        Bingo bing = new Bingo();
        facha.setBingo(bing);
        Usuario jenny = new Usuario("12345", "jenny123", "Jenny", 3, 3000.0);
        Usuario alejo = new Usuario("23423", "alejo123", "Alejo", 3, 3000.0);
        Usuario manteca = new Usuario("3456", "mante123", "Manteca", 3, 3000.0);
        Usuario tonga = new Usuario("54321", "tonga123", "Tonga", 3, 3000.0);
        facha.addUsuario(alejo);
        facha.addUsuario(jenny);
        facha.addUsuario(manteca);
        facha.addUsuario(tonga);
        
        facha.addAdministrador(new Administrador("12345", "admin123", "admin 1", "admin1@admin.com", facha.getBingo()));
        facha.addAdministrador(new Administrador("29654", "admin123", "admin 2", "admin2@admin.com", facha.getBingo()));
        
        
        Ui_ElegirLogin ui = new Ui_ElegirLogin();       
            ui.setVisible(true);
        //            facha.loginUsuario("12345", "jenny123", 3);
//            facha.loginUsuario("23423", "alejo123", 2);
//            facha.loginUsuario("3456", "mante123", 1);
//            facha.loginUsuario("34536", "tonga123", 3);

//        while(!facha.ganador()){
//            facha.continuar();
//        }
//        System.out.println("Ganador");
       
        
    }
}
