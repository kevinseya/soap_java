package com.example.soap_java.countries;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getCountryRequest")
public class GetCountryRequest {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}