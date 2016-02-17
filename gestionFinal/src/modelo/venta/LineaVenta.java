/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.venta;

/**
 *
 * @author Luca
 */
public class LineaVenta {
    
    private int idLineaVenta;
   // NO lo usamos --  private int cantidad;
    private Departamento dpto;
    private float subTotal;
    private Venta venta;

    public LineaVenta(Departamento dpto) {
        this.dpto = dpto;
    }

 
    
    public int getIdLineaVenta() {
        return idLineaVenta;
    }

    public void setIdLineaVenta(int idLineaVenta) {
        this.idLineaVenta = idLineaVenta;
    }


    public Departamento getDpto() {
        return dpto;
    }

    public void setDpto(Departamento dpto) {
        this.dpto = dpto;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public void agregarDepartamento (Departamento depa){
        
        dpto = depa;
    }
    
    public void calcularSubtotal (){
        
        subTotal = dpto.getPrecio();
    }
    
}
