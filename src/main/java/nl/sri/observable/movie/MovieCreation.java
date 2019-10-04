package nl.sri.observable.movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class MovieCreation {

    public static Observable<Movie> aquireMovies() {
        return Observable.fromIterable(getMovies());
    }

    private static List<Movie> getMovies() {
        final List<Movie> movies = new ArrayList<>();
        movies.add(createMovie("Avengers Endgame",2019,"Anthony Russo", cast("Robert Downey Jr", "Chris Evans", "Mark Ruffalo"),8.6));
        movies.add(createMovie("Avengers: Infinity War",2018,"Anthony Russo", cast("Robert Downey Jr", "Chris Hemsworth", "Mark Ruffalo"),8.5));
        movies.add(createMovie("Guardians of the Galaxy",2014,"James Gunn", cast("Chris Pratt", "Vin Diesel", "Bradley Cooper"),8.0));
        movies.add(createMovie("Super",2010,"James Gunn", cast("Rainn Wilson", "Ellen Page", "Liv Tyler"),6.7));
        movies.add(createMovie("Titanic",1997,"James Cameron", cast("Leonardo DiCaprio", "Kate Winslet", "Billy Zane"),7.8));
        movies.add(createMovie("Interstellar",2014,"Christopher Nolan", cast("Matthew McConaughey", "Anne Hathaway", "  Jessica Chastain "),8.6));
        return movies;
    }

    private static Movie createMovie(final String name, final int year, final String director, final List<String> cast, final Double rating ) {
        return new Movie(name,year,director, cast,rating);
    }

    private static List<String> cast(final String... cast) {
        return Arrays.asList(cast);
    }
}
