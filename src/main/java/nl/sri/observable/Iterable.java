package nl.sri.observable;

import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Iterable {

    public static void main(String[] args) {
        Observable<String> observable = Observable.fromIterable(Arrays.asList("one", "two", "three", "four", "five"));
        observable.subscribe(System.out::println);
        observable.subscribe(word -> System.out.println(word + " " + Thread.currentThread().getName()));
        observable.subscribeOn(Schedulers.computation()).subscribe(word -> System.out.println(word + " " + Thread.currentThread().getName()));
        observable.subscribeOn(Schedulers.computation()).subscribe(word -> System.out.println(word + " " + Thread.currentThread().getName()), Throwable::printStackTrace, () -> System.out.println("completed"));
        observable.subscribeOn(Schedulers.io()).subscribe(word -> System.out.println(word + " " + Thread.currentThread().getName()));
        observable.subscribeOn(Schedulers.newThread()).subscribe(word -> System.out.println(word + " " + Thread.currentThread().getName()));
        observable.subscribeOn(Schedulers.single()).subscribe(word -> System.out.println(word + " " + Thread.currentThread().getName()));
        observable.subscribeOn(Schedulers.trampoline()).subscribe(word -> System.out.println(word + " " + Thread.currentThread().getName()));
    }
}
