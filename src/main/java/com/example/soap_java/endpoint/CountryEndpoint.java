package com.example.soap_java.endpoint;

import com.example.soap_java.countries.GetCountryRequest;
import com.example.soap_java.countries.GetCountryResponse;
import com.example.soap_java.repository.CountryRepository;
import com.example.soap_java.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    @Autowired
    private CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        String countryName = request.getName();
        Country country = countryRepository.findCountryByName(countryName); // Obtener el país del repositorio

        GetCountryResponse response = new GetCountryResponse();

        // Aquí verificas si el país fue encontrado y lo asignas a la respuesta
        if (country != null) {
            response.setCountry(country); // Asignar la información del país
        } else {
            response.setCountry(null); // Si el país no se encuentra, puedes asignar un valor por defecto
        }

        return response;
    }
}
