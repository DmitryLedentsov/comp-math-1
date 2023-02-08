package lab1.io;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class FileInputManager  extends InputManagerImpl{
    String path;
    public FileInputManager(String path) {
        super(new Scanner(new InputStream() {
            @Override
            public int read() {
                return 0;
            }
        }));
        this.path = path;

    }
}
