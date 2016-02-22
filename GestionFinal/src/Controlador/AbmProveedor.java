/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.compra.Proveedor;
import vista.AltaProveedor;
import vista.ListaProveedor;

/**
 *
 * @author Luca
 */
public class AbmProveedor {

    Controlador.Conectar cc = new Controlador.Conectar();
    public Connection cn = cc.conexion();
    public static ArrayList<Proveedor> proveedores = new ArrayList<>();

    public static void agregarProveedor(String nombre, String cuit, String provincia, String localidad, String direccion, int telefono) {

        Proveedor proveedor = new Proveedor(nombre, cuit, provincia, localidad, direccion, telefono);
        proveedores.add(proveedor);
        System.out.println(proveedor);
    }

    public void eliminarProveedor(int codigo) {

        Proveedor v = buscarProveedor(codigo);
        if (v != null) {
            proveedores.remove(v);
        }

    }

    public Proveedor buscarProveedor(int codigo) {

        Proveedor auxiliar = null;
        for (int i = 0; i < proveedores.size(); i++) {
            if (codigo == proveedores.get(i).getIdProveedor()) {

                auxiliar = proveedores.get(i);
            }

        }
        return auxiliar;
    }

    public static void llenarTablaArray(JTable tabla) {
        Object[][] rows = new Object[proveedores.size()][6];
        for (int i = 0; i < proveedores.size(); i++) {
            rows[i][0] = proveedores.get(i).getNombre();
            rows[i][1] = proveedores.get(i).getCuit();
            rows[i][2] = proveedores.get(i).getProvincia();
            rows[i][3] = proveedores.get(i).getLocalidad();
            rows[i][4] = proveedores.get(i).getDireccion();
            rows[i][5] = proveedores.get(i).getTelefono();
        }
        tabla.setModel(new DefaultTableModel(rows, new String[]{"Nombre", "CUIT", "Provincia", "Localidad", "Direccion", "Telefono"}));
    }

    public String getNombreProveedorSeleccionado(ListaProveedor lp) {
        int row = lp.getTablaProveedor().getSelectedRow();
        String name = lp.getTablaProveedor().getValueAt(row, 0).toString();
        return name;
    }

    public String getCuitProveedorSeleccionado(ListaProveedor lp) {
        int row = lp.getTablaProveedor().getSelectedRow();
        String cuit = lp.getTablaProveedor().getValueAt(row, 1).toString();
        return cuit;
    }

    public void autoCompletar(ListaProveedor lp) {
        TextAutoCompleter txt = new TextAutoCompleter(lp.getCampoBuscarProv());
        String sql = "SELECT nombre FROM proveedor";
        try {
            Statement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                txt.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    public void agregarProveedor(ListaProveedor lp) {
        AltaProveedor ap = new AltaProveedor(null, true);
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);

        Proveedor p = new Proveedor();
        String nombre = ap.getCampoNombreProveedor().getText().toUpperCase();
        String cuit = ap.getCampoCuitProveedor().getText();
        String provincia = ap.getComboProvincia().getSelectedItem().toString().toUpperCase();
        String localidad = ap.getCampoLocalidadProv().getText().toUpperCase();
        String direccion = ap.getCampoDireccionProv().getText().toUpperCase();
        String telefono = ap.getCampoTelefonoProveedor().getText().toUpperCase();
        if (ap.getRetornarEstado() == 1) {
            p.setNombre(nombre);
            p.setCuit(cuit);
            p.setProvincia(provincia);
            p.setLocalidad(localidad);
            p.setDireccion(direccion);
            p.setTelefono(Integer.parseInt(telefono));

            String sql = "INSERT INTO proveedor(nombre, cuit, provincia, localidad, direccion, telefono) "
                    + "VALUES ('" + nombre + "','" + cuit + "','" + provincia + "','" + localidad + "','" + direccion + "','" + telefono + "')";

            try {
                /*cc.conexion();*/
                Statement st = cn.createStatement();
                st.execute(sql);
                proveedores.add(p);
                JOptionPane.showMessageDialog(null, "Se agregó correctamente");
                ap.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al insertar");
                ap.setVisible(true);

            }
            llenarTablaArray(lp.getTablaProveedor());

        }
    }

    public void mostrarProv(ListaProveedor lp) {
        Proveedor p = new Proveedor();
        String sql = "SELECT nombre, cuit, provincia, localidad, direccion, telefono FROM proveedor";
        proveedores.clear();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        //    DefaultTableModel modelo = (DefaultTableModel) lp.getTablaProveedor().getModel();
            //    lp.getTablaProveedor().setModel(modelo);

          //  int i;
            //  Object datosfila[] = new Object[6];
            while (rs.next()) {
                proveedores.add(new Proveedor(rs.getString("nombre"),
                        rs.getString("cuit"), rs.getString("provincia"),
                        rs.getString("direccion"), rs.getString("localidad"),
                        rs.getInt("telefono")));
            }
            llenarTablaArray(lp.getTablaProveedor());            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            cc.cerrarConexion();
        }
    }


