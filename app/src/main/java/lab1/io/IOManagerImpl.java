package lab1.io;

import java.io.InputStream;
import java.util.Scanner;

public class IOManagerImpl implements IOManager{
    private Scanner scanner;
    public IOManagerImpl(Scanner s) {
        scanner = s;
    }
    public void print(String message) {
        System.out.println(message);
    }
    public void error(String message) {
        System.err.println(message);
    }

    public String readLine() {
        return scanner.nextLine();
    }
    public void close() {
        scanner.close();
    }
    public double readDimension() {
        return Double.parseDouble(scanner.nextLine().trim());
    }
}
