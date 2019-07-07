package test;

public class Calculator{

    public float divide(Integer a, Integer b) throws CalculatorException {

        if (a == null || b == null){
            throw new CalculatorException("Arguments a or b is null");
        }
        if (b == 0){
            throw new ArithmeticException("Деление на ноль");
        }
        return a / b;
    }

}

class CalculatorException extends Exception{

    public CalculatorException(){}

    public CalculatorException(String message){
        super(message);
    }
}
