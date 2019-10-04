package nl.sri.observable;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleExample {

    public static void main(String[] args) {
        String[] result = {""};
        Single<String> single = Observable.just("Hello").singleOrError()
                .doOnSuccess(i -> result[0] += i)
                .doOnError(error -> {
                    throw new RuntimeException(error.getMessage());
                });
        single.subscribe();

        assertTrue(result[0].equals("Hello"));
    }
}
