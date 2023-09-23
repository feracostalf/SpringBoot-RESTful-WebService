package com.example.webservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("SomeBeanFilter")
public class FilteredBean {
    private String user;
    @JsonIgnore
    private String password;
    private String DNI;
    
    public FilteredBean(String user, String password, String dNI) {
        this.user = user;
        this.password = password;
        DNI = dNI;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    @Override
    public String toString() {
        return "FilteredBean [user=" + user + ", password=" + password + ", DNI=" + DNI + "]";
    }

    
}
