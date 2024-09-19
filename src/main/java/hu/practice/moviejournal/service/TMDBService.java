package hu.practice.moviejournal.service;

import hu.practice.moviejournal.config.TMDBProperties;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.movies.MovieDb;
import info.movito.themoviedbapi.tools.TmdbException;
import info.movito.themoviedbapi.tools.builders.discover.DiscoverMovieParamBuilder;
import org.springframework.stereotype.Service;

@Service
public class TMDBService {
    private final TMDBProperties tmdbProperties;
    private final TmdbApi tmdbApi;

    public TMDBService(TMDBProperties tmdbProperties) {
        this.tmdbProperties = tmdbProperties;
        this.tmdbApi = new TmdbApi(this.tmdbProperties.getApiKey());
    }

    public MovieDb getMovie(int id) throws TmdbException {
        TmdbMovies tmdbMovies = tmdbApi.getMovies();
        MovieDb movie = tmdbMovies.getDetails(id, "en-US");
        return movie;
    }

    public MovieResultsPage getDiscover() throws TmdbException {
        DiscoverMovieParamBuilder discoverMovieParamBuilder = new DiscoverMovieParamBuilder()
                .page(1);
        return tmdbApi.getDiscover().getMovie(discoverMovieParamBuilder);
    }
}
