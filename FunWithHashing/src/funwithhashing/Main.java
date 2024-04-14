
package funwithhashing;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Søren Spangsberg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

     //funWithHashing();
     //hashSetMapTest();
     //performanceTest();
     hashMapThreadSafetyTest();

    }

    /**
     *
     */
    private static void hashMapThreadSafetyTest() throws InterruptedException {

        final int NUMBER_OF_THREADS = 2;
        final int NUMBER_OF_ITEMS = 1000;

        //Map<Country, Country> myMap = new HashMap<>(); // requires "syncronized" block around myMap
        Map<Country, Country> myMap = Collections.synchronizedMap(new HashMap<>()); // not scalable, allows null value/key
        //Map<Country, Country> myMap = new ConcurrentHashMap<>(); // scalable, performs better in concurrent environment (allows read and write operations concurrently)


        List<Thread> listOfThreads = new ArrayList<>();

        // Create X Threads
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Thread thread = new Thread(() -> {


                // Let Each thread insert X Items
                for (int j = 0; j < NUMBER_OF_ITEMS; j++) {
                    Country key = new Country(j + "");

                    //synchronized (myMap) {
                        myMap.put(key, key);
                    //}
                }

            });
            thread.start();
            listOfThreads.add(thread);
        }

        for (Thread thread : listOfThreads) {
            thread.join();
        }

        System.out.println("Count should be " + NUMBER_OF_THREADS * NUMBER_OF_ITEMS + ", actual is : " + myMap.size());
    }


    /**
     *
     */
    private static void hashSetMapTest() {
        Customer c1 = new Customer("22222222", "Homer Simpsons", "homer@simpsons.com");
        Customer c2 = new Customer("11111111", "Mr. Burns", "mr@burns.com");
        Customer c3 = new Customer("11111112", "Mr. Burns", "mr@burns.com");

        //Set<Customer> customers = new HashSet();
        //Exercise 1
        Map<String,Customer> customersMap = new HashMap();


        String email = "smsj@easv.dk";

        email.hashCode();





        //HashMap
        customersMap.put(c1.getPhoneNumber(), c1);
        customersMap.put(c2.getPhoneNumber(), c2);
        customersMap.put(c3.getPhoneNumber(), c3);
        customersMap.put("11111112", c3); //HashMap does not allow duplicate keys, but allows duplicate values

        System.out.println("Retrieving customer with phone# 11111112:" + customersMap.get("11111112"));


        //iterate through keys
        for (String key : customersMap.keySet()) {
            System.out.println("Key:" + key);
        }

        //iterate through values
        for (Customer c : customersMap.values()) {
            System.out.println("Customer:" + c);
        }


//        //Exercise 2
//        HashSet<Customer> customersSet = new HashSet<>();
//        customersSet.add(c1);
//        customersSet.add(c2);
//        customersSet.add(c3);
//        customersSet.add(c3);
//
////        for (Customer customer : customers) {
////            System.out.println(customer);
////        }
//
//        Iterator<Customer> it = customersSet.iterator();
//
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
    }

    
    /**
     * 
     */
    private static  void performanceTest() {
        final int SIZE = 5_000_000;


        String test = "12345";

        test.hashCode();

        HashMap hm = new HashMap(SIZE);
        Hashtable ht = new Hashtable();
        HashSet hs = new HashSet();

        final String WANTED = "The droid you have been looking for ;)";

        System.out.println("Initializing items......");
        
        //HashMap O(1) - constant time
        hm.put("MyKeyNumber: " + SIZE + 1, WANTED);
        for (int i = 0; i < SIZE; i++)
            hm.put("MyKeyNumber: " + i, "Not the droid you are looking for");
        
        
        //HashSet (Does not allow duplicate values...)
        hs.add(WANTED);
        for (int i = 0; i < SIZE; i++)
            hs.add(i + "Not the droid you are looking for");


        //Hashtable (Deprecated / Obsolete) O(1) - constant time
        ht.put("MyKeyNumber: " + SIZE + 1, WANTED);
        for (int i = 0; i < SIZE; i++)
            ht.put("MyKeyNumber: " + i, "Not the droid you are looking for");


        //ArrayList (linear) O(N) - linear time
        ArrayList<String> al = new ArrayList();
        for (int i = 0; i < SIZE + 1; i++)
            al.add("Not the droid you are looking for");

        al.add(WANTED);


        System.out.println("Initializing items......Done");
        System.out.println("--------------------------------------------");

        System.out.println("Fetching from HashMap:");
        long start = System.currentTimeMillis();
        System.out.println("Trying to find droid... " + hm.get("MyKeyNumber: " + SIZE + 1));
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start)/1000f + " sek");

        System.out.println("--------------------------------------------");
        System.out.println("Fetching from HashTable:");
        start = System.currentTimeMillis();
        System.out.println("Trying to find droid... " + ht.get("MyKeyNumber: " + SIZE + 1));
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start)/1000f + " sek");

        System.out.println("--------------------------------------------");
        System.out.println("Fetching from HashSet:");
        start = System.currentTimeMillis();
        System.out.println("Trying to find droid... ");

        Iterator<String> it = hs.iterator();

        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("The droid you have been looking for ;)") ) {
                System.out.println(str);
                break;
            }
        }

        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start)/1000f + " sek");


        System.out.println("--------------------------------------------");
        System.out.println("Fetching from ArrayList:");
        start = System.currentTimeMillis();
        System.out.print("Trying to find droid... ");
        long lookups=0;

        it = al.iterator();

        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("The droid you have been looking for ;)") ) {
                System.out.println("FOUND IT!:" + str);
                break;
            }
        }

        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start)/1000f + " sek");
    }


    /**
     * Experimenting with Hash-based data structures
     */
    private static void funWithHashing() {

//        Set<Country> countries = new HashSet<>();
//
//        Country c1 = new Country("Sweden");
//        Country c2 = new Country("Denmark");
//        Country c3 = new Country("Denmark");
//
//        countries.add(c1);
//        countries.add(c2);
//        countries.add(c3);
//
//        System.out.println(c2.equals(c3));
//
//        for (Country country: countries) {
//            System.out.println(country);
//        }
//
//        countries.remove("England");
//
//        System.out.println("---------------------------------------");
//
//
//        for (Country country: countries) {
//            System.out.println(country);
//        }

        Map<Country, String> countries = new HashMap<>();

        Country c1 = new Country("Italy");
        Country c2 = new Country("France");
        Country c3 = new Country("Finland");

        countries.put(c1, "Rome");
        countries.put(c2, "Paris");
        countries.put(c3, "Helsinki");

        //retrieval
        System.out.println("Retrieval: " + countries.get(new Country("Finland")));

//        //iteration
//        for (Country key: countries.keySet()) {
//            System.out.println(countries.get(key));
//        }
//
//        //removal
//        //countries.remove("Spain");
//
//        System.out.println("--------------------------------------");
//
//        //iteration
//        for (Country key: countries.keySet()) {
//            System.out.println(countries.get(key));
//        }
    }

}

class TempValue {
    int value = 3;


    @Override
    public int hashCode() {
        return 1; // All objects of this class will have same hashcode.
    }

}
