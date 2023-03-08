package Presentacion;

import Datos.C_emDB;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Arrays;
import java.util.Properties;


public final class frmDB extends JInternalFrame {
    private C_emDB encryptionManager;

    private void guardarDatos() {
        String DBServidor = txtDBServidor.getText();
        String DBNombre = txtDBNombre.getText();
        String DBUsuario = txtDBUsuario.getText();
        String DBPass = txtDBPass.getText();

        try {
            File configFile = new File("config.txt");
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("DBServidor=")) {
                    line = "DBServidor=" + DBServidor;
                } else if (line.startsWith("DBNombre=")) {
                    line = "DBNombre=" + DBNombre;
                } else if (line.startsWith("DBUsuario=")) {
                    line = "DBUsuario=" + DBUsuario;
                } else if (line.startsWith("DBPass=")) {
                    line = "DBPass=" + DBPass;
                }
                builder.append(line);
                builder.append(System.lineSeparator());
            }
            reader.close();

            FileWriter writer = new FileWriter(configFile);
            writer.write(builder.toString());
            writer.close();
            JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos");
        }
    }

    private void cargarDatos() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.txt");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            txtDBServidor.setText(prop.getProperty("DBServidor").replace(";", ""));
            txtDBNombre.setText(prop.getProperty("DBNombre").replace(";", ""));
            txtDBUsuario.setText(prop.getProperty("DBUsuario").replace(";", ""));
            txtDBPass.setText(prop.getProperty("DBPass").replace(";", ""));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public frmDB() {
        initComponents();
        colorNaranja();
        //cargarDatos();

        //txtDBPass.setEchoChar((char)0);   // Muestra el texto
        //txtDBPass.setEchoChar('*');       // Vuelve a mostrar *****

        try {
            encryptionManager = new C_emDB();
            String[] data = encryptionManager.readData();
            txtDBServidor.setText(data[0]);
            txtDBNombre.setText(data[1]);
            txtDBUsuario.setText(data[2]);
            txtDBPass.setText(data[3]);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbDBTitulo = new javax.swing.JLabel();
        jplDB = new javax.swing.JPanel();
        jplDBFormulario = new javax.swing.JPanel();
        jlbDBServidor = new javax.swing.JLabel();
        txtDBServidor = new javax.swing.JTextField();
        jlbDBNombre = new javax.swing.JLabel();
        txtDBNombre = new javax.swing.JTextField();
        jlbDBUsuario = new javax.swing.JLabel();
        txtDBUsuario = new javax.swing.JTextField();
        jlbDBPass = new javax.swing.JLabel();
        txtDBPass = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setName("jInternalFrame"); // NOI18N

        jlbDBTitulo.setBackground(new java.awt.Color(153, 51, 0));
        jlbDBTitulo.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jlbDBTitulo.setForeground(new java.awt.Color(153, 0, 0));
        jlbDBTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDBTitulo.setText("Base de Datos");
        jlbDBTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jplDB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jplDBFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Base de Datos"));

        jlbDBServidor.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jlbDBServidor.setText("Servidor:");

        txtDBServidor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDBServidorKeyTyped(evt);
            }
        });

        jlbDBNombre.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jlbDBNombre.setText("Nombre:");

        txtDBNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDBNombreKeyTyped(evt);
            }
        });

        jlbDBUsuario.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jlbDBUsuario.setText("Usuario:");

        txtDBUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDBUsuarioKeyTyped(evt);
            }
        });

        jlbDBPass.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jlbDBPass.setText("Contraseña:");

        javax.swing.GroupLayout jplDBFormularioLayout = new javax.swing.GroupLayout(jplDBFormulario);
        jplDBFormulario.setLayout(jplDBFormularioLayout);
        jplDBFormularioLayout.setHorizontalGroup(
            jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplDBFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplDBFormularioLayout.createSequentialGroup()
                        .addComponent(jlbDBPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDBPass))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplDBFormularioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbDBUsuario)
                            .addComponent(jlbDBNombre)
                            .addComponent(jlbDBServidor))
                        .addGap(22, 22, 22)
                        .addGroup(jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDBNombre)
                            .addComponent(txtDBServidor)
                            .addComponent(txtDBUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jplDBFormularioLayout.setVerticalGroup(
            jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplDBFormularioLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDBServidor)
                    .addComponent(txtDBServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDBNombre)
                    .addComponent(txtDBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDBUsuario)
                    .addComponent(txtDBUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplDBFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDBPass)
                    .addComponent(txtDBPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.PNG"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.PNG"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplDBLayout = new javax.swing.GroupLayout(jplDB);
        jplDB.setLayout(jplDBLayout);
        jplDBLayout.setHorizontalGroup(
            jplDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplDBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplDBFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jplDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jplDBLayout.setVerticalGroup(
            jplDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplDBLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jplDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jplDBLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelar))
                    .addComponent(jplDBFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jplDBLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDBTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jplDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlbDBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jplDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //BOTON GUARDAR
        //guardarDatos();
        try {
            // Crear una instancia de la clase C_emDB
            encryptionManager = new C_emDB();
            encryptionManager.saveData(
                    txtDBServidor.getText(),
                    txtDBNombre.getText(),
                    txtDBUsuario.getText(),
                    txtDBPass.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

/*        try {

            int rpta;
            if (mioperacion.GetOperacion() == 1) {
                midb = new C_db();
                rpta = midb.rol_insert(txtDBServidor.getText(), txtDBNombre.getText(), txtDBUsuario.getText(), txtDBPass.getText());

                if (rpta == 1) {
                    JOptionPane.showMessageDialog(this, "REGISTRO GUARDADO CORRECTAMENTE");
                }
            }//FIN DE NUEVO USUARIO

            if (mioperacion.GetOperacion() == 2) {

                midb = new C_db();
                rpta = midb.rol_update(txtDBServidor.getText(), txtDBNombre.getText(), txtDBPass.getText(), txtDBUsuario.getText());

                if (rpta == 1) {
                    JOptionPane.showMessageDialog(this, "DATOS MODIFICADOS CORRECTAMENTE");
                    Limpiar();


                    midb = null;
                }
            }//FIN DE MODIFICAR USUARIO

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "HA OCURRIDO UN ERROR EN EL SISTEMA"
                    + "\n\n" + "Por Favor Comunique al Programador para dar Solucion.");

        }
*/
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        Limpiar();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDBNombreKeyTyped(KeyEvent evt) {//GEN-FIRST:event_txtDBNombreKeyTyped
    }//GEN-LAST:event_txtDBNombreKeyTyped

    private void txtDBServidorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDBServidorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDBServidorKeyTyped

    private void txtDBUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDBUsuarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDBUsuarioKeyTyped


    public void Limpiar() {
        txtDBServidor.setText("");
        txtDBNombre.setText("");
        txtDBPass.setText("");
        txtDBUsuario.setText("");

    }


    public void colorNaranja() {
        for (JTextComponent jTextField : Arrays.asList(txtDBServidor, txtDBNombre, txtDBPass, txtDBUsuario)) {
            jTextField.setBackground(Color.decode("#fcf4bf"));
        }


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jlbDBNombre;
    private javax.swing.JLabel jlbDBPass;
    private javax.swing.JLabel jlbDBServidor;
    private javax.swing.JLabel jlbDBTitulo;
    private javax.swing.JLabel jlbDBUsuario;
    private javax.swing.JPanel jplDB;
    private javax.swing.JPanel jplDBFormulario;
    private javax.swing.JTextField txtDBNombre;
    private javax.swing.JPasswordField txtDBPass;
    private javax.swing.JTextField txtDBServidor;
    private javax.swing.JTextField txtDBUsuario;
    // End of variables declaration//GEN-END:variables
}
