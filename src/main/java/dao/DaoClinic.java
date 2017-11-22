package dao;

import models.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;

public class DaoClinic {

    public HashSet<Doctor> getdoctors(String specialty, Connection con){
        Clinic clinic=new Clinic();
        Doctor doctor=null;
        try {
            String query = "select e.nombre as Especialidad,m.idMedico, m.nombre,m.apellido,m.telefono,m.correo,m.sexo from reserva.especialidad e inner join reserva.medico m on e.idEspecialidad=m.idEspecialidad where e.nombre='"+specialty+"'";
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                String specialti = rs.getString("especialidad");
                int id = rs.getInt("idMedico");
                String name = rs.getString("nombre");
                String lastname = rs.getString("apellido");
                String telephone = rs.getString("telefono");
                String email = rs.getString("correo");
                String sex = rs.getString("sexo");
                doctor = new Doctor(id,name,lastname,telephone,email,sex,specialti);
                clinic.setListDoctors(doctor);

            }

            st.close();

        }catch(Exception e){

        }

        return clinic.getListDoctors();
    }

    public HashSet<Apoitmment> getdoctorsByDate(String date, Connection con){
        String date1 = date+"-01";
        String date2 = date+"-31";
        System.out.println("fecha"+date1);
        Apoitmment apoitmment=null;
        Clinic clinic=new Clinic();
        Doctor doctor=null;
        try {
            String query = "select r.idReserva,m.idMedico,e.nombre as Especialidad,m.nombre,m.apellido,m.telefono,m.correo,m.sexo,r.fecha,r.hora from reserva.reservamedica r inner join reserva.medico m on r.idMedico=m.idMedico inner join reserva.especialidad e on r.idEspecialidad=e.idEspecialidad where r.fecha between '"+date1+"' and '"+date2+"'";
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                int idReserva = rs.getInt("idReserva");
                String specialti = rs.getString("especialidad");
                int id = rs.getInt("idMedico");
                String name = rs.getString("nombre");
                String lastname = rs.getString("apellido");
                String telephone = rs.getString("telefono");
                String email = rs.getString("correo");
                String sex = rs.getString("sexo");
                String fecha = rs.getDate("fecha").toString();
                String hora = rs.getString("hora");

                doctor = new Doctor(id,name,lastname,telephone,email,sex,specialti);
                apoitmment = new Apoitmment(idReserva,null,doctor,fecha,hora);
                clinic.setListApoimments(apoitmment);

            }

            st.close();

        }catch(Exception e){

        }

        return clinic.getListApoimments();
    }

    public HashSet<Apoitmment> getPatientsByDate(String datetofind, Connection con){
        String date1 = datetofind+"-01";
        String date2 = datetofind+"-31";
        Clinic clinic=new Clinic();
        Patient patient=null;
        Apoitmment apoitmment=null;
        try {
            String query = "select r.idReserva,p.idPaciente,p.dni,p.nombre,p.apellido,p.fechaNacimiento,p.direccion,p.correo,p.telefono,p.sexo,r.fecha,r.hora from reserva.paciente p inner join reserva.reservamedica r on p.idPaciente=r.idPaciente  where fecha between'"+date1+"' and '"+date2+"'";
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                int idApoitmment = rs.getInt("idReserva");
                int id=rs.getInt("idPaciente");
                System.out.println("id Paciente: "+id);
                int dni=Integer.parseInt(rs.getString("dni"));
                String name=rs.getString("nombre");
                String lastName=rs.getString("apellido");
                String dateofbirth=rs.getString("fechaNacimiento");
                String address=rs.getString("direccion");
                String email=rs.getString("correo");
                String telephone=rs.getString("telefono");
                String sex=rs.getString("sexo");
                String date = rs.getDate("fecha").toString();
                String hour = rs.getString("hora");
                patient = new Patient(id,dni,name,lastName,dateofbirth,address,email,telephone,sex);
                apoitmment=new Apoitmment(idApoitmment,patient,null,date,hour);
                clinic.setListApoimments(apoitmment);

            }

            st.close();

        }catch(Exception e){

        }

        return clinic.getListApoimments();
    }

    public HashSet<Patient> getPatientsByDateBirth(String date1, String date2, Connection con){
        Clinic clinic=new Clinic();
        Patient patient=null;
        try {
            String query = " select * from reserva.paciente where fechaNacimiento between '"+date1+"' and '"+date2+"'";
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("idPaciente");
                System.out.println("id Paciente: "+id);
                int dni=Integer.parseInt(rs.getString("dni"));
                String name=rs.getString("nombre");
                String lastName=rs.getString("apellido");
                String dateofbirth=rs.getString("fechaNacimiento");
                String address=rs.getString("direccion");
                String email=rs.getString("correo");
                String telephone=rs.getString("telefono");
                String sex=rs.getString("sexo");

                patient = new Patient(id,dni,name,lastName,dateofbirth,address,email,telephone,sex);
                clinic.setListPatients(patient);

            }

            st.close();

        }catch(Exception e){

        }

        return clinic.getListPatients();
    }
}
