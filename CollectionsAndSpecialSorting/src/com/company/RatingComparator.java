package com.company;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2)
    {
        return movie1.getRating().compareTo(movie2.getRating());
    }
}
