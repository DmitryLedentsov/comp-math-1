/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab1;

import lab1.logic.Matrix;
import lab1.logic.Solver;

public class App {


    public static void main(String[] args) {
        Matrix matrix = new Matrix(3);
        matrix.setElement(0, 0, 1);
        matrix.setName("A");
        
        Solver solver = new Solver();
        solver.readFromConsole();
    }
}
