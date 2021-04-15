package funwithsearching;

// Java imports
import java.util.List;

/**
 * @author spangsberg
 */
public interface ISearchStrategy  {
    
    /**
     *
     * Generic Search Strategy definition.
     * Using "bounded type parameters" with <T extends Comparable<T>>
     * doSearch() only accept types that either implements the Comparable interface
     * or extends a class that implements the Comparable interface.
     *
     * @param <T>
     * @param objects
     * @param wanted
     * @return 
     */
    public <T extends Comparable<T>> T doSearch(List<T> objects, T wanted);
}
