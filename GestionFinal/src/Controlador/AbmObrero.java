/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.liquidacion.Categoria;
import modelo.liquidacion.Obrero;
import vista.AñadirGrupoFliar;
import vista.AñadirPersonal;
import vista.ListaPersonal;
import vista.ListaProveedor;

/**
 *
 * @author Luca
 */
public class AbmObrero {

    public static ArrayList<Obrero> obreros = new ArrayList<>();
    Controlador.conectar cc = new Controlador.conectar();
    Connection cn = cc.conexion();

    
    public static void agregarObrero(String nombre, String apellido, String cuil, String estadoCivil, String localidad, String direccion, Date fechaNacimiento, Date fechaIngreso, int dni, int telefono, int idCat) {
        Obrero obrero = new Obrero(nombre, apellido, cuil, estadoCivil, localidad, direccion, fechaNacimiento, fechaIngreso, dni, telefono, idCat);
        obreros.add(obrero);
    }
    
    public void mostrarObrero(ListaPersonal lp) {
        
        String sql = "SELECT nombre, apellido, dni, cuil, fechaNacimiento, localidad, direccion, estadoCivil, fechaIngreso, telefono, Categoria FROM obrero";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) lp.getTablaObrero().getModel();
            lp.getTablaObrero().setModel(modelo);
            int i;

