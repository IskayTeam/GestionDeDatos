/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Luca
 */
public class Material {
    
    private int idMaterial;
    private String descripcion;

    public Material(int idMaterial, String descripcion) {
        this.idMaterial = idMaterial;
        this.descripcion = descripcion;

    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }


    
}
