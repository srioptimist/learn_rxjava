package nl.sri.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Array {

    public static void main(String[] args) {
        Observable<String> observable = Observable.fromArray("sunday","monday","tuesday","wednesday","thursday","friday", "saturday");
        observable.subscribe(System.out::println);
    }


}
