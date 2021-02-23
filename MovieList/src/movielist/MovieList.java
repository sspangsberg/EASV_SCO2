
package movielist;


/**
 *
 * @author spangsberg
 */
public class MovieList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MovieManager mm = new MovieManager();
        
        Movie m1 = new Movie("Terminator 2");
        Movie m2 = new Movie("Dumb and dumber");
        Movie m3 = new Movie("Inception");
        
        mm.addMovies(m1, m2, m3);
        
        for (Movie m: mm.getMovies()) {
            System.out.println(m);
        }       
        
    } 
}
