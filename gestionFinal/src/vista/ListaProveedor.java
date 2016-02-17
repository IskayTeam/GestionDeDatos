/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.istack.internal.logging.Logger;
import controlador.AbmProveedor;
import controlador.Conectar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author Fran
 */
public class ListaProveedor extends javax.swing.JDialog {
    
Conectar cc = new Conectar();
Connection cn = cc.conexion();
private TableRowSorter trsfiltro;

    /**
     * Creates new form ListaPersonals
     */
    public ListaProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        autoCompletar();
        mostrarProv();
    
    }
public String getNombreProveedorSeleccionado(){
    int row = tablaProveedor.getSelectedRow();
        String name = tablaProveedor.getValueAt(row, 0).toString();
    return name;
    }

public String getCuitProveedorSeleccionado(){
    int row = tablaProveedor.getSelectedRow();
        String cuit = tablaProveedor.getValueAt(row, 1).toString();
    return cuit;
    }

    public ListaProveedor(JTable jTable1) {
        this.tablaProveedor = jTable1;
    }
    
    
    void autoCompletar(){
        TextAutoCompleter txt = new TextAutoCompleter(campoBuscarProv);
        String sql = "SELECT nombre FROM proveedor";
        try{
        Statement st = cn.prepareStatement(sql);
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            txt.addItem(rs.getString("nombre"));
        }
        }catch(SQLException ex){
            Logger.getLogger(sql, null);
        }
    }
    
    public void mostrarProv(){
    String sql = "SELECT nombre, cuit, provincia, localidad, direccion, telefono FROM proveedor";
        try{
    Statement st = cn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    DefaultTableModel modelo = (DefaultTableModel)this.getTablaProveedor().getModel();
    this.tablaProveedor.setModel(modelo);
    
    int i;
    Object datosfila[] = new Object[6];
    while(rs.next()){
    for(i=0;i<datosfila.length;i++){
    datosfila[i]=rs.getObject(i+1);
    }
    modelo.addRow(datosfila);
    }
      }catch(SQLException ex){
    Logger.getLogger(sql, null);
    }finally {
            cc.cerrarConexion();
        }
    }
    
    public void filtro() {
    trsfiltro.setRowFilter(RowFilter.regexFilter(campoBuscarProv.getText(), 0));
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoBuscarProv = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Proveedores");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        campoBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarProvActionPerformed(evt);
            }
        });
        campoBuscarProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBuscarProvKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnModificar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "CUIT", "Provincia", "Localidad", "Dirección", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tablaProveedor);

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Ver productos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)))
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AltaProveedor altaproveedor = new AltaProveedor(null, true);
        altaproveedor.setLocationRelativeTo(this);
        altaproveedor.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public JTextField getCampoBuscarProv() {
        return campoBuscarProv;
    }

    public void setCampoBuscarProv(JTextField campoBuscarProv) {
        this.campoBuscarProv = campoBuscarProv;
    }

    public JTable getTablaProveedor() {
        return tablaProveedor;
    }

    
    
    

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarProvActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_campoBuscarProvActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ListaMateriales materiales = new ListaMateriales(this, true);
        getNombreProveedorSeleccionado();
        materiales.mostrarCon(getCuitProveedorSeleccionado(), getNombreProveedorSeleccionado());
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void campoBuscarProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarProvKeyTyped
        // TODO add your handling code here:
    campoBuscarProv.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (campoBuscarProv.getText().toUpperCase());
                campoBuscarProv.setText(cadena);
                repaint();
                filtro();
           
            }
        });
    
    trsfiltro = new TableRowSorter(tablaProveedor.getModel());
    tablaProveedor.setRowSorter(trsfiltro);
    
    }//GEN-LAST:event_campoBuscarProvKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        bajaProveedor();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void bajaProveedor(){
        int fila;
        int resp;
        DefaultTableModel modelo = (DefaultTableModel) this.getTablaProveedor().getModel();
        fila = tablaProveedor.getSelectedRow();
        

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el proveedor a eliminar", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este proveedor?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                
                try {
                    String cuit = tablaProveedor.getValueAt(fila, 1).toString();
                    String sql = "DELETE FROM proveedor WHERE cuit='" + cuit + "'";
                    Statement st = cn.prepareStatement(sql);
                    st.executeUpdate(sql);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                modelo.removeRow(fila);
                //AbmProveedor.proveedores.remove(fila);
            }
    }
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
       
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaPersonal dialog = new ListaPersonal(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField campoBuscarProv;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProveedor;
    // End of variables declaration//GEN-END:variables
}
