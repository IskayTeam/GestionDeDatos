/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.liquidacion.Categoria;
import modelo.liquidacion.Obrero;

/**
 *
 * @author Luca
 */
public class AbmObrero {
    
    private static ArrayList<Obrero> obreros = new ArrayList<>();
    
    public static void agregarObrero(String nombre, String cuil, String estadoCivil, String localidad, String direccion, Date fechaNacimiento, Date fechaIngreso, int dni, int telefono, int idCat){
        Obrero obrero = new Obrero(nombre, cuil, estadoCivil, localidad, direccion, fechaNacimiento, fechaIngreso, dni, telefono, idCat);
        obreros.add(obrero);
        
    }
    
}
