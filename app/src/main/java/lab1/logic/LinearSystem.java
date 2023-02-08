package lab1.logic;

import lombok.Getter;
import lab1.exceptions.*;
public class LinearSystem implements Cloneable{
    
    @Getter
    private final Matrix coefficients;
    @Getter
    private final Vector freeMembers;
  
    @Getter
    private final int dimension;
    public LinearSystem(Matrix coefficients, Vector freeMembers) {
        this.coefficients = coefficients;
        this.freeMembers = freeMembers;
        this.dimension = coefficients.getDimension();
        if(freeMembers.getDimension()!=dimension) throw new VectorAndMatixDimensionDiffer();
    }
    /*public void solve() {
        double[][] matrix = coefficients.getData();
        double[] vector = freeMembers.getData();
        double[] solution = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            double max = matrix[i][i];
            int maxRow = i;
            for (int j = i+1; j < dimension; j++) {
                if(Math.abs(matrix[j][i])>Math.abs(max)) {
                    max = matrix[j][i];
                    maxRow = j;
                }
            }
            for (int j = 0; j < dimension; j++) {
                double temp = matrix[maxRow][j];
                matrix[maxRow][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
            double temp = vector[maxRow];
            vector[maxRow] = vector[i];
            vector[i] = temp;
            for (int j = i+1; j < dimension; j++) {
                double c = -matrix[j][i]/matrix[i][i];
                for (int k = i; k < dimension; k++) {
                    if(i==k) {
                        matrix[j][k] = 0;
                    } else {
                        matrix[j][k] += c*matrix[i][k];
                    }
                }
                vector[j] += c*vector[i];
            }
        }
        for (int i = dimension-1; i >= 0; i--) {
            solution[i] = vector[i];
            for (int j = i+1; j < dimension; j++) {
                solution[i] -= matrix[i][j]*solution[j];
            }
            solution[i] /= matrix[i][i];
        }
        this.solution = new Vector(dimension);
    }
    */
    public static LinearSystem of(int dimension, double[] data) {
        if(data.length!=dimension*dimension+dimension) throw new IllegalArgumentException("Неверная размерность массива данных");
        Matrix coefficients = new Matrix(dimension);
        Vector freeMembers = new Vector(dimension);
        for (int i = 0; i < dimension; i++) {
            int j=0;
            for (j = 0; j < dimension; j++) {
                coefficients.setElement(i, j, data[i*(dimension+1)+j]);
            }
            freeMembers.setElement(i, data[(dimension+1)*i+j]);
        }
        return new LinearSystem(coefficients, freeMembers);
    }

    public void print() {
        System.out.println("Система имеет вид:\n");
        System.out.println(this.toString());
    }
    
    @Override 
    public String toString(){
        String s = "";
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s += coefficients.getElement(i, j) + "\t";
            }
            s += "|\t" + freeMembers.getElement(i) + "\n";
        }
        return s;
    }

    public LinearSystem clone() {
        LinearSystem ls = new LinearSystem(this.coefficients.clone(), this.freeMembers.clone());
        return ls;
    }



}
