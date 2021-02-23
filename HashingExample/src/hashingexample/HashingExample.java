
package hashingexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author sspangsberg
 */
public class HashingExample
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        final int SIZE = 5000000;
        
        HashMap hm = new HashMap(SIZE);
        HashSet hs = new HashSet();
        Hashtable ht = new Hashtable();
        
        System.out.println("Initializing items......");
        
        //HashMap O(1) - constant time
        hm.put("MyKeyNumber: " + SIZE + 1, "The droid you have been looking for ;)");
        for (int i = 0; i < SIZE; i++)
            hm.put("MyKeyNumber: " + i, "Not the droid you are looking for");
        
        
        //Hashtable (Obsolete) O(1) - constant time
        ht.put("MyKeyNumber: " + SIZE + 1, "The droid you have been looking for ;)");
        for (int i = 0; i < SIZE; i++)
            ht.put("MyKeyNumber: " + i, "Not the droid you are looking for");
        
        
        //ArrayList (linear) O(N) - linear time
        ArrayList<String> al = new ArrayList(hs);
        for (int i = 0; i < SIZE + 1; i++)
            al.add("Not the droid you are looking for");
        al.add("The droid you have been looking for ;)");
        
        System.out.println("Initializing items......Done");
                
        
        System.out.println("Fetching from hashmap:");
        
        long start = System.currentTimeMillis();
        System.out.println("Trying to find droid: " + hm.get("MyKeyNumber: " + SIZE + 1));
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start)/1000f + " sek");
        
        System.out.println("Fetching from hashtable:");
        start = System.currentTimeMillis();
        System.out.println("Trying to find droid: " + ht.get("MyKeyNumber: " + SIZE + 1));
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start)/1000f + " sek");
        
        System.out.println("Fetching from ArrayList:");
        long starta = System.currentTimeMillis();
        System.out.print("Trying to find droid: ");
        long lookups=0;
        

        for (String str : al)
        {
            lookups++;
            if(str.equals("The droid you have been looking for ;)"))
            {
                System.out.println(str);
                break;
            }
        }
        System.out.println("Lookups: " + lookups + " " + (System.currentTimeMillis()-starta)/1000f + " sek");
        
    }
    
}