/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.AbmGrupoFamiliar;
import Controlador.Fecha;

import com.toedter.calendar.JDateChooser;
import Controlador.Conectar;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.liquidacion.GrupoFamiliar;

/**
 *
 * @author Fran
 */
public class AñadirGrupoFliar extends javax.swing.JDialog {

    private ArrayList<GrupoFamiliar> grupoFamiliar = new ArrayList<>();
    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    private int dniObrero;
    
    public AñadirGrupoFliar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public AñadirGrupoFliar(Dialog owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }
    
    public void mostrarCon(int dniObrero, String nombre){
        
        this.getLblObrero().setText(nombre);
        this.dniObrero = dniObrero;
        this.mostrarGrupoFamiliar();
        this.setLocationRelativeTo(this);
        this.setVisible(true);

    }
    
    void mostrarGrupoFamiliar(){
       int idOb = getIdObrero(dniObrero);
        String sql = "SELECT nombre, apellido, dni, fechaNacimiento, parentesco FROM grupofamiliar WHERE Obrero='"+idOb+"'";
        try{
        cc.conexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        DefaultTableModel modelo = (DefaultTableModel)this.getTablaGrupoFliar2().getModel();
//        this.tablaMateriales.setModel(modelo);
    int i;
    Object datosfila[] = new Object[5];
    while(rs.next()){
    for(i=0;i<datosfila.length;i++){
    datosfila[i]=rs.getObject(i+1);
    }
    modelo.addRow(datosfila);
    }
        }catch(SQLException ex){
        throw new RuntimeException(ex);
        }
    }
    

    void llenarTabla(ArrayList grupoFamiliar) {
        DefaultTableModel modelo = (DefaultTableModel) tablaGrupoFliar2.getModel();
        Controlador.Fecha fecha = new Fecha();

        String nombre = campoNombreFliar2.getText();
        String apellido = campoApellidoFliar2.getText();
        int dni = Integer.parseInt(campoDniFliar2.getText());       
        Object parentesco = comboParentesco2.getSelectedItem();
        grupoFamiliar.add(new GrupoFamiliar(nombre, apellido, dni, getDateChooserNacGrupoFliar2().getDate(), parentesco.toString(), 0));
        
        Object[] fila = new Object[5];
        fila[0] = nombre;
        fila[1] = apellido;
        fila[2] = dni;
        fila[3] = fecha.getFecha(DateChooserNacGrupoFliar2);
        fila[4] = parentesco;
        
        modelo.addRow(fila);
        tablaGrupoFliar2.setModel(modelo);
    }
    
    int getIdObrero(int dni){

    String sqlp = "SELECT idObrero FROM obrero WHERE dni=" + dni + "";
    try{
        cc.conexion();
        Statement st1 = cn.createStatement();
        ResultSet rs1 = st1.executeQuery(sqlp);
        rs1.next();
        return rs1.getInt(1);
    }catch(SQLException ex){
     throw new RuntimeException(ex);
     }
    }
    
    void añadirGrupo(){
        int idOb = getIdObrero(dniObrero);
        for(GrupoFamiliar gf : grupoFamiliar){
            String nombreF = gf.getNombre().toUpperCase();
            String apellidoF = gf.getApellido().toUpperCase();
            int dniF = gf.getDni();
            Date fechaNacF = gf.getFechaNacimiento();
            String parentesco = gf.getParentesco().toUpperCase();

        java.sql.Date fechaNacSql = new java.sql.Date(fechaNacF.getTime());
        
        String sqlFliar = "INSERT INTO grupofamiliar(nombre, apellido, dni, fechaNacimiento, parentesco, Obrero)"
                + " VALUES ('" + nombreF +"','"+apellidoF+"','"+ dniF + "','" + fechaNacSql + "','" + parentesco + "','" + idOb + "')";
            System.out.println(sqlFliar);
            try {
                cc.conexion();
                Statement st = cn.createStatement();
                st.execute(sqlFliar);
                AbmGrupoFamiliar.agregarGrupoFamiliar(nombreF, apellidoF, dniF, fechaNacF, parentesco, idOb);
            } catch (SQLException ex) {
                
                throw new RuntimeException(ex);
            }
        }
    }
    
    void limpiarCampos(){
    getCampoApellidoFliar2().setText("");
    getCampoNombreFliar2().setText("");
    getCampoDniFliar2().setText("");
    getDateChooserNacGrupoFliar2().setDate(null);
    
    }
    
