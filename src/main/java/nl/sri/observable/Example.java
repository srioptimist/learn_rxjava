package nl.sri.observable;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class Example {

    public static void main(String[] args) {
        final Observable<String> observable = produceObservable();
        observable.subscribe(observer1());
        observable.subscribe(observer2());
        observable.toList().subscribe(observer3());
        observable.toList().subscribe(observer4());
    }

    private static Observable<String> produceObservable() {
        return Observable.fromArray("sunday","monday","tuesday","wednesday","thursday","friday", "saturday");
    }

    private static Observer<String> observer1() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("OnSubscribe observer1");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Received " + s + "from observable for observer1");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error observer1");
            }

            @Override
            public void onComplete() {
                System.out.println("OnComplete observer1");
            }
        };
    }

    private static Observer<String> observer2() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("OnSubscribe observer2");
            }

            @Override
            public void onNext(String s) {
                System.out.println("Received " + s + "from observable for observer2");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error observer2");
            }

            @Override
            public void onComplete() {
                System.out.println("OnComplete observer2");
            }
        };
    }

    private static SingleObserver<List<String>> observer3() {
        return new SingleObserver<List<String>>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("OnSubscribe observer3");
            }

            @Override
            public void onSuccess(List<String> s) {
                s.forEach(st -> System.out.println("Received " + st + "from observable for observer3"));
            }
            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error observer3");
            }

        };
    }

    private static SingleObserver<List<String>> observer4() {
        return new SingleObserver<List<String>>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("OnSubscribe observer4");
            }

            @Override
            public void onSuccess(List<String> s) {
                s.forEach(st -> System.out.println("Received " + st + "from observable for observer4"));
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error observer4");
            }
        };
    }
}
