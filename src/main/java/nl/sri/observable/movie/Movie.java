package nl.sri.observable.movie;

import java.util.List;

import lombok.Value;

@Value
public class Movie {

    private String name;
    private int year;
    private String director;
    private List<String> cast;
    private Double rating;
}
