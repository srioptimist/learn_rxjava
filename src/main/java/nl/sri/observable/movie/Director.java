package nl.sri.observable.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Director {

    private static final Map<String, List<String>> directorMovies = new HashMap<>();

    public static Observer<Movie> addMovieToDirectorsCreation() {
        return new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Director observer subscribed to the movie observable");
            }

            @Override
            public void onNext(Movie movie) {
                final String director = movie.getDirector();
                if (directorMovies.containsKey(director)) {
                    directorMovies.get(director).add(movie.getName());
                } else {
                    final List<String> m = new ArrayList<>();
                    m.add(movie.getName());
                    directorMovies.put(director, m);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Director observer encountered an error");
            }

            @Override
            public void onComplete() {
                Observable<Map<String, List<String>>> observable = Observable.just(directorMovies);
                observable.subscribe(DisplayMovieByDirector.displayMovieByDirector());
                System.out.println("Director observer completed");
            }
        };
    }
}
