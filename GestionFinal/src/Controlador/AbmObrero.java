/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ControladorPantallaLiquidaciones.llenarTablaArray;
import static controlador.AbmProveedor.llenarTablaArray;
import static controlador.AbmProveedor.proveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import modelo.compra.Proveedor;
import modelo.liquidacion.Categoria;
import modelo.liquidacion.Concepto;
import modelo.liquidacion.Obrero;
import vista.AltaProveedor;
import vista.AñadirGrupoFliar;
import vista.AñadirPersonal;
import vista.ListaPersonal;
import vista.PantallaAdmin;

/**
 *
 * @author Luca
 */
public class AbmObrero {

    public static ArrayList<Obrero> obreros = new ArrayList<>();
    Controlador.Conectar cc = new Controlador.Conectar();
    Connection cn = cc.conexion();
    public static ArrayList<Categoria> categorias = new ArrayList<>();

    public void mostrarObrero(ListaPersonal lp) {
        Obrero o = new Obrero();
        obreros.clear();
        //categorias.clear();
        String sql = "SELECT nombre, apellido, dni, cuil, fechaNacimiento, localidad, direccion, estadoCivil, fechaIngreso, telefono, Categoria FROM obrero";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) lp.getTablaObrero().getModel();
            lp.getTablaObrero().setModel(modelo);
            int i;

