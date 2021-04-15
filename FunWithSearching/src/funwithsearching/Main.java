package funwithsearching;

// Project imports
import funwithsearching.algorithm.BinarySearch;
import funwithsearching.algorithm.SequentialSearch;

// Java imports
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Performance measurement
        final int SIZE = 1_000_000;
        List<Movie> objects = new ArrayList<>();
        System.out.println("Loading Movies into list...");
        
        for (int i = 0; i < SIZE; i++) {
            objects.add(new Movie(i, "Awesome #" + i));
        }
        Movie wanted = new Movie(SIZE + 1, "Inception");
        objects.add(wanted); //add it last to get worst case performance time

        System.out.println("Done loading...");
                


        System.out.println("----------------------------------------------------------------");
        System.out.println("Sequential Search benchmark....");
        Searcher s = new Searcher(new SequentialSearch());

        long start = System.currentTimeMillis();

        Movie result = s.doSearch(objects, wanted);
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start) + " ms");        
        System.out.println("Search result (Sequential Search): " + result);


        //FIXME: change strategy to binary search and re-test
    }
}
