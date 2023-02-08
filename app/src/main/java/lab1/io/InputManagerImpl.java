package lab1.io;

import java.io.InputStream;
import java.util.Scanner;

import lab1.app.App;
import lab1.logic.LinearSystem;
import lab1.logic.Matrix;
import lab1.logic.Vector;

public class InputManagerImpl implements InputManager{
    private Scanner scanner;
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
        return scanner.nextLine();
    }
    public void close() {
        scanner.close();
    }
    public int readDimension() {
       
        return new Question<Integer> ("Введите размерность: ", ()->{
            try{
                int d = Integer.parseInt(scanner.nextLine().trim());
                if(d < 1)
                    throw new IllegalArgumentException("Размерность матрицы не может быть меньше 1");
                else if (d > Matrix.MAX_DIMENSION)
                    throw new IllegalArgumentException("Размерность матрицы не может быть больше " + Matrix.MAX_DIMENSION);
                return d;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Неверный формат размерности матрицы");
            }
     
        }).getAnswer();
    }

    public double[] readEquation(int d){
       
        
        Question<double[]> q = new Question<double[]>(() -> {
            App.getInstanse().getOut().add("уравнение " + line + ": ");
            String[] input = scanner.nextLine().split(" ");
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
        });
        return q.getAnswer();
    }
    
    public LinearSystem readLinearSystem() {
        line = 1;
        int dimension = readDimension();
        Matrix A = new Matrix(dimension);
        Vector B = new Vector(dimension);
        System.out.println("Введите систему в виде матрицы коэффициентов и столбца свободных членов:");
        for (int i = 0; i < dimension; i++) {
            double[] equation = readEquation(dimension);
            line++;
            for (int j = 0; j < dimension; j++) {
                A.setElement(i, j, equation[j]);
            }
            B.setElement(i, equation[dimension]);
           
        }
        return new LinearSystem(A, B);
    }


    public int readCommand() {
        return new Question<>("ОПЦИИ:\nчтобы ввести с клавиатуры введите 1, \nчтобы ввести из файла введите 2, \nчтобы выйти введите 3:\n", ()->{
            try{
                int command = Integer.parseInt(scanner.nextLine().trim());
                if(command < 1 || command > 3)
                    throw new IllegalArgumentException("Неверный формат команды");
                return command;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Неверный формат команды");
            }
        }).getAnswer();
    
    }
    public String readPath() {
        return new Question<>("Введите имя файла", ()->{
            String fileName = scanner.nextLine().trim();
            if(fileName.isEmpty())
                throw new IllegalArgumentException("Имя файла не может быть пустым");
            return fileName;
        }).getAnswer();
    }
}
