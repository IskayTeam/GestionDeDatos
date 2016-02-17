/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import com.sun.istack.internal.logging.Logger;
import controlador.Conectar;
import java.awt.Dialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import vista.ListaProveedor;

/**
 *
 * @author Fran
 */
public class ListaMateriales extends javax.swing.JDialog {

    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    private String cuitProveedor;
    private TableRowSorter trsfiltro;
    
    
    /**
     * Creates new form ListaMateriales
     */
    public ListaMateriales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public ListaMateriales(Dialog owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }
    
    void mostrarCon(String cuitProveedor, String nombreProveedor){
        
        this.getLabelProveedor().setText(nombreProveedor);
        this.cuitProveedor = cuitProveedor;
        this.mostrarMateriales();
        this.setLocationRelativeTo(this);
        this.setVisible(true);

    }

    public int getIdProv(String cuit){

    String sqlp = "SELECT idProveedor FROM proveedor WHERE cuit=" + cuit + "";
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
    void mostrarMateriales(){
        
        int idProv = getIdProv(cuitProveedor);
        String sql = "SELECT idMaterial, descripcion, precio FROM material WHERE Proveedor='"+idProv+"'";
        try{
        cc.conexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        DefaultTableModel modelo = (DefaultTableModel)this.getTablaMateriales().getModel();
//        this.tablaMateriales.setModel(modelo);
    int i;
    Object datosfila[] = new Object[3];
    while(rs.next()){
    for(i=0;i<datosfila.length;i++){
    datosfila[i]=rs.getObject(i+1);
    }
    modelo.addRow(datosfila);
    }
        }catch(SQLException ex){
        Logger.getLogger(sql,null);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMateriales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        campoProducto = new javax.swing.JTextField();
        labelProveedor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Producto:");

        tablaMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idMaterial", "Descripcion", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaMateriales);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Proveedor:");

        campoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoProductoActionPerformed(evt);
            }
        });
        campoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoProductoKeyTyped(evt);
            }
        });

        labelProveedor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(labelProveedor))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addGap(19, 19, 19)
                                .addComponent(campoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelProveedor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoProductoKeyTyped
        // TODO add your handling code here:
        campoProducto.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (campoProducto.getText().toUpperCase());
                campoProducto.setText(cadena);
                repaint();
                filtro();
           
            }
        });
    
    trsfiltro = new TableRowSorter(tablaMateriales.getModel());
    tablaMateriales.setRowSorter(trsfiltro);
    }//GEN-LAST:event_campoProductoKeyTyped
public void filtro() {
    trsfiltro.setRowFilter(RowFilter.regexFilter(campoProducto.getText(), 1));
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
            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaMateriales dialog = new ListaMateriales(new javax.swing.JFrame(), true);
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

    public JLabel getLabelProveedor() {
        return labelProveedor;
    }

    public void setLabelProveedor(JLabel labelProveedor) {
        this.labelProveedor = labelProveedor;
    }

    public JTable getTablaMateriales() {
        return tablaMateriales;
    }

    public void setTablaMateriales(JTable tablaMateriales) {
        this.tablaMateriales = tablaMateriales;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelProveedor;
    private javax.swing.JTable tablaMateriales;
    // End of variables declaration//GEN-END:variables
}
