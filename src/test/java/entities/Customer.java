package entities;

import Utils.Utilities;

import java.util.ArrayList;

public class Customer {


    private Utilities.Utilidades utilidades;
    private String name;
    private boolean gender;
    private String birthDate;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private String pin;
    private String email;
    private String password;

    public Customer(String name, boolean gender, String birthDate, String address, String city, String state, String phoneNumber, String pin) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.pin = pin;
        this.email=utilidades.generateEmail(name);
        this.password="Test1234";
    }

    public Customer(ArrayList<String> lista) {
        this.name = lista.get(0);
        if (lista.get(1).equalsIgnoreCase("false"))this.gender = false;
        else this.gender = true;
        this.birthDate = lista.get(2);
        this.address = lista.get(3);
        this.city = lista.get(4);
        this.state = lista.get(5);
        this.phoneNumber = lista.get(6);
        this.pin = lista.get(7);
        this.email = "";
        this.password = "Test1234";
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPin() {
        return pin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
