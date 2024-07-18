package hu.practice.moviejournal.controller;

import hu.practice.moviejournal.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private static final List<Movie> MOVIES = List.of(
            new Movie("Anastasia", List.of("musical", "animation")),
            new Movie("Buffy the Vampire Slayer", List.of("action", "mystery", "paranormal"))
    );

    @GetMapping
    public List<Movie> getMovies() {
        return MOVIES;
    }
}
