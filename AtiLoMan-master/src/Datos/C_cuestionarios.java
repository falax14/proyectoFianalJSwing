package Datos;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class C_cuestionarios {
    public static void closeWindow(JFrame frame) {
        int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro de que quieres salir?",
                "Confirmación", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (confirm == 0) {
            frame.dispose();
        } else if (confirm == 1) {
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    public static void errorSelectTable(ArrayIndexOutOfBoundsException e) {
        int seleccion = JOptionPane.showOptionDialog(null, "HAY SELECCIONAR UNA FILA DE LA TABLA.", "INFORMACIÓN",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, // null para icono por defecto.
                new Object[]{"OK", "Ver error"}, // null para YES, NO y CANCEL
                "OK");
        if (seleccion == 1) {
            JOptionPane.showMessageDialog(null, "El error que muestra es:\n\n" + e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void errorSystem(Exception e) {
        int seleccion = JOptionPane.showOptionDialog(null,
                "Por Favor Comunique al Programador para dar Solucion.", "ERROR DEL SISTEMA",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK", "Ver error"}, "OK");
        if (seleccion == 1) {
            JOptionPane.showMessageDialog(null, "El error que muestra es:\n\n" + e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void generateReport(String reportSource, String tituloPDF, String autorPDF) {
        //String reportSource = "src/Informes/I_usuarios.jrxml";
        //String reportPDF = "Informe.pdf";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("titulo", tituloPDF);
        params.put("autor", autorPDF);
        params.put("fecha", (new java.util.Date()).toString());
        try {
            C_ConDB msql = new C_ConDB();
            Connection micnx = msql.conexion();

            JasperReport jasperReport = JasperCompileManager.compileReport("src/Informes/" + reportSource);
            JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, micnx);

            File tempFile = File.createTempFile("inf-temp-", ".pdf");
            tempFile.deleteOnExit();
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                JasperExportManager.exportReportToPdfStream(MiInforme, fos);
            }
            Desktop.getDesktop().open(tempFile);
            System.out.println(tempFile);

            //System.out.println("Se ha creado el pdf correctamente");
        } catch (JRException ex) {
            errorSystem(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
