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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.liquidacion.Concepto;
import vista.AgregarConcepto;
import vista.ListadosConceptos;

/**
 *
 * @author marco
 */
public class ControladorPantallaLiquidaciones {

    private static conectar cc = new conectar();
    Connection cn = cc.conexion();
    private static ArrayList<Concepto> conceptos = new ArrayList<Concepto>();

    public static ArrayList<Concepto> getConceptos() {
        return conceptos;
    }

    public static void setConceptos(ArrayList<Concepto> conceptos) {
        ControladorPantallaLiquidaciones.conceptos = conceptos;
    }
    

    public void leerTablaConceptos(ListadosConceptos con)  {
        Concepto concep = new Concepto ();
        String sql = "SELECT * FROM  concepto";
        conceptos.clear();

        cc.conexion();
        try {
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
            conceptos.add(new Concepto (rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4),
                    rs.getFloat(5)));
            }
            llenarTablaArray(con.getTablaConceptos());
        }catch (SQLException ex) {
            Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public static void  llenarTablaArray( JTable tabla )
    {  
        Object[][] rows = new Object[conceptos.size()][5];
        for(int i = 0 ; i<conceptos.size();i++){
            rows[i][0] = conceptos.get(i).getIdConcepto();
            rows[i][1] = conceptos.get(i).getDescripcion();
            rows[i][2]= conceptos.get(i).getTipo();
            rows[i][3]= conceptos.get(i).getMontoFijo();
            rows[i][4]=conceptos.get(i).getMontoVariable(); 
        }
        tabla.setModel(new DefaultTableModel(rows, new String []{"Codigo","Descripcion","Tipo","Monto Fijo", "Monto Variable"}));
    }
    

    public  void agregar(ListadosConceptos conc) {
        AgregarConcepto agregar = new AgregarConcepto (null, true);
        
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
    public  void eliminarBaseDatosConcepto(ListadosConceptos lista){
        int fila =lista.getTablaConceptos().getSelectedRow();
         if( fila > -1)
   { int opcion = JOptionPane.showConfirmDialog(lista, "Confirmar eliminacion");
    if (opcion == JOptionPane.YES_OPTION) {
        Concepto concep = conceptos.get(fila);
                conceptos.remove(fila);
               llenarTablaArray(lista.getTablaConceptos());
                String query = "DELETE FROM concepto WHERE idConcepto = " +concep.getIdConcepto();
               
       try {
            cc.conexion();
                Statement st;
           st = cn.createStatement();
             st.execute(query);
       } catch (SQLException ex) {
           Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
       }       
    }
    }else{ JOptionPane.showMessageDialog(lista, "no se seleeccionó alumno");
   }   
   }
   public  void  modificar (ListadosConceptos lista )
   {
       int idx=lista.getTablaConceptos().getSelectedRow();
       if(idx>-1)
       { 
            Concepto concep = conceptos.get(idx);
           AgregarConcepto agre =  new AgregarConcepto(null , true);
           
      agre.getCampoDescripcionLiquidacion().setText(concep.getDescripcion());
      agre.getCampoLiquidacionMontoFijo().setText(""+ concep.getMontoFijo());
      agre.getCampoLiquidacionMontoVariable().setText(""+ concep.getMontoVariable());
      agre.setVisible(true);
       
       if(agre.getReturnstatus()== 1){
       
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
     String consultaModificar = "UPDATE concepto SET " +" idConcepto= " +concep.getIdConcepto() + ",descripcion = "+ concep.getDescripcion() + ",montoFijo = " + concep.getMontoFijo() + ",MontoVariable = " +concep.getMontoVariable() + 
                   ",tipo = " + concep.getTipo() + "  WHERE idConcepto = " +concep.getIdConcepto()+";";
     String consulta = "UPDATE concepto SET idConcepto = "
             + ""+concep.getIdConcepto()+",descripcion="+ concep.getDescripcion()+",tipo ="+concep.getTipo()+",montoFijo="+concep.getMontoFijo()+",montoVariable= "+concep.getTipo()+" WHERE idConcepto ="+concep.getIdConcepto()+";";
      
                try {
                    cc.conexion();
                Statement st;
                    st = cn.createStatement();
                    st.execute(consultaModificar);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPantallaLiquidaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
             
     
     
       llenarTablaArray(lista.getTablaConceptos());
       }
       
       
   
   
   }

}
}
