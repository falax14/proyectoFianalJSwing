package Presentacion;

import Datos.C_cuestionarios;
import Datos.C_rol;
import Datos.Operacion;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;


public final class frmRol extends JInternalFrame {
    C_rol miRol = null;
    Operacion mioperacion = new Operacion();

    public frmRol() {
        initComponents();
        try {
            txtCodigo.setEditable(false);
            EstadoControles(false);

            txtCodigo.setBackground(Color.decode("#f4a12c"));
            colorGris();

            miRol = new C_rol();
            tdatos.setModel(miRol.rol_select());

            int[] anchos = {25, 65, 150, 205, 49};
            for (int i = 0; i < tdatos.getColumnCount(); i++) {
                tdatos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL SISTEMA"
                            + "\n\n" + "Por Favor Comunique al Programador para dar Solucion." + e.getMessage(),
                    "Conexion", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanelRol = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdatos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlbRolCodigo = new javax.swing.JLabel();
        txtRCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRDescripcion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cboT_busq = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

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

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.PNG"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(65, 65, 65))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        jPanelRol.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Roles"));

        tdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE", "Title 3", "Title 4", "Título 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tdatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tdatos.getTableHeader().setResizingAllowed(false);
        tdatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tdatos);
        if (tdatos.getColumnModel().getColumnCount() > 0) {
            tdatos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tdatos.getColumnModel().getColumn(1).setPreferredWidth(70);
            tdatos.getColumnModel().getColumn(2).setPreferredWidth(120);
            tdatos.getColumnModel().getColumn(3).setPreferredWidth(205);
            tdatos.getColumnModel().getColumn(4).setPreferredWidth(49);
        }

        javax.swing.GroupLayout jPanelRolLayout = new javax.swing.GroupLayout(jPanelRol);
        jPanelRol.setLayout(jPanelRolLayout);
        jPanelRolLayout.setHorizontalGroup(
            jPanelRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelRolLayout.setVerticalGroup(
            jPanelRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel4.setBackground(new java.awt.Color(153, 51, 0));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Roles");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jlbRolCodigo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jlbRolCodigo.setText("Código :");

        txtRCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRCodigoActionPerformed(evt);
            }
        });
        txtRCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRCodigoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Descripción :");

        txtRDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRDescripcionKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel12.setText("ID :");

        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setText("AUTOMATICO");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel19.setText("Observaciones :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jlbRolCodigo)
                            .addComponent(jLabel12))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRCodigo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 18, Short.MAX_VALUE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187))
                            .addComponent(txtRDescripcion, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbRolCodigo)
                    .addComponent(txtRCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, jButtonGuardar});

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Busqueda :");

        cboT_busq.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cboT_busq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO DE ROL", "CODIGO", "DESCRIPCION" }));

        txtBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboT_busq, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboT_busq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        //BOTON GUARDAR

