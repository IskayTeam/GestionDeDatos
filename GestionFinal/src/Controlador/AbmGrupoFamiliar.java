/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.liquidacion.GrupoFamiliar;
import vista.AñadirGrupoFliar;
import vista.ListaPersonal;

/**
 *
 * @author Fran
 */
public class AbmGrupoFamiliar {

    public static ArrayList<GrupoFamiliar> grupofamiliar = new ArrayList<>();
    //private ArrayList<GrupoFamiliar> grupoFamiliar2 = new ArrayList<>();
    private static int dniObrero;
    conectar cc = new conectar();
    Connection cn = cc.conexion();

    public static void agregarGrupoFamiliar(String nombre, String apellido, int dni, Date fechaNacimiento, String parentesco, int idOb) {
        GrupoFamiliar miembro = new GrupoFamiliar(nombre, apellido, dni, fechaNacimiento, parentesco, idOb);
        grupofamiliar.add(miembro);
    }

    public void mostrarCon(int dniObrero, String nombre, AñadirGrupoFliar agf) {

        agf.getLblObrero().setText(nombre);
        this.dniObrero = dniObrero;
        this.mostrarGrupoFamiliar(agf);
        agf.setLocationRelativeTo(agf);
        agf.setVisible(true);

    }
    
    public int getIdObrero(int dni) {

        String sqlp = "SELECT idObrero FROM obrero WHERE dni=" + dni + "";
        
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlp);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
       
            throw new RuntimeException(ex);
        }
    }    

    public void mostrarGrupoFamiliar(AñadirGrupoFliar agf) {
        int idOb = getIdObrero(dniObrero);
        String sql = "SELECT nombre, apellido, dni, fechaNacimiento, parentesco FROM grupofamiliar WHERE Obrero='" + idOb + "'";
        try {
            cc.conexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) agf.getTablaGrupoFliar2().getModel();
//        this.tablaMateriales.setModel(modelo);
            int i;
            Object datosfila[] = new Object[5];
            while (rs.next()) {
                for (i = 0; i < datosfila.length; i++) {
                    datosfila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosfila);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void llenarTabla(ArrayList grupofamiliar, AñadirGrupoFliar agf) {
        DefaultTableModel modelo = (DefaultTableModel) agf.getTablaGrupoFliar2().getModel();
        Controlador.Fecha fecha = new Fecha();

        String nombre = agf.getCampoNombreFliar2().getText();
        String apellido = agf.getCampoApellidoFliar2().getText();
        int dni = Integer.parseInt(agf.getCampoDniFliar2().getText());
        Object parentesco = agf.getComboParentesco2().getSelectedItem();
        grupofamiliar.add(new GrupoFamiliar(nombre, apellido, dni, agf.getDateChooserNacGrupoFliar2().getDate(), parentesco.toString(), 0));

        Object[] fila = new Object[5];
        fila[0] = nombre;
        fila[1] = apellido;
        fila[2] = dni;
        fila[3] = fecha.getFecha(agf.getDateChooserNacGrupoFliar2());
        fila[4] = parentesco;

        modelo.addRow(fila);
        agf.getTablaGrupoFliar2().setModel(modelo);
    }

    public void añadirGrupo() {
        int idOb = getIdObrero(dniObrero);
        System.out.println(grupofamiliar.size());
        for (GrupoFamiliar gf : grupofamiliar) {
            String nombreF = gf.getNombre().toUpperCase();
            String apellidoF = gf.getApellido().toUpperCase();
            int dniF = gf.getDni();
            Date fechaNacF = gf.getFechaNacimiento();
            String parentesco = gf.getParentesco().toUpperCase();

            java.sql.Date fechaNacSql = new java.sql.Date(fechaNacF.getTime());

            String sqlFliar = "INSERT INTO grupofamiliar(nombre, apellido, dni, fechaNacimiento, "
                    + "parentesco, Obrero)"
                    + " VALUES ('" + nombreF + "','" + apellidoF + "','" + dniF + "','" 
                    + fechaNacSql + "','" + parentesco + "','" + idOb + "')";
            System.out.println(sqlFliar);
            try {
                Statement st = cn.createStatement();
                st.execute(sqlFliar);
              //  agregarGrupoFamiliar(nombreF, apellidoF, dniF, fechaNacF, parentesco, idOb);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void limpiarCampos(AñadirGrupoFliar agf) {
        agf.getCampoApellidoFliar2().setText("");
        agf.getCampoNombreFliar2().setText("");
        agf.getCampoDniFliar2().setText("");
        agf.getDateChooserNacGrupoFliar2().setDate(null);

    }

    public void borrarMiembro(AñadirGrupoFliar agf) {
        int fila;
        int resp;
        DefaultTableModel modelo = (DefaultTableModel) agf.getTablaGrupoFliar2().getModel();
        fila = agf.getTablaGrupoFliar2().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el miembro a eliminar", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este miembro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    String dni = agf.getTablaGrupoFliar2().getValueAt(fila, 2).toString();
                    String sql = "DELETE FROM grupofamiliar WHERE dni='" + dni + "'";
                    Statement st = cn.prepareStatement(sql);
                    st.executeUpdate(sql);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                modelo.removeRow(fila);
        //AbmGrupoFamiliar.grupofamiliar.remove(fila);

            }
        }
    }

}
