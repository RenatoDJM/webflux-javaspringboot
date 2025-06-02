package com.delajustina.webflux.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delajustina.webflux.model.MovieInformation;
import com.delajustina.webflux.service.MovieInformationService;

@RestController
@RequestMapping("/movies")
public class MovieInformationController {
    
    private final MovieInformationService service;

    public MovieInformationController(MovieInformationService service) {
        this.service = service;
    } 

    @GetMapping
    public List<MovieInformation> getAll(@RequestParam Optional<String> title) {
        return title.map(service::filterByTitle)
                .orElseGet(service::getAllMovies);
    }

    @GetMapping("/autocomplete")
    public List<String> autocomplete(@RequestParam("q") String prefix) {
        return service.autocomplete(prefix);
    }
}
