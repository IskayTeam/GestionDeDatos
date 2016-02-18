/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import modelo.compra.Proveedor;
import vista.AltaProveedor;
import vista.ListaProveedor;

/**
 *
 * @author Luca
 */
public class AbmProveedor {
    
    public Conectar cc = new Conectar();
    public Connection cn = cc.conexion();
    public static ArrayList<Proveedor> proveedores = new ArrayList<>();
    
    public static void agregarProveedor(String nombre, String cuit, String provincia, String localidad, String direccion, int telefono){
        
        Proveedor proveedor = new Proveedor(nombre, cuit, provincia, localidad, direccion, telefono);
            proveedores.add(proveedor);
            System.out.println(proveedor);
        
    }
    
    public void eliminarProveedor(int codigo){
        
        Proveedor v = buscarProveedor(codigo);
        if(v != null){
            proveedores.remove(v);
        }
        
    }
    
    public Proveedor buscarProveedor(int codigo){
        
        Proveedor auxiliar = null;
         for(int i=0; i< proveedores.size(); i++){
            if( codigo == proveedores.get(i).getIdProveedor()){
                
                auxiliar = proveedores.get(i);
            }
            
        } return auxiliar;
    }
    
    public String getNombreProveedorSeleccionado(ListaProveedor lp){
    int row = lp.getTablaProveedor().getSelectedRow();
        String name = lp.getTablaProveedor().getValueAt(row, 0).toString();
    return name;
    }

public String getCuitProveedorSeleccionado(ListaProveedor lp){
    int row = lp.getTablaProveedor().getSelectedRow();
        String cuit = lp.getTablaProveedor().getValueAt(row, 1).toString();
    return cuit;
    }

    public void autoCompletar(ListaProveedor lp){
        TextAutoCompleter txt = new TextAutoCompleter(lp.getCampoBuscarProv());
        String sql = "SELECT nombre FROM proveedor";
        try{
        Statement st = cn.prepareStatement(sql);
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            txt.addItem(rs.getString("nombre"));
        }
        }catch(SQLException ex){
            Logger.getLogger(sql, null);
        }
    }
    
    public void mostrarProv(ListaProveedor lp){
    String sql = "SELECT nombre, cuit, provincia, localidad, direccion, telefono FROM proveedor";
        try{
    Statement st = cn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    DefaultTableModel modelo = (DefaultTableModel)lp.getTablaProveedor().getModel();
    lp.getTablaProveedor().setModel(modelo);
    
    int i;
    Object datosfila[] = new Object[6];
    while(rs.next()){
    for(i=0;i<datosfila.length;i++){
    datosfila[i]=rs.getObject(i+1);
    }
    modelo.addRow(datosfila);
    }
      }catch(SQLException ex){
    Logger.getLogger(sql, null);
    }finally {
            cc.cerrarConexion();
        }
    }
    
    public void bajaProveedor(ListaProveedor lp){
        int fila;
        int resp;
        DefaultTableModel modelo = (DefaultTableModel) lp.getTablaProveedor().getModel();
        fila = lp.getTablaProveedor().getSelectedRow();
        

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el proveedor a eliminar", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este proveedor?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                
                try {
                    String cuit = lp.getTablaProveedor().getValueAt(fila, 1).toString();
                    String sql = "DELETE FROM proveedor WHERE cuit='" + cuit + "'";
                    Statement st = cn.prepareStatement(sql);
                    st.executeUpdate(sql);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                modelo.removeRow(fila);
                eliminarProveedor(fila);
            }
    }
    }
    
    
    
}
