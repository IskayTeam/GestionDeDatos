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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Obra;
import modelo.liquidacion.Obrero;
import vista.AltaObra;
import vista.Callback2;
import vista.ListaObras;
import vista.PantallaAdmin;

/**
 *
 * @author Luca
 */
public class ControladorObra {

    Controlador.Conectar cc = new Controlador.Conectar();
    Connection cn = cc.conexion();

    public static ArrayList<Obra> obras = new ArrayList<Obra>();

    public void llenarTabla(ListaObras lo) {
        String sql = "SELECT idObra, nombre, direccion FROM obra";
        cc.conexion();
        try {
            Statement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) lo.getjTable1().getModel();

            Object datosFila[] = new Object[3];
            while (rs.next()) {
                for (int i = 0; i < datosFila.length; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosFila);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaObras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void llenarCamposObra(ListaObras lo) {

        int row = lo.getjTable1().getSelectedRow();
        int idObra = (int) lo.getjTable1().getValueAt(row, 0);
        String nombre = lo.getjTable1().getValueAt(row, 1).toString();
        String direccion = lo.getjTable1().getValueAt(row, 2).toString();
        String sql = "SELECT fechaInicio, fechaFinalizacion, egresos FROM obra WHERE idObra='" + idObra + "'";

        Statement st;
        try {
            st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            Date fechaInicio = rs.getDate("fechaInicio");
            Date fechaFin = rs.getDate("fechaFinalizacion");
            double egresos = rs.getDouble("egresos");
            lo.callback2.notificarObra(idObra, nombre, direccion, fechaInicio, fechaFin, egresos);

        } catch (SQLException ex) {
            Logger.getLogger(ListaObras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarObra(ListaObras lo) {

        PantallaAdmin pa = new PantallaAdmin();
        AltaObra altaobra = new AltaObra(pa, true);
        altaobra.setLocationRelativeTo(lo);
        altaobra.setVisible(true);

        Obra o = new Obra();
        //String idObra = pa.getCampoId().getText().toString();
        String nombreObra = altaobra.getCampoNombreObra().getText().toUpperCase();
        String direccion = altaobra.getCampoDireccion().getText().toUpperCase();
        Date fechaInicio = altaobra.getDateChooserFechaInicio().getDate();
        Date fechaFin = altaobra.getDateChooserFechaFinaliz().getDate();
        java.sql.Date fechaInicioObra = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date fechaFinalizObra = new java.sql.Date(fechaFin.getTime());

        if (altaobra.getRetornarEstado() == 1) {

            o.setNombre(nombreObra);
            o.setDireccion(direccion);
            o.setFechaInicio(fechaInicioObra);
            o.setFechaFin(fechaFinalizObra);

            String sql = "INSERT INTO obra(nombre, direccion, fechaInicio, fechaFinalizacion, estado, egresos) "
                    + "VALUES ('" + nombreObra + "','" + direccion + "','" + fechaInicioObra + "','" + fechaFinalizObra
                    + "','" + "En construccion" + "','" + 0 + "')";

            Statement st;
            try {
                st = cn.createStatement();
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Se agrego correctamente");
                obras.add(o);
                altaobra.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
                altaobra.setVisible(true);
                throw new RuntimeException(ex);
            } finally {
                cc.cerrarConexion();
            }

        } else {
        }
    }
    /*
     public void llenarTablaObra(JTable tabla) {
     Obra obra = new Obra();
     Obrero ob = new Obrero();
     Object[][] rows = new Object[obra.getObreros().size()][7];
     for (int i = 0; i < obra.getObreros().size(); i++) {
     rows[i][0] = obra.getObreros().get(i).getNombre();
     rows[i][1] = obra.getObreros().get(i).getApellido();
     rows[i][2] = obra.getObreros().get(i).getDni();
     rows[i][3] = obra.getObreros().get(i).getCuil();
     rows[i][4] = obra.getObreros().get(i).getLocalidad();
     rows[i][5] = obra.getObreros().get(i).getDireccion();
     rows[i][6] = obra.getObreros().get(i).getCategoria();
            
     }
     tabla.setModel(new DefaultTableModel(rows, new String[]{"Nombre", "Apellido", "Dni", "CUIL", "Localidad", "Dirección","Categoria"}));
     }
     */

    public void llenarTablaObreros(int idObra, JTable tabla) {
        //int idObra = Integer.parseInt(pa.getCampoId().getText());
        
        System.out.println(idObra);
        String sql = "SELECT nombre, apellido, dni, cuil, localidad, direccion, Categoria FROM obrero WHERE Obra='" + idObra + "'";
        try {
            Statement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            
            
          DefaultTableModel  modelo = (DefaultTableModel) tabla.getModel();
            while(modelo.getRowCount()>0)modelo.removeRow(0);
            
            Object datosFila[] = new Object[7];
            while (rs.next()) {
                for (int i = 0; i < datosFila.length; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosFila);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
