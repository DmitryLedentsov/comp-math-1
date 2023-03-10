package lab1;

import lab1.logic.LinearSystem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LinearSystemTest {
    LinearSystem system;
    double[] expected;

    public static LinearSystemTest of(LinearSystem sys, double... expected){
        return new LinearSystemTest(sys, expected);
    }
}
