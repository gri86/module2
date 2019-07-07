package calculator;

import java.io.IOException;
import java.util.logging.*;

public class Calculator {

    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    static {

        //logger.setLevel(Level.WARNING);





        try{

            logger.setLevel(Level.ALL);

            Handler fileHandler = new FileHandler("log%u.txt");
            fileHandler.setLevel(Level.INFO);
            Formatter f = new SimpleFormatter();
            fileHandler.setFormatter(f);
            logger.addHandler(fileHandler);

            Handler handler = new ConsoleHandler();
            handler.setLevel(Level.SEVERE);
            logger.addHandler(handler);
            System.out.println(logger.getHandlers().length);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public int sum(int a, int b){
        logger.info("Вычисляю сумму");
        return a + b;
    }

    public int diff(int a, int b){
        logger.log(Level.INFO, "Вычисляется разность между {0} и {1}",new Object[]{a, b});
        return a - b;
    }

    public int mult(int a, int b){
        return a * b;
    }


    public double div(int a, int b) throws Exception{
        if(b == 0){
            throw new Exception("Деление на букву 0");
        }
        return a/b;
    }

}
