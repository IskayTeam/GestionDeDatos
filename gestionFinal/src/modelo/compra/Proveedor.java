/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.compra;

import java.util.ArrayList;

/**
 *
 * @author Luca
 */
public class Proveedor {
    
    private int idProveedor;
    private String nombre;
    private int telefono;
    private int cuit;
    private String direccion;
    private ArrayList<Material> materiales;

    public Proveedor(int idProveedor, String nombre, String direccion  , int cuit, int telefono) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cuit = cuit;
        this.direccion = direccion;
        materiales = new ArrayList<>();
                
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
    public Material buscarMaterial(int codigo){
        Material auxiliar = null;
        for(int i=0; i<materiales.size(); i++){
            if(codigo == materiales.get(i).getIdMaterial()){
                auxiliar = materiales.get(i);
            }
        } return auxiliar;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + ", telefono=" + telefono + ", cuit=" + cuit + ", direccion=" + direccion + '}';
    }
    
    
    
    
}
