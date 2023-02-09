package lab1.io;

import java.io.InputStream;
import java.util.Scanner;

import lab1.app.App;
import lab1.logic.LinearSystem;
import lab1.logic.Matrix;
import lab1.logic.Vector;

public class InputManagerImpl implements InputManager{
    protected Scanner scanner;
    protected int line;
    public InputManagerImpl(Scanner s) {
        scanner = s;
    }
    public void print(String message) {
        System.out.println(message);
    }
    public void error(String message) {
        System.err.println(message);
    }

    public String readLine() {
        return scanner.nextLine().stripLeading();
    }
    public void close() {
        scanner.close();
    }
    







    public int readDimension() {
        try{
            int d = Integer.parseInt(readLine());
            if(d <= 1)
                throw new IllegalArgumentException("Размерность матрицы должна быть больше 1");
            else if (d > Matrix.MAX_DIMENSION)
                throw new IllegalArgumentException("Размерность матрицы не может быть больше " + Matrix.MAX_DIMENSION);
            return d;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат размерности матрицы");
        }
    }

    public double[] readEquation(int d){
        String[] input = readLine().split(" ");
        if(input.length != d + 1) {
            throw new IllegalArgumentException("Неверное количество элементов в уравнении");
        }
        double[] equation = new double[input.length];
        for (int i = 0; i < input.length; i++) {
        
            try{
            equation[i] = Double.parseDouble(input[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Неверный формат элемента уравнения " + input[i]);
            }
        }
        return equation;
    }
    
    public LinearSystem readLinearSystem() {
        line = 1;
        int dimension = readDimension();
        Matrix A = new Matrix(dimension);
        Vector B = new Vector(dimension);
        for (int i = 0; i < dimension; i++) {
            double[] equation = readEquation(dimension);
            line++;
            for (int j = 0; j < dimension; j++) {
                A.set(i, j, equation[j]);
            }
            B.set(i, equation[dimension]);
           
        }
        return new LinearSystem(A, B);
    }

    public int readCommand() {
        try{
            int command = Integer.parseInt(readLine());
            if(command < 1 || command > 3)
                throw new IllegalArgumentException("Неверный формат команды");
            return command;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат команды");
        }
         
    
    }
    public String readPath() {
        String fileName = readLine();
        if(fileName.isEmpty())
            throw new IllegalArgumentException("Имя файла не может быть пустым");
        return fileName;
    }
}
