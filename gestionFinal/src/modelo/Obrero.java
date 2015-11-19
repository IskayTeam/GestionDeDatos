/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Luca
 */
public class Obrero {
    
    private int idObrero;
    private String nombre;
    private Date fechaNacimiento;
    private int dni;
    private int cuil;

    public Obrero(int idObrero, String nombre, Date fechaNacimiento, int dni, int cuil) {
        this.idObrero = idObrero;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.cuil = cuil;
    }

    public int getIdObrero() {
        return idObrero;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getDni() {
        return dni;
    }

    public int getCuil() {
        return cuil;
    }
    
    
    
    
    
    
}
