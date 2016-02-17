/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class Venta {
    
  
   private double monto;
   private Date fecha;
   private Cliente cliente;
   private ArrayList<LineaVenta> lineas;

    public Venta() {
        
        
        lineas = new ArrayList<>();
    }


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaVenta> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaVenta> lineas) {
        this.lineas = lineas;
    }
  
   public void agregarCliente(Cliente c){
       
       cliente = c;
   }
   
   public void agregarMonto(double total){
       
       monto = total;
   }
   
   public void agregarLineaVenta(LineaVenta lv){
       
       lineas.add(lv);
   }

    @Override
    public String toString() {
        return "Venta{" + "monto=" + monto + ", fecha=" + fecha + ", cliente=" + cliente + '}';
    }
   
   
   
    
}
