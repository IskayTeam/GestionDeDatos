/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Obra;
import modelo.venta.Cliente;
import modelo.venta.Departamento;
import modelo.venta.LineaVenta;
import modelo.venta.Venta;

/**
 *
 * @author Luca
 */
public class ControladorVenta {
    
    private Venta venta;
    private Cliente cliente;
    private LineaVenta linea;
    
    
    
    public  void  crearNuevaVenta(){
        
    venta = new Venta();
    //venta.setFecha(Date.from(Instant.EPOCH));
        
    }
    
    public void agregarCliente(int dni, String nombre, String domicilio, int telefono){
        
        cliente = new Cliente(dni, nombre, domicilio, telefono);
        venta.agregarCliente(cliente);
    }
    
    public void agregarDepartamento(Departamento depa){
        
        linea = new LineaVenta(depa);
        linea.calcularSubtotal();
     venta.getLineas().add(linea);
        
    }
    
    
    
    public void calcularTotalVenta (){
     
        double ac = 0;
        for(int i=0; i< venta.getLineas().size(); i++){
           ac = ac + venta.getLineas().get(i).getSubTotal();
           
        }
        venta.agregarMonto(ac);
        
    }
    
    public void finalizarVenta(){
        Controlador.conectar cc = new conectar();
    Connection cn = cc.conexion();
    
        String sql = "INSERT INTO venta(monto, fecha )VALUES ( " + venta.getMonto() + "," + venta.getFecha() + ")";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Venta Finalizada", "EXITO", JOptionPane.INFORMATION_MESSAGE);
        
        
        
        
        
        
}
    
}
