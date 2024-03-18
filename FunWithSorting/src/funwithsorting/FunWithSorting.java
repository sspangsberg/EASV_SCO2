
package funwithsorting;

import java.util.*;

import funwithsorting.Car;

/**
 *
 * @author smsj
 */
public class FunWithSorting {

    private static List<Car> cars = new ArrayList<Car>();
    private static Car[] carArray = new Car[4];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        setup();

        Collections.shuffle(cars);

        System.out.println("Before sort....");
        for (Car c: cars)
            System.out.println(c);
        System.out.println("------------------------------------------------------");

        //concreteComparator();
        //usingComparing();
        usingLambdas();
        //usingLambdas();
    }

    /**
     *
     */
    private static void setup() {
        // Collection
        Car c1 = new Car("VW", "Golf GTE", "blue", 215);
        Car c2 = new Car("Peugeot", "308 SW", "reaalyy green", 287);
        Car c3 = new Car("BMW", "320i", "black", 215);
        Car c4 = new Car("Tesla", "Model S", "red", 250);

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);

        // Array
        carArray[0] = c1;
        carArray[1] = c2;
        carArray[2] = c3;
        carArray[3] = c4;
    }

    /**
     * Concrete comparator class
     */
    private static void concreteComparator() {
        //Pre Java 8
        CarComparatorBrand carSortBrand = new CarComparatorBrand();

        System.out.println("Sort using concrete comparator class:");
        Collections.sort(cars, carSortBrand);
        for (Car c: cars)
            System.out.println(c);
    }

    /**
     *
     */
    private static void usingLambdas() {
        Comparator<Car> byBrand = (Car car1, Car car2) -> car1.getBrand().compareTo(car2.getBrand());
        Comparator<Car> byColor = (Car car1, Car car2) -> car1.getColor().compareTo(car2.getColor());
        Comparator<Car> byTopSpeed2 = (Car car1, Car car2) -> car1.getTopSpeed() - car2.getTopSpeed();
        Comparator<Car> byTopSpeed = (car1, car2) -> {
            if (car1.getTopSpeed() < car2.getTopSpeed()) //First object is smaller than the second: -1 // or negative
                return -1;
            else if (car1.getTopSpeed() > car2.getTopSpeed()) //First object is larger than the second: 1 //or positive
               return 1;
            else //They are equal: 0
                return 0;
        };

        System.out.println("Sort using lambda: (byColor)");

        Collections.sort(cars,byBrand);
        for (Car c: cars)
           System.out.println(c);
    }

    /**
     *
     */
    private static void usingComparing() {
        cars.sort(Comparator.comparing(Car::getTopSpeed).reversed().thenComparing(Car::getBrand));

        System.out.println("Sort using Comparator.comparing + thenComparing:");
        for (Car c: cars)
            System.out.println(c);
    }

    /**
     *
     */
    private static void usingStreams() {
        // Stream sort
        System.out.println("\n\nStream sort....");
        cars.stream()
                // normal compare lambda...
                .sorted((o1, o2)->o1.getModel().compareTo(o2.getModel()))

                // static function...
                //.sorted(Comparator.comparing(Car::getModel))

                .forEach(System.out::println);
    }

    private static void misc() {
        //        int[] numbers = {1,5,12,15,19,23,45,67,78,97 }
//        int key = 24;
//
//        int result = Arrays.binarySearch(numbers, key);
//
//        System.out.println(result);

//        Arrays.sort(carArray, Collections.reverseOrder(byTopSpeed2));
//        System.out.println("Looking for " + c3);
//        int result = Arrays.binarySearch(carArray, 0, carArray.length, c3);
//        System.out.println("Car found at index:" + result);
//
//        System.out.println("Arrays.sort()....");
//        for (Car c: carArray)
//            System.out.println(c);
    }
}
