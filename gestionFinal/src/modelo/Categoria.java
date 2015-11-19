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
public class Categoria {
    
    private int idCategoria;
    private String nombreCategoria;
    private float salarioBasico;

    public Categoria(int idCategoria, String nombreCategoria, float salarioBasico) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.salarioBasico = salarioBasico;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public float getSalarioBasico() {
        return salarioBasico;
    }
    
    
    
    
}
