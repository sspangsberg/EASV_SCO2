
package funwithsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author smsj
 */
public class FunWithSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        int[] numbers = {1,5,12,15,19,23,45,67,78,97 }; 
        int key = 24;
        
        int result = Arrays.binarySearch(numbers, key);
        
        System.out.println(result);
        
        
        
        
        //Java - Lambda Expression
        Comparator<Car> byBrand = (Car car1, Car car2) -> car1.getBrand().compareTo(car2.getBrand());
        Comparator<Car> byColor = (Car car1, Car car2) -> car1.getColor().compareTo(car2.getColor());
        Comparator<Car> byTopSpeed2 = (Car car1, Car car2) -> car1.getTopSpeed() - car2.getTopSpeed();                
       
        
        
        Car c1 = new Car("VW", "Golf GTE", "blue", 215);
        Car c2 = new Car("Peugeot", "308 SW", "reaalyy green", 207);
        Car c3 = new Car("BMW", "320i", "black", 212);
        Car c4 = new Car("Tesla", "Model S", "red", 250);
       
        Car[] carArray = new Car[4];
        
        carArray[0] = c1;
        carArray[1] = c2;
        carArray[2] = c3;
        carArray[3] = c4;
        
        
        Arrays.sort(carArray);
        System.out.println("Looking for " + c3);
        result = Arrays.binarySearch(carArray, 0, carArray.length, c3);
        System.out.println("Car found at index:" + result);
        
        System.out.println("Arrays.sort()....");
        for (Car c: carArray)
            System.out.println(c);
        
        
        ArrayList<Car> cars = new ArrayList<Car>();
        
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        
        System.out.println("Before sort....");
        for (Car c: cars)
            System.out.println(c);
        
        //Pre Java 8
        CarComparatorBrand carSortBrand = new CarComparatorBrand();
                
           
//            if (car1.getTopSpeed() < car2.getTopSpeed())
//                return -1;
//            else if (car1.getTopSpeed() > car2.getTopSpeed())
//                return 1;
//            else
//                return 0;
            
         
            //return car1.getTopSpeed().compareTo(car2.getTopSpeed());       
       // };
        /*
        
        First object is smaller than the second: -1 // or negative
        They are equal: 0
        First object is larger than the second: 1 //or positive
        
        */
        
        
        Comparator<Car> byTopSpeed = (Car car1, Car car2) 
                -> car1.getTopSpeed() - car2.getTopSpeed();                
               
        Collections.sort(cars, byTopSpeed);
       
        System.out.println("After sort....");
        for (Car c: cars)
            System.out.println(c);
        
        
        
    }    
}
