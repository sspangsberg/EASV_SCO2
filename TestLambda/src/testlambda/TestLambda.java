
package testlambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class TestLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testLambda3();
    }

    public static void testLambda1() {
        
        List<String> movies = new ArrayList<>();

        movies.add("Harry Potter");
        movies.add("Terminator 2");
        movies.add("Terminator 1");
        movies.add("Godfather 1-3");
        movies.add("The Matrix");

        //Regular for-loop
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }
        
        System.out.println("------------------");

        //Lambda expression - single line
        movies.forEach((String movie) -> System.out.println(movie) );
    }   

    public static void testLambda2() {

                new Thread(()-> {
                System.out.println("Printing from Lambda....");
                System.out.println("Test two");
                System.out.println("Test three");
            }).start();

        /*
        // Anonymous inner class - can implement MULTIPLE methods from any interface...
        new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("Printing from inner annonymous class....");
            }
        }).start();
        */

        //now we run on a new and separate Thread :)
        //Thread myCoolThread = new Thread(new SimpleThread());
        //myCoolThread.start();

        //This example does not create a new Thread
        //SimpleThread mySimpleThread = new SimpleThread();
        //mySimpleThread.run();
    }

    public static void testLambda3() {
        
        // lambda expression to define the calculate method 
        ISquare s = ((x) -> {
            return x+x;
        });
        //Box b = new Box(); //Without Lambda - we need to create class that implements the interface
                
        // parameter passed and return type must be 
        // same as defined in the prototype 
        //int result = s.calculate(5);
        //System.out.println(result);
        System.out.println(s.calculate(5));
    }    
}




