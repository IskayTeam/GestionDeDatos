/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.ListaProveedor;

/**
 *
 * @author Fran
 */
public class ControladorReportes {

    Controlador.Conectar cc = new Controlador.Conectar();
    Connection cn = cc.conexion();

    public void ReporteProveedor() {
        
        String path = "C:\\Users\\Fran\\Documents\\NetBeansProjects\\gestion\\GestionFinal\\src\\Reportes\\listaProveedores.jasper";
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cc.conexion());
            JasperViewer jv = new JasperViewer(jp);
            jv.setTitle(path);
            jv.setVisible(true);
            
            
            cc.cerrarConexion();
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReporteVentas() {
        
        String path = "C:\\Users\\Fran\\Documents\\NetBeansProjects\\gestion\\GestionFinal\\src\\Reportes\\ReporteVentas.jasper";
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cc.conexion());
            JasperViewer jv = new JasperViewer(jp);
            jv.setTitle(path);
            jv.setVisible(true);
            
            
            cc.cerrarConexion();
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ReporteCompras() {
        
        String path = "C:\\Users\\Fran\\Documents\\NetBeansProjects\\gestion\\GestionFinal\\src\\Reportes\\ReporteCompras.jasper";
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cc.conexion());
            JasperViewer jv = new JasperViewer(jp);
            jv.setTitle(path);
            jv.setVisible(true);
            
            
            cc.cerrarConexion();
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReporteLiquidaciones() {
        
        String path = "C:\\Users\\Fran\\Documents\\NetBeansProjects\\gestion\\GestionFinal\\src\\Reportes\\ReporteLiquidaciones.jasper";
        JasperReport jr = null;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cc.conexion());
            JasperViewer jv = new JasperViewer(jp);
            jv.setTitle(path);
            jv.setVisible(true);
            
            
            cc.cerrarConexion();
        } catch (JRException ex) {
            Logger.getLogger(ControladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
