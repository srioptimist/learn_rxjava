package nl.sri.observable;

import java.util.Arrays;

import io.reactivex.Observable;

public class IterableMap {

    public static void main(String[] args) {
        Observable<String> observable = Observable.fromIterable(Arrays.asList("one", "two", "three", "four", "five"));
        observable.subscribe(System.out::println);
        observable.map(String::toUpperCase).subscribe(System.out::println);
        observable.flatMap(result -> Observable.just(result.concat("test"))).subscribe(System.out::println);
    }
}