            Object datosfila[] = new Object[11];
            while (rs.next()) {
                for (i = 0; i < datosfila.length; i++) {
                    datosfila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosfila);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            cc.cerrarConexion();
        }
    }
    
    public String getNombreObreroSeleccionado(ListaPersonal lp) {
        
        int row = lp.getTablaObrero().getSelectedRow();
        String name = lp.getTablaObrero().getValueAt(row, 0).toString();
        String apellido = lp.getTablaObrero().getValueAt(row, 1).toString();
        return name + " " + apellido;
    }

    public int getDniObreroSeleccionado(ListaPersonal lp) {
        int row = lp.getTablaObrero().getSelectedRow();
        int dni = (int) lp.getTablaObrero().getValueAt(row, 2);
        return dni;
    }
    
    public int getIdCategoriaObrero(AñadirPersonal ap) {
        String categoria = ap.getComboCategoria().getSelectedItem().toString();
        String sqlOb = "SELECT idCategoria FROM categoria WHERE nombreCategoria='" + categoria + "'";
        try {
            cc.conexion();
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sqlOb);
            rs1.next();
            return rs1.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void agregarPersonal(AñadirPersonal ap) {
        //Tomo datos obrero
        
        int idCat = getIdCategoriaObrero(ap);
        String nombre = ap.getCampoNombre().getText().toUpperCase();
        String apellido = ap.getCampoApellido().getText().toUpperCase();
        int dni = Integer.parseInt(ap.getCampoDni().getText());
        String cuil = ap.getCampoCuil().getText();
        int telefono = Integer.parseInt(ap.getCampoTelefono().getText());
        String direccion = ap.getCampoDireccion().getText().toUpperCase();
        String localidad = ap.getCampoLocalidad().getText().toUpperCase();
        String estadoCivil = ap.getComboEstadoCivil().getSelectedItem().toString().toUpperCase();
        Date fechaNac = ap.getDateChooserNacOb().getDate();
        Date fechaIng = ap.getDateChooserIngOb().getDate();
        java.sql.Date fechaNacSqlOb = new java.sql.Date(fechaNac.getTime());
        java.sql.Date fechaIngSqlOb = new java.sql.Date(fechaIng.getTime());
        String sqlObrero = "INSERT INTO obrero(nombre, apellido, dni, cuil, fechaNacimiento, localidad, direccion, estadoCivil, fechaIngreso, telefono, Categoria) "
                + "VALUES ('" +nombre+"','"+apellido+"','" + dni + "','" + cuil + "','" + fechaNacSqlOb + "','" + localidad + "','" + direccion + "','" + estadoCivil + "','" + fechaIngSqlOb + "','" + telefono + "','" + idCat + "')";
System.out.println(sqlObrero);
        try {
            Statement st = cn.createStatement();
            st.execute(sqlObrero);
            AbmObrero.agregarObrero(nombre, apellido, cuil, estadoCivil, localidad, direccion, fechaNac, fechaIng, dni, telefono, idCat);
            JOptionPane.showMessageDialog(null, "Se agrego correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
        }
    }

  /* public void modificarPersonal(){
        int resp;
        int fila;
        DefaultTableModel modelo = (DefaultTableModel) this.getTablaObrero().getModel();
        fila = tablaObrero.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún miembro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } 
        else {
            resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar este miembro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                AñadirPersonal ap = new AñadirPersonal(null, true);
                String nombre = (String) tablaObrero.getValueAt(fila, 0);
        String apellido = (String) tablaObrero.getValueAt(fila, 1);
        int dni = (int) tablaObrero.getValueAt(fila, 2);
        String cuil = (String) tablaObrero.getValueAt(fila, 3);
        java.sql.Date fechaNac = (java.sql.Date) tablaObrero.getValueAt(fila, 4);
        String localidad = (String) tablaObrero.getValueAt(fila, 5);
        String direccion = (String) tablaObrero.getValueAt(fila, 6);
        String estadoCivil = (String) tablaObrero.getValueAt(fila, 7);
        java.sql.Date fechaIngreso = (java.sql.Date) tablaObrero.getValueAt(fila, 8);
        int telefono = (int) tablaObrero.getValueAt(fila, 9);
                
        int idCategoria2 = getIdCategoriaObrero();
        ap.setLocationRelativeTo(this);
                ap.setVisible(true);
                ap.getCampoNombre().setText(nombre);
                ap.getCampoApellido().setText(apellido);                
                ap.getCampoDni().setText(""+dni);
                ap.getCampoCuil().setText(cuil);
                ap.getDateChooserNacOb().setDate(fechaNac);
                ap.getCampoLocalidad().setText(localidad);
                ap.getCampoDireccion().setText(direccion);
                ap.getDateChooserIngOb().setDate(fechaIngreso);
                ap.getCampoTelefono().setText(""+telefono);
                
                String nombre2 = ap.getCampoNombre().getText().toUpperCase();
                String apellido2 = ap.getCampoNombre().getText().toUpperCase();
                String dni2 = ap.getCampoNombre().getText().toUpperCase();
                String cuil2 = ap.getCampoNombre().getText().toUpperCase();
                String fechaNac2 = ap.getCampoNombre().getText().toUpperCase();
                String localidad2 = ap.getCampoNombre().getText().toUpperCase();
                String direccion2 = ap.getCampoNombre().getText().toUpperCase();
                String estadoCivil2 = ap.getComboEstadoCivil().getSelectedItem().toString().toUpperCase();
                String fechaIngreso2 = ap.getCampoNombre().getText().toUpperCase();
                String telefono2 = ap.getCampoNombre().getText().toUpperCase();
                
    
            String query = "UPDATE obrero SET " + "Nombre = '"+ nombre2 + "',Apellido = '" + apellido2 + "',dni = " + dni2 + 
                   ",cuil = " + cuil2 + ", fechaNacimiento = " +fechaNac2+ ", localidad = '"+ localidad2 +"',direccion = '"+direccion2+"', "
                    + "estadoCivil = '"+ estadoCivil2 +"', fechaIngreso="+fechaIngreso2+",telefono='"+telefono2+",Categoria="+idCategoria2+" WHERE Dni = "+dni+";";
                try {            
            PreparedStatement pstm = cc.conexion().prepareStatement(query);
            pstm.setString(1, nombre2);                   
            pstm.setString(2, apellido2);
            pstm.setString(3, dni2);
            pstm.setString(4, cuil2);
            pstm.setString(5, fechaNac2);
            pstm.setString(6, localidad2);
            pstm.setString(7, direccion2);
            pstm.setString(8, estadoCivil2);
            pstm.setString(9, fechaIngreso2);
            pstm.setString(10, telefono2);
            pstm.setString(11, String.valueOf(idCategoria2));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
       
                    
            }
        }
    }
*/
    public void bajaObrero(ListaPersonal lp) {
        int fila;
        int resp;
        DefaultTableModel modelo = (DefaultTableModel) lp.getTablaObrero().getModel();
        fila = lp.getTablaObrero().getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún miembro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } 
        else {
            resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este miembro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                String dni = lp.getTablaObrero().getValueAt(fila, 2).toString();
                String sql = "DELETE FROM obrero WHERE dni='" + dni + "'";
                Statement st = cn.prepareStatement(sql);
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
                modelo.removeRow(fila);
                //AbmObrero.obreros.remove(fila);
            }
            

        }
    }
    
    public void validar(ListaPersonal lp) {
        int fila;
        AbmGrupoFamiliar agf = new AbmGrupoFamiliar();
        AñadirGrupoFliar agf2 = new AñadirGrupoFliar(lp, true);
        DefaultTableModel modelo = (DefaultTableModel) lp.getTablaObrero().getModel();
        fila = lp.getTablaObrero().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún miembro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            getDniObreroSeleccionado(lp);
            agf.mostrarCon(getDniObreroSeleccionado(lp), getNombreObreroSeleccionado(lp), agf2);
            //agf.mostrarCon(getDniObreroSeleccionado(lp), getNombreObreroSeleccionado(lp));
        }
    
    
}
    }


