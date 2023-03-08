package Datos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class C_usuario {
    C_ConDB msql;
    Connection micnx = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    Statement st = null;

    public void cargarCodigoRol(JComboBox cboTipo_usu, String descripcionRol) {
        // Crear conexión a la base de datos
        msql = new C_ConDB();
        micnx = msql.conexion();

        try {
            // Crear sentencia SQL y ejecutar consulta
            st = micnx.createStatement();
            rs = st.executeQuery("SELECT id,codigo FROM rol WHERE descripcion = '" + descripcionRol + "'");

            // Recorrer resultados de la consulta
            while (rs.next()) {
                String codigo = rs.getString(2);

                // Buscar indice del codigo en el combobox
                int indice = -1;
                for (int i = 0; i < cboTipo_usu.getItemCount(); i++) {
                    if (cboTipo_usu.getItemAt(i).toString().equals(codigo)) {
                        indice = i;
                        break;
                    }
                }

                // Seleccionar el valor en el combobox
                if (indice != -1) {
                    cboTipo_usu.setSelectedIndex(indice);
                }
            }

            // Cerrar objetos
            rs.close();
            st.close();
        } catch (SQLException ex) {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                micnx.close();
            } catch (SQLException ex) {
                // Mostrar mensaje de error
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public Vector<comboBox> ListaCBOX() {
        msql = new C_ConDB();
        micnx = msql.conexion();
        try {
            st = micnx.createStatement();
            rs = st.executeQuery("SELECT * FROM rol ORDER BY id");

            Vector<comboBox> data = new Vector<>();
            if (rs.next()) {
                do {
                    comboBox oListaTemporal = new comboBox(rs.getInt(1), rs.getString(2));
                    data.addElement(oListaTemporal);
                }
                while (rs.next());
                return data;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.print(ex);
            return null;
        }
    }


    public DefaultTableModel usuario_select() {

        DefaultTableModel mitabla = new DefaultTableModel();
        String[] encabezado = {"Codigo", "Nombre", "Apellidos", "DNI", "Correo", "Telefono", "Direccion", "CP", "Poblacion", "Provincia",
                "Pais", "Observaciones", "Sexo", "Fecha Nacimiento", "Usuario", "Tipo usuario"};

        mitabla.setColumnIdentifiers(encabezado);
        try {
            msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_usuario_select}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Object[] mifila = new Object[16];
                for (int i = 0; i < 16; i++) {
                    mifila[i] = rs.getObject(i + 1);
                }
                mitabla.addRow(mifila);
            }

 /*
            String sSQL = "SELECT persona.id, usuario.nick as nick, nombre, apellidos, dni, email, tlfno1, direccion, rol.descripcion FROM persona " +
                    "LEFT JOIN usuario ON persona.id = usuario.persona_id " +
                    "LEFT JOIN rol_usuario ON  usuario.id = rol_usuario.usuario_id " +
                    "LEFT JOIN rol on rol_usuario.rol_id = rol.id";
            Statement st = micnx.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            //String[] mifila = new String[9];

            while (rs.next()) {
                mifila[0]=rs.getString("id");
                mifila[1]=rs.getString("nick");
                mifila[2]=rs.getString("nombre");
                mifila[3]=rs.getString("apellidos");
                mifila[4]=rs.getString("dni");
                mifila[5]=rs.getString("email");
                mifila[6]=rs.getString("tlfno1");
                mifila[7]=rs.getString("direccion");
                mifila[8]=rs.getString("descripcion");

                mitabla.addRow(mifila);
            }
*/

            rs.close();
            cs.close();
            micnx.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar el Select: \n\n" + e.getMessage(), "Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return mitabla;
    }

    public int usuarios_insert(String dni, String nombre, String apellido, String direccion, String cp, String poblacion, String provincia,
                               String pais, String telefono, String correo, String observaciones, String sexo, String fnac,
                               String usuario, String contrasena, String id_tipo) {
        int rpta;
/*
        JOptionPane.showMessageDialog(null,
                "Nombre: " + nombre +
                        "\nApellido: " + apellido +
                        "\nDNI: " + dni +
                        "\nCorreo: " + correo +
                        "\nTelefono: " + telefono +
                        "\nDireccion: " + direccion +
                        "\nCP: " + cp +
                        "\nPoblacion: " + poblacion +
                        "\nProvincia: " + provincia +
                        "\nPais: " + pais +
                        "\nObservaciones: " + observaciones +
                        "\nSexo: " + sexo +
                        "\nFecha Nacimiento: " + fnac +
                        "\nUsuario: " + usuario +
                        "\nContraseña: " + contrasena +
                        "\nTipo Usuario: " + id_tipo);

*/

        try {
            msql = new C_ConDB();
            micnx = msql.conexion();
            cs = micnx.prepareCall("{call usp_insertar_Datos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            cs.setString(1, dni);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, direccion);
            cs.setString(5, cp);
            cs.setString(6, poblacion);
            cs.setString(7, provincia);
            cs.setString(8, pais);
            cs.setString(9, telefono);
            cs.setString(10, correo);
            cs.setString(11, observaciones);
            cs.setString(12, sexo);
            cs.setDate(13, Date.valueOf(fnac));
            cs.setString(14, usuario);
            cs.setString(15, contrasena);
            cs.setString(16, id_tipo);
            cs.registerOutParameter(17, Types.VARCHAR);
            cs.registerOutParameter(18, Types.VARCHAR);
            cs.registerOutParameter(19, Types.VARCHAR);

            cs.executeUpdate();
            rpta = 1;
            cs.close();
            micnx.close();
        } catch (Exception e) {
            rpta = 0;
            JOptionPane.showMessageDialog(null, "Error en el Insert\n\n" + e.getMessage(), "Conexion", JOptionPane.ERROR_MESSAGE);

        }
        return rpta;
    }

    public int usuario_update(int id_usu, String nombre, String apellidos, String dni, String correo, String telefono, String direccion,
                              String cp, String poblacion, String provincia, String pais, String observaciones, String sexo, String fnac,
                              String id_tipo) { //String usuario, String contrasena,

        int rpta;

        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //String cadena = "jdbc:sqlserver://localhost:1433;databaseName=siscolegio;";
            //micnx = DriverManager.getConnection(cadena,"sa","123");
            msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_modificar_Datos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            cs.setInt(1, id_usu);
            cs.setString(2, dni);
            cs.setString(3, nombre);
            cs.setString(4, apellidos);
            cs.setString(5, direccion);
            cs.setString(6, cp);
            cs.setString(7, poblacion);
            cs.setString(8, provincia);
            cs.setString(9, pais);
            cs.setString(10, telefono);
            cs.setString(11, correo);
            cs.setString(12, observaciones);
            cs.setString(13, sexo);
            cs.setDate(14, Date.valueOf(fnac));
            //cs.setString(15, usuario);
            //cs.setString(16, contrasena);
            cs.setString(15, id_tipo);
            cs.registerOutParameter(16, Types.VARCHAR);
            cs.registerOutParameter(17, Types.VARCHAR);
            cs.registerOutParameter(18, Types.VARCHAR);


            cs.executeUpdate();
            rpta = 1;
            cs.close();
            micnx.close();
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }

    public int usuario_delete(int id_usu) {
        int rpta;
        try {
            msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_usuario_delete(?)}");
            cs.setInt(1, id_usu);
            cs.executeUpdate();
            rpta = 1;
            cs.close();
            micnx.close();
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }

    public DefaultTableModel usuario_buscar(int t_busq, String dato) {

        DefaultTableModel mitabla = new DefaultTableModel();
        String[] encabezado = {"Codigo", "Usuario", "Nombres", "Apellidos", "DNI", "Correo", "Telefono", "Direccion", "Tipo usuario"};
        mitabla.setColumnIdentifiers(encabezado);
        try {
            msql = new C_ConDB();
            micnx = msql.conexion();

            cs = micnx.prepareCall("{call usp_usuario_buscar(?,?)}");
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
            System.out.println(e.getMessage());
        }
        return mitabla;
    }
}
