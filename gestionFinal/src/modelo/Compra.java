/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.compra.Proveedor;

/**
 *
 * @author Luca
 */
public class Compra {
    
   private int nroCompra;
   private double total;
   private ArrayList<LineaCompra> lineas;
   private Proveedor proveedor;

    public Compra() {
        lineas = new ArrayList<>();
    }

    public int getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(int nroCompra) {
        this.nroCompra = nroCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
   public void agregarLinea(LineaCompra linea){
       lineas.add(linea);      
   }
   
   public void calcularTotal(){
       double ac = 0;
       for(int i=0; i<lineas.size(); i++){
           ac = ac + lineas.get(i).getSubtotal();
       }
       total = ac;
   }
    
}
