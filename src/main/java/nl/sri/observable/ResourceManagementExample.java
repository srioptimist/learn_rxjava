package nl.sri.observable;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.reactivex.Observable;

public class ResourceManagementExample {

    public static void main(String[] args) {
        String[] result = {""};
        Observable<Character> values = Observable.using(
                () -> "MyResource",
                r -> {
                    return Observable.create(o -> {
                        for (Character c : r.toCharArray()) {
                            o.onNext(c);
                        }
                        o.onComplete();
                    });
                },
                r -> System.out.println("Disposed: " + r)
        );
        values.subscribe(
                v -> result[0] += v,
                e -> result[0] += e
        );
        assertTrue(result[0].equals("MyResource"));
    }
}
