package Presentacion;

import Datos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public final class frmPersonas extends JInternalFrame {
    Connection micnx = null;
    C_usuario miusuario = null;
    Operacion mioperacion = new Operacion();
    Statement st;
    ResultSet rs;

    public void CargarDatos() {
        try {
            miusuario = new C_usuario();

            tdatos.setModel(miusuario.usuario_select());

            Vector<comboBox> boxLista = miusuario.ListaCBOX();
            for (Datos.comboBox comboBox : boxLista) {
                comboBox oItem = new comboBox(comboBox.getId(), comboBox.getCodigo());
                cboTipo_usu.addItem(oItem);
            }
            
                        int[] anchos = {50, 65, 150, 100, 200, 100, 100, 60, 100, 100, 50, 100, 30, 100, 100, 100};
            for (int i = 0; i < tdatos.getColumnCount(); i++) {
                tdatos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            
            
            miusuario = null;
        } catch (Exception e) {
            C_cuestionarios.errorSystem(e);
        }
    }

    public frmPersonas() {
        initComponents();
        try {
            txtCodigo.setEditable(false);
            EstadoControles(false);

            txtCodigo.setBackground(Color.decode("#f4a12c"));
            colorGris();

            //tUsuario();
            CargarDatos();

        } catch (Exception nfe) {
            C_cuestionarios.errorSystem(nfe);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtgSexo = new javax.swing.ButtonGroup();
        jPanelModificadores = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cboT_busq = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdatos = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelUsuarios = new javax.swing.JPanel();
        jPanelPersonales = new javax.swing.JPanel();
        jLabelDNI = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabelTelf = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        txtCP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPoblacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        rbtHombre = new javax.swing.JRadioButton();
        rbtMujer = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jPanelCuentas = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        txtCcontra = new javax.swing.JPasswordField();
        cboTipo_usu = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setNextFocusableComponent(txtDni);

        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevo.PNG"))); // NOI18N
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.PNG"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.PNG"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reporte.PNG"))); // NOI18N
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Busqueda :");

        cboT_busq.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cboT_busq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO USUARIO", "APELLIDO", "USUARIO" }));

        txtBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.PNG"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModificadoresLayout = new javax.swing.GroupLayout(jPanelModificadores);
        jPanelModificadores.setLayout(jPanelModificadoresLayout);
        jPanelModificadoresLayout.setHorizontalGroup(
            jPanelModificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnReportes)
                .addGap(37, 37, 37)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboT_busq, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelModificadoresLayout.setVerticalGroup(
            jPanelModificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModificadoresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelModificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelModificadoresLayout.createSequentialGroup()
                .addGroup(jPanelModificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelModificadoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelModificadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cboT_busq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Usuarios"));

        tdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6", "Título 7", "Título 8", "Título 9", "Titulo 10", "null", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tdatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tdatos);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );

        jLabelTitulo.setBackground(new java.awt.Color(153, 51, 0));
        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(153, 0, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Mantenimientos de Usuarios");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanelUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanelPersonales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelPersonales.setNextFocusableComponent(txtDni);

        jLabelDNI.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabelDNI.setText("DNI :");

        txtDni.setNextFocusableComponent(txtNombre);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Nombres :");

        txtNombre.setNextFocusableComponent(txtApellido);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Apellidos :");

        txtApellido.setNextFocusableComponent(txtDireccion);
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Email :");

        txtCorreo.setNextFocusableComponent(txtFechaNac);
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        jLabelTelf.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabelTelf.setText("Teléfono:");

        txtTelefono.setNextFocusableComponent(txtCorreo);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setText("Dirección :");

        txtDireccion.setNextFocusableComponent(txtCP);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel12.setText("ID :");

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setText("AUTO");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel14.setText("Fech Nac:");

        txtCP.setText("28");
        txtCP.setNextFocusableComponent(txtPoblacion);
        txtCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel15.setText("CP :");

        txtPoblacion.setText("Madrid");
        txtPoblacion.setNextFocusableComponent(txtProvincia);
        txtPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionActionPerformed(evt);
            }
        });
        txtPoblacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPoblacionKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel16.setText("Población :");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel17.setText("Provincia :");

        txtProvincia.setText("Provincia");
        txtProvincia.setNextFocusableComponent(txtPais);
        txtProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProvinciaKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel18.setText("Pais :");

        txtPais.setText("España");
        txtPais.setNextFocusableComponent(txtTelefono);
        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaisKeyTyped(evt);
            }
        });

        rbtgSexo.add(rbtHombre);
        rbtHombre.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        rbtHombre.setSelected(true);
        rbtHombre.setText("Hombre");
        rbtHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtHombreActionPerformed(evt);
            }
        });

        rbtgSexo.add(rbtMujer);
        rbtMujer.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        rbtMujer.setText("Mujer");
        rbtMujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMujerActionPerformed(evt);
            }
        });

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.setToolTipText("Observaciones");
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel19.setText("Observaciones :");

        javax.swing.GroupLayout jPanelPersonalesLayout = new javax.swing.GroupLayout(jPanelPersonales);
        jPanelPersonales.setLayout(jPanelPersonalesLayout);
        jPanelPersonalesLayout.setHorizontalGroup(
            jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonalesLayout.createSequentialGroup()
                                    .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel12))
                                    .addGap(2, 2, 2))
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPersonalesLayout.createSequentialGroup()
                                .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre)
                            .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDNI)
                                .addGap(43, 43, 43)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(38, 38, 38)
                        .addComponent(txtPais)))
                .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2))
                        .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                            .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabelTelf)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel19)))
                            .addGap(135, 135, 135)))
                    .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtHombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtMujer))
                            .addComponent(jLabel14)
                            .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo)))))
                .addGap(10, 10, 10))
        );
        jPanelPersonalesLayout.setVerticalGroup(
            jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDNI)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rbtHombre)
                                .addComponent(rbtMujer))
                            .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTelf)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelPersonalesLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelCuentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Cuenta"));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setText("Usuario :");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setText("Contraseña :");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setText("Confirmar  :");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setText("Tipo usuario :");

        cboTipo_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipo_usuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCuentasLayout = new javax.swing.GroupLayout(jPanelCuentas);
        jPanelCuentas.setLayout(jPanelCuentasLayout);
        jPanelCuentasLayout.setHorizontalGroup(
            jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCuentasLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCuentasLayout.createSequentialGroup()
                        .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCcontra)
                            .addComponent(txtContrasena)
                            .addComponent(cboTipo_usu, 0, 176, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCuentasLayout.setVerticalGroup(
            jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCcontra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboTipo_usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.PNG"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButtonGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.PNG"))); // NOI18N
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanelCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelUsuariosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, jButtonGuardar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelModificadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelModificadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        //BOTON GUARDAR
        try {
            // Comprobaciones antes de guardar
            String sexo = null;
            String txtOFechaNac;
            String nuevoPass = null;
            String nuevoPass2 = null;
            String pass = new String(txtContrasena.getPassword());
            String passCon = new String(txtCcontra.getPassword());
            nuevoPass = Pass_hash.sha1(pass);
            nuevoPass2 = Pass_hash.sha1(passCon);
            if (rbtHombre.isSelected()) sexo = "H";
            if (rbtMujer.isSelected()) sexo = "M";
            /*
            if (Objects.equals(txtFechaNac.getText(), "")) {
                txtOFechaNac = "1111-01-01";
            } else txtOFechaNac = txtFechaNac.getText();
*/
            if (Objects.equals(txtDni.getText(), ""))
                JOptionPane.showMessageDialog(txtCodigo, "El DNI es Obligatorio");
            else if (Objects.equals(txtNombre.getText(), ""))
                JOptionPane.showMessageDialog(null, "El Nombre es Obligatorio");
            else if (Objects.equals(txtApellido.getText(), ""))
                JOptionPane.showMessageDialog(null, "Los Apellidos son Obligatorio");
            else if (Objects.equals(txtFechaNac.getText(), ""))
                JOptionPane.showMessageDialog(null, "El Fecha de Nacimiento es Obligatorio");
            else if (Objects.equals(txtUsuario.getText(), ""))
                JOptionPane.showMessageDialog(null, "El Usuario es Obligatorio");
            else if (Arrays.equals(nuevoPass.toCharArray(), nuevoPass2.toCharArray())) {
                //System.out.println("Las contraseñas coinciden");

                //if (pass.equals(passCon)){}else JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Validación", JOptionPane.WARNING_MESSAGE);

                // FIN DE LA COMPROBACIÓN

                int rpta;
                if (mioperacion.GetOperacion() == 1) {
                    miusuario = new C_usuario();
                    assert sexo != null;
                    rpta = miusuario.usuarios_insert(
                            txtDni.getText(),
                            txtNombre.getText(),
                            txtApellido.getText(),
                            txtDireccion.getText(),
                            txtCP.getText(),
                            txtPoblacion.getText(),
                            txtProvincia.getText(),
                            txtPais.getText(),
                            txtTelefono.getText(),
                            txtCorreo.getText(),
                            txtObservaciones.getText(),
                            sexo,
                            //txtOFechaNac,
                            txtFechaNac.getText(),
                            txtUsuario.getText(),
                            //txtContrasena.getText(),
                            nuevoPass,
                            String.valueOf(cboTipo_usu.getSelectedItem()));
/*
               JOptionPane.showMessageDialog(null,
                       "Nombre: " + txtNombre.getText() +
                               "\nApellido: " + txtApellido.getText() +
                               "\nDNI: " + txtDni.getText() +
                               "\nCorreo: " + txtCorreo.getText() +
                               "\nTelefono: " + txtTelefono.getText() +
                               "\nDireccion: " + txtDireccion.getText() +
                               "\nCP: " + txtCP.getText() +
                               "\nPoblacion: " + txtPoblacion.getText() +
                               "\nProvincia: " + txtProvincia.getText() +
                               "\nPais: " + txtPais.getText() +
                               "\nObservaciones: " + txtObservaciones.getText() +
                               "\nSexo: " + sexo +
                               "\nFecha Nacimiento: " + txtFechaNac.getText() +
                               "\nO Fecha Nacimiento: " + txtOFechaNac +
                               "\nUsuario: " + txtUsuario.getText() +
                               "\nContraseña: " + txtContrasena.getText() +
                               "\nTipo Usuario: " + cboTipo_usu.getSelectedItem());
*/

                    if (rpta == 1) {
                        JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO CORRECTAMENTE");
                        Limpiar();
                        miusuario = new C_usuario();
                        tdatos.setModel(miusuario.usuario_select());
                        miusuario = null;
                    }
                }//FIN DE NUEVO USUARIO

                if (mioperacion.GetOperacion() == 2) {

                    miusuario = new C_usuario();
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    //rpta = miusuario.usuario_update(codigo, txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtCorreo.getText(), txtTelefono.getText(), txtDireccion.getText(), txtCP.getText(), txtPoblacion.getText(), txtProvincia.getText(), txtPais.getText(), txtObservaciones.getText(), sexo, txtFechaNac.getText(), txtUsuario.getText(), nuevoPass, String.valueOf(cboTipo_usu.getSelectedItem()));
                    rpta = miusuario.usuario_update(codigo, txtNombre.getText(), txtApellido.getText(), txtDni.getText(), txtCorreo.getText(), txtTelefono.getText(), txtDireccion.getText(), txtCP.getText(), txtPoblacion.getText(), txtProvincia.getText(), txtPais.getText(), txtObservaciones.getText(), sexo, txtFechaNac.getText(), String.valueOf(cboTipo_usu.getSelectedItem()));


                    if (rpta == 1) {
                        JOptionPane.showMessageDialog(this, "DATOS MODIFICADOS CORRECTAMENTE");
                        Limpiar();
                        //txtCodigo.setText("");


                        tdatos.setModel(miusuario.usuario_select());
                        miusuario = null;
                    }
                }//FIN DE MODIFICAR USUARIO
                EstadoBtones(true);
                EstadoControles(false);
                colorGris();
            } else {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException e) {
            C_cuestionarios.errorSystem(e);
        }

    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void btnModificarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        try {
            //Limpiar();

            mioperacion.SetOperacion(2);
            int fila = tdatos.getSelectedRow();

            txtCodigo.setText(tdatos.getValueAt(fila, 0).toString());
            txtNombre.setText(tdatos.getValueAt(fila, 1).toString());
            txtApellido.setText(tdatos.getValueAt(fila, 2).toString());
            txtDni.setText(tdatos.getValueAt(fila, 3).toString());
            txtCorreo.setText(tdatos.getValueAt(fila, 4).toString());
            txtTelefono.setText(tdatos.getValueAt(fila, 5).toString());
            txtDireccion.setText(tdatos.getValueAt(fila, 6).toString());
            txtCP.setText(tdatos.getValueAt(fila, 7).toString());
            txtPoblacion.setText(tdatos.getValueAt(fila, 8).toString());
            txtProvincia.setText(tdatos.getValueAt(fila, 9).toString());
            txtPais.setText(tdatos.getValueAt(fila, 10).toString());
            txtObservaciones.setText(tdatos.getValueAt(fila, 11).toString());
            if (tdatos.getModel().getValueAt(fila, 12).equals("H")) rbtHombre.setSelected(true);
            else rbtMujer.setSelected(true);
            txtFechaNac.setText(tdatos.getValueAt(fila, 13).toString());
            txtUsuario.setText(tdatos.getValueAt(fila, 14).toString());
            //cboTipo_usu.setSelectedItem(tdatos.getValueAt(fila, 15).toString());
            //cboTipo_usu.setSelectedIndex(1);

            C_usuario cboTUsuario = new C_usuario();
            cboTUsuario.cargarCodigoRol(cboTipo_usu, tdatos.getValueAt(fila, 15).toString());

/*
            C_ConDB msql = new C_ConDB();
            micnx = msql.conexion();

            String tipo_rol = tdatos.getValueAt(fila, 15).toString();
            String query = "SELECT id,codigo FROM rol WHERE descripcion = '" + tipo_rol + "'";

            st = micnx.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                String codigo = rs.getString(2);
                //System.out.println("Codigo del rol: " + codigo);

                int indice = -1;
                for (int i = 0; i < cboTipo_usu.getItemCount(); i++) {
                    if (cboTipo_usu.getItemAt(i).toString().equals(codigo)) {
                        indice = i;
                        break;
                    }
                }
                if (indice != -1) {
                    cboTipo_usu.setSelectedIndex(indice);
                }

            }

            // Cerrar objetos
            rs.close();
            st.close();
 */

            colorNaranja();
            txtUsuario.setBackground(Color.decode("#f4a12c"));
            txtCcontra.setBackground(Color.decode("#f4a12c"));
            txtContrasena.setBackground(Color.decode("#f4a12c"));

            EstadoControles(true);

            txtUsuario.setEditable(false);
            txtContrasena.setEnabled(false);
            txtCcontra.setEnabled(false);


            EstadoBtones(false);
        } catch (ArrayIndexOutOfBoundsException e) {
            colorGris();
            C_cuestionarios.errorSelectTable(e);
        } catch (NullPointerException e) {
            //System.out.println("La celda esta vacia");
            colorNaranja();
            EstadoControles(true);
            EstadoBtones(false);
        } catch (Exception e) {
            C_cuestionarios.errorSystem(e);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        //txtCodigo.setText("AUTO");
        Limpiar();
        colorGris();
        EstadoBtones(true);
        EstadoControles(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            int rpta = 1000;
            int codigo = Integer.parseInt(tdatos.getValueAt(tdatos.getSelectedRow(), 0).toString());
            rpta = JOptionPane.showConfirmDialog(this, "¿DESEA ELIMINAR ESTE REGISTRO?", "SISTEMA DE USUARIOS", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (rpta == 0) {

                miusuario = new C_usuario();
                int x = miusuario.usuario_delete(codigo);

                if (x == 1) {
                    JOptionPane.showMessageDialog(this, "EL REGISTRO SE HA ELIMINADO ");
                    tdatos.setModel(miusuario.usuario_select());
                    miusuario = null;
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por Favor Comunique al Programador para dar Solucion.\n" + e, "HA OCURRIDO UN ERROR EN EL SISTEMA", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnReportesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        //JOptionPane.showMessageDialog(null, "Los reportes todavía no están listos", "REPORTES", JOptionPane.WARNING_MESSAGE);
        C_cuestionarios reportGenerator = new C_cuestionarios();
        reportGenerator.generateReport("I_usuarios.jrxml",  "Ver Datos de los usuarios insertados", "FELIX");

    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnNuevoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        mioperacion.SetOperacion(1);
        EstadoControles(true);
        txtDni.requestFocus();
        EstadoBtones(false);
        txtContrasena.setEnabled(true);
        txtCcontra.setEnabled(true);
        colorNaranja();


    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarKeyPressed(KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

        try {
            int t_busq;
            String dato;
            t_busq = cboT_busq.getSelectedIndex();

            dato = txtBuscar.getText();
            miusuario = new C_usuario();
            tdatos.setModel(miusuario.usuario_buscar(t_busq, dato));
            miusuario = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por Favor Comunique al Programador para dar Solucion.\n" + e, "HA OCURRIDO UN ERROR EN EL SISTEMA", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisKeyTyped

    private void txtProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvinciaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvinciaKeyTyped

    private void txtPoblacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoblacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionKeyTyped

    private void txtCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPKeyTyped
        char c = evt.getKeyChar();
        int ta = txtCP.getText().length();
        if (!Character.isDigit(c) || ta >= 5) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtCPKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped

        int x = (int) evt.getKeyChar();
        if ((x > 32 && x <= 45) || (x > 58 && x <= 64) || (x >= 91 && x < 97) || (x > 122 && x <= 163) || (x > 165 && x <= 255) || (x == 47)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped

        char c = evt.getKeyChar();
        int ta = txtDni.getText().length();

        if (!Character.isDigit(c) || ta >= 8) {
            if (!Character.isLetter(c) || ta >= 9) {
                evt.consume();
                getToolkit().beep();
                jLabelDNI.setForeground(Color.RED);
            }
        }
        //minuscula a MAYUSCULA
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
        //minuscula a MAYUSCULA FIN

    }//GEN-LAST:event_txtDniKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped

        char c = evt.getKeyChar();
        int ta = txtTelefono.getText().length();
        if (!Character.isDigit(c) || ta >= 9) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped

        int x = (int) evt.getKeyChar();
        if ((x >= 32 && x <= 45) || (x > 58 && x < 64) || (x >= 91 && x < 97) || (x > 122 && x <= 163) || (x > 165 && x <= 255) || (x == 47)) {
            evt.consume();
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null, "Has pulsado un caracter no valido", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped


        char key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }

    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void rbtHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtHombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtHombreActionPerformed

    private void rbtMujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMujerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtMujerActionPerformed

    private void cboTipo_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipo_usuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipo_usuActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Limpiar();
        miusuario = new C_usuario();
        tdatos.setModel(miusuario.usuario_select());
        miusuario = null;
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoblacionActionPerformed

    public void EstadoControles(boolean estado) {
        txtNombre.setEditable(estado);
        txtApellido.setEditable(estado);
        txtDni.setEditable(estado);
        txtFechaNac.setEditable(estado);
        txtCorreo.setEditable(estado);
        txtTelefono.setEditable(estado);
        txtDireccion.setEditable(estado);
        txtCP.setEditable(estado);
        txtPoblacion.setEditable(estado);
        txtProvincia.setEditable(estado);
        txtPais.setEditable(estado);
        txtObservaciones.setEditable(estado);
        rbtHombre.setEnabled(estado);
        rbtMujer.setEnabled(estado);

        txtUsuario.setEditable(estado);
        txtContrasena.setEditable(estado);
        txtCcontra.setEditable(estado);
        cboTipo_usu.setEnabled(estado);
        jButtonGuardar.setEnabled(estado);//boton guardar
        btnCancelar.setEnabled(estado);
    }

    public void EstadoBtones(boolean estado) {
        btnNuevo.setEnabled(estado);
        btnModificar.setEnabled(estado);
        btnEliminar.setEnabled(estado);
        btnReportes.setEnabled(estado);
        cboT_busq.setEnabled(estado);
        txtBuscar.setEditable(estado);
        btnActualizar.setEnabled(estado);
    }

    public void Limpiar() {
        txtCodigo.setText("AUTO");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtFechaNac.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCP.setText("");
        txtPoblacion.setText("");
        txtProvincia.setText("");
        txtPais.setText("");
        txtObservaciones.setText("");
        rbtgSexo.clearSelection();
        rbtHombre.setSelected(isSelected);
        txtUsuario.setText("");
        txtContrasena.setText("");
        txtCcontra.setText("");
        cboTipo_usu.setSelectedIndex(0);
        jLabelDNI.setForeground(Color.BLACK);
        txtContrasena.setEnabled(true);
        txtCcontra.setEnabled(true);
    }

    public void colorGris() {
        txtNombre.setBackground(Color.lightGray);
        txtApellido.setBackground(Color.lightGray);
        txtFechaNac.setBackground(Color.lightGray);
        txtDni.setBackground(Color.lightGray);
        txtTelefono.setBackground(Color.lightGray);
        txtContrasena.setBackground(Color.lightGray);
        txtCorreo.setBackground(Color.lightGray);
        txtDireccion.setBackground(Color.lightGray);
        txtCP.setBackground(Color.lightGray);
        txtPoblacion.setBackground(Color.lightGray);
        txtProvincia.setBackground(Color.lightGray);
        txtPais.setBackground(Color.lightGray);
        txtObservaciones.setBackground(Color.lightGray);


        txtUsuario.setBackground(Color.lightGray);
        txtCcontra.setBackground(Color.lightGray);
    }

    public void colorNaranja() {
        txtCodigo.setBackground(Color.decode("#f4a12c"));
        for (JTextField jTextField : Arrays.asList(txtDni, txtTelefono, txtContrasena, txtFechaNac, txtApellido, txtNombre, txtCorreo, txtDireccion)) {
            jTextField.setBackground(Color.decode("#fcf4bf"));
        }
        txtCP.setBackground(Color.decode("#fcf4bf"));
        txtPoblacion.setBackground(Color.decode("#fcf4bf"));
        txtProvincia.setBackground(Color.decode("#fcf4bf"));
        txtPais.setBackground(Color.decode("#fcf4bf"));
        txtObservaciones.setBackground(Color.decode("#fcf4bf"));

        txtUsuario.setBackground(Color.decode("#fcf4bf"));
        txtCcontra.setBackground(Color.decode("#fcf4bf"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox cboT_busq;
    private javax.swing.JComboBox cboTipo_usu;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelTelf;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelCuentas;
    private javax.swing.JPanel jPanelModificadores;
    private javax.swing.JPanel jPanelPersonales;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtHombre;
    private javax.swing.JRadioButton rbtMujer;
    private javax.swing.ButtonGroup rbtgSexo;
    private javax.swing.JTable tdatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCP;
    private javax.swing.JPasswordField txtCcontra;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPoblacion;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
