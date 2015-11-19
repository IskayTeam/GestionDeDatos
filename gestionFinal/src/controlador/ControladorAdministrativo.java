/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Administrativo;

/**
 *
 * @author Luca
 */
public class ControladorAdministrativo {
    
    private Administrativo administrador;
    private Administrativo adminCompras;
    private Administrativo adminVentas;
    private ArrayList<Administrativo> administradores = new ArrayList<>();
    
    public void agregarAdministrativo(){
        Administrativo administrador    = new Administrativo(01, "Luca Fogliatto", "Las Rosas 29", 101010, 4353629);
        Administrativo adminCompras     = new Administrativo(02, "Francisco Garcia Nava", "Balcarce 720", 202020, 123456);
        Administrativo adminVenta       = new Administrativo(03, "Jose Scarlata", "Peru 1207", 303003, 54321);
        Administrativo adminLiquidacion = new Administrativo(04, "Carolina Barros", "Peru 1207", 5748, 102938);
  
        administradores.add(administrador);
        administradores.add(adminCompras);
        administradores.add(adminVenta);
        administradores.add(adminLiquidacion);  
        
        
    }
   
    
    
}
