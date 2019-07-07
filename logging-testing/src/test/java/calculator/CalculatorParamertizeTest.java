package calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class CalculatorParamertizeTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {1,2,3}, {10,10,20}, {0,0,0}, {5,5,10}
        });
    }

    private int a;
    private int b;
    private int c;

    private Calculator calc;

    public CalculatorParamertizeTest(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Before
    public void init(){
        calc = new Calculator();
    }

    @Test
    public void sumTest(){
        Assert.assertEquals(this.c, calc.sum(this.a, this.b));
    }

}
