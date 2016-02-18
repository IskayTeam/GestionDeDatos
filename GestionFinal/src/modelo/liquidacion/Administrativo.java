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
    private String cuil;
    private Usuario usuario;
    
    

    public Administrativo(String nombre, String domicilio, String cuil, Usuario usuario) {
        
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cuil = cuil;
        this.usuario = usuario;
    }

    public Administrativo() {
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

    public String getCuil() {
        return cuil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    @Override
    public String toString() {
        return "Administrativo{" + "idAdmin=" + idAdmin + ", nombre=" + nombre + ", domicilio=" + domicilio + ", cuil=" + cuil + ", usuario=" + usuario + '}';
    }

    
    
    
    
    
}
