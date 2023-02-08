package lab1.io;

import java.util.Scanner;

import lab1.app.App;
import lab1.logic.LinearSystem;
import lab1.logic.Matrix;
import lab1.logic.Vector;

public class ConsoleInputManager extends InputManagerImpl{
    public ConsoleInputManager() {
        super(new Scanner(System.in));
    }

    public int readDimension() {
       
        return new Question<Integer> ("Введите размерность: ",super::readDimension).getAnswer();
    }

    public double[] readEquation(int d){
       
        
        Question<double[]> q = new Question<double[]>("уравнение " + line + ": ", ()->super.readEquation(d));
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
        return new Question<>("ОПЦИИ:\nчтобы ввести с клавиатуры введите 1, \nчтобы ввести из файла введите 2, \nчтобы выйти введите 3:\n", super::readCommand).getAnswer();
    }
    public String readPath() {
        return new Question<>("Введите имя файла", super::readPath).getAnswer();
    }
    
}
