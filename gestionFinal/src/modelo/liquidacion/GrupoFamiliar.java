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
    private String apellido;
    private int dni;
    private Date fechaNacimiento;
    private String parentesco;
    private int idOb;

    public GrupoFamiliar(String nombre, String apellido, int dni, Date fechaNacimiento, String parentesco, int idOb) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.parentesco = parentesco;
        this.idOb = idOb;
    }

    public int getIdGrupoFamiliar() {
        return idGrupoFamiliar;
    }

    public void setIdGrupoFamiliar(int idGrupoFamiliar) {
        this.idGrupoFamiliar = idGrupoFamiliar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public int getIdOb() {
        return idOb;
    }

    public void setIdOb(int idOb) {
        this.idOb = idOb;
    }

    public String getApellido() {
        return apellido;
    }
    
    
    
}
