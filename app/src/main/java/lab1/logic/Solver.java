package lab1.logic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Solver {
    @Getter  @Setter
    private LinearSystem system;

    @Getter
    private Vector solution;
    @Getter
    private Vector errors;

    @Getter 
    private double determinant;
    
    private boolean chooseMainElementAndChangeRawsOrder(int i){
        double max = Math.abs(system.getCoefficients().get(i,i));
        int maxIndex = i;
        //начиная с i+1 элемента в столбце, ищем максимальный и его индекс
        for(int j=i+1; j<system.getDimension(); j++){
            double current = system.getCoefficients().get(i,j);
            if(current > max){
                max = current;
                maxIndex = j;
            }
        }
        if(maxIndex != i){
            //если нашли, меняем строки местами
            system.getCoefficients().swapRaws(i, maxIndex);
            system.getFreeMembers().swap(i, maxIndex);
            return true;
        }
        return false;
    }

    private void subRaws(int i){
        for (int k = i + 1; k < system.getDimension(); k++){   
            //начиная с iго элемента вычитаем из каждой строки iю строку * коэффициент
            double c = system.getCoefficients().get(i,k) / system.getCoefficients().get(i, i);
            for (int j = i; j < system.getDimension(); j++)
            {
                system.getCoefficients().set(j,k, system.getCoefficients().get(j,k) - c * system.getCoefficients().get(j,i));
            }
            system.getFreeMembers().set(k, system.getFreeMembers().get(k) - c * system.getFreeMembers().get(i));

        }
    }

    void findSolution(){
        int n = system.getDimension();
        //последовательно находим неизвестные начиная с последнего
        for (int i = n - 1; i >= 0; i--){
            double s = 0;
            for (int j = i + 1; j < system.getDimension(); j++){
                s = s + system.getCoefficients().get(j,i) * solution.get(j);
            }
            solution.set(i, (system.getFreeMembers().get(i) - s) / system.getCoefficients().get(i, i));
        }
    }
 
    void findErrors(){
        for(int i = 0; i < system.getDimension(); i++){
            double s = 0;
            //находим значение левой части уравнения подставляя найденные корни
            for(int j = 0; j < system.getDimension(); j++){
                s += system.getCoefficients().get(j,i) * solution.get(j);
            }
            //ошибка- разница найденного значения и настоящего
            errors.set(i, s - system.getFreeMembers().get(i));
        }
    }
    
    public int triangularForm(){
        int swapCount = 0;
        //"Прямой ход", приводим к треугольному виду
        for ( int i = 0; i < system.getDimension()-1; i++)
        {
            //меняем строки местами
            if(chooseMainElementAndChangeRawsOrder(i)) swapCount ++;
            //вычитаем из следующих строк iю
            subRaws(i);
        }
        return swapCount;
    }
    public void solve(){
        solution = new Vector(system.getDimension());
        errors = new Vector(system.getDimension());
        int swapCount = triangularForm();
        findDeterminant(swapCount);
        //"Обратный ход"
        findSolution();
        findErrors();
    }

    void findDeterminant(int swapCount){
        //(-1)^(число перестановок)*диагональ
        determinant = Math.pow(-1, swapCount) * system.getCoefficients().multiplyDiagonal();
    }
}
