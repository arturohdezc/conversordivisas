package com.aluracursos.conversormonedas.principal;

import com.aluracursos.conversormonedas.calculos.Calculos;
import com.aluracursos.conversormonedas.calculos.Selector;
import com.aluracursos.conversormonedas.modulos.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrincipalAlura {
    public static void main(String[] args) {
        System.out.println("Se ejecuto el programa de Alura");

        Scanner lectura = new Scanner(System.in);
        var eleccion = 0 ;
        double cantidad = 0;

        String mensajeSeleccion = """
               
               **************************************
               
               Bienvenido al Conversor de Monedas Sugerido por Alura, ¿Que quieres hacer hoy?
               
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
        List<DatosRawHistorico> lista = new ArrayList<>();






        while (true){
            Selector selector = new Selector();
            System.out.println(mensajeSeleccion);
            try {
                eleccion = Integer.valueOf(lectura.nextLine());
                if (eleccion == 9){
                    LeerJson leerJson = new LeerJson();
                    leerJson.historicoAlura();
                }else if (eleccion == 10) {

                    PrincipalElector.main(args);
                } else if (eleccion == 11) {
                    System.out.println("Gracias por Usar nuestros Servicios");
                    System.exit(0);
                    break;

                } else if (1<=eleccion && eleccion<11) {

                    System.out.println(mensajeCantidad);
                    cantidad = Double.valueOf(lectura.nextLine());
                    TraerDatos traerDatos = new TraerDatos();
                    DatosRaw datosRaw = traerDatos.datosRaw();
                    Calculos calculos = new Calculos();
                    Horaactual horaactual = new Horaactual();

                    String[] resultadoConversion = calculos.ejecutarConversion(eleccion, cantidad, datosRaw);
                    BigDecimal bigDecimal = new BigDecimal(resultadoConversion[0]);
                    String moneda;
                    if (resultadoConversion[1]=="USD"){
                         moneda = String.valueOf(datosRaw.conversion_rates().get(resultadoConversion[2]));
                    }else{
                         moneda= String.valueOf(1/datosRaw.conversion_rates().get(resultadoConversion[1]));
                    }
                    System.out.println(resultadoConversion[1]);
                    System.out.println(moneda);
                    DatosRawHistorico datosRawHistorico = new DatosRawHistorico(resultadoConversion[1],
                            resultadoConversion[2],
                            moneda,
                            String.valueOf(bigDecimal.setScale(2, RoundingMode.HALF_UP)),
                            String.valueOf(cantidad),
                            horaactual.obtenerHoraActual()
                    );

                    System.out.println("El valor de " +
                            datosRawHistorico.cantidad_conversion() + " "+
                            datosRawHistorico.base_code() +
                            " equivale a " +
                            datosRawHistorico.conversion_result() + " "+
                            datosRawHistorico.target_code()+
                            ", La hora de la consulta es: " +
                            datosRawHistorico.hora_actual() );
                    lista.add(datosRawHistorico);
                    GeneradorDeArchivos generadorDeArchivos = new GeneradorDeArchivos();
                    generadorDeArchivos.guardarJsonAlura(datosRawHistorico);
                }else {
                    System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e){
                System.out.println("Ingresa un numero " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
