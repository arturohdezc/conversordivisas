package com.aluracursos.conversormonedas.modulos;

import com.google.gson.*;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivos {

    public void guardarJsonArturo (Conversion conversion) throws IOException {
        String ruta = ("historicoArturo.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();

        try (FileReader lector = new FileReader(ruta)) {
            JsonElement jsonElement = JsonParser.parseReader(lector);
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
            }
        } catch (IOException e) {
            System.out.println("El archivo no existe aún o está vacío. Se creará uno nuevo.");
        }
        jsonArray.add(gson.toJsonTree(conversion));
        try (FileWriter escritura = new FileWriter(ruta)) {
            escritura.write(gson.toJson(jsonArray));
        }


    }
    public void guardarJsonArturoV2 (Conversion conversion) throws IOException {
        String ruta = ("historicoArturoV2.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();

        try (FileReader lector = new FileReader(ruta)) {
            JsonElement jsonElement = JsonParser.parseReader(lector);
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
            }
        } catch (IOException e) {
            System.out.println("El archivo no existe aún o está vacío. Se creará uno nuevo.");
        }
        jsonArray.add(gson.toJsonTree(conversion));
        try (FileWriter escritura = new FileWriter(ruta)) {
            escritura.write(gson.toJson(jsonArray));
        }


    }
    public void guardarJsonAlura (DatosRawHistorico datosRawHistorico) throws IOException {
        String ruta = ("historicoAlura.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();

        try (FileReader lector = new FileReader(ruta)) {
            JsonElement jsonElement = JsonParser.parseReader(lector);
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
            }
        } catch (IOException e) {
            System.out.println("El archivo no existe aún o está vacío. Se creará uno nuevo.");
        }
        jsonArray.add(gson.toJsonTree(datosRawHistorico));
        try (FileWriter escritura = new FileWriter(ruta)) {
            escritura.write(gson.toJson(jsonArray));
        }
    }
}
