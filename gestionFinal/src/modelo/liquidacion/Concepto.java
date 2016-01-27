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
public class Concepto {
    
    private int idConcepto;
    private String descripcion;
    private String tipo;
    private float montoFijo;
    private float montoVariable;

    public Concepto(int idConcepto, String descripcion, String tipo, float montoFijo, float montoVariable) {
        this.idConcepto = idConcepto;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.montoFijo = montoFijo;
        this.montoVariable = montoVariable;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public float getMontoFijo() {
        return montoFijo;
    }

    public float getMontoVariable() {
        return montoVariable;
    }
    
    
    
}
