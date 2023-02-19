package lab1.io;

import lab1.logic.LinearSystem;

public interface InputManager extends AutoCloseable{

    public String readLine();
    public int readDimension();
    public LinearSystem readLinearSystem();
    public int readCommand();
    public String readPath();

}
