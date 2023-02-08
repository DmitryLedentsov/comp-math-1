package lab1.io;

import java.util.Scanner;

public class ConsoleInputManager extends InputManagerImpl{
    public ConsoleInputManager() {
        super(new Scanner(System.in));
    }
}
