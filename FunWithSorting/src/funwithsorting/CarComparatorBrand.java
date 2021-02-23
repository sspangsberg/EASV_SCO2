
package funwithsorting;

import java.util.Comparator;

/**
 *
 * @author smsj
 */
public class CarComparatorBrand implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }    
}
