package nl.sri.observable;

import io.reactivex.Observable;

public class Scan {

    public static void main(String[] args) {
        String[] letters = {"a", "b", "c"};
        Observable.fromArray(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(System.out::println);
    }
}
