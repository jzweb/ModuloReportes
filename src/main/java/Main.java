import Controllers.CtrlClinic;
import Controllers.CtrlUser;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import models.*;
import spark.Spark;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFiles.location("/public");

        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Main.class, "/");


        Spark.get("/",(request, response) -> {
            StringWriter writer = new StringWriter();

            try{
                Template template =configuration.getTemplate("templates/login.ftl");
                template.process(null,writer);
            }
            catch(Exception e){
                Spark.halt(500);
            }
            return writer;
        });

        before("/dashboard",(request, response) -> {
            boolean authenticated=false;
            String usersession = request.session().attribute("user");
            if (usersession!=null){
                authenticated=true;
            }

            if (!authenticated) {
                halt(401, "<center><h2>Lo sentimos <strong>:( </strong> Es una area restringida. </h2>Debe de logearse en <a href='/'>NovaSalud</a></center>");
            }
        });
        Spark.get("/dashboard",(request,response)->{
            StringWriter writer = new StringWriter();
            try {
                 Template template= configuration.getTemplate("templates/dashboard.ftl");
                 Map<String, Object> map = new HashMap<>();
                 map.put("user", request.session().attribute("user"));
                template.process(map,writer);


            }
            catch (Exception e){
                Spark.halt(500);
            }
            return writer;
        });

        before("/reportsdoctors",(request, response) -> {
            boolean authenticated=false;
            String usersession = request.session().attribute("user");
            if (usersession!=null){
                authenticated=true;
            }

            if (!authenticated) {
                halt(401, "<center><h2>Lo sentimos <strong>:( </strong> Es una area restringida. </h2>Debe de logearse en <a href='/'>NovaSalud</a></center>");
            }
        });

        Spark.get("/reportsdoctors",(request,response)->{
            StringWriter writer = new StringWriter();
            HashSet<Doctor>listDoc = new HashSet<Doctor>();
            listDoc.add(new Doctor(1,"Luis","Mateo","323333444","luis@hotmail.com","M","Cardiologo"));
            listDoc.add(new Doctor(2,"Marta","Alva","526652225","marta@hotmail.com","F","Pediatra"));
            try {
                 Template template = configuration.getTemplate("templates/doctorReport.ftl");
                 Map<String,Object>map = new HashMap<>();
                 map.put("user",request.session().attribute("user"));
                 map.put("doctors",listDoc);
                 template.process(map,writer);

            }
            catch(Exception e){

            }
            return writer;
        });

        Spark.get("/reportspatients",(request,response)->{
            StringWriter writer = new StringWriter();
            try {
                Template template = configuration.getTemplate("templates/patientReport.ftl");
                Map<String,Object>map = new HashMap<>();
                map.put("user",request.session().attribute("user"));
                template.process(map,writer);

            }
            catch(Exception e){

            }
            return writer;
        });

        // Reports JasperReport (Doctors & Patients)
        Spark.get("/reportDoctorsEspecialtyPrint/:val",(request,response)->{
            String value=request.params(":val");
            System.out.println("Val: "+value);
            Conexion con =new Conexion();
            JasperReportDoctors reportsDocs =new JasperReportDoctors();
            reportsDocs.printReportDoctorsEspecialty(value,con.getConexion());
            response.redirect("/reportsdoctors");
            return null;
        });

        Spark.get("/reportDoctorsDateApoitmmentPrint/:val",(request,response)->{
            String value1=request.params(":val")+"-01";
            String value2=request.params(":val")+"-31";
            Conexion con =new Conexion();
            JasperReportDoctors reportsDocs =new JasperReportDoctors();
            reportsDocs.printReportDoctorsApoitmmentdate(value1,value2,con.getConexion());
            response.redirect("/reportsdoctors");
            return null;
        });

        Spark.get("/reportPatientDatePrint/:val",(request,response)->{
            String value1=request.params(":val")+"-01";
            String value2=request.params(":val")+"-31";
            System.out.println("Val1: "+value1);
            System.out.println("Val2: "+value2);
            Conexion con =new Conexion();
            JasperReportPatient reportsPatient =new JasperReportPatient();
            reportsPatient.printReportPatientDate(value1,value2,con.getConexion());
            response.redirect("/reportspatients");
            return null;
        });

        Spark.get("/reportPatientDateBornPrint/:val1/:val2",(request,response)->{
            String value1=request.params(":val1");
            String value2=request.params(":val2");
            System.out.println("Val1: "+value1);
            System.out.println("Val2: "+value2);
            Conexion con =new Conexion();
            JasperReportPatient reportsPatient =new JasperReportPatient();
            reportsPatient.printReportPatientDateBorn(value1,value2,con.getConexion());
            response.redirect("/reportspatients");
            return null;
        });


        //Close Session
        Spark.get("/closeSession",(request,response)->{
            request.session().removeAttribute("user");
            response.redirect("/");
            return null;
        });



