package models;

import java.util.HashSet;

public class Clinic {
    private String name="NovaSalud";
    private String address="Miraflores";
    private String country="Lima";
    HashSet<Doctor>doctors = new HashSet<Doctor>();
    HashSet<Patient>patients=new HashSet<Patient>();
    HashSet<Apoitmment>apoimments = new HashSet<Apoitmment>();
    HashSet<User>users=new HashSet<User>();

    public void setListDoctors(Doctor d){
        this.doctors.add(d);
    }

    public HashSet<Doctor> getListDoctors(){
        return this.doctors;

    }

    public void setListPatients(Patient p){
        this.patients.add(p);
    }

    public HashSet<Patient> getListPatients(){
        return this.patients;

    }

    public void setListApoimments(Apoitmment a){
        this.apoimments.add(a);
    }

    public HashSet<Apoitmment> getListApoimments(){
        return this.apoimments;

    }

    public void setListUser(User u){
        this.users.add(u);
    }

    public HashSet<User> getListUsers(){
        return this.users;

    }

}
