/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.liquidacion.Obrero;

/**
 *
 * @author Luca
 */
public class AbmObrero {
    
    private static ArrayList<Obrero> obreros = new ArrayList<>();
    
    public static void agregarObrero(int id, String nombre, Date fechaNac, int dni, int cuil){
        Obrero obrero = new Obrero(id, nombre, fechaNac, dni, cuil);
        obreros.add(obrero);
        
    }
    
}
