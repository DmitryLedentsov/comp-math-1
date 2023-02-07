package lab1.exceptions;

public class VectorAndMatixDimensionDiffer extends IllegalArgumentException{
    public VectorAndMatixDimensionDiffer() {
        super("Размерность матрицы и вектора не совпадают");
    }
}
