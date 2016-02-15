/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.liquidacion;

import modelo.Usuario;

/**
 *
 * @author Luca
 */
public class Administrativo {
    
    private int idAdmin;
    private String nombre;
    private String domicilio;
    private String cuit;
    private int idUs;
    
    

    public Administrativo(String nombre, String domicilio, String cuit, int idUs) {
        
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.idUs = idUs;
        
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

    public String getCuit() {
        return cuit;
    }

    
    
    
    
    
}
