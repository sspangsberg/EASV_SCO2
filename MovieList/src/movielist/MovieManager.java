package movielist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class MovieManager {
    List<Movie> movieList = new ArrayList<Movie>();    
    
    public void addMovies(List<Movie> moviesToAdd) {
        movieList.addAll(moviesToAdd);
    }
    
    public List<Movie> getMovies() {
        return movieList;
    }
    
    
    
    /*
    
    */
    public void addMovies(Movie... m) {
        for (Movie movie : m) {
            movieList.add(movie);
        }
    }
    
    
    
    @Override
    public String toString() {
        return "MovieManager{" + "movieList=" + movieList + '}';
    }
}
