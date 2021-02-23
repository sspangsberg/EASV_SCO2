package simplesearching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
        List<String> objects = new ArrayList<>();
        System.out.println("Loading strings into list...");
        
        for (int i = 0; i < SIZE; i++) {
            objects.add(new String("A string #" + i));            
        }
        String wanted = "The string I'm looking for";
        objects.add(wanted); //add it last to get worst case performance time
        
        System.out.println("Done loading...");
                
        //create a new Searcher object with a search strategy of SequentialSearch
        Searcher s = new Searcher(new SequentialSearch());
        
        long start = System.currentTimeMillis();
        int result = s.executeSearch(objects, wanted);
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start) + " ms");        
        System.out.println("Search result (Sequential Search): index:" + result + " ("+ objects.get(result) + ")");
        
        //FIXME: change strategy to binary search and re-test
    }
}
