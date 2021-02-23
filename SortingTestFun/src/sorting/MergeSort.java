package sorting;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author spangsberg
 */
public class MergeSort {
    
    /**
     * Starter method, including time measurement
     * @param arr
     * @param left
     * @param right 
     */
    public void sort(int[] arr, int left, int right) {
    
        Instant start = Instant.now();
        
        int[] tmp = new int[arr.length];        
        mergeSort(arr, tmp, 0, arr.length - 1);
        
        Instant finish = Instant.now();
        
        long elapsedTime = Duration.between(start, finish).toMillis();
        
        System.out.println("Finished MergeSort on " + arr.length + " items in " + elapsedTime + " ms");       
    }
    
   
    /**
     * Recursive "core" method in the sorting algorithm
     * @param arr
     * @param tmp
     * @param left
     * @param right 
     */
    public void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2; //find the center index in our array
            
            mergeSort(arr, tmp, left, center); //sort left part
            mergeSort(arr, tmp, center + 1, right); //sort right part
            merge(arr, tmp, left, center + 1, right);
        }
    }
    
    
    /**
     * Merge the two arrays into one
     * @param arr
     * @param tmp
     * @param left
     * @param right
     * @param rightEnd 
     */
    private void merge(int[] arr, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right])
                tmp[k++] = arr[left++];
            else
                tmp[k++] = arr[right++];
        }
        
        while (left <= leftEnd) {
            tmp[k++] = arr[left++];
        }
        
        while (right <= rightEnd) {
            tmp[k++] = arr[right++];
        }
            
        for (int i = 0; i < num; i++, rightEnd--) {
            arr[rightEnd] = tmp[rightEnd];            
        }
    }
}
