package com.project.conversormonedas.models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    public Moneda consultaCambio(String base_code, String target_code, double mount) {

    String API_KEY = System.getenv("API_KEY");

    URI API_URL = URI.create(API_KEY+base_code+"/"+target_code+"/"+mount);

    // API Request
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(API_URL).build();

    // API Response
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la consulta correctamente");
        }
    }
}
