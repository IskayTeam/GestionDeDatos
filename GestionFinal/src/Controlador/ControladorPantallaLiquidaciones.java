/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.sun.xml.internal.bind.v2.util.FlattenIterator;
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
import modelo.liquidacion.Categoria;
import modelo.liquidacion.Concepto;
import modelo.liquidacion.DetalleLiquidacion;
import modelo.liquidacion.Liquidacion;
import modelo.liquidacion.Obrero;
import vista.AgregarConcepto;
import vista.AgregarLiquidacion;
import vista.BuscarConceptos;
import vista.ListaLiquidaciones;
import vista.ListadosConceptos;

/**
 *
 * @author marco
 */
public class ControladorPantallaLiquidaciones {

    private static Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    private static ArrayList<Concepto> conceptos = new ArrayList<Concepto>();
    private static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    private ArrayList<DetalleLiquidacion> lineas = new ArrayList<DetalleLiquidacion>();

    public static ArrayList<Concepto> getConceptos() {
        return conceptos;
    }

    public static void setConceptos(ArrayList<Concepto> conceptos) {
        ControladorPantallaLiquidaciones.conceptos = conceptos;
    }

    public void leerTablaConceptos(ListadosConceptos con) {
        Concepto concep = new Concepto();
        String sql = "SELECT * FROM  concepto";
        conceptos.clear();

        cc.conexion();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                conceptos.add(new Concepto(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5)));
            }
            llenarTablaArray(con.getTablaConceptos());
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void llenarTablaArray(JTable tabla) {
        Object[][] rows = new Object[conceptos.size()][5];
        for (int i = 0; i < conceptos.size(); i++) {
            rows[i][0] = conceptos.get(i).getIdConcepto();
            rows[i][1] = conceptos.get(i).getDescripcion();
            rows[i][2] = conceptos.get(i).getTipo();
            rows[i][3] = conceptos.get(i).getMontoFijo();
            rows[i][4] = conceptos.get(i).getMontoVariable();
        }
        tabla.setModel(new DefaultTableModel(rows, new String[]{"Codigo", "Descripcion", "Tipo", "Monto Fijo", "Monto Variable"}));
    }

    public void agregar(ListadosConceptos conc) {
        AgregarConcepto agregar = new AgregarConcepto(null, true);

        agregar.setLocationRelativeTo(null);
        agregar.setVisible(true);
        Concepto concep = new Concepto();
        String descripcion = agregar.getCampoDescripcionLiquidacion().getText();
        String montoFijo = agregar.getCampoLiquidacionMontoFijo().getText().toUpperCase();
        String montoVariable = agregar.getCampoLiquidacionMontoVariable().getText();
        String tipo = "";
        if (agregar.getRadiobotonResta().isSelected() == true) {
            tipo = "resta";
        } else if (agregar.getRadiobotonSuma().isSelected() == true) {
            tipo = "suma";

        } else {
            // JOptionPane.showMessageDialog(null, "error debe seleccionar un tipo", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        if (agregar.getReturnstatus() == 1) {
            concep.setDescripcion(descripcion);
            concep.setMontoFijo(Float.parseFloat(montoFijo));
            concep.setMontoVariable(Float.parseFloat(montoVariable));
            concep.setTipo(tipo);
            conceptos.add(concep);
            llenarTablaArray(conc.getTablaConceptos());

            String sqlConcepto = "INSERT INTO concepto(descripcion, tipo, montoFijo, montoVariable)"
                    + "VALUES('" + descripcion + "','" + tipo + "','" + montoFijo + "','" + montoVariable + "')";

            try {

                cc.conexion();
                Statement st = cn.createStatement();
                st.execute(sqlConcepto);
                JOptionPane.showMessageDialog(null, "Se agrego correctamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
            }

        } // llave de returnstatus
    }// llava funcion

    public void eliminarBaseDatosConcepto(ListadosConceptos lista) {
        int fila = lista.getTablaConceptos().getSelectedRow();
        if (fila > -1) {
            int opcion = JOptionPane.showConfirmDialog(lista, "Confirmar eliminacion");
            if (opcion == JOptionPane.YES_OPTION) {
                Concepto concep = conceptos.get(fila);
                llenarTablaArray(lista.getTablaConceptos());
                String query = "DELETE FROM concepto WHERE idConcepto = " + concep.getIdConcepto();

                try {
                    cc.conexion();
                    Statement st;
                    st = cn.createStatement();
                    st.execute(query);
                    conceptos.remove(fila);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(lista, "No se seleccionó concepto", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(ListadosConceptos lista) {
        int idx = lista.getTablaConceptos().getSelectedRow();
        if (idx > -1) {
            Concepto concep = conceptos.get(idx);
            AgregarConcepto agre = new AgregarConcepto(null, true);
            agre.setLocationRelativeTo(null);

            agre.getCampoDescripcionLiquidacion().setText(concep.getDescripcion());
            agre.getCampoLiquidacionMontoFijo().setText("" + concep.getMontoFijo());
            agre.getCampoLiquidacionMontoVariable().setText("" + concep.getMontoVariable());
            agre.setVisible(true);

            if (agre.getReturnstatus() == 1) {

                String descripcion = agre.getCampoDescripcionLiquidacion().getText().toUpperCase();
                String montoFijo = agre.getCampoLiquidacionMontoFijo().getText();
                String montoVariable = agre.getCampoLiquidacionMontoVariable().getText();
                String tipo = "";
                if (agre.getRadiobotonResta().isSelected() == true) {
                    tipo = "resta";
                } else if (agre.getRadiobotonSuma().isSelected() == true) {
                    tipo = "suma";

                } else {
                    // JOptionPane.showMessageDialog(null, "error debe seleccionar un tipo", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }
                concep.setDescripcion(descripcion);
                concep.setMontoFijo(Float.parseFloat(montoFijo));
                concep.setMontoVariable(Float.parseFloat(montoVariable));
                concep.setTipo(tipo);

                String consulta = "UPDATE concepto SET idConcepto ='" + concep.getIdConcepto()
                        + "',descripcion ='" + concep.getDescripcion() + "',tipo ='" + concep.getTipo()
                        + "',montoFijo='" + concep.getMontoFijo() + "',montoVariable= '" + concep.getMontoVariable() + "' WHERE idConcepto ='" + concep.getIdConcepto() + "'";

                try {

                    Statement st;
                    st = cn.createStatement();
                    st.execute(consulta);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                llenarTablaArray(lista.getTablaConceptos());
            }
        } else {
            JOptionPane.showMessageDialog(lista, "Debe seleccionar un concepto", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void AgregarObrero(AgregarLiquidacion liquidacion) {
        categorias.clear();
        liquidacion.getComboCategoria().removeAllItems();
        String TraerArray = "Select idCategoria, nombreCategoria, salarioBasico FROM categoria";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(TraerArray);
            while (rs.next()) {
                categorias.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getFloat(3)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < categorias.size(); i++) {

            String nombres = categorias.get(i).getNombreCategoria();

            liquidacion.getComboCategoria().insertItemAt(nombres, i);
        }
        liquidacion.setLocationRelativeTo(null);
        liquidacion.setVisible(true);

    }

    public void ComboBOXcategoria(AgregarLiquidacion liqui) {
        liqui.getTablaLiquidacion().removeAll();
        ArrayList<Obrero> obreros1 = new ArrayList<Obrero>();
        if (liqui.getComboCategoria().getSelectedIndex() != -1) {
            liqui.getCampoDni().setText("");
            liqui.getCampoNombre().setText("");
            int index = liqui.getComboCategoria().getSelectedIndex() + 1;
            String sql = "Select nombre, apellido, dni, categoria FROM obrero WHERE Categoria= '" + index + "'";
            Statement st;

            try {
                liqui.getComboEmpleado().removeAllItems();
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    obreros1.add(new Obrero(rs.getString(1), rs.getString(2), rs.getInt(3), new Categoria(rs.getInt(4))));
                }

                for (int i = 0; i < obreros1.size(); i++) {
                    String nombres = obreros1.get(i).getNombre();
                    liqui.getComboEmpleado().insertItemAt(nombres, i);

                }

            } catch (SQLException ex) {
                Logger.getLogger(AgregarLiquidacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Obrero comboBOXempleado(AgregarLiquidacion liqui) {
        if (liqui.getComboEmpleado().getSelectedIndex() != -1) {
            String Nombre = liqui.getComboEmpleado().getSelectedItem().toString();
            String sql = "Select nombre, apellido, dni, categoria FROM obrero WHERE nombre= '" + Nombre + "'";
            Statement st;

            try {
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Obrero ob = new Obrero(rs.getString(1), rs.getString(2), rs.getInt(3), new Categoria(rs.getInt(4)));
                    liqui.getCampoNombre().setText(Nombre);
                    liqui.getCampoDni().setText("" + ob.getDni());
                    return ob;
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

        }
        return null;
    }

    public void Tabla(AgregarLiquidacion liqui) {
        Obrero obrero = comboBOXempleado(liqui);
        if (obrero != null) {
            String consultaMonto = "SELECT salarioBasico FROM categoria WHERE idCategoria='" + obrero.getCategoria().getIdCategoria() + "'";
            Statement st, st2;
            try {
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(consultaMonto);

                rs.next();
                Float monto = rs.getFloat("salarioBasico");
                String hora = liqui.getCampoHoras().getText();
                Float subMonto = monto * Integer.parseInt(hora);
                DetalleLiquidacion detalle = new DetalleLiquidacion();
                detalle.setMonto(subMonto);
                Liquidacion nuevaLiquidacion = new Liquidacion();
                nuevaLiquidacion.AgregarLinea(detalle);
                Object[][] rows = new Object[nuevaLiquidacion.getLineasLiquidacion().size()][3];
                for (int i = 0; i < nuevaLiquidacion.getLineasLiquidacion().size(); i++) {
                    rows[i][1] = nuevaLiquidacion.getLineasLiquidacion().get(i).getMonto();
                    rows[i][2] = "0";
                    rows[i][0] = "Sueldo Basico";

                }
                liqui.getTablaLiquidacion().setModel(new DefaultTableModel(rows, new String[]{"Descripcion", "Monto", "Monto descuento"}));

            } catch (SQLException ex) {
                Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void ActualizarTabla(JTable tabla) {

    }

    public void AgregarConceptos(AgregarLiquidacion agre) {
        String TraerConceptos = "Select * FROM conceptos";
        Statement st;
        try {
            st = cn.createStatement();

            ResultSet rs = st.executeQuery(TraerConceptos);
            while (rs.next()) {
                conceptos.add(new Concepto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BuscarConcepto(AgregarLiquidacion agre) {

        BuscarConceptos con = new BuscarConceptos(agre, true);
        String sql = "SELECT * FROM  concepto";
        conceptos.clear();

        cc.conexion();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                conceptos.add(new Concepto(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5)));
            }
            llenarTablaArray(con.getTablaConceptos());
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.setLocationRelativeTo(null);
        con.setVisible(true);
        if (con.getReturnStatus() == 1) {

            if (con.getTablaConceptos().getSelectedRow() != -1) {
                int idx = con.getTablaConceptos().getSelectedRow();
                Concepto conep = conceptos.get(idx);
                DetalleLiquidacion detalle = new DetalleLiquidacion();
                detalle.setConcepto(conep);
                float monto = 0;
                if (conep.getMontoFijo() == 0) {
                    monto = conep.getMontoVariable();
                }
                if (conep.getMontoVariable() == 0) {
                    monto = conep.getMontoFijo();
                }

                detalle.setMonto(monto);

                lineas.add(detalle);
                System.out.println(lineas);
                DefaultTableModel modelo = (DefaultTableModel) agre.getTablaLiquidacion().getModel();

                Object[] fila = new Object[3];

                fila[0] = detalle.getConcepto().getDescripcion();
                if (detalle.getConcepto().getTipo().compareTo("suma") == 0) {
                    fila[1] = detalle.getMonto();
                } else {
                    fila[1] = "0";
                }
                if (detalle.getConcepto().getTipo().compareTo("resta") == 0) {
                    fila[2] = detalle.getMonto();

                } else {
                    fila[2] = "0";
                }
                modelo.addRow(fila);
                agre.getTablaLiquidacion().setModel(modelo);

                /*calcular sub total*/
                float total = 0, s = 0, r = 0;
                for (int i = 0; i < agre.getTablaLiquidacion().getRowCount(); i++) {
                    s = Float.parseFloat(modelo.getValueAt(i, 1).toString());
                    r = Float.parseFloat(modelo.getValueAt(i, 2).toString());
                    System.out.println(r);
                    System.out.println(s);
                    if (r > 0) {
                        total = (total + s) - (total * r);
                        agre.getCampoSueldoNeto().setText("" + total);
                    } else {

                        total = total + s;
                        agre.getCampoSueldoNeto().setText("" + total);

                    }
                }

            }
        }
    }

    public void Guardar(AgregarLiquidacion liqui) {
        Liquidacion liquidacion = new Liquidacion();
        DetalleLiquidacion dl = new DetalleLiquidacion();
        Obrero ob = new Obrero();
        ob = comboBOXempleado(liqui);

        liquidacion.setEmpleado(ob);
        liquidacion.setLineasLiquidacion(lineas);
        float sueldo = Float.parseFloat(liqui.getCampoSueldoNeto().getText());
        liquidacion.setSalarioNeto(sueldo);
        String sql = "INSERT INTO liquidacion(salarioNeto, Obrero, Administrativo)"
                    + "VALUES('" + liquidacion.getSalarioNeto() + "','" + ob.getIdObrero() + "','" + "4"  + "')";
        
        if (liqui.getRetornarEstado() == 1){
//ob.getIdObrero()
        try {
            Statement st = cn.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(liqui, "SE REGISTRÓ LIQUIDACIÓN", "EXITO", JOptionPane.INFORMATION_MESSAGE);
            liqui.setVisible(false);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);            
        }JOptionPane.showMessageDialog(liqui, "ERROR EN REGISTRAR", "FALLO", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void borrarConceptoDeTabla(AgregarLiquidacion al){
        
    DefaultTableModel modelo = (DefaultTableModel)al.getTablaLiquidacion().getModel(); 
    int fila = al.getTablaLiquidacion().getSelectedRow();
    int resp;
    
    if(fila == -1){
        JOptionPane.showMessageDialog(null, "Debe seleccionar el concepto a eliminar","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
    }else{
        resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este concepto?", "Eliminar",JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_OPTION){
            //DetalleLiquidacion dl = lineas.get(fila);
            try {
                String concepto = al.getTablaLiquidacion().getValueAt(fila, 0).toString();
                String sql = "DELETE FROM detalleliquidacion WHERE Concepto='"+concepto+"'";
                Statement st = cn.prepareStatement(sql);
                st.executeUpdate(sql);
                lineas.remove(fila);
                
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            modelo.removeRow(fila);
    }

}
    }
    
    public void mostrarLiquidaciones(ListaLiquidaciones ll) {
        
        String sql = "SELECT * FROM liquidacion";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) ll.getTablaLiquidaciones().getModel();
            ll.getTablaLiquidaciones().setModel(modelo);

            int i;
            Object datosfila[] = new Object[9];
            while (rs.next()) {
                for(i=0; i<datosfila.length;i++){
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
}
