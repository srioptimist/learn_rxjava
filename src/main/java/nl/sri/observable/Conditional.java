package nl.sri.observable;

import io.reactivex.Observable;

public class Conditional {

    public static void main(String[] args) {
        Observable.fromArray(new Integer[]{1,2,3,4,5,6,7,8,9})
                .last(0)
                .subscribe(System.out::println);

        Observable.fromArray(new Integer[]{1,2,3,4,5,6,7,8,9})
                .first(0)
                .subscribe(System.out::println);

        Observable.fromArray(new Integer[]{1,2,3,4,5,6,7,8,9})
                .take(5)
                .subscribe(System.out::println);

        Observable.fromArray(new Integer[]{1,2,3,4,5,6,7,8,9})
                .takeWhile(i -> i<3)
                .subscribe(System.out::println);

        Observable.fromArray(new Integer[]{1,2,3,4,5,6,7,8,9})
                .skip(2)
                .subscribe(System.out::println);
    }
}
