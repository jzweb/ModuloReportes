package models;

public class Apoitmment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String  hour;

    public Apoitmment(int id, Patient patient, Doctor doctor, String date, String hour) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
