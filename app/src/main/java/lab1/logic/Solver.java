package lab1.logic;

import java.util.Arrays;
import java.util.Scanner;

import lab1.io.Question;

public class Solver {
    private Matrix A;
    private Vector B;
    private int n;
    Scanner scanner = new Scanner(System.in);
    public Solver() {
        scanner.useDelimiter("/n");
    }
    public Solver(Matrix A, Vector B) {
        this.A = A;
        this.B = B;
        n = A.getDimension();
        if(n!=B.getDimension()) throw new IllegalArgumentException("Размерность матрицы не совпадает с размерностью вектора");

    }
    public void readFromConsole() {
        
        
        System.out.print("Введите размерность матрицы: ");
        n = Integer.parseInt(scanner.nextLine().trim());
        A = new Matrix(n);
        B = new Vector(n);

        for (int i = 0; i < n; i++) {
            System.out.println("Введите левую часть " + (i+1) + " системы: ");
            String[] line = scanner.nextLine().split(" ");
            A.setRaw (i, Arrays.stream(line).
                    mapToDouble(Double::parseDouble).
                    toArray());
            System.out.println("Введите правую часть " + (i+1) + " системы: ");
            B.setElement(i,  Double.parseDouble(scanner.nextLine().trim()));

            A.print();
            B.print();
        }


        scanner.close();
    }
}
