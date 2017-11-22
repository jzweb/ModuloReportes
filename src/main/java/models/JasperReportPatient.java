package models;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


public class JasperReportPatient {

    public void printReportPatientDate(String val1,String val2, Connection conexion) {
        JasperReport report = null;
        String file ="C:\\Users\\Jorge\\IdeaProjects\\clinicReports\\src\\main\\resources\\public\\reports\\reportesPacientesFechaConsulta.jasper";
        try { Map parameters = new HashMap();
            parameters.put("Fecha1",val1);
            parameters.put("Fecha2",val2);
            report =(JasperReport) JRLoader.loadObjectFromFile(file);
            JasperPrint print = JasperFillManager.fillReport(report,parameters,conexion);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
            viewer.setTitle("Reporte de Pacientes Atendidos en Determinada Fecha");

        }
        catch(JRException ex){

        }


    }

    public void printReportPatientDateBorn(String val1,String val2, Connection conexion) {
        JasperReport report = null;
        String file ="C:\\Users\\Jorge\\IdeaProjects\\clinicReports\\src\\main\\resources\\public\\reports\\reportesPacientesFechaNacimiento.jasper";
        System.out.println("val1: "+val1);
        System.out.println("val2: "+val2);
        try { Map parameters = new HashMap();
            parameters.put("Fecha1",val1);
            parameters.put("Fecha2",val2);
            report =(JasperReport) JRLoader.loadObjectFromFile(file);
            JasperPrint print = JasperFillManager.fillReport(report,parameters,conexion);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
            viewer.setTitle("Reporte de Pacientes que Nacieron en Determinada Fecha");

        }
        catch(JRException ex){

        }


    }
}
