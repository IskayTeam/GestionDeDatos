/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.Fecha;
import java.util.ArrayList;
import java.util.Date;
import modelo.liquidacion.Obrero;

/**
 *
 * @author Luca
 */
public class Obra {
    
    private int idObra;
    private String nombre;
    private String direccion;
    private ArrayList<Obrero> obreros;
    private Date fechaInicio;
    private Date fechaFin;
    private double egresos;

    public Obra(String nombre, String direccion, Date fechaInicio, Date fechaFin, double egresos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.egresos = egresos;
        obreros = new ArrayList<>();
    }


  

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Obrero> getObreros() {
        return obreros;
    }

    public void setObreros(ArrayList<Obrero> obreros) {
        this.obreros = obreros;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getEgresos() {
        return egresos;
    }

    public void setEgresos(float egresos) {
        this.egresos = egresos;
    }


    
    
    
    
    
    
}
