package nl.sri.observable.movie;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Rating {

    private static final Map<String, Double> movieRating = new HashMap<>();

    public static Observer<Movie> addMovieToRating(){
        return new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Rating observer subscribed to the movie observable");
            }

            @Override
            public void onNext(Movie movie) {
                movieRating.put(movie.getName(),movie.getRating());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Rating observer encountered an error");
            }

            @Override
            public void onComplete() {
                final Map<String, Double> sortedMovieRating = movieRating.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e, e1) -> e, LinkedHashMap::new));
                Observable<Map<String, Double>> observable = Observable.just(sortedMovieRating);
                observable.subscribe(DisplayMovieByRating.displayMovieByRating());
                System.out.println("Rating observer completed");
            }
        };
    }
}
