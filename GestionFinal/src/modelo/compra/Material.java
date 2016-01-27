/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.compra;

/**
 *
 * @author Luca
 */
public class Material {
    
    private int idMaterial;
    private String descripcion;
    private int precio;

    public Material(int idMaterial, String descripcion, int precio) {
        this.idMaterial = idMaterial;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }
    


    @Override
    public String toString() {
        return "Material{" + "idMaterial: " + idMaterial + ", descripcion: " + descripcion + ", precio: $" + precio + '}';
    }


    
}
