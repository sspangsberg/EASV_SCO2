package testlambda.BE;

/**
 * Simple Functional Interface with single method to implement
 */
@FunctionalInterface
public interface ISquare
{
    /**
     * The only method to implement
     * @param x
     * @return
     */
    int calculate(int x);
}
