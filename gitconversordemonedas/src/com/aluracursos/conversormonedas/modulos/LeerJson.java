package com.aluracursos.conversormonedas.modulos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerJson {
    private String ruta;

    public void leerJson(String ruta) {
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            StringBuilder contenidoJson = new StringBuilder();


            while ((linea = lector.readLine()) != null) {
                contenidoJson.append(linea).append("\n");
            }


            System.out.println("Contenido de " + ruta + ":");
            System.out.println(contenidoJson.toString());

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void historicoArturo() {
        ruta = "historicoArturo.json";
        leerJson(ruta);

    }
    public void historicoArturoV2() {
        ruta = "historicoArturoV2.json";
        leerJson(ruta);
    }
    public void historicoAlura() {
        ruta = "historicoAlura.json";
        leerJson(ruta);
    }
    public void ayudaMonedas() {
        ruta = "ayudaMonedas.json";
        leerJson(ruta);
    }

}
