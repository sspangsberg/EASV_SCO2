
package testlambda;

// Project imports
import testlambda.BE.ISquare;
import testlambda.BE.Movie;

// Java imports
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
        testLambda2();
    }

    /**
     * "Trivial" Lambda expression operations
     */
    public static void testLambda1() {

        // Create a generic list of movies
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1,2011, "Harry Potter",7.6));
        movies.add(new Movie(2,1991,"Terminator 2", 8.6));
        movies.add(new Movie(3,1984, "Terminator 1", 8.1));
        movies.add(new Movie(4,1972, "Godfather 1", 9.2));
        movies.add(new Movie(5,1999,"The Matrix", 8.7));

        //Regular for-loop
        System.out.println("Normal for-loop printout:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }
        
        System.out.println("------------------");

        // Lambda expression - single line
        System.out.println("Lambda expression printout:");
        movies.forEach((Movie movie) -> System.out.println(movie) );

        System.out.println("------------------");

        // Method reference
        System.out.println("Method reference printout: ");
        movies.forEach(System.out::println);

        // Streams with lambda
        List<Movie> filteredList = movies
                .stream()
                .filter(m -> m.getRating() > 8.5)
                .toList();

        System.out.println("Rating > 8.5:" + filteredList);

        filteredList = movies.stream().filter(m -> m.getTitle().contains("Terminator")).toList();

        System.out.println("Terminators:" + filteredList);

    }

    /**
     *  Threads, Runnables and Lambdas...
     */
    public static void testLambda2() {

        // Implementing Runnable functional interface under-the-hood
        new Thread(()-> {
            System.out.println("Printing from Lambda....");
            System.out.println("Test two");
            System.out.println("Test three");
        }).start();

        /*
        // Anonymous inner class - can also implement MULTIPLE methods from any interface...
        new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("Printing from inner anonymous class....");
                System.out.println("Test two");
                System.out.println("Test three");
            }
        }).start();
        */


        /*
        // This example does not create a new Thread, but only a Runnable object
        SimpleThread mySimpleThread = new SimpleThread();
        mySimpleThread.run();
        */


        // Now we run on a new and separate Thread :)
        Thread myCoolThread = new Thread(new SimpleThread());
        myCoolThread.start();
    }

    /**
     * Functional interfaces
     */
    public static void testLambda3() {
        
        // lambda expression to define the calculate method 
        ISquare s = ((x) -> {
            return x+x;
        });
        //Box b = new Box(); //Without Lambda - we need to create+compile class that implements the interface
                
        // parameter passed and return type must be 
        // same as defined in the prototype 
        //int result = s.calculate(5);
        //System.out.println(result);
        System.out.println(s.calculate(5));
    }    
}




