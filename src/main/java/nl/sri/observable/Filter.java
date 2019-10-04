package nl.sri.observable;

import io.reactivex.Observable;

public class Filter {

    public static void main(String[] args) {
        Observable.fromArray(new Integer[]{1,2,3,4,5,6,7,8,9,0})
                .filter(i -> (i % 2 == 0) )
                .subscribe(System.out::println);
    }
}
