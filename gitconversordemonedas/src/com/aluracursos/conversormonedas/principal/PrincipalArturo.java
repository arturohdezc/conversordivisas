package com.aluracursos.conversormonedas.principal;

import com.aluracursos.conversormonedas.modulos.*;
import com.aluracursos.conversormonedas.calculos.Selector;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalArturo {
    public static void main(String[] args) {


        Scanner lectura = new Scanner(System.in);
        var eleccion = 0 ;
        double cantidad = 0;
        String mensajeSeleccion = """
               
               **************************************
               
               Bienvenido al Conversor de Monedas, ¿Que quieres hacer hoy?
               
                1 - Convertir Dolar Americano (USD) -> Peso Argentino (ARS)
                2 - Convertir Peso Argentino (ARS) -> Dolar Americano (USD)
                3 - Convertir Dolar Americano (USD) -> Real Brasileño (BRL)
                4 - Convertir Real Brasileño (BRL) -> Dolar Americano (USD)
                5 - Convertir Dolar Americano (USD) -> Peso Colombiano (COP)
                6 - Convertir Peso Colombiano (COP) -> Dolar Americano (USD)
                7 - Convertir Dolar Americano (USD) -> Peso Mexicano (MXN)
                8 - Convertir Peso Mexicano (MXN) -> Dolar Americano (USD)
                9 - Leer el Historial
                10 - Regresar al Selector
                11 - Salir del programa
                **************************************
                Elige una opcion Valida:
                """;
        String mensajeCantidad = "Ingresa el valor que deseas convertir:";
        List<Conversion> lista = new ArrayList<>();

        while (true){
            Selector selector = new Selector();
            System.out.println(mensajeSeleccion);
            try {
                eleccion = Integer.valueOf(lectura.nextLine());
                if (eleccion == 9){
                    LeerJson leerJson = new LeerJson();
                    leerJson.historicoArturo();
                }else if (eleccion == 10) {

                    PrincipalElector.main(args);
                } else if (eleccion == 11) {
                    System.out.println("Gracias por Usar nuestros Servicios");
                    System.exit(0);
                    break;

                } else if (1<=eleccion && eleccion<11) {

                System.out.println(mensajeCantidad);
                cantidad = Double.valueOf(lectura.nextLine());
                HacerUnaConversion hacerUnaConversion = new HacerUnaConversion();


                    Conversion conversion = hacerUnaConversion.conversion(
                        selector.monedaRecibida(eleccion)[0],
                        selector.monedaRecibida(eleccion)[1],
                        cantidad);
                    BigDecimal bigDecimal = new BigDecimal(conversion.conversion_result());
                    Horaactual horaactual = new Horaactual();
                    Conversion conversionHistorico = new Conversion(
                            conversion.base_code(),
                            conversion.target_code(),
                            conversion.conversion_rate(),
                            String.valueOf( bigDecimal.setScale(2, RoundingMode.HALF_UP)),
                            String.valueOf(cantidad),
                            horaactual.obtenerHoraActual()
                    );




                    System.out.println("El valor de " +
                            conversionHistorico.cantidad_conversion() + " "+
                            conversionHistorico.base_code() +
                            " equivale a " +
                            conversionHistorico.conversion_result()+ " "+
                            conversionHistorico.target_code()+
                            ", La hora de la consulta es: " +
                            conversionHistorico.hora_actual() );
                    lista.add(conversionHistorico);
                    GeneradorDeArchivos generadorDeArchivos = new GeneradorDeArchivos();
                    generadorDeArchivos.guardarJsonArturo(conversionHistorico);


                }else {
                    System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e){
                System.out.println("Ingresa un numero " + e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicacion");
            }

        }




    }
}
