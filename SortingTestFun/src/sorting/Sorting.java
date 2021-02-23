/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 *
 * @author spangsberg
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        //Generate some random numbers
        int[] int10000 = generateRandomNumbers(10000,10);
        int[] int20000 = generateRandomNumbers(20000,10);
        int[] int40000 = generateRandomNumbers(40000,10);
        int[] int80000 = generateRandomNumbers(80000,10);
        /*        
        //sort the data
        bubbleSort(int10000);        
        bubbleSort(int20000);        
        bubbleSort(int40000);        
        bubbleSort(int80000); 
        
        
        System.out.println("------------------------------------------------");       
      
        
        
        //Generate some random numbers
        int10000 = generateRandomNumbers(10000,10);
        int20000 = generateRandomNumbers(20000,10);
        int40000 = generateRandomNumbers(40000,10);
        int80000 = generateRandomNumbers(80000,10);
      */          
        //sort the data
        insertionSort(int10000);        
        insertionSort(int20000);        
        insertionSort(int40000);        
        insertionSort(int80000); 
        
        System.out.println("------------------------------------------------");       
        
        
        int10000 = generateRandomNumbers(10000,10);
        int20000 = generateRandomNumbers(20000,10);
        int40000 = generateRandomNumbers(40000,10);
        int80000 = generateRandomNumbers(80000,10);

        QuickSort qs = new QuickSort(); 
        qs.quickSort(int10000, 0, int10000.length - 1);
        qs.quickSort(int20000, 0, int20000.length - 1);
        qs.quickSort(int40000, 0, int40000.length - 1);
        qs.quickSort(int80000, 0, int80000.length - 1);

        
        System.out.println("------------------------------------------------");       
                
        int10000 = generateRandomNumbers(10000,10);
        int20000 = generateRandomNumbers(20000,10);
        int40000 = generateRandomNumbers(40000,10);
        int80000 = generateRandomNumbers(80000,10);

//        Integer[] manyInts = generateRandomIntegers(8000000, 10);
        
//        
        MergeSort ms = new MergeSort();
        ms.sort(int10000, 0, 0);
        ms.sort(int20000, 0, 0);
        ms.sort(int40000, 0, 0);
        ms.sort(int80000, 0, 0);        
        
        //printArray(int80000);       
        
        
        /*
        //int[] int100 = generateRandomNumbers(100000, 1);
        //ob.quickSort(int100, 0, int100.length - 1);

        //for (int i = 0; i < int100.length; i++) {
            //System.out.print(int100[i] + ",");
            
        //}
        
        
        //int[] test = {1,10,25,32,56,79,111};
        //System.out.println("");
        //System.out.println("Result:" + binarySearch(int100, 20, 0, int100.length - 1));
      */  
        
    }
    
    
    public static int binarySearch(int[] arr, int key, int left, int right) {
        if (left > right) 
            return -1;           
        else {
            int m = (left + right) / 2;
            int value = arr[m];
            
            if (key == value)
                return m;//base case
            else if (key < value) 
                return binarySearch(arr, key, left , m-1);
            else
                return binarySearch(arr, key, m+1, right);
        }
    }
    
    
    private static Integer[] generateRandomIntegers(int size, int multiplier) {
        Integer[] randomNumbers = new Integer[size];
        Random r = new Random();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = r.nextInt(size * multiplier);
            //System.out.println(randomNumbers[i] + ",");
        }
        return randomNumbers;
    }
    

    private static int[] generateRandomNumbers(int size, int multiplier) {
        int[] randomNumbers = new int[size];
        Random r = new Random();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = r.nextInt(size * multiplier);
            //System.out.println(randomNumbers[i] + ",");
        }
        return randomNumbers;
    }

    
    
    private static int[] bubbleSort(int[] numbers) {

        Instant start = Instant.now();

        //O(N)
        for (int i = 1; i < numbers.length; i++) {
            //O(N^2)
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j]; //create temporary space

                    //swap elements
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        Instant finish = Instant.now();

        long elapsedTime = Duration.between(start, finish).toMillis();

        System.out.println("Finished BubbleSort on " + numbers.length + " items in " + elapsedTime + " ms");

        return numbers;
    }

    private static int[] insertionSort(int[] arr) {

        Instant start = Instant.now();

        //O(N)
        for (int i = 1; i < arr.length; i++) {
            
            int tmp = arr[i]; // move an element to a temporary location to create a
            int holeIndex = i; // hole in the list
            
            //O(N^2)
            while (holeIndex > 0 && arr[holeIndex - 1] > tmp) // move the hole to the correct position 
            {
                arr[holeIndex] = arr[holeIndex - 1];
                holeIndex--;
            }
            arr[holeIndex] = tmp; // insert the temporary element into the hole.
        }

        Instant finish = Instant.now();

        long elapsedTime = Duration.between(start, finish).toMillis();

        System.out.println("Finished InsertionSort on " + arr.length + " items in " + elapsedTime + " ms");

        return arr;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
