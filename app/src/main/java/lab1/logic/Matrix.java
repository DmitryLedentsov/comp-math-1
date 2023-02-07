package lab1.logic;

import lab1.exceptions.VectorAndMatixDimensionDiffer;
import lombok.Getter;
import lombok.Setter;

public class Matrix {
    public final static int MAX_DIMENSION = 20;
    @Getter
    private double[][] matrix;
    @Getter
    private int dimension;

    @Setter @Getter
    private String name;
    public Matrix(int d) {
        dimension = d;
        if(dimension>MAX_DIMENSION) throw new IllegalArgumentException("Max matrix dimension is " + MAX_DIMENSION);
        this.matrix = new double[dimension][dimension];
    }


    public void setElement(int column, int row, double value) {
        this.matrix[row][column] = value;
    }
    public void setRaw(int row, double[] values) {
        if(values.length!=dimension) throw new VectorAndMatixDimensionDiffer();
        this.matrix[row] = values;
    }
    public void setRaw(int row, Vector values) {
        if(values.getDimension()!=dimension) throw new VectorAndMatixDimensionDiffer();
        this.matrix[row] = values.getData();
    }

    public double[][] getData(){
        return this.matrix;
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
