package br.com.claudiobs07.newfeatures.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientSynchronous {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response;
        try {
            String urlEndpoint = "https://www.google.com/";
            URI uri = URI.create(urlEndpoint);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Headers: " + response.headers().allValues("content-type"));
        System.out.println("Body: " + response.body());
    }
}
