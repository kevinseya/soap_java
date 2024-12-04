package com.example.soap_java.repository;

import com.example.soap_java.model.Country;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CountryRepository {
    private final Map<String, Country> countries = new HashMap<>();

    public CountryRepository() {
        countries.put("Spain", new Country("Spain", 46754778, "Madrid", "EUR"));
        countries.put("France", new Country("France", 66990000, "Paris", "EUR"));
        countries.put("Germany", new Country("Germany", 83019200, "Berlin", "EUR"));
        // Agregar más países según sea necesario
    }

    public Country findCountryByName(String name) {
        return countries.get(name);
    }
}
