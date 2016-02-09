/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.liquidacion;

import java.util.Date;

/**
 *
 * @author Fran
 */
public class GrupoFamiliar {
    
    private int idGrupoFamiliar;
    private String nombre;
    private int dni;
    private Date fechaNacimiento;
    private String parentesco;
    private int idOb;

    public GrupoFamiliar(String nombre, int dni, Date fechaNacimiento, String parentesco, int idOb) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.parentesco = parentesco;
        this.idOb = idOb;
    }
    
    
    
}
