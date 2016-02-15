/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.conectar;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.istack.internal.logging.Logger;
import controlador.ControladorCompra;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.compra.Material;

/**
 *
 * @author Luca
 */
public class NuevaCompra extends javax.swing.JDialog {

    conectar cc = new conectar();
    Connection cn = cc.conexion();
    ControladorCompra controlador = new ControladorCompra();
    Material m;

    public NuevaCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        autoCompletar();
    }

    public String getNombreProveedorSeleccionado() {

        String np = campoBuscarProv.getText();
        return np;
    }

    public String getCuitProveedorSeleccionado() {
        String prov = campoCuit.getText();
        return prov;
    }

    void autoCompletar() {
        TextAutoCompleter txt = new TextAutoCompleter(campoBuscarProv);
        String sql = "SELECT nombre FROM proveedor";
        cc.conexion();
        try {
            Statement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                txt.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(sql, null);
        }
    }

    void validacionProv() {
        String sql = "SELECT nombre FROM proveedor";
        cc.conexion();
        try {
            Statement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (getCampoBuscarProv().getText().equals(rs.getString("nombre"))) {
                    llenarCamposSegunProv();
                }
            }

        } catch (SQLException ex) {

        }
    }

    void llenarCamposSegunProv() {

        String nombre = getCampoBuscarProv().getText();
        String sql = "SELECT cuit, provincia, localidad, direccion, telefono FROM proveedor "
                + "WHERE nombre='" + nombre + "'";

        cc.conexion();
        try {
            Statement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            String cuit = rs.getString("cuit");
            String provincia = rs.getString("provincia");
            String localidad = rs.getString("localidad");
            String direccion = rs.getString("direccion");
            int telefono = rs.getInt("telefono");
            //this.getCampoId().setText(String.valueOf(id1));
            this.getCampoCuit().setText(cuit);
            this.getCampoProvincia().setText(provincia);
            this.getCampoLocalidad().setText(localidad);
            this.getCampoDireccion().setText(direccion);
            this.getCampoTelefono().setText(String.valueOf(telefono));
        } catch (SQLException ex) {
            Logger.getLogger(sql, null);
        }
    }
    
   

    public JTextField getCampoBuscarProv() {
        return campoBuscarProv;
    }

    public void setCampoBuscarProv(JTextField campoBuscarProv) {
        this.campoBuscarProv = campoBuscarProv;
    }

    public JTextField getCampoCantidad() {
        return campoCantidad;
    }

    public void setCampoCantidad(JTextField campoCantidad) {
        this.campoCantidad = campoCantidad;
    }

    public JTextField getCampoCodigoMaterial() {
        return campoCodigoMaterial;
    }

    public void setCampoCodigoMaterial(JTextField campoCodigoMaterial) {
        this.campoCodigoMaterial = campoCodigoMaterial;
    }

    public JTextField getCampoCuit() {
        return campoCuit;
    }

    public void setCampoCuit(JTextField campoCuit) {
        this.campoCuit = campoCuit;
    }

    public JTextField getCampoDescripMaterial() {
        return campoDescripMaterial;
    }

    public void setCampoDescripMaterial(JTextField campoDescripMaterial) {
        this.campoDescripMaterial = campoDescripMaterial;
    }

    public JTextField getCampoDireccion() {
        return campoDireccion;
    }

    public void setCampoDireccion(JTextField campoDireccion) {
        this.campoDireccion = campoDireccion;
    }

    public JTextField getCampoLocalidad() {
        return campoLocalidad;
    }

    public void setCampoLocalidad(JTextField campoLocalidad) {
        this.campoLocalidad = campoLocalidad;
    }

    public JTextField getCampoPrecioMaterial() {
        return campoPrecioMaterial;
    }

    public void setCampoPrecioMaterial(JTextField campoPrecioMaterial) {
        this.campoPrecioMaterial = campoPrecioMaterial;
    }

    public JTextField getCampoProvincia() {
        return campoProvincia;
    }

    public void setCampoProvincia(JTextField campoProvincia) {
        this.campoProvincia = campoProvincia;
    }

    public JTextField getCampoTelefono() {
        return campoTelefono;
    }

    public void setCampoTelefono(JTextField campoTelefono) {
        this.campoTelefono = campoTelefono;
    }

    public JTextField getCampoTotalCompra() {
        return campoTotalCompra;
    }

    public void setCampoTotalCompra(JTextField campoTotalCompra) {
        this.campoTotalCompra = campoTotalCompra;
    }

    public JTable getTablaNuevaCompra() {
        return tablaNuevaCompra;
    }

    public void setTablaNuevaCompra(JTable tablaNuevaCompra) {
        this.tablaNuevaCompra = tablaNuevaCompra;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNuevaCompra = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        campoTotalCompra = new javax.swing.JTextField();
        botonFinalizarCompra = new javax.swing.JButton();
        botonCancelarCompra = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoBuscarProv = new javax.swing.JTextField();
        campoProvincia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoCuit = new javax.swing.JTextField();
        campoLocalidad = new javax.swing.JTextField();
        botonBuscarProv = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        campoPrecioMaterial = new javax.swing.JTextField();
        campoCodigoMaterial = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        campoCantidad = new javax.swing.JTextField();
        campoDescripMaterial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        btnBuscarProduc = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Compra");
        setBackground(new java.awt.Color(51, 0, 255));

        tablaNuevaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio Unitario", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tablaNuevaCompra);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("TOTAL:");

        campoTotalCompra.setEditable(false);

        botonFinalizarCompra.setText("Finalizar");

        botonCancelarCompra.setText("Cancelar");
        botonCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarCompraActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

        jLabel3.setText("Nombre:");

        campoDireccion.setEditable(false);

        jLabel4.setText("Dirección:");

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

        campoProvincia.setEditable(false);

        jLabel10.setText("Localidad:");

        jLabel11.setText("CUIT:");

        jLabel12.setText("Provincia:");

        campoCuit.setEditable(false);
        campoCuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCuitActionPerformed(evt);
            }
        });

        campoLocalidad.setEditable(false);

        botonBuscarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico_buscar_tbjo.png"))); // NOI18N
        botonBuscarProv.setText("jButton1");
        botonBuscarProv.setMargin(new java.awt.Insets(2, 29, 2, 14));
        botonBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProvActionPerformed(evt);
            }
        });

        jLabel1.setText("Telefono:");

        campoTelefono.setEditable(false);
        campoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(campoBuscarProv, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botonBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(campoTelefono))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(campoCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel7.setText("Precio:");

        jLabel6.setText("Descripcion:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11564764-vector-de-agregar-eliminar-o-mostrar-ocultar-los-botones-de-colores-Foto-de-archivo.png"))); // NOI18N
        jButton3.setText("jButton3");
        jButton3.setMargin(new java.awt.Insets(2, 26, 2, 14));
        jButton3.setMaximumSize(new java.awt.Dimension(121, 37));
        jButton3.setMinimumSize(new java.awt.Dimension(121, 37));
        jButton3.setPreferredSize(new java.awt.Dimension(107, 35));

        campoPrecioMaterial.setEditable(false);

        campoCodigoMaterial.setEditable(false);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnRemover.png"))); // NOI18N
        jButton5.setText("jButton2");
        jButton5.setMargin(new java.awt.Insets(2, 25, 2, 14));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        campoDescripMaterial.setEditable(false);

        jLabel8.setText("Cantidad:");

        jLabel5.setText("Codigo Material:");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        jButton6.setText("jButton3");
        jButton6.setMargin(new java.awt.Insets(2, 26, 2, 14));
        jButton6.setPreferredSize(new java.awt.Dimension(107, 35));

        btnBuscarProduc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico_buscar_tbjo.png"))); // NOI18N
        btnBuscarProduc.setText("jButton1");
        btnBuscarProduc.setMargin(new java.awt.Insets(2, 29, 2, 14));
        btnBuscarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProducActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecioMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCodigoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDescripMaterial)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 67, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(campoCodigoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(campoDescripMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(campoPrecioMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(botonFinalizarCompra)
                                        .addGap(143, 143, 143)
                                        .addComponent(botonCancelarCompra)))
                                .addGap(52, 52, 52))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(campoTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFinalizarCompra)
                    .addComponent(botonCancelarCompra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarCompraActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCancelarCompraActionPerformed

    private void botonBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProvActionPerformed
        // TODO add your handling code here:
        validacionProv();


    }//GEN-LAST:event_botonBuscarProvActionPerformed

    private void campoBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarProvActionPerformed

    private void campoBuscarProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarProvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarProvKeyTyped

    private void btnBuscarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProducActionPerformed
        // TODO add your handling code here:
        AgregarMateriales agregarmateriales = new AgregarMateriales(this, true);
        getNombreProveedorSeleccionado();
        agregarmateriales.setCallback(new Callback() {

            @Override
            public void notificar(int idMaterial, String descripcion, float precio) {
                
                getCampoCodigoMaterial().setText(String.valueOf(idMaterial));
                getCampoDescripMaterial().setText(descripcion);
                getCampoPrecioMaterial().setText(String.valueOf(precio));
            }
        });
        agregarmateriales.mostrarCon(getCuitProveedorSeleccionado(), getNombreProveedorSeleccionado());


    }//GEN-LAST:event_btnBuscarProducActionPerformed

    private void campoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoActionPerformed

    private void campoCuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCuitActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        getCampoCodigoMaterial().setText("");
        getCampoDescripMaterial().setText("");
        getCampoPrecioMaterial().setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevaCompra dialog = new NuevaCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonBuscarProv;
    private javax.swing.JButton botonCancelarCompra;
    private javax.swing.JButton botonFinalizarCompra;
    private javax.swing.JButton btnBuscarProduc;
    private javax.swing.JTextField campoBuscarProv;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoCodigoMaterial;
    private javax.swing.JTextField campoCuit;
    private javax.swing.JTextField campoDescripMaterial;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoLocalidad;
    private javax.swing.JTextField campoPrecioMaterial;
    private javax.swing.JTextField campoProvincia;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campoTotalCompra;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tablaNuevaCompra;
    // End of variables declaration//GEN-END:variables
}
