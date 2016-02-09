/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.AbmGrupoFamiliar;
import Controlador.Fecha;
import Controlador.conectar;
import com.toedter.calendar.JDateChooser;
import controlador.AbmObrero;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.liquidacion.Categoria;

/**
 *
 * @author Luca
 */
public class AñadirPersonal extends javax.swing.JDialog {

    conectar cc = new conectar();
    Connection cn = cc.conexion();
    private String cuil;

    /**
     * Creates new form GestionarObrero
     */
    public AñadirPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarUltimoId();
    }

    void llenarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaGrupoFliar.getModel();
        Controlador.Fecha fecha = new Fecha();

        Object[] fila = new Object[5];
        fila[0] = campoNombreFliar.getText();
        fila[1] = campoApellidoFliar.getText();
        fila[2] = campoDniFliar.getText();
        fila[4] = comboParentesco.getSelectedItem();
        fila[3] = fecha.getFecha(DateChooserNacGpoFliar);

        modelo.addRow(fila);
        tablaGrupoFliar.setModel(modelo);
    }

    void mostrarUltimoId() {
        String sqlid = "SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'obrero' AND table_schema = DATABASE();";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlid);
            rs.next();
            int id1 = rs.getInt(1);
            this.getCampoInvisible().setText(String.valueOf(id1));
        } catch (SQLException ex) {
            Logger.getLogger(NuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdCategoriaObrero() {
        String categoria = getComboCategoria().getSelectedItem().toString();
        String sqlOb = "SELECT idCategoria FROM categoria WHERE nombreCategoria='" + categoria + "'";
        try {
            cc.conexion();
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sqlOb);
            rs1.next();
            return rs1.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Puto");
            throw new RuntimeException(ex);
        }
    }

    void agregarPersonal() {
        //Tomo datos obrero
        int idOb = Integer.parseInt(getCampoInvisible().getText());
        int idCat = getIdCategoriaObrero();
        String nombre = getCampoNombreObrero().getText().toUpperCase();
        String apellido = getCampoApellido().getText().toUpperCase();
        int dni = Integer.parseInt(getCampoDni().getText());
        String cuil = getCampoCuil().getText();
        int telefono = Integer.parseInt(getCampoTelefono().getText());
        String direccion = getCampoDireccion().getText().toUpperCase();
        String localidad = getCampoLocalidad().getText().toUpperCase();
        String estadoCivil = getComboEstadoCivil().getSelectedItem().toString().toUpperCase();
        Date fechaNac = getDateChooserNacOb().getDate();
        Date fechaIng = getDateChooserIngOb().getDate();

        String sqlObrero = "INSERT INTO obrero(nombre, dni, cuil, fechaNacimiento, localidad, direccion, estadoCivil, fechaIngreso, telefono, Categoria) "
                + "VALUES ('" +nombre+apellido+ "','" + dni + "','" + cuil + "','" + fechaNac + "','" + localidad + "','" + direccion + "','" + estadoCivil + "','" + fechaIng + "','" + telefono + "','" + idCat + "')";

        //Tomo datos Gpo Fliar
        
        String nombreF = getCampoNombreFliar().getText().toUpperCase();
        String apellidoF = getCampoApellidoFliar().getText().toUpperCase();
        int dniF = Integer.parseInt(getCampoDniFliar().getText());
        String parentesco = getComboParentesco().getSelectedItem().toString();
        Date fechaNacF = getDateChooserNacGpoFliar().getDate();

        String sqlFliar = "INSERT INTO grupofamiliar(nombre, dni, fechaNacimiento, parentesco, Obrero)"
                + " VALUES ('" + nombreF + "','" + dniF + "','" + fechaNacF + "','" + parentesco + "','" + idOb + "')";

        try {
            cc.conexion();
            Statement st = cn.createStatement();
            st.execute(sqlObrero);
            st.execute(sqlFliar);
            AbmObrero.agregarObrero(nombre, cuil, estadoCivil, localidad, direccion, fechaNacF, fechaIng, dni, telefono, idCat);
            AbmGrupoFamiliar.agregarGrupoFamiliar(nombre, dni, fechaNacF, parentesco, idOb);
            JOptionPane.showMessageDialog(null, "Se agrego correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");

        }

    }

    public JComboBox getComboEstadoCivil() {
        return comboEstadoCivil;
    }

    public void setComboEstadoCivil(JComboBox comboEstadoCivil) {
        this.comboEstadoCivil = comboEstadoCivil;
    }

    public JDateChooser getDateChooserIngOb() {
        return DateChooserIngOb;
    }

    public JDateChooser getDateChooserNacGpoFliar() {
        return DateChooserNacGpoFliar;
    }

    public JDateChooser getDateChooserNacOb() {
        return DateChooserNacOb;
    }

    public JTextField getCampoNombreObrero() {
        return campoCuil;
    }

    public void setCampoNombreObrero(JTextField campoNombreObrero) {
        this.campoCuil = campoNombreObrero;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoDni = new javax.swing.JTextField();
        campoCuil = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoLocalidad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboEstadoCivil = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        campoSalarioBasico = new javax.swing.JTextField();
        DateChooserNacOb = new com.toedter.calendar.JDateChooser();
        DateChooserIngOb = new com.toedter.calendar.JDateChooser();
        campoApellido = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        campoApellidoFliar = new javax.swing.JTextField();
        campoDniFliar = new javax.swing.JTextField();
        campoNombreFliar = new javax.swing.JTextField();
        comboParentesco = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGrupoFliar = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        DateChooserNacGpoFliar = new com.toedter.calendar.JDateChooser();
        campoInvisible = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel6.setText("Apellido:");

        jLabel7.setText("Dirección:");

        campoCuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCuilActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Fecha de Nacimiento:");

        jLabel4.setText("Dni:");

        jLabel5.setText("Cuil:");

        jLabel12.setText("Localidad:");

        jLabel13.setText("Estado Civil:");

        comboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Soltero", "Casado", "Viudo", "Divorciado" }));

        jLabel14.setText("Teléfono:");

        campoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefonoActionPerformed(evt);
            }
        });

        jLabel15.setText("Fecha de Ingreso:");

        jLabel16.setText("Categoría:");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Oficial Especializado", "Oficial", "Medio Oficial", "Ayudante", "Sereno" }));

        jLabel17.setText("Salario Básico:");

        campoSalarioBasico.setEditable(false);

        campoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApellidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38)
                        .addComponent(campoCuil)
                        .addGap(289, 289, 289))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(27, 27, 27)
                        .addComponent(DateChooserIngOb, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoSalarioBasico))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25)
                                    .addComponent(campoDni, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(DateChooserNacOb, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel7)
                                    .addGap(26, 26, 26)
                                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(campoApellido))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(DateChooserNacOb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(campoLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(DateChooserIngOb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(campoSalarioBasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Datos Personales", jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(449, 384));

        jLabel1.setText("Nombre:");

        jLabel8.setText("Apellido:");

        jLabel9.setText("Dni:");

        jLabel10.setText("Fecha Nacimiento:");

        jLabel11.setText("Parentesco:");

        campoDniFliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDniFliarActionPerformed(evt);
            }
        });

        campoNombreFliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreFliarActionPerformed(evt);
            }
        });

        comboParentesco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Esposo/a", "Hijo/a", "Padre", "Madre", "Hermano/a" }));
        comboParentesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboParentescoActionPerformed(evt);
            }
        });

        tablaGrupoFliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Fecha Nacimiento", "Parentesco"
            }
        ));
        jScrollPane3.setViewportView(tablaGrupoFliar);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11564764-vector-de-agregar-eliminar-o-mostrar-ocultar-los-botones-de-colores-Foto-de-archivo.png"))); // NOI18N
        jButton3.setText("jButton3");
        jButton3.setMargin(new java.awt.Insets(2, 29, 2, 14));
        jButton3.setMaximumSize(new java.awt.Dimension(121, 37));
        jButton3.setMinimumSize(new java.awt.Dimension(121, 37));
        jButton3.setPreferredSize(new java.awt.Dimension(107, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        jButton4.setText("jButton3");
        jButton4.setMargin(new java.awt.Insets(2, 29, 2, 14));
        jButton4.setPreferredSize(new java.awt.Dimension(107, 35));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(campoApellidoFliar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(campoNombreFliar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDniFliar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateChooserNacGpoFliar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(campoDniFliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombreFliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(campoApellidoFliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DateChooserNacGpoFliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Grupo Familiar", jPanel3);

        campoInvisible.setText("jTextField1");
        campoInvisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoInvisibleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoInvisible, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnAceptar)
                        .addGap(157, 157, 157)
                        .addComponent(btnCancelar)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(campoInvisible, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    
        agregarPersonal();
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void campoDniFliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDniFliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDniFliarActionPerformed

    private void campoNombreFliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreFliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreFliarActionPerformed

    private void comboParentescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboParentescoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboParentescoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void campoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoCuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCuilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCuilActionPerformed

    private void campoInvisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoInvisibleActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_campoInvisibleActionPerformed

    private void campoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApellidoActionPerformed

    
    public JTextField getCampoApellidoFliar() {
        return campoApellidoFliar;
    }

    public void setCampoApellidoFliar(JTextField campoApellidoFliar) {
        this.campoApellidoFliar = campoApellidoFliar;
    }

    public JTextField getCampoCuil() {
        return campoCuil;
    }

    public void setCampoCuil(JTextField campoCuil) {
        this.campoCuil = campoCuil;
    }

    public JTextField getCampoDireccion() {
        return campoDireccion;
    }

    public void setCampoDireccion(JTextField campoDireccion) {
        this.campoDireccion = campoDireccion;
    }

    public JTextField getCampoDni() {
        return campoDni;
    }

    public void setCampoDni(JTextField campoDni) {
        this.campoDni = campoDni;
    }

    public JTextField getCampoDniFliar() {
        return campoDniFliar;
    }

    public void setCampoDniFliar(JTextField campoDniFliar) {
        this.campoDniFliar = campoDniFliar;
    }

    public JTextField getCampoLocalidad() {
        return campoLocalidad;
    }

    public void setCampoLocalidad(JTextField campoLocalidad) {
        this.campoLocalidad = campoLocalidad;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(JTextField campoNombre) {
        this.campoNombre = campoNombre;
    }

    public JTextField getCampoNombreFliar() {
        return campoNombreFliar;
    }

    public void setCampoNombreFliar(JTextField campoNombreFliar) {
        this.campoNombreFliar = campoNombreFliar;
    }

    public JTextField getCampoSalarioBasico() {
        return campoSalarioBasico;
    }

    public void setCampoSalarioBasico(JTextField campoSalarioBasico) {
        this.campoSalarioBasico = campoSalarioBasico;
    }

    public JTextField getCampoTelefono() {
        return campoTelefono;
    }

    public void setCampoTelefono(JTextField campoTelefono) {
        this.campoTelefono = campoTelefono;
    }

    public JComboBox getComboCategoria() {
        return comboCategoria;
    }

    public void setComboCategoria(JComboBox comboCategoria) {
        this.comboCategoria = comboCategoria;
    }

    public JComboBox getComboParentesco() {
        return comboParentesco;
    }

    public void setComboParentesco(JComboBox comboParentesco) {
        this.comboParentesco = comboParentesco;
    }

    public JComboBox getjComboBox1() {
        return comboEstadoCivil;
    }

    public void setjComboBox1(JComboBox jComboBox1) {
        this.comboEstadoCivil = jComboBox1;
    }

    public JTable getTablaGrupoFliar() {
        return tablaGrupoFliar;
    }

    public void setTablaGrupoFliar(JTable tablaGrupoFliar) {
        this.tablaGrupoFliar = tablaGrupoFliar;
    }

    public JTextField getCampoInvisible() {
        return campoInvisible;
    }

    public void setCampoInvisible(JTextField campoInvisible) {
        this.campoInvisible = campoInvisible;
    }

    public JTextField getCampoApellido() {
        return campoApellido;
    }

    public void setCampoApellido(JTextField campoApellido) {
        this.campoApellido = campoApellido;
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
            java.util.logging.Logger.getLogger(AñadirPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AñadirPersonal dialog = new AñadirPersonal(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser DateChooserIngOb;
    private com.toedter.calendar.JDateChooser DateChooserNacGpoFliar;
    private com.toedter.calendar.JDateChooser DateChooserNacOb;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoApellidoFliar;
    private javax.swing.JTextField campoCuil;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoDni;
    private javax.swing.JTextField campoDniFliar;
    private javax.swing.JTextField campoInvisible;
    private javax.swing.JTextField campoLocalidad;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoNombreFliar;
    private javax.swing.JTextField campoSalarioBasico;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JComboBox comboEstadoCivil;
    private javax.swing.JComboBox comboParentesco;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tablaGrupoFliar;
    // End of variables declaration//GEN-END:variables
}
