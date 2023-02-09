package lab1.exceptions;

public class ZeroDeterminantException extends IllegalArgumentException{
    public ZeroDeterminantException() {
        super("дискриминант равен нулю");
    }
}
