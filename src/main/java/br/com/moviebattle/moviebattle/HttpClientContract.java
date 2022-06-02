package br.com.moviebattle.moviebattle;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface HttpClientContract {
    public CompletableFuture<HttpResponse<String>> makeRequest() throws ExecutionException, InterruptedException;
}
