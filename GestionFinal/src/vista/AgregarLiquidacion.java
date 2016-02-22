/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControladorPantallaLiquidaciones;
import Controlador.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.liquidacion.Obrero;

/**
 *
 * @author marco
 */
public class AgregarLiquidacion extends javax.swing.JDialog {

    private static Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    ControladorPantallaLiquidaciones con = new ControladorPantallaLiquidaciones();
    public int retornarEstado;

    public JTextField getCampoSueldoNeto() {
        return CampoSueldoNeto;
    }

    public int getRetornarEstado() {
        return retornarEstado;
    }

    public void setCampoSueldoNeto(JTextField CampoSueldoNeto) {
        this.CampoSueldoNeto = CampoSueldoNeto;
    }

    /**
     * Creates new form AgregarLiquidacion
     */
    public AgregarLiquidacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JTextField getCampoDni() {
        return CampoDni;
    }

    public void setCampoDni(JTextField CampoDni) {
        this.CampoDni = CampoDni;
    }

    public JTextField getCampoFechaDesde() {
        return CampoFechaDesde;
    }

    public void setCampoFechaDesde(JTextField CampoFechaDesde) {
        this.CampoFechaDesde = CampoFechaDesde;
    }

    public JTextField getCampoFechaHasta() {
        return CampoFechaHasta;
    }

    public void setCampoFechaHasta(JTextField CampoFechaHasta) {
        this.CampoFechaHasta = CampoFechaHasta;
    }

    public JTextField getCampoHoras() {
        return CampoHoras;
    }

    public void setCampoHoras(JTextField CampoHoras) {
        this.CampoHoras = CampoHoras;
    }

    public JTextField getCampoNombre() {
        return CampoNombre;
    }

    public void setCampoNombre(JTextField CampoNombre) {
        this.CampoNombre = CampoNombre;
    }

    public JComboBox<String> getComboEmpleado() {
        return ComboEmpleado;
    }

    public void setComboEmpleado(JComboBox<String> ComboEmpleado) {
        this.ComboEmpleado = ComboEmpleado;
    }

    public JComboBox<String> getComboCategoria() {
        return comboCategoria;
    }

    public void setComboCategoria(JComboBox<String> comboCategoria) {
        this.comboCategoria = comboCategoria;
    }

    public JTable getTablaLiquidacion() {
        return TablaLiquidacion;
    }

    public void setTablaLiquidacion(JTable TablaLiquidacion) {
        this.TablaLiquidacion = TablaLiquidacion;
    }

    public void Tabla() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        comboCategoria = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboEmpleado = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLiquidacion = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        CampoDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BotonAgregarC = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BotonElimintar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        CampoHoras = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CampoFechaHasta = new javax.swing.JTextField();
        CampoFechaDesde = new javax.swing.JTextField();
        AceptarHoras = new javax.swing.JButton();
        CampoSueldoNeto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BotonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "seleccione" }));
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Nueva Liquidacion");

        jLabel2.setText("Seleccionar Categoria");

        jLabel3.setText("Seleccionar Empleado");

        ComboEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "seleccione" }));
        ComboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEmpleadoActionPerformed(evt);
            }
        });

        TablaLiquidacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Descuento", "Monto"
            }
        ));
        jScrollPane1.setViewportView(TablaLiquidacion);

        jLabel4.setText("Nombre Empleado");

        CampoNombre.setEditable(false);
        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });

        CampoDni.setEditable(false);

        jLabel5.setText("Dni");

        BotonAgregarC.setText("Agregar Conceptos");
        BotonAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarCActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BotonElimintar.setText("Eliminar");
        BotonElimintar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonElimintarActionPerformed(evt);
            }
        });

        jLabel6.setText("Horas Trabajadas:");

        CampoHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoHorasActionPerformed(evt);
            }
        });
        CampoHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoHorasKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Hasta:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Desde:");

        CampoFechaHasta.setEditable(false);
        CampoFechaHasta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        CampoFechaDesde.setEditable(false);
        CampoFechaDesde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        AceptarHoras.setText("Agregar");
        AceptarHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarHorasActionPerformed(evt);
            }
        });

        CampoSueldoNeto.setEditable(false);
        CampoSueldoNeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSueldoNetoActionPerformed(evt);
            }
        });

        jLabel9.setText("Sueldo Neto:");

        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoDni, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AceptarHoras))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(CampoFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(BotonGuardar)
                        .addGap(128, 128, 128)
                        .addComponent(BotonElimintar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(BotonAgregarC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(540, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(CampoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CampoHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AceptarHoras))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(BotonAgregarC))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonElimintar)
                    .addComponent(jButton2)
                    .addComponent(BotonGuardar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(390, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNombreActionPerformed

    private void CampoHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoHorasActionPerformed
        // TODO add your handling code here:
        AceptarHorasActionPerformed(evt);

    }//GEN-LAST:event_CampoHorasActionPerformed

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed

        con.ComboBOXcategoria(this);
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void ComboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEmpleadoActionPerformed
        con.comboBOXempleado(this);
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboEmpleadoActionPerformed

    private void CampoHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoHorasKeyTyped

    }//GEN-LAST:event_CampoHorasKeyTyped

    private void AceptarHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarHorasActionPerformed
        con.Tabla(this);        // TODO add your handling code here:
    }//GEN-LAST:event_AceptarHorasActionPerformed

    private void BotonAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarCActionPerformed
        con.BuscarConcepto(this);        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAgregarCActionPerformed

    private void CampoSueldoNetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSueldoNetoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_CampoSueldoNetoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        retornarEstado = 1;
        this.dispose();
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonElimintarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonElimintarActionPerformed
        // TODO add your handling code here:
        //ControladorPantallaLiquidaciones cpl = new ControladorPantallaLiquidaciones();
        //cpl.borrarConceptoDeTabla(this);
    }//GEN-LAST:event_BotonElimintarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarLiquidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarLiquidacion dialog = new AgregarLiquidacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarHoras;
    private javax.swing.JButton BotonAgregarC;
    private javax.swing.JButton BotonElimintar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JTextField CampoDni;
    private javax.swing.JTextField CampoFechaDesde;
    private javax.swing.JTextField CampoFechaHasta;
    private javax.swing.JTextField CampoHoras;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoSueldoNeto;
    private javax.swing.JComboBox<String> ComboEmpleado;
    private javax.swing.JTable TablaLiquidacion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}