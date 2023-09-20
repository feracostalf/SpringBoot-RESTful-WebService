package com.example.webservice.versioning;

public class CustomerV1 {
    private String name;

    public CustomerV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerV1 [name=" + name + "]";
    }

    

}
