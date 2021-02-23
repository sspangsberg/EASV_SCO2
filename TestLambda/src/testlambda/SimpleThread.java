package testlambda;

/**
 * Class that implements a Functional Interface (ONE method to implement only)
 */
public class SimpleThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Hey! I'm a simple and runnable thread :)");
    }
}