    void borrarMiembro(){
    int fila;
    int resp;
    DefaultTableModel modelo = (DefaultTableModel)this.getTablaGrupoFliar2().getModel(); 
    fila = tablaGrupoFliar2.getSelectedRow();
    
    
    if(fila == -1){
        JOptionPane.showMessageDialog(null, "Debe seleccionar el miembro a eliminar","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
    }else{
        resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este miembro?", "Eliminar",JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_OPTION){
            try {
                String dni = tablaGrupoFliar2.getValueAt(fila, 2).toString();
                String sql = "DELETE FROM grupofamiliar WHERE dni='"+dni+"'";
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        campoApellidoFliar2 = new javax.swing.JTextField();
        campoDniFliar2 = new javax.swing.JTextField();
        campoNombreFliar2 = new javax.swing.JTextField();
        comboParentesco2 = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaGrupoFliar2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblObrero = new javax.swing.JLabel();
        DateChooserNacGrupoFliar2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setPreferredSize(new java.awt.Dimension(449, 384));

        jLabel3.setText("Nombre:");

        jLabel16.setText("Apellido:");

        jLabel17.setText("Dni:");

        jLabel18.setText("Fecha Nacimiento:");

        jLabel19.setText("Parentesco:");

        campoDniFliar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDniFliar2ActionPerformed(evt);
            }
        });

        campoNombreFliar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreFliar2ActionPerformed(evt);
            }
        });

        comboParentesco2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Esposo/a", "Hijo/a", "Padre", "Madre", "Hermano/a" }));
        comboParentesco2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboParentesco2ItemStateChanged(evt);
            }
        });
        comboParentesco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboParentesco2ActionPerformed(evt);
            }
        });

        tablaGrupoFliar2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Fecha Nacimiento", "Parentesco"
            }
        ));
        jScrollPane5.setViewportView(tablaGrupoFliar2);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11564764-vector-de-agregar-eliminar-o-mostrar-ocultar-los-botones-de-colores-Foto-de-archivo.png"))); // NOI18N
        jButton7.setText("jButton3");
        jButton7.setMargin(new java.awt.Insets(2, 29, 2, 14));
        jButton7.setMaximumSize(new java.awt.Dimension(121, 37));
        jButton7.setMinimumSize(new java.awt.Dimension(121, 37));
        jButton7.setPreferredSize(new java.awt.Dimension(107, 35));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        jButton8.setText("jButton3");
        jButton8.setMargin(new java.awt.Insets(2, 29, 2, 14));
        jButton8.setPreferredSize(new java.awt.Dimension(107, 35));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Obrero:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(campoApellidoFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboParentesco2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(campoNombreFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDniFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblObrero, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateChooserNacGrupoFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(94, 94, 94))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(lblObrero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel17)
                    .addComponent(campoDniFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombreFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(campoApellidoFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboParentesco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DateChooserNacGrupoFliar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Grupo Familiar", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDniFliar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDniFliar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDniFliar2ActionPerformed

    private void campoNombreFliar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreFliar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreFliar2ActionPerformed

    private void comboParentesco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboParentesco2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboParentesco2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        llenarTabla(grupoFamiliar);
        limpiarCampos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboParentesco2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboParentesco2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboParentesco2ItemStateChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        
        int confirmar = JOptionPane.showConfirmDialog(rootPane, "Desea finalizar edición?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(confirmar == JOptionPane.YES_OPTION){
        añadirGrupo();
        this.dispose();
        }else{}    
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        borrarMiembro();
    }//GEN-LAST:event_jButton8ActionPerformed

    public JDateChooser getDateChooserNacGrupoFliar2() {
        return DateChooserNacGrupoFliar2;
    }

    public void setDateChooserNacGrupoFliar2(JDateChooser DateChooserNacGrupoFliar2) {
        this.DateChooserNacGrupoFliar2 = DateChooserNacGrupoFliar2;
    }


    public JTextField getCampoApellidoFliar2() {
        return campoApellidoFliar2;
    }

    public void setCampoApellidoFliar2(JTextField campoApellidoFliar2) {
        this.campoApellidoFliar2 = campoApellidoFliar2;
    }

    public JTextField getCampoDniFliar2() {
        return campoDniFliar2;
    }

    public void setCampoDniFliar2(JTextField campoDniFliar2) {
        this.campoDniFliar2 = campoDniFliar2;
    }

    public JTextField getCampoNombreFliar2() {
        return campoNombreFliar2;
    }

    public void setCampoNombreFliar2(JTextField campoNombreFliar2) {
        this.campoNombreFliar2 = campoNombreFliar2;
    }

    public JComboBox getComboParentesco2() {
        return comboParentesco2;
    }

    public void setComboParentesco2(JComboBox comboParentesco2) {
        this.comboParentesco2 = comboParentesco2;
    }

    public JTable getTablaGrupoFliar2() {
        return tablaGrupoFliar2;
    }

    public void setTablaGrupoFliar2(JTable tablaGrupoFliar2) {
        this.tablaGrupoFliar2 = tablaGrupoFliar2;
    }

    public JLabel getLblObrero() {
        return lblObrero;
    }

    public void setLblObrero(JLabel lblObrero) {
        this.lblObrero = lblObrero;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AñadirGrupoFliar dialog = new AñadirGrupoFliar(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser DateChooserNacGrupoFliar2;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoApellidoFliar2;
    private javax.swing.JTextField campoDniFliar2;
    private javax.swing.JTextField campoNombreFliar2;
    private javax.swing.JComboBox comboParentesco2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblObrero;
    private javax.swing.JTable tablaGrupoFliar2;
    // End of variables declaration//GEN-END:variables
}
