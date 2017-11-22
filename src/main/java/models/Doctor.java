package models;

public class Doctor {
   private int id;
   private String name;
   private String lastname;
   private String telephone;
   private String email;
   private String sex;
   private String specialty;

    public Doctor(int id, String name, String lastname, String telephone, String email, String sex, String specialty) {
        this.id = id;
        this.name = name;
        this.lastname=lastname;
        if(telephone==null){
            this.telephone = "-";
        }else{this.telephone = email;}
        //this.lastname = lastname;
        //this.telephone = telephone;
        if(email==null){
            this.email = "-";
        }else{this.email = email;}
        //this.email = email;
        this.sex = sex;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
