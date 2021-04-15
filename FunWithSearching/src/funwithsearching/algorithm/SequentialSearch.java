package funwithsearching.algorithm;

// Project imports
import funwithsearching.ISearchStrategy;

// Java imports
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class SequentialSearch implements ISearchStrategy {

    /**
     * Simple sequential search implementation that
     * @param objects
     * @param wanted
     * @param <T>
     * @return
     */
    @Override
    public <T extends Comparable<T>> T doSearch(List<T> objects, T wanted) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).equals(wanted))
                return objects.get(i);
        }        
        return null;
    } 
}
