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
    private int idProv;

    public Material(int idMaterial, String descripcion, int precio, int idProv) {
        this.idMaterial = idMaterial;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idProv = idProv;

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

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }
    


    @Override
    public String toString() {
        return "Material{" + "idMaterial: " + idMaterial + ", descripcion: " + descripcion + ", precio: $" + precio + '}';
    }


    
}