/**
 * Tabla rol
 * String tipoUsuario
 *
 */
        try {

            int rpta;
            if (mioperacion.GetOperacion() == 1) {
                miRol = new C_rol();
                rpta = miRol.rol_insert(
                        txtRCodigo.getText(),
                        txtRDescripcion.getText(),
                        txtObservaciones.getText(),
                        "S");

                if (rpta == 1) {
                    JOptionPane.showMessageDialog(this, "REGISTRO GUARDADO CORRECTAMENTE");
                    Limpiar();
                    miRol = new C_rol();
                    tdatos.setModel(miRol.rol_select());
                    configTabla();

                    miRol = null;
                }
            }//FIN DE NUEVO USUARIO

            if (mioperacion.GetOperacion() == 2) {

                miRol = new C_rol();
                int codigo = Integer.parseInt(txtCodigo.getText());
                rpta = miRol.rol_update(codigo, txtRCodigo.getText(), txtRDescripcion.getText(), txtObservaciones.getText(), "S");

                if (rpta == 1) {
                    JOptionPane.showMessageDialog(this, "DATOS MODIFICADOS CORRECTAMENTE");
                    Limpiar();
                    txtCodigo.setText("");

                    tdatos.setModel(miRol.rol_select());
                    configTabla();

                    miRol = null;
                }
            }//FIN DE MODIFICAR USUARIO
            EstadoBtones(true);
            EstadoControles(false);
            txtCodigo.setText("AUTOMATICO");
            colorGris();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "HA OCURRIDO UN ERROR EN EL SISTEMA"
                    + "\n" + "Por Favor Comunique al Programador para dar Solucion.\n\n" + e.getMessage());

        }

    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void btnModificarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        colorNaranja();
        try {
            mioperacion.SetOperacion(2);
            int fila = tdatos.getSelectedRow();

            txtCodigo.setText(tdatos.getValueAt(fila, 0).toString());
            txtRCodigo.setText(tdatos.getValueAt(fila, 1).toString());
            txtRDescripcion.setText(tdatos.getValueAt(fila, 2).toString());
            txtObservaciones.setText(tdatos.getValueAt(fila, 3).toString());

            configTabla();

            EstadoControles(true);
            EstadoBtones(false);
        } catch (ArrayIndexOutOfBoundsException e) {
            colorGris();
            int seleccion = JOptionPane.showOptionDialog( this, "HAY SELECCIONAR UNA FILA DE LA TABLA.", "INFORMACIÓN",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, // null para icono por defecto.
                    new Object[]{"OK", "Ver error"}, // null para YES, NO y CANCEL
                    "OK");
            if (seleccion == 1) {
                JOptionPane.showMessageDialog(this, "El error que muestra es:\n\n" + e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "HA OCURRIDO UN ERROR EN EL SISTEMA\n" +
                    "Por Favor Comunique al Programador para dar Solucion.\n\n" + e.getMessage());
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        txtCodigo.setText("AUTOMATICO");
        Limpiar();
        colorGris();
        EstadoBtones(true);
        EstadoControles(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            int rpta = 1000;
            int codigo = Integer.parseInt(tdatos.getValueAt(tdatos.getSelectedRow(), 0).toString());
            rpta = JOptionPane.showConfirmDialog(this, "¿DESEA ELIMINAR ESTE REGISTRO?", "SISTEMA DE USUARIOS",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (rpta == 0) {

                miRol = new C_rol();
                int x = miRol.rol_delete(codigo);

                if (x == 1) {
                    JOptionPane.showMessageDialog(this, "EL REGISTRO SE HA ELIMINADO ");
                    tdatos.setModel(miRol.rol_select());
                    configTabla();

                    miRol = null;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            colorGris();
            C_cuestionarios.errorSelectTable(e);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por Favor Comunique al Programador para dar Solucion.\n" +
                    e.getMessage(), "HA OCURRIDO UN ERROR EN EL SISTEMA", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnReportesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed

        JOptionPane.showMessageDialog(null, "Los reportes todavía no están listos", "REPORTES", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnNuevoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        mioperacion.SetOperacion(1);
        EstadoControles(true);
        txtRCodigo.requestFocus();
        EstadoBtones(false);

        colorNaranja();


    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarKeyPressed(KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

        try {
            int t_busq;
            String dato;
            t_busq = cboT_busq.getSelectedIndex();

            dato = txtBuscar.getText();
            miRol = new C_rol();
            tdatos.setModel(miRol.rol_buscar(t_busq, dato));
            miRol = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por Favor Comunique al Programador para dar Solucion.\n" +
                    e, "HA OCURRIDO UN ERROR EN EL SISTEMA", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtRDescripcionKeyTyped(KeyEvent evt) {//GEN-FIRST:event_txtRDescripcionKeyTyped

        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();

        }
    }//GEN-LAST:event_txtRDescripcionKeyTyped
    boolean playBeep;
    private void txtRCodigoKeyTyped(KeyEvent evt) {//GEN-FIRST:event_txtRCodigoKeyTyped

        char c = evt.getKeyChar();
        int ta = txtRCodigo.getText().length();


        if (!playBeep) {
            //no hace nada, no suena el beep
        } else {
            getToolkit().beep();
        }

        if (!Character.isLetterOrDigit(c) || ta >= 5) {
            evt.consume();
            playBeep = true;

        } if (ta <5) {
            playBeep = false;
        }

        //minuscula a MAYUSCULA
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
        //minuscula a MAYUSCULA FIN
    }//GEN-LAST:event_txtRCodigoKeyTyped

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtRCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRCodigoActionPerformed

    public void EstadoControles(boolean estado) {
        txtRCodigo.setEditable(estado);
        txtRDescripcion.setEditable(estado);
        txtObservaciones.setEditable(estado);

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
        txtRCodigo.setText("");
        txtRDescripcion.setText("");
        txtObservaciones.setText("");
    }

    public void configTabla() {
        if (tdatos.getColumnModel().getColumnCount() > 0) {
            tdatos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tdatos.getColumnModel().getColumn(1).setPreferredWidth(70);
            tdatos.getColumnModel().getColumn(2).setPreferredWidth(120);
            tdatos.getColumnModel().getColumn(3).setPreferredWidth(205);
            tdatos.getColumnModel().getColumn(4).setPreferredWidth(49);
        }
    }

    public void colorGris() {
        for (JTextComponent jTextField : Arrays.asList(txtRCodigo, txtRDescripcion, txtObservaciones)) {
            jTextField.setBackground(Color.lightGray);
        }
    }

    public void colorNaranja() {
        for (JTextComponent jTextField : Arrays.asList(txtRCodigo, txtRDescripcion, txtObservaciones)) {
            jTextField.setBackground(Color.decode("#fcf4bf"));
        }
        txtCodigo.setBackground(Color.decode("#f4a12c"));


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox cboT_busq;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelRol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbRolCodigo;
    private javax.swing.JTable tdatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtRCodigo;
    private javax.swing.JTextField txtRDescripcion;
    // End of variables declaration//GEN-END:variables
}
