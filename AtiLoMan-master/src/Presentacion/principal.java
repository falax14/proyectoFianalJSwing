/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.C_cuestionarios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

/**
 *
 * @author FelixChristianCarlos
 */
public class principal extends JFrame {

    /**
     * Creates new form princi
     */
    public principal() {
        Image icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("..\\images\\logo_escudo.png"))).getImage();

        initComponents();
        setTitle("AtiLoMan");
        setIconImage(icon);
        //setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setLocationRelativeTo(null); //Centrar en la pantalla
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                C_cuestionarios.closeWindow(principal.this);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonInformes = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonEmpleados = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuNuevoCliente = new javax.swing.JMenuItem();
        jMenuNuevoProyecto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuMantenimiento = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenuItem();
        jMenuProyectos = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenuItem();
        jMenuConfiguracion = new javax.swing.JMenu();
        jMenuEmpleados = new javax.swing.JMenuItem();
        jMenuDiasFestivos = new javax.swing.JMenuItem();
        jMenuTurnos = new javax.swing.JMenuItem();
        jMenuRoles = new javax.swing.JMenuItem();
        jMenuDB = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(249, 248, 248));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 248, 248));

        jButtonInformes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notas.PNG"))); // NOI18N
        jButtonInformes.setText("Informes");
        jButtonInformes.setContentAreaFilled(false);
        jButtonInformes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInformes.setFocusable(false);
        jButtonInformes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jButtonClientes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matricula.PNG"))); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.setContentAreaFilled(false);
        jButtonClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonClientes.setFocusable(false);
        jButtonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jButtonEmpleados.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alumno.PNG"))); // NOI18N
        jButtonEmpleados.setText("Empleados");
        jButtonEmpleados.setContentAreaFilled(false);
        jButtonEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEmpleados.setFocusable(false);
        jButtonEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apoderado.PNG"))); // NOI18N
        jButton6.setText("Apoderado");
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jButton7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/docente.PNG"))); // NOI18N
        jButton7.setText("Docente");
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel1.setBackground(new java.awt.Color(251, 251, 252));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seprador.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInformes)
                .addGap(3, 3, 3)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButtonEmpleados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addContainerGap(724, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 50));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1450, 680));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1410, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1410, 680));

        jMenuBar1.setBackground(new java.awt.Color(248, 248, 249));
        jMenuBar1.setBorderPainted(false);

        jMenuArchivo.setActionCommand("Archivo");
        jMenuArchivo.setLabel("Archivo");

        jMenuNuevoCliente.setText("Nuevo Cliente");
        jMenuNuevoCliente.setActionCommand("NuevoCliente");
        jMenuNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoClienteActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuNuevoCliente);

        jMenuNuevoProyecto.setText("Nuevo Proyecto");
        jMenuNuevoProyecto.setActionCommand("NuevoProyecto");
        jMenuArchivo.add(jMenuNuevoProyecto);
        jMenuArchivo.add(jSeparator1);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuMantenimiento.setText("Mantenimiento");

        jMenuClientes.setText("Clientes");
        jMenuClientes.setPreferredSize(new java.awt.Dimension(163, 19));
        jMenuMantenimiento.add(jMenuClientes);

        jMenuProyectos.setText("Proyectos");
        jMenuMantenimiento.add(jMenuProyectos);

        jMenuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuUsuarios.setText("Usuarios");
        jMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuariosActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(jMenuUsuarios);

        jMenuBar1.add(jMenuMantenimiento);

        jMenuConfiguracion.setText("Configuración");
        jMenuConfiguracion.setActionCommand("Configuracion");

        jMenuEmpleados.setText("Empleados");
        jMenuConfiguracion.add(jMenuEmpleados);

        jMenuDiasFestivos.setText("Dias Festivos");
        jMenuDiasFestivos.setActionCommand("DiasFestivos");
        jMenuConfiguracion.add(jMenuDiasFestivos);

        jMenuTurnos.setText("Turnos");
        jMenuConfiguracion.add(jMenuTurnos);

        jMenuRoles.setText("Roles");
        jMenuRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRolesActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(jMenuRoles);

        jMenuDB.setText("Base de Datos");
        jMenuDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDBActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(jMenuDB);

        jMenuBar1.add(jMenuConfiguracion);

        jMenu4.setText("Herramientas");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ayuda");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuUsuariosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuUsuariosActionPerformed

        //JOptionPane.showMessageDialog(this,"Abriendo Mantenimiento de Usuarios");
        frmPersonas nuevo = new frmPersonas();
        jDesktopPane1.add(nuevo);
        nuevo.show();
        //nuevo.setLocation(75,10);

        // Una cuenta para situar la ventana en el centro de la pantalla.
        nuevo.setLocation((jDesktopPane1.getWidth() - nuevo.getWidth()) / 2, (jDesktopPane1.getHeight() - nuevo.getHeight()) / 2);


    }//GEN-LAST:event_jMenuUsuariosActionPerformed

    private void jMenuNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuNuevoClienteActionPerformed

    private void jMenuRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRolesActionPerformed
        frmRol nuevo = new frmRol();
        jDesktopPane1.add(nuevo);
        nuevo.show();
        nuevo.setLocation((jDesktopPane1.getWidth() - nuevo.getWidth()) / 2, (jDesktopPane1.getHeight() - nuevo.getHeight()) / 2);
    }//GEN-LAST:event_jMenuRolesActionPerformed

    private void jMenuDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDBActionPerformed
        frmDB nuevo = new frmDB();
        jDesktopPane1.add(nuevo);
        nuevo.show();
        nuevo.setLocation((jDesktopPane1.getWidth() - nuevo.getWidth()) / 2, (jDesktopPane1.getHeight() - nuevo.getHeight()) / 2);
    }//GEN-LAST:event_jMenuDBActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        C_cuestionarios.closeWindow(principal.this);
    }//GEN-LAST:event_jMenuSalirActionPerformed

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
        //opcional si qusieras cambiar el tamaño de la fuente
        UIManager UI = new UIManager();
        UI.put("OptionPane.messageFont", new Font("Comic Sans MS", Font.BOLD, 14));
        //puedes aplicar Color.GREEN no hay problema
        //UI.put("OptionPane.messageForeground", Color.decode("#008F39"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonEmpleados;
    private javax.swing.JButton jButtonInformes;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuClientes;
    private javax.swing.JMenu jMenuConfiguracion;
    private javax.swing.JMenuItem jMenuDB;
    private javax.swing.JMenuItem jMenuDiasFestivos;
    private javax.swing.JMenuItem jMenuEmpleados;
    private javax.swing.JMenu jMenuMantenimiento;
    private javax.swing.JMenuItem jMenuNuevoCliente;
    private javax.swing.JMenuItem jMenuNuevoProyecto;
    private javax.swing.JMenuItem jMenuProyectos;
    private javax.swing.JMenuItem jMenuRoles;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenuTurnos;
    private javax.swing.JMenuItem jMenuUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
