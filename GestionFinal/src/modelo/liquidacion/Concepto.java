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

    public Concepto() {
    }
    

    public Concepto(int idConcepto, String descripcion, String tipo, float montoFijo, float montoVariable) {
        this.idConcepto = idConcepto;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.montoFijo = montoFijo;
        this.montoVariable = montoVariable;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMontoFijo(float montoFijo) {
        this.montoFijo = montoFijo;
    }

    public void setMontoVariable(float montoVariable) {
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

    @Override
    public String toString() {
        return "Concepto{" + "idConcepto=" + idConcepto + ", descripcion=" + descripcion + ", tipo=" + tipo + ", montoFijo=" + montoFijo + ", montoVariable=" + montoVariable + '}';
    }
    
    
    
}
