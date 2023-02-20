package lab1.logic;

import lab1.utils.DoubleFormatter;
import lombok.Getter;
import lombok.Setter;

public class Vector implements Cloneable{
    public final static int MAX_DIMENSION = 20;
    private double[] vector;
    @Getter
    private int dimension;
    @Getter @Setter
    private String name;
    public Vector(int d) {
        dimension = d;
        if(dimension>MAX_DIMENSION) throw new IllegalArgumentException("Max vector dimension is " + MAX_DIMENSION);
        this.vector = new double[dimension];
    }
    public static Vector of(double[] data){
        Vector v = new Vector(data.length);
        v.vector = data;
        return v;
    }
    public void set(int column, double value) {
        this.vector[column] = value;
    }
    public double get(int column) {
        return this.vector[column];
    }
    public double[] getData(){
        return this.vector;
    }
 

    void swap(int i, int j) {
        double tmp = vector[i];
        vector[i] = vector[j];
        vector[j] = tmp;
    }
    @Override
    public Vector clone() {
        Vector v = new Vector(this.dimension);
        v.vector = this.vector.clone();
        return v;
    }
    @Override 
    public String toString() {
        String s = "";
        for (int i = 0; i < dimension; i++) {
            //s += DoubleFormatter.format(vector[i]) + "\t";
            s += vector[i] + "\t";
        }
        return s;
    }


}
