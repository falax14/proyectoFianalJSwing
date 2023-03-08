package Datos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class C_rol {
    Connection micnx = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    public DefaultTableModel rol_select() {

        DefaultTableModel mitabla = new DefaultTableModel();
        String[] encabezado = {"ID", "Codigo", "Descripcion", "Observaciones", "Activo?"};
        mitabla.setColumnIdentifiers(encabezado);
        try {
            C_ConDB msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_rol_select}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Object[] mifila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    mifila[i] = rs.getObject(i + 1);
                }
                mitabla.addRow(mifila);
            }
            rs.close();
            cs.close();
            micnx.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar el Select: \n\n" + e.getMessage(), "Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return mitabla;
    }
    public int rol_insert(String codigo, String descripcion, String observaciones, String activo) {
        int rpta;

        try {
            C_ConDB msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_rol_insert(?,?,?,?,?)}");

            cs.setString(1, null);
            cs.setString(2, codigo);
            cs.setString(3, descripcion);
            cs.setString(4, observaciones);
            cs.setString(5, activo);

            cs.executeUpdate();
            rpta = 1;
            cs.close();
            micnx.close();
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }
    public int rol_update(int id, String codigo, String descripcion, String observaciones, String activo) {

        int rpta;

        try {
            C_ConDB msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_rol_update(?,?,?,?,?)}");

            cs.setInt(1, id);
            cs.setString(2, codigo);
            cs.setString(3, descripcion);
            cs.setString(4, observaciones);
            cs.setString(5, activo);

            cs.executeUpdate();
            rpta = 1;
            cs.close();
            micnx.close();
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }
    public int rol_delete(int id_rol) {
        int rpta;
        try {
            C_ConDB msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_rol_delete(?)}");
            cs.setInt(1, id_rol);
            cs.executeUpdate();
            rpta = 1;
            cs.close();
            micnx.close();
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }

    public DefaultTableModel rol_buscar(int t_busq, String dato) {

        DefaultTableModel mitabla = new DefaultTableModel();
        String[] encabezado = {"ID", "Codigo", "Descripcion", "Observaciones", "Activo?"};
        mitabla.setColumnIdentifiers(encabezado);
        try {
            C_ConDB msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_rol_buscar(?,?)}");
            cs.setInt(1, t_busq);
            cs.setString(2, dato);

            rs = cs.executeQuery();

            while (rs.next()) {
                Object[] mifila = new Object[9];
                for (int i = 0; i < 9; i++) {
                    mifila[i] = rs.getObject(i + 1);
                }
                mitabla.addRow(mifila);
            }
            rs.close();
            cs.close();
            micnx.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return mitabla;
    }
}
