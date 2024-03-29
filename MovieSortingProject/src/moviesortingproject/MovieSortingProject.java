
package moviesortingproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.SortOrder;

/**
 *
 * @author Søren Spangsberg
 */
public class MovieSortingProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList();
        
        Movie m1 = new Movie(1,"Terminator 2","James Cameron", "SCI-FI action", 2010,8.5);
        Movie m2 = new Movie(2,"Dumb and dumber","Peter Farrelly", "Comedy", 1994, 7.3);
        Movie m3 = new Movie(3,"Inception","Christopher Nolan", "SCI-FI action", 2010, 8.8);
        Movie m4 = new Movie(4,"The Dark Knight","Christopher Nolan", "Action Chrime Drama", 2008, 9.0);
        Movie m5 = new Movie(5,"Four Weddings and a Funeral","Mike Newel", "Comedy Drama Romance", 1994, 7.0);
        Movie m6 = new Movie(6,"Die Hard","John McTiernan", "Acion Thriller", 1988, 8.2);
        
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
        movies.add(m5);
        movies.add(m6);
        
        Collections.shuffle(movies);



        /*
        //Create object from class "classic way"
        //Comparator<Movie> titleSort = new TitleComparator();
        Comparator<Movie> ratingSort = new RatingComparator();

        Comparator<Movie> reversedComparator = Collections.reverseOrder(ratingSort);
        */

        //Lambda expression Comparator<Movie>
        Comparator<Movie> titleSort = (Movie first, Movie second) -> first.getTitle().compareTo(second.getTitle());


        //Collections.sort(movies, titleSort);

        Comparator<Movie> ratingSortLambda = (Movie first, Movie second) -> {

            //return first.getRating() - second.getRating();

            //explicit syntax
            /*
            if (first.getRating() < second.getRating())
                return -1;
            else if (first.getRating() > second.getRating())
                return 1;
            else
                return 0;
            */

            //shorter syntax
            return Double.compare(first.getRating(),second.getRating());
        };



        //Compare by productionYear and then rating (multiple properties)
        //Method references

        Comparator<Movie> compareByChaining = Comparator
                .comparing(Movie::getProductionYear)
                .thenComparing(Movie::getRating);

        Collections.sort(movies, compareByChaining);

        //reverse it
        //Comparator<Movie> reversedComparator = Collections.reverseOrder(titleSort);

        //Collections.sort(movies); //sort using Movie's compareTo() method
        
        for (Movie m: movies) {
            System.out.println(m);
        }        
    }
}
