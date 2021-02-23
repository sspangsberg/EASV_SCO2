package simplesearching;

import java.util.List;

/**
 *
 * @author spangsberg
 */
public interface ISearchStrategy  {
    
    /**
     * 
     * @param <T>
     * @param objects
     * @param wanted
     * @return 
     */
    public <T extends Comparable<T>> int doSearch(List<T> objects, T wanted);
}
