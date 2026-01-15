package com.project.conversormonedas.main;

import com.project.conversormonedas.models.ApiRequest;
import com.project.conversormonedas.models.ConversionModel;
import com.project.conversormonedas.models.Moneda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<ConversionModel> listaDeConsultas = new ArrayList<>();

        // realizar el menu del programa

        int value_menu = 0;

        ApiRequest consultar = new ApiRequest();

        while (value_menu != 4) {
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
            try {
                System.out.print("Ingrese un valor: ");
                value_menu = sc.nextInt();
                // limpiamos buffer del scanner
                sc.nextLine();
                if (value_menu == 1) {
                    mostrarConversiones();
                } else if (value_menu == 2) {
                    System.out.println("\nEligió hacer una conversión:\n ");

                    System.out.println("Ingrese la primera moneda (codigo de moneda ISO):");
                    String moneda1 = sc.nextLine().toUpperCase();

                    System.out.println("Ingrese la segunda moneda (codigo de moneda ISO):");
                    String moneda2 = sc.nextLine().toUpperCase();

                    System.out.println("Ingrese el monto a convertir:");
                    double monto = sc.nextDouble();

                    try {
                        Moneda moneda = consultar.consultaCambio(moneda1, moneda2, monto);
                        if (moneda.result().equals("success")) {
                            ConversionModel monedaConvertida = new ConversionModel(moneda, monto);
                            System.out.println(monedaConvertida);
                            listaDeConsultas.add(monedaConvertida);
                        } else {
                            System.out.println("El tipo de moneda ingresado no existe");
                            System.out.println("Detalle del error: " + moneda.errorType());
                        }

                    } catch (Exception e) {
                        System.out.println("Ocurrio un error en la consulta\n" + e.getMessage());
                    }

                } else if (value_menu == 3) {
                    if (listaDeConsultas.isEmpty()) {
                        System.out.println("\n========================================");
                        System.out.println("\nAún no haz realizado una consulta\n");
                        System.out.println("========================================\n");
                    } else {
                        System.out.println("\nMostrar historial de consultas\n");
                        System.out.println("========================================");
                        listaDeConsultas.forEach(System.out::println); // expresion lambada de java
                        System.out.println("========================================\n");
                    }
                } else if(value_menu == 4){
                    break;
                } else {
                    System.out.println("Ingrese un número válido\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número válido.\n");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Algo salió mal, intente de nuevo.\n" + e.getMessage());
            }
        }
    }

    private static void mostrarConversiones() {
        System.out.println("""
                
                Eligió lista de monedas:
                
                1. ARS (Peso Argentino)                 10. GTQ (Quetzal Guatemalteco)
                2. BOB (Peso Boliviano)                 11. MXN (Peso Mexicano)
                3. BRL (Real Brasileño)                 12. PEN (Sol Peruano)
                4. BZD (Dolar de Belice)                13. UYU (Peso Uruguayo)
                5. CLP (Peso Chileno)                   14. VES (Bolivar Venezolano)
                6. COP (Peso Colombiano)                15. USD (Dólar Estadounidense)
                7. CRC (Colon Costarricense)            16. CAD (Dólar Canadiense)
                8. CUB (Peso Cubano)
                9. DOP (Peso Dominicano)
                """);
    }
}
