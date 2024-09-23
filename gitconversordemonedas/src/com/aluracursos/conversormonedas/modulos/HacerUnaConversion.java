package com.aluracursos.conversormonedas.modulos;

import com.aluracursos.conversormonedas.principal.PrincipalElector;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HacerUnaConversion {
    public Conversion conversion(String monedaPrimaria, String monedaSecundaria, double cantidad){
        Api api = new Api();
        if (api.getApi() == ""){
            throw new RuntimeException("No hay clave API");
        }
        URI direccion = URI.create( "https://v6.exchangerate-api.com/v6/"+ api.getApi() + "/pair/" +
                monedaPrimaria +"/" +
                monedaSecundaria+ "/" +
                cantidad + "/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre ese par");
        }
    }


}






