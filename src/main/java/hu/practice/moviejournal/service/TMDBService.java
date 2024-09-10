package hu.practice.moviejournal.service;

import hu.practice.moviejournal.config.TMDBProperties;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.movies.MovieDb;
import info.movito.themoviedbapi.tools.TmdbException;
import org.springframework.stereotype.Service;

@Service
public class TMDBService {
    private final TMDBProperties tmdbProperties;

    public TMDBService(TMDBProperties tmdbProperties) {
        this.tmdbProperties = tmdbProperties;
    }

    public MovieDb getMovie(int id) throws TmdbException {
        TmdbApi tmdbApi = new TmdbApi(tmdbProperties.getApiKey());
        TmdbMovies tmdbMovies = tmdbApi.getMovies();
        MovieDb movie = tmdbMovies.getDetails(id, "en-US");
        return movie;
    }
}