    public void bajaProveedor(ListaProveedor lp) {
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
                    proveedores.remove(fila);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                llenarTablaArray(lp.getTablaProveedor());
                modelo.removeRow(fila);

            }
        }
    }

    public void modificarProveedor(ListaProveedor lp) {
        int idx = lp.getTablaProveedor().getSelectedRow();
        if (idx > -1) {
            Proveedor prov = proveedores.get(idx);
            AltaProveedor ap = new AltaProveedor(null, true);
            String nombreP = lp.getTablaProveedor().getValueAt(idx, 0).toString();
            String cuitP = lp.getTablaProveedor().getValueAt(idx, 1).toString();
            String provinciaP = lp.getTablaProveedor().getValueAt(idx, 2).toString();
            String localidadP = lp.getTablaProveedor().getValueAt(idx, 3).toString();
            String direccionP = lp.getTablaProveedor().getValueAt(idx, 4).toString();
            int telefonoP = (int) lp.getTablaProveedor().getValueAt(idx, 5);

            ap.getCampoNombreProveedor().setText(nombreP.toUpperCase());
            ap.getCampoCuitProveedor().setText(cuitP.toUpperCase());
            ap.getComboProvincia().setSelectedItem(provinciaP);
            ap.getCampoLocalidadProv().setText(localidadP.toUpperCase());
            ap.getCampoDireccionProv().setText(direccionP.toUpperCase());
            ap.getCampoTelefonoProveedor().setText("" + telefonoP);

            ap.setLocationRelativeTo(null);
            ap.setVisible(true);

            if (ap.getRetornarEstado() == 1) {

                String nombre = ap.getCampoNombreProveedor().getText().toUpperCase();
                String cuit = ap.getCampoCuitProveedor().getText();
                String provincia = ap.getComboProvincia().getSelectedItem().toString().toUpperCase();
                String localidad = ap.getCampoLocalidadProv().getText().toUpperCase();
                String direccion = ap.getCampoDireccionProv().getText().toUpperCase();
                String telefono = ap.getCampoTelefonoProveedor().getText().toUpperCase();

                prov.setNombre(nombre);
                prov.setCuit(cuit);
                prov.setProvincia(provincia);
                prov.setLocalidad(localidad);
                prov.setDireccion(direccion);
                prov.setTelefono(Integer.parseInt(telefono));

                String consultaModificar = "UPDATE proveedor SET nombre= '" + prov.getNombre() + "',cuit = '" + prov.getCuit() + "',provincia = '" + prov.getProvincia()
                        + "',localidad = '" + prov.getLocalidad() + "',direccion = '" + prov.getDireccion()
                        + "',telefono = '" + prov.getTelefono() + "'  WHERE cuit = '" + prov.getCuit() + "'";

                try {
                    Statement st;
                    st = cn.createStatement();
                    st.execute(consultaModificar);
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(ap, "Proveedor modificado", "Modificación", JOptionPane.INFORMATION_MESSAGE);
                llenarTablaArray(lp.getTablaProveedor());
            }
        } else {
            JOptionPane.showMessageDialog(lp, "Debe seleccionar un proveedor", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

    }

}
