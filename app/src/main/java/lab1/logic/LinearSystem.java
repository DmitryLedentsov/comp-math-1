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
    
    public static LinearSystem of(int dimension, double... data) {
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
