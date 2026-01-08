package com.project.conversormonedas.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    double mount = 10.99; // example

// https://v6.exchangerate-api.com/v6/d333520843fc59e3d82fe792/pair/USD/MXN/23 - URL con mi ApiKey para realizar el proyecto

    public Moneda consultarCambio(String base_code, String target_code) {

    URI API_URL = URI.create("https://v6.exchangerate-api.com/v6/d333520843fc59e3d82fe792/pair/"+base_code+"/"+target_code+"/"+mount);

    // API Request
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(API_URL).build();

    // API Response
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la consulta correctamente");
        } finally {
            System.out.println("Fin de la consulta");
        }
    }
}
