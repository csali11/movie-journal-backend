package hu.practice.moviejournal.model;

import lombok.Data;

import java.util.List;

@Data
public class Movie {
    private String title;
    private List<String> genres;

    public Movie(String title, List<String> genres) {
        this.title = title;
        this.genres = genres;
    }
}
