package funwithrecursion;

import java.time.Duration;
import java.time.Instant;

/**
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
        //helloWorldIterative(5);

        //countDown(10);

        //System.out.println("Sum iterative:" + sumIterative(5));
        System.out.println("Sum recursive:" + sumRecursive(4)); // 5+4+3+2+1

        //move(3,'A','B','C');
        //System.out.println("Moves: " + Math.pow(2, 3));
    }

    /**
     * Prints Hello World n times based on a recursive approach
     *
     * @param n
     */
    public static void helloWorldRecursive(int n) {
        System.out.println("Hello World"); // base case
        if (n > 0) { //recursive call
            helloWorldRecursive(n - 1);
        }
    }

    /**
     * Prints Hello World n times based on an iterative approach
     *
     * @param n
     */
    public static void helloWorldIterative(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello World");
        }
    }


    /**
     * Sums up all numbers from n to 0 using a RECURSIVE approach
     * @param n
     * @return
     */
    public static int sumRecursive(int n) {
        if (n > 0) {
            return sumRecursive(n - 1) + n;
        }
        return 0;
    }

    /**
     * Sums up all numbers from n to 0 using an ITERATIVE approach
     * @param n
     * @return
     */
    public static int sumIterative(int n) {
        int total = 0;

        for (int i = 0; i <= n ; i++) {
            total = total + i;
        }
        return total;
    }


    /**
     * Calculate the factorial number of N. Ex. factorial(4) = 3*2*1 = 6
     *
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
     *
     * @param n
     * @return
     */
    public static long factorialRecursive(int n) {

        //Recursive solution
        if (n == 0) //base case, where we backtrack    
            return 1;
        else //we are not at the base case yet, continue recursive calls           
            return (n * factorialRecursive(n - 1));
    }

    /**
     * @param arr
     * @param key
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;
        } else {
            int m = (left + right / 2);
            int value = arr[m];

            if (key == value)
                return m;//base case
            else if (key < value)
                return binarySearch(arr, key, left, m - 1);
            else
                return binarySearch(arr, key, m + 1, right);
        }
    }



    /**
     * Recursive algorithm that implements a solution to the Towers of Hanoi
     * Time Complexity: O(2^N)
     *
     * @param n
     * @param sourceTower
     * @param targetTower
     * @param tmpTower
     */
    public static void move(int n, char sourceTower, char targetTower, char tmpTower) {
        if (n > 1)
            move(n - 1, sourceTower, tmpTower, targetTower);

        System.out.println("Moves one disc from " + sourceTower + " to " + targetTower);

        if (n > 1)
            move(n - 1, tmpTower, targetTower, sourceTower);
    }


    /**
     * @param counter
     */
    public static void countDown(int counter) {
        System.out.print(counter + " "); //base case
        if (co+unter > 0) //recursive call
            countDown(counter - 1); // countDown() calls itself!!!!

        /*
        countDown(5)     5
        countDown(5 - 1) 5 4
        countDown(4 - 1) 5 4 3
        countDown(3 - 1) 5 4 3 2
        countDown(2 - 1) 5 4 3 2 1
        countDown(1 - 1) 5 4 3 2 1 0
        false
        
        */
        //System.out.println("");

//        for (int i = counter; i > 0; i--)
//          System.out.print(i + " ");

    }
}
