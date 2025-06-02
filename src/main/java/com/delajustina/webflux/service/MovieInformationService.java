package com.delajustina.webflux.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.delajustina.webflux.model.MovieInformation;

@Service
public class MovieInformationService {
    
    private final WebClient webClient;

    public MovieInformationService(WebClient.Builder builder) {
        this.webClient = builder 
        .baseUrl("https://data.sfgov.org/resource/yitu-d5am.json")
        .build();
    }

    public List<MovieInformation> getAllMovies() {
        return webClient.get()
        .retrieve()
        .bodyToFlux(MovieInformation.class)
        .collectList()
        .block();
    }

    public List<MovieInformation> filterByTitle(String query) {
        return getAllMovies().stream()
        .filter(movie -> movie.getTitle() != null && movie.getTitle().toLowerCase().contains(query.toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<String> autocomplete(String prefix) {
        return getAllMovies().stream()
            .map(MovieInformation::getTitle)
            .filter(Objects::nonNull)
            .filter(title -> title.toLowerCase().startsWith(prefix.toLowerCase()))
            .distinct()
            .sorted()
            .limit(10)
            .collect(Collectors.toList());
    }
}
