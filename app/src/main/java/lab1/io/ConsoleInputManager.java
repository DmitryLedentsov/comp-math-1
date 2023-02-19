package lab1.io;

import java.util.Scanner;

import lab1.logic.LinearSystem;

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
        
        System.out.println("Введите систему в виде матрицы коэффициентов и столбца свободных членов:");
        return super.readLinearSystem();
    }


    public int readCommand() {
        return new Question<>("ОПЦИИ:\n\n -   чтобы ввести с клавиатуры введите 1, \n -   чтобы ввести из файла введите 2, \n -   чтобы выйти введите 3\n", super::readCommand).getAnswer();
    }
    public String readPath() {
        return new Question<>("Введите имя файла: ", super::readPath).getAnswer();
    }
    
}
