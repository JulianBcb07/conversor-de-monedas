package com.project.conversormonedas.main;

import com.project.conversormonedas.models.ApiRequest;
import com.project.conversormonedas.models.ConversionModel;
import com.project.conversormonedas.models.Moneda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<ConversionModel>  listaDeConsultas = new ArrayList<>();


        // realizar el menu del programa

        int value_menu = 0;

        ApiRequest consultar = new ApiRequest();

        while(value_menu != 4) {
            System.out.println("""
                    ===================================================
                    |        Bienvenido al Conversor de Moneda        |
                    |                                                 |  
                    |    Eliga una opción del menú para continuar     |
                    |                                                 |
                    |    1) Ver la lista de monedas actual            |
                    |    2) Realizar conversión de monedas            |
                    |    3) Lista de sus consultas de conversión      |
                    |    4) Salir del programa                        |
                    ===================================================
                    """);
            System.out.print("Ingrese un valor: ");
            value_menu = sc.nextInt();
            if (value_menu == 1) {
                mostrarConversiones();
            } if (value_menu == 2) {
                System.out.println("Ingrese la primera moneda:");
                String moneda1 = sc.next().toUpperCase();

                System.out.println("Ingrese la segunda moneda:");
                String moneda2 = sc.next().toUpperCase();

                System.out.println("Ingrese el monto a convertir:");
                double monto = sc.nextDouble();

                try {
                    Moneda moneda = consultar.consultaCambio(moneda1, moneda2, monto);
//                    System.out.println(moneda);
                    ConversionModel monedaConvertida = new ConversionModel(moneda, monto);
                    System.out.println(monedaConvertida);

                } catch (Exception e) {
                    System.out.println("Ocurrio un error en la consulta");
                }


            } if (value_menu == 3) {
                System.out.println("Mostrar historial de consultas...");
            }
        }

        // Prueba de solicitud a la API

//        ApiRequest consulta = new ApiRequest();
//
//        try {
//        Moneda moneda = consulta.consultaCambio("USD","MXN");
//            System.out.println(moneda);
//        } catch (Exception e) {
//            System.out.println("Probando API");
//        }
    }

    private static void mostrarConversiones() {
        System.out.println("""
                
                Eligió lista de monedas:
               
                1. ARS (Peso Argentino)                 11. MXN (Peso Mexicano)
                2. BOB (Peso Boliviano)                 12. PEN (Sol Peruano)
                3. BRL (Real Brasileño)                 13. UYU (Peso Uruguayo)
                4. BZD (Dolar de Belice)                14. VES (Bolivar Venezolano)
                5. CLP (Peso Chileno)                   15. USD (Dólar Estadounidense)
                6. COP (Peso Colombiano)                16. CAD (Dólar Canadiense)
                7. CRC (Colon Costarricense)
                8. CUB (Peso Cubano)
                9. DOP (Peso Dominicano)
                10. GTQ (Quetzal Guatemalteco)
                """);
    }


}
