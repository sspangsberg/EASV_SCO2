package testlambda.BE;

/**
 * Class that implements our Functional Interface
 *
 * @author Søren Spangsberg
 */
class Box implements ISquare {

    @Override
    public int calculate(int x) {
        return x*x;
    }
}