package nl.sri.observable.movie;

import static java.util.stream.Collectors.groupingBy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class MovieStatistics {

    public static SingleObserver<List<Movie>> movieStatistics() {
        return new SingleObserver<List<Movie>>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("MovieStatistics single observer subscribed to movie observable");
            }

            @Override
            public void onSuccess(List<Movie> movies) {
                System.out.println("Total movies created " + movies.size());
                final Map<Integer, List<Movie>> moviesGroupByYear = movies.stream().collect(groupingBy(Movie::getYear)).entrySet().stream().filter(e -> e.getValue().size() > 1).sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e, e1) -> e, LinkedHashMap::new));
                moviesGroupByYear.keySet().stream().forEach(
                        year -> {
                            System.out.println("Movies release in year " + year + " are ");
                            moviesGroupByYear.get(year).forEach(movie -> System.out.println(movie.getName()));
                        }
                );
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error encountered by MovieStatisctics single observer");
            }
        };
    }
}
