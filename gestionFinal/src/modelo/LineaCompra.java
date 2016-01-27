/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.compra.Material;

/**
 *
 * @author Luca
 */
public class LineaCompra {
    
    private Material material;
    private int cantidad;
    private double subtotal;

    public LineaCompra() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    
    public void agregarMaterial(Material m){
        
        material = m;
    }
    
    public void calcularSubtotal(){
        subtotal = material.getPrecio() * cantidad;
    }
    
}
