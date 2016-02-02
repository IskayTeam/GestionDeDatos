/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.conectar;
import controlador.AbmProveedor;
import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luca
 */
public class AltaProveedor extends javax.swing.JDialog {

    conectar cc = new conectar();
    Connection cn = cc.conexion();
    /**
     * Creates new form GestionarProveedor
     */
    public AltaProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        botonAceptarProv = new javax.swing.JButton();
        botonCancelarProv = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoCuitProveedor = new javax.swing.JTextField();
        campoTelefonoProveedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoLocalidadProv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoNombreProveedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoDireccionProv = new javax.swing.JTextField();
        comboProvincia = new javax.swing.JComboBox();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Proveedor");

        botonAceptarProv.setText("Aceptar");
        botonAceptarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarProvActionPerformed(evt);
            }
        });

        botonCancelarProv.setText("Cancelar");
        botonCancelarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarProvActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alta de Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 1, 12), java.awt.Color.black)); // NOI18N

        jLabel3.setText("Dirección:");

        jLabel2.setText("Nombre:");

        campoCuitProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCuitProveedorActionPerformed(evt);
            }
        });
        campoCuitProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCuitProveedorKeyTyped(evt);
            }
        });

        jLabel5.setText("CUIT:");

        campoLocalidadProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLocalidadProvActionPerformed(evt);
            }
        });

        jLabel4.setText("Teléfono:");

        jLabel7.setText("Provincia:");

        jLabel8.setText("Localidad:");

        comboProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buenos Aires(CABA)", "Buenos Aires(Capital Federal)", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego", "Tucumán" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoLocalidadProv, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDireccionProv, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(comboProvincia, javax.swing.GroupLayout.Alignment.LEADING, 0, 145, Short.MAX_VALUE)
                        .addComponent(campoTelefonoProveedor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoCuitProveedor, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoCuitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(campoLocalidadProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoDireccionProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(botonAceptarProv)
                .addGap(85, 85, 85)
                .addComponent(botonCancelarProv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptarProv)
                    .addComponent(botonCancelarProv))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarProvActionPerformed
        
        String nombre = getCampoNombreProveedor().getText().toUpperCase();
        String cuit = getCampoCuitProveedor().getText();
        String provincia = getComboProvincia().getSelectedItem().toString().toUpperCase();
        String localidad = getCampoLocalidadProv().getText().toUpperCase();
        String direccion = getCampoDireccionProv().getText().toUpperCase();
        int telefono = Integer.parseInt(getCampoTelefonoProveedor().getText());
       
    String sql = "INSERT INTO proveedor(nombre, cuit, provincia, localidad, direccion, telefono) VALUES ('"+nombre+"','"+cuit+"','"+provincia+"','"+localidad+"','"+direccion+"','"+telefono+"')";
       // String sql ="INSERT INTO proveedor(nombre, cuit) VALUES (('"+nombre+"','"+cuit+"')";
        try{
            cc.conexion();
            Statement st = cn.createStatement();
            st.execute(sql);
            AbmProveedor.agregarProveedor(nombre, cuit, provincia, localidad, direccion, telefono);
            JOptionPane.showMessageDialog(null, "Se agregó correctamente");
            setVisible(false);
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al insertar");
                setVisible(true);

        }
        
    }//GEN-LAST:event_botonAceptarProvActionPerformed

    private void botonCancelarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarProvActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCancelarProvActionPerformed

    private void campoLocalidadProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLocalidadProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLocalidadProvActionPerformed

    private void campoCuitProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCuitProveedorKeyTyped
        // TODO add your handling code here:
        if(campoCuitProveedor.getText().length()== 11){
        evt.consume();
        }
    }//GEN-LAST:event_campoCuitProveedorKeyTyped

    private void campoCuitProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCuitProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCuitProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AltaProveedor dialog = new AltaProveedor(new javax.swing.JFrame(), true);
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

    public JTextField getCampoCuitProveedor() {
        return campoCuitProveedor;
    }

    public void setCampoCuitProveedor(JTextField campoCuitProveedor) {
        this.campoCuitProveedor = campoCuitProveedor;
    }

    public JTextField getCampoDireccionProv() {
        return campoDireccionProv;
    }

    public void setCampoDireccionProv(JTextField campoDireccionProv) {
        this.campoDireccionProv = campoDireccionProv;
    }

    public JTextField getCampoLocalidadProv() {
        return campoLocalidadProv;
    }

    public void setCampoLocalidadProv(JTextField campoLocalidadProv) {
        this.campoLocalidadProv = campoLocalidadProv;
    }

    public JTextField getCampoNombreProveedor() {
        return campoNombreProveedor;
    }

    public void setCampoNombreProveedor(JTextField campoNombreProveedor) {
        this.campoNombreProveedor = campoNombreProveedor;
    }

    public JTextField getCampoTelefonoProveedor() {
        return campoTelefonoProveedor;
    }

    public void setCampoTelefonoProveedor(JTextField campoTelefonoProveedor) {
        this.campoTelefonoProveedor = campoTelefonoProveedor;
    }

    public JComboBox getComboProvincia() {
        return comboProvincia;
    }

    public void setComboProvincia(JComboBox comboProvincia) {
        this.comboProvincia = comboProvincia;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptarProv;
    private javax.swing.JButton botonCancelarProv;
    private javax.swing.JTextField campoCuitProveedor;
    private javax.swing.JTextField campoDireccionProv;
    private javax.swing.JTextField campoLocalidadProv;
    private javax.swing.JTextField campoNombreProveedor;
    private javax.swing.JTextField campoTelefonoProveedor;
    private javax.swing.JComboBox comboProvincia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
}
