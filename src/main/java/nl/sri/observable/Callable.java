package nl.sri.observable;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class Callable {

    public static void main(String[] args) {
        Observable<List<String>> observable = Observable.fromCallable(() ->
                Arrays.asList("one", "two", "three", "four", "five")
        );
        observable.subscribe(result -> result.forEach(System.out::println));
        observable.subscribe(System.out::println);
        observable.flatMap(r -> Observable.fromIterable(r)).subscribe(System.out::println);
        observable.map(Observable::just).subscribe(System.out::println);
    }
}
