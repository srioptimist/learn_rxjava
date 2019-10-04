package nl.sri.observable;

import io.reactivex.Observable;

public class GroupBy {

    public static void main(String[] args) {
        Observable.fromArray(new Integer[]{1,2,3,4,5,6,7,8,9,0})
                .groupBy(i -> 0 == (i % 2) ? "EVEN" : "ODD")
                .subscribe(group ->
                        group.subscribe((number) -> {
                            if (group.getKey().equals("EVEN")) {
                                System.out.println("EVEN " + number);
                            } else {
                                System.out.println("ODD " + number);
                            }
                        })
                );
    }
}
