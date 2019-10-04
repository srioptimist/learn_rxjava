package nl.sri.observable.movie;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DisplayMovieByDirector {

    public static Observer<Map<String, List<String>>> displayMovieByDirector() {
       return new Observer<Map<String, List<String>>>() {
           @Override
           public void onSubscribe(Disposable disposable) {
               System.out.println("DisplayMovieByDirector observer subscribed to the movie director observable");
           }

           @Override
           public void onNext(Map<String, List<String>> movies) {
               movies.keySet().iterator().forEachRemaining(director -> {
                   System.out.println("Director " + director + " has created " + movies.get(director));
               });
           }

           @Override
           public void onError(Throwable throwable) {
               System.out.println("DisplayMovieByDirector encountered an error");
           }

           @Override
           public void onComplete() {
               System.out.println("DisplayMovieByDirector observer completed");
           }
       };
    }
}
