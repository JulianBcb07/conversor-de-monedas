package com.project.conversormonedas.models;

import com.google.gson.annotations.SerializedName;

public record Moneda(
        String base_code,
        String target_code,
        String result,
        @SerializedName("error-Type")
        String errorType,
        double conversion_rate,
        double conversion_result) {
}

/*
    1. Moneda 1
    2. Moneda 2
    3. resultado de la peticion
    4. error de la peticion (si existe)
    5. Conversion de la moneda 1 actual
    6. Conversion de la moneda 2 actual
 */
