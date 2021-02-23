
package funwithhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javafx.scene.control.CustomMenuItem;

/**
 *
 * @author Søren Spangsberg
 */
public class FunWithHashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //hashSetMapTest();
        performanceTest();
    } 
    
    
    
    private static void hashSetMapTest() {
        //Set<Customer> customers = new HashSet();
        Map<String,Customer> customers = new HashMap();
        
        Customer c1 = new Customer("26580128", "Søren Spangsberg", "smsj@easv.dk");
        Customer c2 = new Customer("11111111", "Mr. Burns", "mr@burns.com");
        Customer c3 = new Customer("11111112", "Mr. Burns", "mr@burns.com");
        
        //equals
        if (c2.equals(c3))
            System.out.println("c2 is equal to c3");
        else
            System.out.println("c2 is not equal to c3");
        
        Customer c4 = new Customer("99999999", "Elon Musk", "emj@tesla.com");
        
        //HashMap
        customers.put(c1.getPhoneNumber(), c1);
        customers.put(c2.getPhoneNumber(), c2);
        customers.put(c3.getPhoneNumber(), c3);
        //customers.put("11111112", c3);
        
        
        //iterate through keys
        for (String key : customers.keySet()) {
            System.out.println("Key:" + key);
        }

        //iterate through values
        for (Customer c : customers.values()) {
            System.out.println("Customer:" + c);
        }

//        customers.add(c1);
//        customers.add(c2);
//        customers.add(c3);        
//       // customers.add(c3);
////   
////        for (Customer customer : customers) {
////            System.out.println(customer);
////        }
//        
//        Iterator<Customer> it = customers.iterator();
//        
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
        
        
        
//        Map<String, String> languages = new HashMap();
//        
//        
//        languages.put("Java", "Compiled high level, OOP, platform independant language");
//        languages.put("Python", "Interpreted, OOP, high-level language");
//        languages.put("Algol", "Algorithmic language");
//        languages.put("BASIC", "Beginners All-Purposes Symbolic Instruction Code");
//        languages.put("LISP", "Therin lies madness");
//        
////        System.out.println(languages.get("Java"));
////        languages.put("Java", "Another entry about Java.");
//        
//        for (String key: languages.keySet()) {
//            System.out.println(languages.get(key));
//        }
//        
//        System.out.println(languages.get("Java"));


        Object o = new Object();
        o.equals(o);
        "tester".equals("");
    }
    
    
    
    
    /**
     * 
     */
    private static  void performanceTest() {
        final int SIZE = 20_000_000;
        
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
