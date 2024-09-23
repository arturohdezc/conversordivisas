package com.aluracursos.conversormonedas.principal;
import com.aluracursos.conversormonedas.modulos.*;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrincipalArturoV2 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        var eleccion = 0 ;
        String mensajeSeleccion = """
               
               **************************************
               
               Bienvenido al Conversor de Monedas de Arturo V2, ¿Que quieres hacer hoy?
               
                1 - Convertir Monedas
                2 - Leer el Historial
                3 - Ayuda sobre las Divisas por paises
                4 - Regresar al Selector
                5 - Salir del programa
                **************************************
                Elige una opcion Valida:
                """;
        List<Conversion> lista = new ArrayList<>();

        while (true){

            System.out.println(mensajeSeleccion);
            try {
                eleccion = Integer.valueOf(lectura.nextLine());

                LeerJson leerJson = new LeerJson();
                switch (eleccion) {
                    case 1: {
                        ObtenerMoneda obtenerMoneda = new ObtenerMoneda();
                        ListaMonedas listaMonedas = new ListaMonedas();


                        System.out.print("Ingrese moneda Principal: ");
                        String monedaPrincipal = obtenerMoneda.moneda(lectura, listaMonedas.getPrincipalesMonedas());
                        System.out.println("Moneda Principal seleccionada: " + monedaPrincipal);


                        System.out.print("Ingrese moneda Secundaria: ");
                        String monedaSecundaria = obtenerMoneda.moneda(lectura, listaMonedas.getPrincipalesMonedas());
                        System.out.println("Moneda Secundaria seleccionada: " + monedaSecundaria);


                        System.out.print("Ingrese cantidad a convertir: ");
                        double cantidad;
                        while (true) {

                            cantidad = Double.parseDouble(lectura.nextLine());
                            System.out.println("Cantidad a convertir: " + cantidad);
                            break;
                        }
                        HacerUnaConversion hacerUnaConversion = new HacerUnaConversion();
                        Conversion conversion = hacerUnaConversion.conversion(monedaPrincipal,monedaSecundaria,cantidad);
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
                        generadorDeArchivos.guardarJsonArturoV2(conversionHistorico);
                    }
                    break;
                    case 2:
                        leerJson.historicoArturoV2();
                        break;
                    case 3:
                        leerJson.ayudaMonedas();
                        break;
                    case 4:
                        PrincipalElector.main(args);
                        break;
                    case 5:
                        System.out.println("Gracias por Usar nuestros Servicios");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Ingresa un numero " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }




    }
}



