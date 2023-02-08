package lab1.logic;

import java.util.Arrays;
import java.util.Scanner;

import lab1.app.App;
import lab1.io.Question;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Solver {
    @Getter 
    private LinearSystem system;

    @Getter
    private Vector solution;
    @Getter
    private Vector errors;

    @Getter
    private SolutionWay solutionWay;

    Scanner scanner = new Scanner(System.in);
    void init(){
        
    }
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
        solutionWay = new SolutionWay();
    }

    public void readFromConsole() {
        
        
        system = App.getInstanse().getIn().readLinearSystem();
    }
    public void readFromFile(String path) {
       // system = new FileIn;
    }

    public void chooseMainElement(){
        int n = system.getDimension();
        
        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                if(Math.abs(system.getCoefficients().getElement(x, y)) > solutionWay.max){
                    solutionWay.max = Math.abs(system.getCoefficients().getElement(x, y));
                    solutionWay.maxX = x;
                    solutionWay.maxY = y;
                }
            }
        }
    }
    public void solve(){
        solutionWay = new SolutionWay();

        int n = system.getDimension();
        chooseMainElement();
        
    }

    public void printSolution() {
        System.out.println("Решение системы имеет вид:\n");
        for (int i = 0; i < system.getDimension(); i++) {
            System.out.print(solution.getElement(i) + "\t");
        }
        System.out.println();
    }

    @Data
    public class SolutionWay{
        protected double max;
        protected int maxX;
        protected int maxY;
    }
}
