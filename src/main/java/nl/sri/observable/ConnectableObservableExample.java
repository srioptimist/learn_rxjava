package nl.sri.observable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableExample {

    public static void main(String[] args) throws InterruptedException {
        String[] result = {""};
        ConnectableObservable<Long> connectable
                = Observable.interval(200, TimeUnit.MILLISECONDS).publish();
        connectable.subscribe(i -> result[0] += i);
        System.out.println(result[0]);
        assertFalse(result[0].equals("01"));

        connectable.connect();
        Thread.sleep(500);
        System.out.println(result[0]);
        assertTrue(result[0].equals("01"));
    }
}
