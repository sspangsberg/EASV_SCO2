package funwithsearching;

// Java imports
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class Searcher {
    private ISearchStrategy strategy;

    /**
     * Constructor that sets the chosen ISearchStrategy object
     * @param strategy
     */
    public Searcher(ISearchStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Primary search method of the Searcher
     * @param objects
     * @param wanted
     * @param <T>
     * @return
     */
    public <T extends Comparable<T>> T doSearch(List<T> objects, T wanted) {
        return strategy.doSearch(objects, wanted);
    }
}
