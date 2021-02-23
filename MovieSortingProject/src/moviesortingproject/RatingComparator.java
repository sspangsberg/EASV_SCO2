/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviesortingproject;

import java.util.Comparator;

/**
 *
 * @author Søren Spangsberg
 */
class RatingComparator implements Comparator<Movie> {

     @Override
     public int compare(Movie m1, Movie m2) {
         
         if (m1.getRating() < m2.getRating())
             return -1;
         else if (m1.getRating() > m2.getRating())
             return 1;
         else 
             return 0;  
     }
}
