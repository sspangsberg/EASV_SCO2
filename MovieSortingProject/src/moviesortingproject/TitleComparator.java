/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviesortingproject;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Søren Spangsberg
 */
class TitleComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        
        Collator titleCollator = Collator.getInstance(new Locale("da", "dk"));        
        return titleCollator.compare(o1.getTitle(), o2.getTitle());
        
        //return o1.getTitle().compareTo(o2.getTitle());
    }
}
