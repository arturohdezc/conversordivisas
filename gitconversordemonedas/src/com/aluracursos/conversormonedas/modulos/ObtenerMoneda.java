package com.aluracursos.conversormonedas.modulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObtenerMoneda {
    public String moneda(Scanner scanner, List<String> listaMonedas) {
        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("iniciar")) {
                System.out.println("Volviendo al inicio...");
                System.out.println("Ingrese moneda Principal: ");
                continue;
            }

            if (input.isEmpty()) {
                continue;
            }

            if (listaMonedas.contains(input.toUpperCase())) {
                return input.toUpperCase();
            }

            List<String> sugerencias = new ArrayList<>();
            for (String moneda : listaMonedas) {
                if (moneda.toLowerCase().startsWith(input.toLowerCase())) {
                    sugerencias.add(moneda);
                }
            }

            if (sugerencias.isEmpty()) {
                System.out.println("Moneda no encontrada, te sugiero: " + sugerencias);
            } else {
                System.out.println("Sugerencias: " + sugerencias);
                while (true) {
                    String seleccion = scanner.nextLine();

                    if (seleccion.equalsIgnoreCase("iniciar")) {
                        System.out.println("Volviendo al inicio...");
                        System.out.println("Ingrese moneda Principal: ");
                        break;
                    }

                    if (sugerencias.contains(seleccion.toUpperCase())) {
                        return seleccion.toUpperCase();
                    } else {
                        System.out.println("Moneda no válida. Prueba otra vez o selecciona de las sugerencias: " + sugerencias);
                    }
                }
            }
        }
    }


}
