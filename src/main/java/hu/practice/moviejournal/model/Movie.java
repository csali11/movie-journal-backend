package hu.practice.moviejournal.model;

import java.util.List;
import java.util.Objects;

public class Movie {
    private String title;
    private List<String> genres;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(genres, movie.genres);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(genres);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Movie{");
        sb.append("title='").append(title).append('\'');
        sb.append(", genres=").append(genres);
        sb.append('}');
        return sb.toString();
    }
}
