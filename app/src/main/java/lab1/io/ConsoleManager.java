package lab1.io;

import java.util.Scanner;

public class ConsoleManager extends IOManagerImpl{
    public ConsoleManager() {
        super(new Scanner(System.in));
    }
}
