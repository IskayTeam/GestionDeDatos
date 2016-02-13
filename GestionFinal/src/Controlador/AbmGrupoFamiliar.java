/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.liquidacion.GrupoFamiliar;

/**
 *
 * @author Fran
 */
public class AbmGrupoFamiliar {
    
    private static ArrayList<GrupoFamiliar> grupofamiliar = new ArrayList<>();
    
    public static void agregarGrupoFamiliar(String nombre, String apellido, int dni, Date fechaNacimiento, String parentesco, int idOb){
    GrupoFamiliar miembro = new GrupoFamiliar(nombre, apellido, dni, fechaNacimiento, parentesco, idOb);
    
    grupofamiliar.add(miembro);
    }
    
    
    
}
