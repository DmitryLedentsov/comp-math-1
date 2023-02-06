package lab1.io;

@FunctionalInterface
/**
 *user input callback
 */
public interface Askable<T> {
    T ask() throws IllegalArgumentException;
}