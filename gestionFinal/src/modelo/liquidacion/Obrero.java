/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.liquidacion;

import java.util.Date;

/**
 *
 * @author Luca
 */
public class Obrero {
    
    private int idObrero;
    private String nombre;
    private String apellido;
    private String cuil;
    private String estadoCivil;
    private String localidad;
    private String direccion;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private int dni;
    private int telefono;   
    private int categoria;

    public Obrero(String nombre, String apellido, String cuil, String estadoCivil, String localidad, String direccion, Date fechaNacimiento, Date fechaIngreso, int dni, int telefono, int categoria) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.estadoCivil = estadoCivil;
        this.localidad = localidad;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.dni = dni;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    public String getApellido() {
        return apellido;
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

    public String getCuil() {
        return cuil;
    }

    @Override
    public String toString() {
        return "Obrero{" + "idObrero=" + idObrero + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + ", cuil=" + cuil + '}';
    }
    
    
    
    
    
    
}
