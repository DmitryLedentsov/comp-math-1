package lab1.logic;

import java.util.Arrays;

import lab1.exceptions.VectorAndMatixDimensionDiffer;
import lombok.Getter;
import lombok.Setter;

public class Matrix implements Cloneable{
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

    public static Matrix of(double[][] data){
        if(data.length!=data[0].length) throw new IllegalArgumentException("Matrix must be square");
        Matrix m = new Matrix(data.length);
        m.matrix = data;
        return m;
    }

    public void set(int x, int y, double value) {
        this.matrix[y][x] = value;
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
    public double get(int x, int y) {
        return this.matrix[y][x];
    }
/*
    public double getDeterminant(){
        double result = 0;
       
		if (getDimension() == 1) {
			result = matrix[0][0];
			return result;
		}
		if (getDimension() == 2) {
			result = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
			return result;
		}
		for (int i = 0; i < getDimension(); i++) {

			result += get(i,0) * getAlgAddition(i,0) ;
		}
		return result;
    }
    public double getAlgAddition(int i, int j){
        return Math.pow(-1, i + j) * getMinor(i, j).getDeterminant();
    }
    public Matrix getMinor(int x, int y){
        Matrix minor = new Matrix(getDimension() - 1);

        for (int i = 0; i < getDimension(); i++){
            for (int j = 0; j < getDimension(); j++){
                if (i != x && j != y){
                    minor.set(i < x ? i : i - 1, j < y ? j : j - 1, get(i, j));
                }
            }
        }
        return minor;
    }
*/

    public void swapElements(int x1, int y1, int x2, int y2) {
        double tmp = matrix[y1][x1];
        matrix[y1][x1] = matrix[y2][x2];
        matrix[y2][x2] = tmp;
    }
    public void swapRaws(int y1, int y2) {
        double[] tmp = matrix[y1];
        matrix[y1] = matrix[y2];
        matrix[y2] = tmp;
    }

    public double multiplyDiagonal() {
        double result = 1;
        for (int i = 0; i < dimension; i++) {
            result *= matrix[i][i];
        }
        return result;
    }
    public boolean hasZeroRaw(){
        for (int i = 0; i < dimension; i++) {
            boolean hasZero = true;
            for (int j = 0; j < dimension; j++) {
                if(matrix[i][j]!=0) hasZero = false;
            }
            if(hasZero) return true;
        }
        return false;
    }
    @Override
    public Matrix clone(){
        Matrix m = new Matrix(this.dimension);
        m.matrix = Arrays.stream(matrix).map(double[]::clone).toArray(double[][]::new);
        return m;
    }
 


    
}
