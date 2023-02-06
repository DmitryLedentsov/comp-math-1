package lab1.logic;

import lombok.Getter;
import lombok.Setter;

public class Matrix {
    final static int MAX_DIMENSION = 20;
    @Getter
    private double[][] matrix;
    @Getter
    private int dimension;

    @Setter @Getter
    private String name;
    public Matrix(int d) {
        dimension = d;
        if(dimension>MAX_DIMENSION) throw new IllegalArgumentException("Максимальная размерность матрицы " + MAX_DIMENSION);
        this.matrix = new double[dimension][dimension];
    }


    public void setElement(int column, int row, double value) {
        this.matrix[row][column] = value;
    }
    public void setRaw(int row, double[] values) {
        if(values.length!=dimension) throw new IllegalArgumentException("Размерность вектора не совпадает с размерностью матрицы");
        this.matrix[row] = values;
    }

    public double getElement(int column, int row) {
        return this.matrix[row][column];
    }
    public void print() {

        System.out.println("Матрица " + (name!=null?name:"") + " имеет следующий вид:\n");

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
 

    
}
