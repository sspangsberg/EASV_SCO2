package funwithrecursion;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author spangsberg
 */
public class FunWithRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        //System.out.println(factorialIterative(5));
        //System.out.println(factorialRecursive(50));
        
        //helloWorldRecursive(5);
        
        //countDown(10);
        
        //System.out.println(sum(3));
        
        //move(3,'A','B','C');
        //System.out.println("Moves: " + Math.pow(2, 3));
    } 
    
    /**
     * Prints
     * @param n 
     */
    public static void helloWorldRecursive(int n) {
        if (n < 0)
            System.out.println("Hello World");
        else {
            System.out.println("Hello World");
            helloWorldRecursive(n - 1);
        }           
            
    }
    
    /**
     * 
     * @param n
     * @return 
     */
    public static int sum(int n) {
    if (n >= 1) {
        return sum(n - 1) + n;
    }
    return n;
}
    
    
    /**
     * Calculate the factorial number of N. Ex. factorial(4) = 3*2*1 = 6
     * @param n
     * @return 
     */
    public static long factorialIterative(int n) {        
        
        //Iterative solution
        long product = 1;
        
        for (int i = 1; i < n; i++) 
            product += product * i; 
        
        return product;
        
    }  
    
    /**
     * Calculate the factorial number of N. Ex. factorial(4) = 3*2*1 = 6
     * @param n
     * @return 
     */
    public static long factorialRecursive(int n) {        
        
        //Recursive solution
        if (n == 0) //base case, where we backtrack    
            return 1;         
        else //we are not at the base case yet, continue recursive calls           
            return(n * factorialRecursive(n-1)); 
    }  
    
    /**
     * 
     * @param arr
     * @param key
     * @param left
     * @param right
     * @return 
     */
    public static int binarySearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;           
        }
        else {
            int m = (left + right / 2);
            int value = arr[m];
            
            if (key == value)
                return m;//base case
            else if (key < value) 
                return binarySearch(arr, key, left , m-1);
            else
                return binarySearch(arr, key, m+1, right);
        }
    }
    
    
    /**
     * Recursive algorithm that implements a solution to the Towers of Hanoi 
     * Time Complexity: O(2^N)
     * @param n
     * @param sourceTower
     * @param targetTower
     * @param tmpTower 
     */
    public static void move(int n, char sourceTower, char targetTower, char tmpTower) {
        if (n > 1) 
            move(n-1, sourceTower, tmpTower, targetTower);       
        
        System.out.println("Moves one disc from " + sourceTower + " to " + targetTower);   
        
        if (n > 1)  
            move(n-1, tmpTower, targetTower, sourceTower);
    }
    
 
    /**
     * 
     * @param counter 
     */
    public static void countDown(int counter)
    {
        System.out.print(counter + " ");
        if (counter > 0) 
            countDown(counter - 1); // countDown() calls itself!!!! 
        
        /*
        
        countDown(5 - 1)
        countDown(4 - 1)
        countDown(3 - 1)
        countDown(2 - 1)
        countDown(1 - 1)
        false
        
        */
        
        
        //System.out.println("");
        //for (int i = counter; i > 0; i--) 
        //  System.out.print(i + " ");            
        
    }
    
    
    
}
