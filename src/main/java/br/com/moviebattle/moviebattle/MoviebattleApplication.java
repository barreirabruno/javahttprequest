package br.com.moviebattle.moviebattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class MoviebattleApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(MoviebattleApplication.class, args);
		HttpClientMovieBattle httpReq = new HttpClientMovieBattle();
		httpReq.makeRequest();
	}

}
