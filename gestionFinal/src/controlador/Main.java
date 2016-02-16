/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.PantallaAdmin;
import vista.PantallaPrincipal;

/**
 *
 * @author Luca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PantallaPrincipal pp = new PantallaPrincipal();
        pp.setVisible(true);
        pp.setLocationRelativeTo(null);
        
        //PantallaAdmin pantallaPrincipal = new PantallaAdmin();
        //pantallaPrincipal.setVisible(true);
        //pantallaPrincipal.setLocationRelativeTo(null);
        
        
    }
    
}
