package lab1.io;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class FileInputManager  extends InputManagerImpl{
    String path;
    public FileInputManager(String path) throws Exception {
        
        super(new Scanner(new File(path)));
       
        this.path = path;

    }

    
}
