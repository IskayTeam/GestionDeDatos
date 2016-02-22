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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.LineaCompra;
import modelo.compra.Material;
import modelo.compra.Proveedor;
import vista.ListaCompras;

/**
 *
 * @author Luca
 */
public class ControladorCompra {
    
    private Compra compra;
    private Proveedor proveedor;
    private Material material;
    private LineaCompra linea;
    Controlador.Conectar conexion = new Controlador.Conectar();
    Connection cn = conexion.conexion();
    private int obraEnCuestion;
    
    
    public void nuevaCompra(){
        
         compra = new Compra();
        
    }
    
    public void agregarTotal(float total){
        
        compra.setTotal(total);
    }
    
    public void agregarProveedor(int id, String nombre,String cuit,String provincia,String localidad,String direccion,int telefono){
        proveedor = new Proveedor(nombre, cuit, provincia, localidad, direccion, telefono);
        proveedor.setIdProveedor(id);
    }
    
    public void agregarObra(int idObra){
        
       obraEnCuestion = idObra;
        
    }
    
    public void finalizarCompra(){
        
       System.out.println(obraEnCuestion);
       double total = compra.getTotal();
       int idProv = proveedor.getIdProveedor();
       
        
        String sql = "INSERT INTO compra(total, Proveedor, Obra, Administrativo)" + 
                "VALUES (' "+ compra.getTotal()+ "','" + idProv + "','1','2')";
        
        try {
            Statement st = cn.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        JOptionPane.showMessageDialog(null, "Compra Finalizada", "EXITO", JOptionPane.INFORMATION_MESSAGE);
        
    }

    public void mostrarCompras(ListaCompras lc) {
        
        String sql = "SELECT * FROM compra";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) lc.getTablaCompra().getModel();
            lc.getTablaCompra().setModel(modelo);

            int i;
            Object datosfila[] = new Object[5];
            while (rs.next()) {
                for(i=0; i<datosfila.length;i++){
              datosfila[i] = rs.getObject(i + 1);  
                }
                modelo.addRow(datosfila);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            conexion.cerrarConexion();
        }
    }
    
}