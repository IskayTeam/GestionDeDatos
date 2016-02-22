/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.liquidacion;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marco
 */
public class Liquidacion {
   
    private Obrero empleado;
    private Date fechaHasta;
    private Date fechaDesde;
    private Float salarioNeto;
    private  Float totalHaberes;
    private Float tontalDescuentos;
    private ArrayList<DetalleLiquidacion> lineasLiquidacion ;
    
    
    public Liquidacion(){
        lineasLiquidacion = new ArrayList<DetalleLiquidacion>();
    
}
    
    

    public Liquidacion(Obrero empleado, Date fechaHasta, Date fechaDesde, Float salarioNeto, Float totalHaberes, Float tontalDescuentos, ArrayList lineasLiquidacion) {
        this.empleado = empleado;
        this.fechaHasta = fechaHasta;
        this.fechaDesde = fechaDesde;
        this.salarioNeto = salarioNeto;
        this.totalHaberes = totalHaberes;
        this.tontalDescuentos = tontalDescuentos;
        this.lineasLiquidacion = lineasLiquidacion;
    }
    

    public Obrero getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Obrero empleado) {
        this.empleado = empleado;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Float getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(Float salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public Float getTotalHaberes() {
        return totalHaberes;
    }

    public void setTotalHaberes(Float totalHaberes) {
        this.totalHaberes = totalHaberes;
    }

    public Float getTontalDescuentos() {
        return tontalDescuentos;
    }

    public void setTontalDescuentos(Float tontalDescuentos) {
        this.tontalDescuentos = tontalDescuentos;
    }

    public ArrayList<DetalleLiquidacion> getLineasLiquidacion() {
        return lineasLiquidacion;
    }

    public void setLineasLiquidacion(ArrayList<DetalleLiquidacion> lineasLiquidacion) {
        this.lineasLiquidacion = lineasLiquidacion;
    }

    

  
    public void AgregarLinea(DetalleLiquidacion linea)
    {
      lineasLiquidacion.add(linea);
    }

    @Override
    public String toString() {
        return "Liquidacion{" + "empleado=" + empleado + ", fechaHasta=" + fechaHasta + ", fechaDesde=" + fechaDesde + ", salarioNeto=" + salarioNeto + ", totalHaberes=" + totalHaberes + ", tontalDescuentos=" + tontalDescuentos + ", lineasLiquidacion=" + lineasLiquidacion + '}';
    }
    
    
    
}
