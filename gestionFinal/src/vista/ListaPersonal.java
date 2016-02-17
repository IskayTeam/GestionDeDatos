/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.Validaciones;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.istack.internal.logging.Logger;
import Controlador.AbmObrero;
import controlador.Conectar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Fran
 */
public class ListaPersonal extends javax.swing.JDialog {

    private TableRowSorter trsfiltro;
    Controlador.Validaciones val = new Validaciones();
    Controlador.AbmObrero abmObrero = new AbmObrero();
    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    
    

    public ListaPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarObrero();
    }

    public void mostrarObrero() {
        
        String sql = "SELECT nombre, apellido, dni, cuil, fechaNacimiento, localidad, direccion, estadoCivil, fechaIngreso, telefono, Categoria FROM obrero";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel modelo = (DefaultTableModel) this.getTablaObrero().getModel();
            this.tablaObrero.setModel(modelo);
            int i;

            Object datosfila[] = new Object[11];
            while (rs.next()) {
                for (i = 0; i < datosfila.length; i++) {
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
   

    public String getNombreObreroSeleccionado() {
        int row = tablaObrero.getSelectedRow();
        String name = tablaObrero.getValueAt(row, 0).toString();
        String apellido = tablaObrero.getValueAt(row, 1).toString();
        return name + " " + apellido;
    }

    public int getDniObreroSeleccionado() {
        int row = tablaObrero.getSelectedRow();
        int dni = (int) tablaObrero.getValueAt(row, 2);
        return dni;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoBuscarObrero = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaObrero = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        campoBuscarObrero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBuscarObreroKeyTyped(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnModificar.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminar.png"))); // NOI18N
        btnEliminar.setText("Lista de Personal");
        btnEliminar.setMargin(new java.awt.Insets(2, 29, 2, 14));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tablaObrero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Dni", "CUIL", "Fecha Nacimiento", "Localidad", "Dirección", "Estado Civil", "Fecha Ingreso", "Telefono", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(tablaObrero);

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

        jButton1.setText("Grupo Familiar");
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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBuscarObrero, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoBuscarObrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        AñadirPersonal altapersonal = new AñadirPersonal(null, true);
        altapersonal.setLocationRelativeTo(this);
        altapersonal.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        modificarPersonal();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoBuscarObreroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarObreroKeyTyped
        campoBuscarObrero.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (campoBuscarObrero.getText().toUpperCase());
                campoBuscarObrero.setText(cadena);
                repaint();
                filtro();

            }
        });
        trsfiltro = new TableRowSorter(tablaObrero.getModel());
        tablaObrero.setRowSorter(trsfiltro);

    }//GEN-LAST:event_campoBuscarObreroKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:  
        validar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        bajaObrero();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public void bajaObrero() {
        int fila;
        int resp;
        DefaultTableModel modelo = (DefaultTableModel) this.getTablaObrero().getModel();
        fila = tablaObrero.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún miembro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } 
        else {
            resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este miembro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                String dni = tablaObrero.getValueAt(fila, 2).toString();
                String sql = "DELETE FROM obrero WHERE dni='" + dni + "'";
                Statement st = cn.prepareStatement(sql);
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
                modelo.removeRow(fila);
                //AbmObrero.obreros.remove(fila);
            }
            

        }
    }
    public int getIdCategoriaObrero() {
        int idCategoria = (int) tablaObrero.getValueAt(tablaObrero.getSelectedRow(), 10);
        String sqlOb = "SELECT idCategoria FROM categoria WHERE nombreCategoria='" + idCategoria + "'";
        try {
            cc.conexion();
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sqlOb);
            rs1.next();
            return rs1.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void modificarPersonal(){
        int resp;
        int fila;
        DefaultTableModel modelo = (DefaultTableModel) this.getTablaObrero().getModel();
        fila = tablaObrero.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún miembro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } 
        else {
            resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar este miembro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                AñadirPersonal ap = new AñadirPersonal(null, true);
                String nombre = (String) tablaObrero.getValueAt(fila, 0);
        String apellido = (String) tablaObrero.getValueAt(fila, 1);
        int dni = (int) tablaObrero.getValueAt(fila, 2);
        String cuil = (String) tablaObrero.getValueAt(fila, 3);
        Date fechaNac = (Date) tablaObrero.getValueAt(fila, 4);
        String localidad = (String) tablaObrero.getValueAt(fila, 5);
        String direccion = (String) tablaObrero.getValueAt(fila, 6);
        String estadoCivil = (String) tablaObrero.getValueAt(fila, 7);
        Date fechaIngreso = (Date) tablaObrero.getValueAt(fila, 8);
        int telefono = (int) tablaObrero.getValueAt(fila, 9);
                
        int idCategoria2 = getIdCategoriaObrero();
        ap.setLocationRelativeTo(this);
                ap.setVisible(true);
                ap.getCampoNombre().setText(nombre);
                ap.getCampoApellido().setText(apellido);                
                ap.getCampoDni().setText(""+dni);
                ap.getCampoCuil().setText(cuil);
                ap.getDateChooserNacOb().setDate(fechaNac);
                ap.getCampoLocalidad().setText(localidad);
                ap.getCampoDireccion().setText(direccion);
                ap.getDateChooserIngOb().setDate(fechaIngreso);
                ap.getCampoTelefono().setText(""+telefono);
                
                String nombre2 = ap.getCampoNombre().getText().toUpperCase();
                String apellido2 = ap.getCampoNombre().getText().toUpperCase();
                String dni2 = ap.getCampoNombre().getText().toUpperCase();
                String cuil2 = ap.getCampoNombre().getText().toUpperCase();
                String fechaNac2 = ap.getCampoNombre().getText().toUpperCase();
                String localidad2 = ap.getCampoNombre().getText().toUpperCase();
                String direccion2 = ap.getCampoNombre().getText().toUpperCase();
                String estadoCivil2 = ap.getComboEstadoCivil().getSelectedItem().toString().toUpperCase();
                String fechaIngreso2 = ap.getCampoNombre().getText().toUpperCase();
                String telefono2 = ap.getCampoNombre().getText().toUpperCase();
                
    
            String query = "UPDATE obrero SET " + "Nombre = '"+ nombre2 + "',Apellido = '" + apellido2 + "',dni = " + dni2 + 
                   ",cuil = " + cuil2 + ", fechaNacimiento = " +fechaNac2+ ", localidad = '"+ localidad2 +"',direccion = '"+direccion2+"', "
                    + "estadoCivil = '"+ estadoCivil2 +"', fechaIngreso="+fechaIngreso2+",telefono='"+telefono2+",Categoria="+idCategoria2+" WHERE Dni = "+dni+";";
                try {            
            PreparedStatement pstm = cc.conexion().prepareStatement(query);
            pstm.setString(1, nombre2);                   
            pstm.setString(2, apellido2);
            pstm.setString(3, dni2);
            pstm.setString(4, cuil2);
            pstm.setString(5, fechaNac2);
            pstm.setString(6, localidad2);
            pstm.setString(7, direccion2);
            pstm.setString(8, estadoCivil2);
            pstm.setString(9, fechaIngreso2);
            pstm.setString(10, telefono2);
            pstm.setString(11, String.valueOf(idCategoria2));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
       
                    
            }
        }
    }
    public void validar() {
        AñadirGrupoFliar agf = new AñadirGrupoFliar(this, true);
        int fila;

        DefaultTableModel modelo = (DefaultTableModel) this.getTablaObrero().getModel();
        fila = tablaObrero.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún miembro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            getDniObreroSeleccionado();
            agf.mostrarCon(getDniObreroSeleccionado(), getNombreObreroSeleccionado());
        }

    }

    public void filtro() {
        trsfiltro.setRowFilter(RowFilter.regexFilter(campoBuscarObrero.getText(), 1));
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

    public JTable getTablaObrero() {
        return tablaObrero;
    }

    public void setTablaObrero(JTable tablaObrero) {
        this.tablaObrero = tablaObrero;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField campoBuscarObrero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaObrero;
    // End of variables declaration//GEN-END:variables
}
