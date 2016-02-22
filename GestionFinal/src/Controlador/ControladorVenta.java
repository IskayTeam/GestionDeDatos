/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.AbmProveedor.llenarTablaArray;
import static controlador.AbmProveedor.proveedores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.compra.Proveedor;
import modelo.venta.Cliente;
import modelo.venta.Departamento;
import modelo.venta.LineaVenta;
import modelo.venta.Venta;
import vista.ListaProveedor;
import vista.ListaVentas;

/**
 *
 * @author Luca
 */
public class ControladorVenta {

    private Venta venta;
    private Cliente cliente;
    private LineaVenta linea;
    Controlador.Conectar cc = new Controlador.Conectar();
    Connection cn = cc.conexion();

    public void crearNuevaVenta() {

        venta = new Venta();
        venta.setFecha(new Date());

    }

    public void agregarCliente(int dni, String nombre, String domicilio, int telefono) {

        cliente = new Cliente(dni, nombre, domicilio, telefono);
        venta.agregarCliente(cliente);
        guardarClienteBD(dni, nombre, domicilio, telefono);
    }

    public void agregarDepartamento(Departamento depa) {

        linea = new LineaVenta(depa);
        linea.calcularSubtotal();
        venta.agregarLineaVenta(linea);

    }

    public void guardarClienteBD(int dni, String nombre, String domicilio, int telefono) {

        String sql = "INSERT INTO cliente(dni, nombre, domicilio, telefono) VALUES ('" + dni + "','" + nombre + "','" + domicilio + "','" + telefono + "')";
        Statement st;
        try {
            st = cn.createStatement();
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void calcularTotalVenta() {

        double ac = 0;
        for (int i = 0; i < venta.getLineas().size(); i++) {
            ac = ac + venta.getLineas().get(i).getSubTotal();

        }
        venta.agregarMonto(ac);

    }

    public void finalizarVenta() {

        Date fecha = venta.getFecha();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
        String fechaSql = formateador.format(fecha);

        String sql = "INSERT INTO venta(monto, fecha, Cliente, Administrativo)VALUES ( " + venta.getMonto() + "," + fechaSql + "," + cliente.getDni() + ",3)";

        Statement st;
        try {
            st = cn.createStatement();

            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Venta Finalizada", "EXITO", JOptionPane.INFORMATION_MESSAGE);

    }

    public void mostrarVentas(ListaVentas lv) {
        
        String sql = "SELECT * FROM venta";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) lv.getTablaVenta().getModel();
            lv.getTablaVenta().setModel(modelo);

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
            cc.cerrarConexion();
        }
    }

}
