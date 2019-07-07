package calc;

import java.io.IOException;
import java.sql.SQLException;

public class Calculator {
    public double divide(int a, int b) throws CalculatorException{
        if (b == 0)
            throw new CalculatorException("Dividing by zero is Forbiden");
        return a/b;
    }

    public double sqrt(int a) throws CalculatorException {
        if (a < 0)
            throw new CalculatorException("argument a can't be negative");
        return Math.pow(a, 0.5);
    }
}
