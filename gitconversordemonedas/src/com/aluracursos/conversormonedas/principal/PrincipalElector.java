package com.aluracursos.conversormonedas.principal;

import com.aluracursos.conversormonedas.calculos.Selector;

import java.util.Scanner;

public class PrincipalElector {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int eleccion = 0;
        String seleccion = """
                *********************************************
                ¿Qué versión deseas ejecutar?
                (Mayores detalles de cada versión en readme.md)
                1.- Versión Alura Básica
                2.- Versión Arturo Hernández
                3.- Version Arturo Hernández V2
                4.- Salir
                *********************************************
                """;

        Selector selector = new Selector();

        while (true) {
            System.out.println(seleccion);
            try {
                eleccion = Integer.parseInt(lectura.nextLine());

                switch (eleccion) {
                    case 1:
                        PrincipalAlura.main(args);
                        break;
                    case 2:
                        PrincipalArturo.main(args);
                        break;
                        case 3:
                            PrincipalArturoV2.main(args);
                            break;
                    case 4:
                        System.out.println("Gracias por usar nuestros servicios.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
            }
        }
    }
}
