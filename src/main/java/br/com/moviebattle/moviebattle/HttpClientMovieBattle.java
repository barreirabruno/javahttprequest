package br.com.moviebattle.moviebattle;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientMovieBattle implements HttpClientContract {
    @Override
    public CompletableFuture<HttpResponse<String>> makeRequest() throws ExecutionException, InterruptedException {
        String uri = "https://swapi.dev/api/people/1";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        var client = HttpClient.newBuilder().executor(executor).build();

        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        responseFuture.thenApply(res -> {
            System.out.printf("StatusCode %s%n", res.statusCode());
            return res;
        })
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .get();

        executor.shutdown();

        return responseFuture;
    }
}
