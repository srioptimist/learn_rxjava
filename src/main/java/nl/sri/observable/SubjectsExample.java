package nl.sri.observable;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class SubjectsExample {

    private static Integer subscriber1 = 0;
    private static Integer subscriber2 = 0;

    public static void main(String[] args) {

        PublishSubject<Integer> subject = PublishSubject.create();
        subject.subscribe(getFirstObserver());
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
        subject.subscribe(getSecondObserver());
        subject.onNext(4);
        subject.onComplete();

        assertTrue(subscriber1 + subscriber2 == 14);
    }

    private static Observer<Integer> getFirstObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe1");

            }

            @Override
            public void onNext(Integer value) {
                System.out.println("subscribe1 onNext "+ value);
                subscriber1 += value;
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("Subscriber1 completed");
            }

        };
    }

    private static Observer<Integer> getSecondObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe2");

            }

            @Override
            public void onNext(Integer value) {
                System.out.println("subscribe2 onNext "+ value);
                subscriber2 += value;
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("Subscriber2 completed");
            }
        };
    }
}
