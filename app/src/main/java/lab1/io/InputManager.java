package lab1.io;

import java.io.InputStream;

import lab1.logic.LinearSystem;
import lab1.logic.Vector;

public interface InputManager extends AutoCloseable{

    public String readLine();
    public int readDimension();
    public LinearSystem readLinearSystem();
    public int readCommand();
    public String readPath();

}
