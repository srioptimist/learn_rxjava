package nl.sri.observable.movie;


import static nl.sri.observable.movie.MovieCreation.aquireMovies;

import io.reactivex.Observable;

public class MovieController {

    public static void main(String[] args) {
        Observable<Movie> movieObservable = aquireMovies();
        movieObservable.subscribe(Director.addMovieToDirectorsCreation());
        movieObservable.subscribe(Rating.addMovieToRating());
        movieObservable.toList().subscribe(MovieStatistics.movieStatistics());
    }


}
