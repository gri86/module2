package calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;



    @Before
    public void init(){
        calc = new Calculator();
    }


    @Test
    public void sumTest(){
        int expect = 10;
        int actual = calc.sum(5,5);
        assertEquals(expect, actual);
    }

    @Test
    public void diffTest(){
        int expect = 20;
        assertEquals(expect, calc.diff(40,20));

    }

    @Test(timeout = 4000)
    public void multTest(){
        try {
            Thread.sleep(3000);
            calc.mult(10,10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = Exception.class)
    public void divTest() throws Exception{
        calc.div(1,0);

    }





}
