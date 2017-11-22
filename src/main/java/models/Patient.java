package models;

public class Patient {
    private int id;
    private int dni;
    private String name;
    private String lastName;
    private String dateofbirth;
    private String address;
    private String email;
    private String telephone;
    private String sex;

    public Patient(int id, int dni, String name, String lastName, String dateofbirth, String address, String email, String telephone, String sex) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.dateofbirth = dateofbirth;

        if(address==null) {
            this.address = "-";
        }else{this.address = address;}

        if(email==null) {
            this.email = "-";
        }else{this.email = email;}

        if(telephone==null) {
            this.telephone = "-";
        }else{this.telephone = telephone;}

        if(sex==null) {
            this.sex = "-";
        }else{this.sex=sex;}
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
