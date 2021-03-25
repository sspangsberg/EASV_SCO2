package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Movie> movies = new ArrayList<>();

//	    movies.add(new Movie(1, "Terminator 2:Judgement Day", "James Cameron", "Action",1991, 8.5));
//        movies.add(new Movie(2, "Interstellar", "Christopher Nolan", "Adventure, Drama, Sci-Fi",2014, 8.6));
//        movies.add(new Movie(3, "Spaceballs", "Mel Brooks", "Adventure, Comedy, Sci-Fi",1987, 7.1));
//        movies.add(new Movie(4, "The Simpsons Movie", "David Silverman", "Animation, Adventure, Comedy",2007, 7.3));
//        movies.add(new Movie(5, "Inception", "Christopher Nolan", "Action, Adventure, Sci-Fi", 2010, 8.8));
//        movies.add(new Movie(6, "Disaster Movie", "Jason Friedberg, Aaron Seltzer", "Comedy, Sci-Fi", 2008, 1.9));

        movies.add(new Movie(1, "Terminator 2:Judgement Day", "James Cameron", "Action",1991, 8.0));
        movies.add(new Movie(2, "Interstellar", "Christopher Nolan", "Adventure, Drama, Sci-Fi",2010, 8.0));
        movies.add(new Movie(3, "Spaceballs", "Mel Brooks", "Adventure, Comedy, Sci-Fi",1987, 8.0));
        movies.add(new Movie(4, "The Simpsons Movie", "David Silverman", "Animation, Adventure, Comedy",2010, 8.0));
        movies.add(new Movie(5, "Inception", "Christopher Nolan", "Action, Adventure, Sci-Fi", 2010, 8.0));
        movies.add(new Movie(6, "Disaster Movie", "Jason Friedberg, Aaron Seltzer", "Comedy, Sci-Fi", 2010, 8.0));


        Collections.shuffle(movies);
        System.out.println("\nAfter shuffle:");
        printArray(movies);

        Collections.sort(movies);
        System.out.println("\nAfter sort:");
        printArray(movies);

        Collections.sort(movies, new RatingComparator());
        System.out.println("\nAfter RatingComparator sort:");
        printArray(movies);

        //Lambda expression comparator
        Comparator<Movie> titleComparatorLambda = (Movie movie1, Movie movie2) -> {
            return movie1.getTitle().compareTo(movie2.getTitle());
        };

        //Comparator.comparing() (we avoid writing the compareTo logic)
        Comparator<Movie> titleComparatorComparing = Comparator.comparing(Movie::getDirector);

        //Chained comparator (allows us to specify sorting order)
        Comparator chainedComparator = Comparator.comparingDouble(Movie::getRating)
                                                 .thenComparingInt(Movie::getProductionYear)
                                                 .thenComparing(Movie::getDirector)
                                                 .thenComparing(Movie::getTitle);


        //Comparator c = Collections.reverseOrder(chainedComparator);
        Collections.sort(movies, chainedComparator);
        System.out.println("\nAfter TitleComparator sort:");
        printArray(movies);
    }

    private static void printArray(List<Movie> movies) {
        for (Movie m: movies) {
            System.out.println(m);
        }
    }

}
