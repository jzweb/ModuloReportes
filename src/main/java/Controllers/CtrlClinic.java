package Controllers;

import dao.DaoClinic;
import models.*;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;

public class CtrlClinic {
    Connection con;

    public HashSet<Doctor> findDoctors(String specialty){
        HashSet<Doctor>listDoctors=null;
        boolean exist=false;
        Conexion co =new Conexion();
        con = co.getConexion();
        DaoClinic clinic = new DaoClinic();

        if(clinic.getdoctors(specialty,con)!=null){
            listDoctors = clinic.getdoctors(specialty,con);
        }
        return listDoctors;
    }

    public HashSet<Apoitmment> findDoctorsByDate(String date){
        HashSet<Apoitmment>listApoiments=null;
        boolean exist=false;
        Conexion co =new Conexion();
        con = co.getConexion();
        DaoClinic clinic = new DaoClinic();

        if(clinic.getdoctorsByDate(date,con)!=null){
            listApoiments = clinic.getdoctorsByDate(date,con);
        }
        return listApoiments;
    }

    public HashSet<Apoitmment> findPatientsByDate(String date){
        HashSet<Apoitmment>listApoiments=null;
        Conexion co =new Conexion();
        con = co.getConexion();
        DaoClinic clinic = new DaoClinic();

        if(clinic.getdoctorsByDate(date,con)!=null){
            listApoiments = clinic.getPatientsByDate(date,con);
        }
        return listApoiments;
    }

    public HashSet<Patient> findPatientsByDateBirth(String date1, String date2){
        HashSet<Patient>listPatients=null;
        boolean exist=false;
        Conexion co =new Conexion();
        con = co.getConexion();
        DaoClinic clinic = new DaoClinic();

        if(clinic.getPatientsByDateBirth(date1,date2,con)!=null){
            listPatients = clinic.getPatientsByDateBirth(date1,date2,con);
        }
        return listPatients;
    }
}
