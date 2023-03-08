package jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class jasper1 {

    static String ruta = "C:\\jasper\\jasper\\I_usuarios.jrxml";
    public static void main(String[] args) {
        String reportSource = "C:\\jasper\\jasper\\I_usuarios.jrxml";
        String reportPDF = "C:\\jasper\\PdfGenerado\\Informe.pdf";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("titulo", "Ver Datos de los usuarios insertados");
        params.put("autor", "Datos Usuarios");
        params.put("fecha", (new java.util.Date()).toString());
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/trabajofinal", "root", "");

            JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, conn);
            //Visualizar en pantalla
            JasperViewer.viewReport(MiInforme);
            //Convertir a PDF
            JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);
            System.out.println("Se ha creado el pdf correctamente");


        } catch (JRException ex) {
            System.out.println("Error al ejecutar el porgrama. Posible error de Jasper");
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
