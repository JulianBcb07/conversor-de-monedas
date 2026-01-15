package com.project.conversormonedas.models;

public class ConversionModel {

    private String moneda1;
    private String moneda2;
    private double montoDeCambio;
    private double resultadoConversion;


    public ConversionModel(Moneda miMoneda, double montoUsuario) {
        this.moneda1 = miMoneda.base_code();
        this.moneda2 = miMoneda.target_code();
        this.montoDeCambio =  montoUsuario;
        this.resultadoConversion = miMoneda.conversion_result();
    }

    @Override
    public String toString() {
        return "\nConsulta realizada \n" +
                "Usted elegio la moneda '" + moneda1 + "' y la moneda a convertir '" +
                moneda2 + "'. \n" +
                "El monto a convertir es: " + montoDeCambio +
                ", y el resultado de la conversion es: " + resultadoConversion + "\n";
    }
}
