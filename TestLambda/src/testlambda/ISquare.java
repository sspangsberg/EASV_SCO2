package testlambda;

/**
 * Simple Functional Interface with single method to implement
 */
@FunctionalInterface
interface ISquare
{
    /**
     * The only method to implement
     * @param x
     * @return
     */
    int calculate(int x);
}
