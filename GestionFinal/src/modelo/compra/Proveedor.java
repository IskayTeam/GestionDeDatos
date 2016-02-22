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
    private String cuit;
    private String provincia;
    private String localidad;
    private String direccion;
    private ArrayList<Material> materiales;

    public Proveedor(String nombre, String cuit, String provincia, String localidad, String direccion, int telefono) {
        
        this.nombre = nombre;
        this.telefono = telefono;
        this.cuit = cuit;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
        materiales = new ArrayList<>();
                
    }

    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(ArrayList<Material> materiales) {
        this.materiales = materiales;
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
