package com.example.webservice.versioning;

public class Name {
    private String fisrtName;
    private String lastName;
    private int DNI;
    
    public Name(String fisrtName, String lastName, int dNI) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        DNI = dNI;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int dNI) {
        DNI = dNI;
    }

    @Override
    public String toString() {
        return "Name [fisrtName=" + fisrtName + ", lastName=" + lastName + ", DNI=" + DNI + "]";
    }

    
}
