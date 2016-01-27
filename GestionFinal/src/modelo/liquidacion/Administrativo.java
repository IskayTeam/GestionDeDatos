/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.liquidacion;

/**
 *
 * @author Luca
 */
public class Administrativo {
    
    private int idAdmin;
    private String nombre;
    private String domicilio;
    private int cuit;
    private int telefono;

    public Administrativo(int idAdmin, String nombre, String domicilio, int cuit, int telefono) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.telefono = telefono;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getCuit() {
        return cuit;
    }

    public int getTelefono() {
        return telefono;
    }
    
    
    
    
}
