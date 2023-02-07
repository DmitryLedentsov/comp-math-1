package lab1.io;

import java.io.InputStream;

import lab1.logic.Vector;

public interface IOManager extends AutoCloseable{
    public void print(String message);
    public void error(String message);
    public void close();
    public String readLine();
    public double readDimension();


}
