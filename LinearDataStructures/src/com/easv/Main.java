package com.easv;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Car c1 = new Car("VW", "Golf GTE", "blue", 215);
        Car c2 = new Car("Peugeot", "206 GTI", "green", 287);
        Car c3 = new Car("BMW", "m5", "black", 212);
        Car c4 = new Car("Tesla", "Model S", "red", 250);

        //ArrayList - start
        //Time Complexities:
        // add(element)        = O(1)
        // add(index, element) = O(N)
        // get(index)          = O(1)
        // remove(index)       = O(N)
        // List<Car> cars = new ArrayList<>();


        //LinkedList - start
        //Time Complexities:
        // add(element)        = O(1)
        // add(index, element) = O(1)
        // get(index)          = O(N)
        // remove(index)       = O(1)
        List<Car> cars = new LinkedList<>();


        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(0, c4);

        iterateCollection(cars);

        cars.remove(0);
        System.out.println("Car at index #2:" + cars.get(2));


//        List<String> names = new ArrayList<>();
//
//        names.add("John");
//        names.add("Peter");
//        names.add("Soren");
//        names.add("Tommy");
//
//        iterateCollection(names);


        // LinkedList
//        List<Car> linkedCars = new LinkedList<>();
//
//        cars.add(c1);
//        cars.add(c2);
//        cars.add(c3);
//        cars.add(c4);
//
//
//        iterateCollection(cars);

    }

    private static void iterateCollection(List<Car> collection) {
        for (Car c: collection) {
            System.out.println(c);
        }
    }

//    private static <T> void iterateCollection(Collection<T> collection) {
//        /*
//        for (T c: collection) {
//            System.out.println(c);
//        }
//        */
//
//        Iterator<T> it = collection.iterator();
//
//        //inspect the methods of the iterator
//
//        //iterate through it
//        while (it.hasNext()) {
//            T c = it.next();
//
//            System.out.println(c);
//        }
//    }
}
