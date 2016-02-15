/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Compra;
import modelo.LineaCompra;
import modelo.compra.Material;
import modelo.compra.Proveedor;
import repositorio.RepositorioCompras;

/**
 *
 * @author Luca
 */
public class ControladorCompra {
    
    private Compra compra;
    private Proveedor p;
    private Material m;
    
    
    public void nuevaCompra(){
        
        Compra compra = new Compra();
        
    }
    
    public Proveedor buscarProveedor(int codigo){
        //p = AbmProveedor.buscarProveedor(codigo);
        return p;
    }
    
    public  Material buscarMaterial(int codigo){
        
      m =  p.buscarMaterial(codigo);
        return m;
    }
    
    public void agregarLinea(int cantidad){
        LineaCompra linea = new LineaCompra();
        linea.setCantidad(cantidad);
        linea.agregarMaterial(m);
        linea.calcularSubtotal();
        compra.agregarLinea(linea);
        
    }
    
    public void finalizarCompra(){
        compra.calcularTotal();
        RepositorioCompras.agregarCompra(compra);
    }
          
    
}