/******************** ALL POST ROUTERS****************/

        Spark.post("/controlLogin",(request,response)->{

            String user = request.queryParams("user");
            String password = request.queryParams("pass");
            System.out.println("User:"+user+" "+"Passwprd:"+password);
            CtrlUser userOn =new CtrlUser();
            if(userOn.checkUser(user,password)){
                request.session(true);
                request.session().attribute("user",user);
                response.redirect("/dashboard");
            }else{
                response.redirect("/");
            }

            return null;
        });

        //Reports Doctors

        before("/report-doctors-specialty",(request, response) -> {
            boolean authenticated=false;
            String usersession = request.session().attribute("user");
            if (usersession!=null){
                authenticated=true;
            }

            if (!authenticated) {
                halt(401, "<center><h2>Lo sentimos <strong>:( </strong> Es una area restringida. </h2>Debe de logearse en <a href='/'>NovaSalud</a></center>");
            }
        });
        Spark.post("/report-doctors-specialty",(request, response) ->{
            HashSet<Doctor>doctors=null;
            String specialty = request.queryParams("specialtydoc");
            StringWriter writer = new StringWriter();
            try{
                CtrlClinic clinic=new CtrlClinic();
                doctors=clinic.findDoctors(specialty);
                System.out.println(doctors);
                Template template = configuration.getTemplate("templates/doctorReportResult.ftl");
                Map<String,Object>map = new HashMap<>();
                map.put("user",request.session().attribute("user"));
                map.put("doctorSpecialty",specialty);
                map.put("listDoctors",doctors);
                template.process(map,writer);
            }
            catch(Exception e){

            }

            return writer;
        });

        before("/report-doctors-date",(request, response) -> {
            boolean authenticated=false;
            String usersession = request.session().attribute("user");
            if (usersession!=null){
                authenticated=true;
            }

            if (!authenticated) {
                halt(401, "<center><h2>Lo sentimos <strong>:( </strong> Es una area restringida. </h2>Debe de logearse en <a href='/'>NovaSalud</a></center>");
            }
        });
        Spark.post("/report-doctors-date",(request, response) ->{
            HashSet<Apoitmment>doctorlist=null;
            String month = request.queryParams("month");
            String year = request.queryParams("year");
            String dateToFind=year+"-"+month;
            String dateToShow=year+"/"+month;

            StringWriter writer = new StringWriter();
            try{
                CtrlClinic clinic=new CtrlClinic();
                doctorlist=clinic.findDoctorsByDate(dateToFind);
                System.out.println(doctorlist);
                Template template = configuration.getTemplate("templates/doctorReportDateResults.ftl");
                Map<String,Object>map = new HashMap<>();
                map.put("user",request.session().attribute("user"));
                map.put("dateFind",dateToShow);
                map.put("date",dateToFind);
                map.put("listApoitmment",doctorlist);
                template.process(map,writer);
            }
            catch(Exception e){

            }

            return writer;
        });

        //******* reportes Patients

        before("/report-patients-date",(request, response) -> {
            boolean authenticated=false;
            String usersession = request.session().attribute("user");
            if (usersession!=null){
                authenticated=true;
            }

            if (!authenticated) {
                halt(401, "<center><h2>Lo sentimos <strong>:( </strong> Es una area restringida. </h2>Debe de logearse en <a href='/'>NovaSalud</a></center>");
            }
        });
        Spark.post("/report-patients-date",(request, response) ->{
            HashSet<Apoitmment>apoitmmets=null;
            String dateMonth = request.queryParams("dateMonth");
            String dateYear = request.queryParams("dateYear");
            System.out.println("Date : "+ dateYear+"-"+dateMonth+"-01");
            String dateFind = dateYear+"-"+dateMonth;
            String dateToShow = dateYear+"/"+dateMonth;
            StringWriter writer = new StringWriter();
            try{
                CtrlClinic clinic=new CtrlClinic();
                apoitmmets=clinic.findPatientsByDate(dateFind);
                System.out.println("lista apoits : "+apoitmmets);
                Template template = configuration.getTemplate("templates/patientReportDate.ftl");
                Map<String,Object>map = new HashMap<>();
                map.put("user",request.session().attribute("user"));
                map.put("date",dateFind);
                map.put("dateFind",dateToShow);
                map.put("listApoitmments",apoitmmets);
                template.process(map,writer);
            }
            catch(Exception e){

            }

            return writer;
        });

        before("/report-patients-yearborn",(request, response) -> {
            boolean authenticated=false;
            String usersession = request.session().attribute("user");
            if (usersession!=null){
                authenticated=true;
            }

            if (!authenticated) {
                halt(401, "<center><h2>Lo sentimos <strong>:( </strong> Es una area restringida. </h2>Debe de logearse en <a href='/'>NovaSalud</a></center>");
            }
        });

        Spark.post("/report-patients-yearborn",(request, response) ->{
            HashSet<Patient>patients=null;
            String dateMonthInicio = request.queryParams("dateMonthInicio");
            String dateYearInicio = request.queryParams("dateYearInicio");

            String dateMonthFin = request.queryParams("dateMonthFin");
            String dateYearFin = request.queryParams("dateYearFin");

            String date1Find = dateYearInicio+"-"+dateMonthInicio+"-01";
            String date2Find = dateYearFin+"-"+dateMonthFin+"-01";


            StringWriter writer = new StringWriter();
            try{
                CtrlClinic clinic=new CtrlClinic();
                patients=clinic.findPatientsByDateBirth(date1Find,date2Find);
                System.out.println(patients);
                Template template = configuration.getTemplate("templates/patientReportYearborn.ftl");
                Map<String,Object>map = new HashMap<>();
                map.put("user",request.session().attribute("user"));
                map.put("date1Find",date1Find);
                map.put("date2Find",date2Find);
                map.put("listPatients",patients);
                template.process(map,writer);
            }
            catch(Exception e){

            }

            return writer;
        });



    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 1000; //return default port if heroku-port isn't set (i.e. on localhost)


    }
}


/**
 NOTAS:

 Reporte de Médicos por Especialidad
 Reporte de Médicos que atendieron a una determinada fecha
 Reporte de Pacientes Atendidos a una determinada Fecha
 Reporte de Pacientes a un determinado rango de fecha de nacimiento.


 **/