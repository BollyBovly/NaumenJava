package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Http {
    private static final String url = "https://httpbin.org/headers";
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            System.out.println("Ошибка запроса " + response.statusCode());
            return;
        }

        JsonNode headers = new ObjectMapper().readTree(response.body()).get("headers");

        String result = StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(headers.fieldNames(), 0), false)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
