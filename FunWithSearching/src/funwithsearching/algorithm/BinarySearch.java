package funwithsearching.algorithm;

// Project imports
import funwithsearching.ISearchStrategy;

// Java imports
import java.util.Collections;
import java.util.List;

/**
 * @author spangsberg
 */
public class BinarySearch implements ISearchStrategy {

    /**
     * Simple sequential search implementation that
     *
     * @param objects
     * @param wanted
     * @param <T>
     * @return
     */
    @Override
    public <T extends Comparable<T>> T doSearch(List<T> objects, T wanted) {
        // Javas built-in binarySearch
//        int index = Collections.binarySearch(objects, wanted);
//
//        if (index < 0) return null;
//        else
//            return objects.get(index);
//


        // Home-brewed implementation
        int low = 0;
        int high = objects.size() - 1;
        while (low < high) {
            int m = low / 2 + high / 2;
            if (wanted.compareTo(objects.get(m)) < 0) {
                high = m;
            } else {
                low = m + 1;
            }
        }

        if (objects.get(high).compareTo(wanted) == 0)
            return objects.get(high);
        else
            return null;
    }
}
