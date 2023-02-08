package lab1.io;

public class ConsoleOutputManager implements OutputManager{
    public void print(String message) {
        System.out.println(message);
    }
    public void add(String message) {
        System.out.print(message);
    }
    public void error(String message) {
        System.err.println("ОШИБКА: " + message);
    }
}
