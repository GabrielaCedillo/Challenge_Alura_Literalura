package com.alura.literalura.servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

// Vamos a utilizar la Api proporcionada por alura, que es Gutendex, que nos deja buscar los libros que queramos
public class ConsumoApi {
    private String urlGutendex = "https://gutendex.com/books/?search=";

    public String buscarLibro(String tituloLibro) {
        String url = urlGutendex + tituloLibro.replace(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    // Metodo Json to Map, para tener el idioma
    public String getIdioma(Map<String, Object> jsonMap) {
        List<String> languages = (List<String>) jsonMap.get("languages");
        return languages.get(0);
    }
}

