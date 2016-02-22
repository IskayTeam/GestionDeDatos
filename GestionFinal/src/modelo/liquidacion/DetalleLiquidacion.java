/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.liquidacion;

/**
 *
 * @author marco
 */
public class DetalleLiquidacion {
   
    private  int idDetalle;
    private Concepto concepto;
    private float monto;
    private float montoDescuento;
    private int cantidad;

    public DetalleLiquidacion(float monto, float montoDescuento) {
        this.monto = monto;
        this.montoDescuento = montoDescuento;
    }

    public DetalleLiquidacion() {
    }
    

    public DetalleLiquidacion(Concepto concepto, float monto, float montoDescuento, int cantidad) {
        this.concepto = concepto;
        this.monto = monto;
        this.montoDescuento = montoDescuento;
        this.cantidad = cantidad;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(float montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleLiquidacion{" + "idDetalle=" + idDetalle + ", concepto=" + concepto + ", monto=" + monto + ", montoDescuento=" + montoDescuento + ", cantidad=" + cantidad + '}';
    }

    
    
    
    
}
