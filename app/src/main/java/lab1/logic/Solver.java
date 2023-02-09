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

    
    private boolean chooseMainElementAndChangeRawsOrder(int i){
        double max = Math.abs(system.getCoefficients().get(i, i));
        int maxIndex = i;
        for(int j=i+1; j<system.getDimension(); j++){
            if(Math.abs(system.getCoefficients().get(i,j)) > max){
                max = Math.abs(system.getCoefficients().get(i,j));
                maxIndex = j;
            }
        }
        if(maxIndex != i){
            system.getCoefficients().swapRaws(i, maxIndex);
            system.getFreeMembers().swap(i, maxIndex);
            return true;
        }
        return false;
    }

    /*private void subRaw(int y, int x){
        Matrix a = system.getCoefficients();
        Vector b = system.getFreeMembers();
        float c = arrayA[k][i] / arrayA[i][i];
        for (int j = i; j < n ; j++) {
            arrayA[k][j] = arrayA[k][j] - c * arrayA[i][j];
        }
        arrayB[k] = arrayB[k] - c * arrayB[i];


    }*/
    private void subAllRaws(int i){
        for (int k = i + 1; k < system.getDimension(); k++)
        {
            double c = system.getCoefficients().get(i,k) / system.getCoefficients().get(i, i);
            for (int j = i; j < system.getDimension(); j++)
            {
                system.getCoefficients().set(j,k, system.getCoefficients().get(j,k) - c * system.getCoefficients().get(j,i));
            }
            system.getFreeMembers().set(k, system.getFreeMembers().get(k) - c * system.getFreeMembers().get(i));
        }
    }

 
    public void solve(){
        solutionWay = new SolutionWay();
        solution = new Vector(system.getDimension());
        int n = system.getDimension();
        int k=0;
        for ( int i = 0; i < n-1; i++)
        {
            if (chooseMainElementAndChangeRawsOrder(i))
            {
                k++;
            }
            subAllRaws(i);
        }

        for (int i = n - 1; i >= 0; i--)
        {
            double s = 0;
            for (int j = i + 1; j < n; j++)
            {
                s += system.getCoefficients().get(j,i) * solution.get(j);
            }
            solution.set(i, (system.getFreeMembers().get(i) - s) / system.getCoefficients().get(i, i));
        }
        
    }

    public void printSolution() {
        System.out.println("Решение системы имеет вид:\n");
        for (int i = 0; i < system.getDimension(); i++) {
            System.out.print(solution.get(i) + "\t");
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
