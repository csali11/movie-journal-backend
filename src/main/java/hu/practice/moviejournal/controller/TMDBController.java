package hu.practice.moviejournal.controller;

import hu.practice.moviejournal.service.TMDBService;
import info.movito.themoviedbapi.model.movies.MovieDb;
import info.movito.themoviedbapi.tools.TmdbException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tmdb")
public class TMDBController {
    private TMDBService tmdbService;

    public TMDBController(TMDBService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDb> getGenres(@PathVariable int id) throws TmdbException {
        return ResponseEntity.ok(tmdbService.getMovie(id));
    }
}
