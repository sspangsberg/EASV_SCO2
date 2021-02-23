package simplesearching;

import java.util.List;

/**
 *
 * @author spangsberg
 */
public class Searcher {
    private ISearchStrategy strategy;

    public Searcher(ISearchStrategy strategy) {
        this.strategy = strategy;
    }
    
    public <T extends Comparable<T>> int executeSearch(List<T> objects, T wanted) {
        return strategy.doSearch(objects, wanted);
    }
}
