package com.project.conversormonedas.main;

import com.project.conversormonedas.models.ApiRequest;
import com.project.conversormonedas.models.Moneda;

public class Main  {
    public static void main(String[] args) {

        // realizar el menu del programa

        ApiRequest consulta = new ApiRequest();

        try {
        Moneda moneda = consulta.consultaCambio("USD","MXN");
            System.out.println(moneda);
        } catch (Exception e) {
            System.out.println("Probando API");
        }
    }
}
