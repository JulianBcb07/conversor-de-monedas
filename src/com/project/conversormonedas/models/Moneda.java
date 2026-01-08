package com.project.conversormonedas.models;

public record Moneda(
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result) {
}

/*
    1. Moneda 1
    2. Moneda 2
    3. Conversion de la moneda 1 actual
    4. Conversion de la moneda 2 actual
 */
