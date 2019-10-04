package nl.sri.observable.movie;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DisplayMovieByRating {

    public static Observer<Map<String, Double>> displayMovieByRating() {
       return new Observer<Map<String, Double>>() {
           @Override
           public void onSubscribe(Disposable disposable) {
               System.out.println("DisplayMovieByRating observer subscribed to the movie director observable");
           }

           @Override
           public void onNext(Map<String, Double> movies) {
               movies.keySet().iterator().forEachRemaining(movie -> {
                   System.out.println("Movie " + movie + " has rating " + movies.get(movie));
               });
           }

           @Override
           public void onError(Throwable throwable) {
               System.out.println("DisplayMovieByRating encountered an error");
           }

           @Override
           public void onComplete() {
               System.out.println("DisplayMovieByRating observer completed");
           }
       };
    }
}