            Object datosfila[] = new Object[11];
            while (rs.next()) {
                obreros.add(new Obrero(rs.getString("nombre"), rs.getString("apellido"), rs.getString("cuil"), rs.getString("estadoCivil"), rs.getString("localidad"), rs.getString("direccion"), rs.getDate("fechaNacimiento"), rs.getDate("fechaIngreso"), rs.getInt("dni"), rs.getInt("telefono"), new Categoria(rs.getInt(11)), null));
            }
            llenarTablaArray(lp.getTablaObrero());
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
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sqlOb);
            rs1.next();
            return rs1.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    /*
     public void llenarCombo(AñadirPersonal ap){
     categorias.clear();
     ap.getComboCategoria().removeAllItems();
     String traerArray = "SELECT * FROM categoria";
     try{
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(traerArray);
     while(rs.next()){
     categorias.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
     }
     }catch(SQLException ex){
     throw new RuntimeException(ex);
     }
        
     for(int i=0; i<categorias.size();i++){
     String nombres = categorias.get(i).getNombreCategoria();
     ap.getComboCategoria().insertItemAt(nombres, i);
     }
     }
     */

    public static void llenarTablaArray(JTable tabla) {
        Object[][] rows = new Object[obreros.size()][11];
        for (int i = 0; i < obreros.size(); i++) {
            rows[i][0] = obreros.get(i).getNombre();
            rows[i][1] = obreros.get(i).getApellido();
            rows[i][2] = obreros.get(i).getDni();
            rows[i][3] = obreros.get(i).getCuil();
            rows[i][4] = obreros.get(i).getFechaNacimiento();
            rows[i][5] = obreros.get(i).getLocalidad();
            rows[i][6] = obreros.get(i).getDireccion();
            rows[i][7] = obreros.get(i).getEstadoCivil();
            rows[i][8] = obreros.get(i).getFechaIngreso();
            rows[i][9] = obreros.get(i).getTelefono();
            rows[i][10] = obreros.get(i).getCategoria().getIdCategoria();
        }
        tabla.setModel(new DefaultTableModel(rows, new String[]{"Nombre", "Apellido", "Dni", "CUIL", "Fecha Nacimiento", "Localidad", "Dirección", "Estado Civil", "Fecha Ingreso", "Telefono", "Categoria"}));
    }

    public void agregarPersonal(ListaPersonal lp) {
        //Tomo datos obrero
        AñadirPersonal ap = new AñadirPersonal(null, true);
        ap.setLocationRelativeTo(lp);
        ap.setVisible(true);

        Obrero ob = new Obrero();
        Categoria cat = new Categoria();
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
        String nombreCategoria = ap.getComboCategoria().getSelectedItem().toString();

        if (ap.retornarEstado == 1) {
            ob.setNombre(nombre);
            ob.setApellido(apellido);
            ob.setDni(dni);
            ob.setCuil(cuil);
            ob.setTelefono(telefono);
            ob.setDireccion(direccion);
            ob.setLocalidad(localidad);
            ob.setEstadoCivil(estadoCivil);
            ob.setFechaNacimiento(fechaNacSqlOb);
            ob.setFechaIngreso(fechaIngSqlOb);
            cat.setNombreCategoria(nombreCategoria);
            ob.setCategoria(cat);

            String sqlObrero = "INSERT INTO obrero(nombre, apellido, dni, cuil, fechaNacimiento, localidad, direccion, estadoCivil, fechaIngreso, telefono, Categoria) "
                    + "VALUES ('" + nombre + "','" + apellido + "','" + dni + "','" + cuil + "','" + fechaNacSqlOb + "','" + localidad + "','" + direccion + "','" + estadoCivil + "','" + fechaIngSqlOb + "','" + telefono + "','" + cat.getIdCategoria() + "')";
            System.out.println(sqlObrero);
            try {
                Statement st = cn.createStatement();
                st.execute(sqlObrero);
                obreros.add(ob);
                JOptionPane.showMessageDialog(null, "Se agrego correctamente");
                ap.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
                ap.setVisible(true);
            }
            llenarTablaArray(lp.getTablaObrero());
        }
    }

    public void modificarPersonal(ListaPersonal lp) {
        int idx = lp.getTablaObrero().getSelectedRow();
        if (idx > -1) {
            Obrero ob = obreros.get(idx);
            Categoria cat = new Categoria();
            AñadirPersonal ap = new AñadirPersonal(null, true);

            String nombreO = lp.getTablaObrero().getValueAt(idx, 0).toString();
            String apellidoO = lp.getTablaObrero().getValueAt(idx, 1).toString();
            int dniO = getDniObreroSeleccionado(lp);
            String cuilO = lp.getTablaObrero().getValueAt(idx, 3).toString();
            Date fechaNacO = (Date) lp.getTablaObrero().getValueAt(idx, 4);
            String localidadO = lp.getTablaObrero().getValueAt(idx, 5).toString();
            String direccionO = lp.getTablaObrero().getValueAt(idx, 6).toString();
            String estadoCivilO = lp.getTablaObrero().getValueAt(idx, 7).toString();
            Date fechaIngO = (Date) lp.getTablaObrero().getValueAt(idx, 8);
            int telefonoO = (int) lp.getTablaObrero().getValueAt(idx, 9);
            //int categoriaO = (int) lp.getTablaObrero().getValueAt(idx, 10);

            java.sql.Date fechaNacSql = new java.sql.Date(fechaNacO.getTime());
            java.sql.Date fechaIngSql = new java.sql.Date(fechaIngO.getTime());

            ap.getCampoNombre().setText(nombreO.toUpperCase());
            ap.getCampoApellido().setText(apellidoO.toUpperCase());
            ap.getCampoDni().setText("" + dniO);
            ap.getCampoCuil().setText(cuilO.toUpperCase());
            ap.getDateChooserNacOb().setDate(fechaNacSql);
            ap.getComboEstadoCivil().setSelectedItem(estadoCivilO);
            ap.getCampoLocalidad().setText(localidadO.toUpperCase());
            ap.getCampoDireccion().setText(direccionO.toUpperCase());
            ap.getDateChooserIngOb().setDate(fechaIngSql);
            ap.getCampoTelefono().setText("" + telefonoO);
            //ap.getComboCategoria().setSelectedItem(categoriaO);

            ap.setLocationRelativeTo(null);
            ap.setVisible(true);

            if (ap.getRetornarEstado() == 1) {

                String nombre = ap.getCampoNombre().getText().toUpperCase();
                String apellido = ap.getCampoApellido().getText().toUpperCase();
                int dni = Integer.parseInt(ap.getCampoDni().getText());
                String cuil = ap.getCampoCuil().getText();
                Date fechaNac = ap.getDateChooserNacOb().getDate();
                Date fechaIng = ap.getDateChooserIngOb().getDate();
                java.sql.Date fechaNacSqlOb = new java.sql.Date(fechaNac.getTime());
                java.sql.Date fechaIngSqlOb = new java.sql.Date(fechaIng.getTime());
                String localidad = ap.getCampoLocalidad().getText().toUpperCase();
                String direccion = ap.getCampoDireccion().getText().toUpperCase();
                String provincia = ap.getComboCategoria().getSelectedItem().toString().toUpperCase();
                int telefono = Integer.parseInt(ap.getCampoTelefono().getText());
                String estadoCivil = ap.getComboEstadoCivil().getSelectedItem().toString().toUpperCase();
                int idCat = getIdCategoriaObrero(ap);

                ob.setNombre(nombre);
                ob.setApellido(apellido);
                ob.setDni(dni);
                ob.setCuil(cuil);
                ob.setFechaNacimiento(fechaNacSqlOb);
                ob.setLocalidad(localidad);
                ob.setDireccion(direccion);
                ob.setFechaIngreso(fechaIngSqlOb);
                ob.setTelefono(telefono);
                ob.setCategoria(cat);

                String consultaModificar = "UPDATE obrero SET nombre= '" + ob.getNombre() + "',apellido = '" + ob.getApellido() + "',dni = '" + ob.getDni()
                        + "',cuil = '" + ob.getCuil() + "',fechaNacimiento = '" + ob.getFechaNacimiento()
                        + "',localidad = '" + ob.getLocalidad() + "',direccion = '" + ob.getDireccion()
                        + "',fechaIngreso = '" + ob.getFechaIngreso() + "',Categoria = '" + idCat
                        + "'  WHERE dni = '" + ob.getDni() + "'";
                System.out.println(consultaModificar);
                try {
                    Statement st;
                    st = cn.createStatement();
                    st.execute(consultaModificar);
                    llenarTablaArray(lp.getTablaObrero());
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(ap, "Obrero modificado", "Modificación", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(lp, "Debe seleccionar un proveedor", "Advertencia", JOptionPane.ERROR_MESSAGE);
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

    public void bajaObrero(ListaPersonal lp) {
        int fila = lp.getTablaObrero().getSelectedRow();
        if (fila > -1) {
            int opcion = JOptionPane.showConfirmDialog(lp, "Confirmar eliminacion");
            if (opcion == JOptionPane.YES_OPTION) {
                Obrero ob = obreros.get(fila);

                String query = "DELETE FROM obrero WHERE dni = " + ob.getDni() + "";

                try {

                    Statement st;
                    st = cn.createStatement();
                    st.execute(query);
                    obreros.remove(fila);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                llenarTablaArray(lp.getTablaObrero());
            }
        } else {
            JOptionPane.showMessageDialog(lp, "No se seleccionó obrero a eliminar");
        }

    }

    public void pasarAObra(ListaPersonal lp, int idObra) {
        Obra obra = new Obra();
        Obrero ob = new Obrero();
        Categoria cat = new Categoria();
        int idx = lp.getTablaObrero().getSelectedRow();
        if (idx == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el obrero a agregar", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            //System.out.println(idObra);
            String nombre = lp.getTablaObrero().getValueAt(idx, 0).toString();
            String apellido = lp.getTablaObrero().getValueAt(idx, 1).toString();
            int dni = (int) lp.getTablaObrero().getValueAt(idx, 2);
            String cuil = lp.getTablaObrero().getValueAt(idx, 3).toString();
            String localidad = lp.getTablaObrero().getValueAt(idx, 5).toString();
            String direccion = lp.getTablaObrero().getValueAt(idx, 6).toString();
            int categoria = (int) lp.getTablaObrero().getValueAt(idx, 10);
            lp.callback3.pasarObra(nombre, apellido, dni, cuil, localidad, direccion, categoria);
            ob.setNombre(nombre);
            ob.setApellido(apellido);
            ob.setDni(dni);
            ob.setCuil(cuil);
            ob.setLocalidad(localidad);
            ob.setDireccion(direccion);
            cat.setIdCategoria(categoria);
            ob.setCategoria(cat);
            //obra.getObreros().add(ob);
            //co.llenarTablaObra(pa.getTablaObraPersonal());
            String sql= "UPDATE obrero SET Obra='" +idObra+ "' WHERE dni='"+dni+"'";
            Statement st;
            try {
                st = cn.createStatement();
                st.execute(sql);
                //co.llenarTablaObra(pa.getTablaObraPersonal());
            } catch (SQLException ex) {
                Logger.getLogger(AbmObrero.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            lp.setVisible(false);
        }
        
    }
    
}
