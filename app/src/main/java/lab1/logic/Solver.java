package lab1.logic;

import java.util.Arrays;
import java.util.Scanner;

import lab1.app.App;
import lab1.io.Question;
import lombok.Getter;
import lombok.Setter;

public class Solver {
    @Getter 
    private LinearSystem system;

    @Getter
    private Vector solution;
    @Getter
    private Vector errors;


    Scanner scanner = new Scanner(System.in);
    public Solver() {
        scanner.useDelimiter("/n");
    }

    public Solver(LinearSystem s) {
        setSystem(s);
    }

    public void setSystem(LinearSystem s) {
        system = s;
        errors = new Vector(s.getDimension());
        solution = new Vector(s.getDimension());
    }

    public void readFromConsole() {
        
        
        system = App.getInstanse().getIn().readLinearSystem();
    }
    public void readFromFile(String path) {
       // system = new FileIn;
    }

    public void solve(){

    }

    public void printSolution() {
        System.out.println("Решение системы имеет вид:\n");
        for (int i = 0; i < system.getDimension(); i++) {
            System.out.print(solution.getElement(i) + "\t");
        }
        System.out.println();
    }
}
