package com.example.venkataraman.hola;

/**
 * Created by Venkataraman on 16-01-2017.
 */

public class UserInformation {

    public String id;
    public String name;
    public String address;
    public String height;
    public String weight;

    public UserInformation(){

    }

    public UserInformation(String name, String address) {
        this.name = name;
        this.address = address;
        this.height = "";
        this.weight = "";
    }

    public UserInformation(String name, String address, String height, String weight) {
        this.name = name;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
