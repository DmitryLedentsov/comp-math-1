package lab1.logic;

import lombok.Getter;
import lombok.Setter;

public class Vector {
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
    public void setElement(int column, double value) {
        this.vector[column] = value;
    }
    public double getElement(int column) {
        return this.vector[column];
    }
    public double[] getData(){
        return this.vector;
    }
    public void print() {
        System.out.println("Вектор " + (name!=null?name:"") + " имеет следующий вид:\n");
        for (int i = 0; i < dimension; i++) {
            System.out.print(vector[i] + "\t");
        }
        System.out.println();
    }

}
