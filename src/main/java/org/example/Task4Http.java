package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4Http {

    public static void main(String[] args) throws Exception {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/anything"))
                    .header("Accept", "application/json, text/plain, */*")
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            String accept = root.path("headers").path("Accept").asText();
            System.out.println("Accept: " + accept);
        }
    }
}
