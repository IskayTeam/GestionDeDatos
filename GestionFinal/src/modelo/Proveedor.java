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
public class Proveedor {
    
    private int idProveedor;
    private String nombre;
    private int telefono;
    private int cuit;

    public Proveedor(int idProveedor, String nombre, int telefono, int cuit) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cuit = cuit;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getCuit() {
        return cuit;
    }
    
    
    
    
}
