package entities;

import java.util.Date;

public class Customer {

    private String name;
     //true: male - false: female
    private boolean gender;
    private String birthDate;
    private String address;
    private String city;
    private String state;
    private String PIN;
    private String phoneNumber;
    private String email;
    //Test1234
    private String pswd;


    public Customer(String name, boolean gender, String birthDate, String address, String city, String state, String PIN, String phoneNumber, String email) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.state = state;
        this.PIN = PIN;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.pswd = "Test1234";
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPIN() {
        return PIN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPswd() {
        return pswd;
    }
}
