package calculator;

import annotation.MyTest;

public class ManualTest {


    @MyTest
    public void testSum(){
        Calculator calc = new Calculator();
        calc.sum(10,20);
    }
}
