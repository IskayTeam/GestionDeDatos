/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.liquidacion;

import java.util.ArrayList;
import java.util.Date;
import modelo.Obra;

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
    private Categoria categoria;
    private ArrayList grupofamiliar;
    private Obra obra;

    public Obrero() {
        grupofamiliar = new ArrayList<GrupoFamiliar>();
    }
    
    public Obrero(String nombre, String apellido, String cuil, String estadoCivil, String localidad, String direccion, Date fechaNacimiento, Date fechaIngreso, int dni, int telefono, Categoria categoria, Obra obra) {
        
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
        this.obra = obra;
    }
    
        public Obrero(String nombre, String apellido, int dni, Categoria categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.categoria = categoria;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
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

    public void setIdObrero(int idObrero) {
        this.idObrero = idObrero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setGrupofamiliar(ArrayList grupofamiliar) {
        this.grupofamiliar = grupofamiliar;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public int getTelefono() {
        return telefono;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public ArrayList getGrupofamiliar() {
        return grupofamiliar;
    }

    
    @Override
    public String toString() {
        return "Obrero{" + "idObrero=" + idObrero + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + ", cuil=" + cuil + '}';
    }
    
    
    
    
    
    
}
