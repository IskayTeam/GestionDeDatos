/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.venta;

import modelo.Obra;

/**
 *
 * @author Luca
 */
public class Departamento {
    
    private String descripcion;
    private int piso;
    private int numero;
    private float precio;
    private Obra obra;
    
    public Departamento(String descripcion, int piso, int numero, float precio) {
        this.descripcion = descripcion;
        this.piso = piso;
        this.numero = numero;
        this.precio = precio;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    
}
