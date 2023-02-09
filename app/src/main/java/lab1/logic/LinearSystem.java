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
/*/
    private void SubRaw(int i1, int i2)
    {
        double c = coefficients.get(i2, i1) / coefficients.get(i1, i1);
        //coefficients.set( i2, i1,0);
        for (int j = i1 + 1; j < getDimension(); j++)
        {
            coefficients.set(i1, i2, c);(a.GetElement(i2, j) - c * a.GetElement(i1, j), i2, j);
        }
        b.SetElement(b.GetElement(i2, 0) - c * b.GetElement(i1, 0), i2, 0);
    }

    private  void SubAllRows(DoubleMatrix a, DoubleMatrix b, int i)
    {
        for (int j = i + 1; j < a.getN(); j++)
        {
            SubRaw(a, b, i, j);
        }
    }*/
    
    public static LinearSystem of(int dimension, double... data) {
        if(data.length!=dimension*dimension+dimension) throw new IllegalArgumentException("Неверная размерность массива данных");
        Matrix coefficients = new Matrix(dimension);
        Vector freeMembers = new Vector(dimension);
        for (int i = 0; i < dimension; i++) {
            int j=0;
            for (j = 0; j < dimension; j++) {
                coefficients.set(i, j, data[i*(dimension+1)+j]);
            }
            freeMembers.set(i, data[(dimension+1)*i+j]);
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
                s += coefficients.get(i, j) + "\t";
            }
            s += "|\t" + freeMembers.get(i) + "\n";
        }
        return s;
    }


    public LinearSystem clone() {
        LinearSystem ls = new LinearSystem(this.coefficients.clone(), this.freeMembers.clone());
        return ls;
    }



}
