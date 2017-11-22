package models;

import Controllers.CtrlUser;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JasperReportDoctors {

    public void printReportDoctorsEspecialty(String val, Connection conexion) {
        JasperReport report = null;
        String file ="C:\\Users\\Jorge\\IdeaProjects\\clinicReports\\src\\main\\resources\\public\\reports\\reportesMedicosEspecialidad.jasper";
        try { Map parameters = new HashMap();
              parameters.put("especialidadDoctor",val);
              report =(JasperReport) JRLoader.loadObjectFromFile(file);
              JasperPrint print = JasperFillManager.fillReport(report,parameters,conexion);
              JasperViewer viewer = new JasperViewer(print,false);
              viewer.setVisible(true);
              viewer.setTitle("Reportes de Medicos por Especialidad");

        }
        catch(JRException ex){

        }


    }

    public void printReportDoctorsApoitmmentdate(String val1,String val2, Connection conexion) {
        JasperReport report = null;
        String file ="C:\\Users\\Jorge\\IdeaProjects\\clinicReports\\src\\main\\resources\\public\\reports\\reportesMedicosFecha.jasper";
        try { Map parameters = new HashMap();
            parameters.put("Fecha1",val1);
            parameters.put("Fecha2",val2);
            report =(JasperReport) JRLoader.loadObjectFromFile(file);
            JasperPrint print = JasperFillManager.fillReport(report,parameters,conexion);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
            viewer.setTitle("Reportes de Medicos por fecha de atención");

        }
        catch(JRException ex){

        }


    }
}
