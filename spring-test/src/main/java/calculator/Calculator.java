package calculator;

import logger.BufferedFileLogger;
import logger.ConsoleLogger;
import logger.FileLogger;
import logger.Loggable;

public class Calculator {

    private Loggable logger;


    public void setLogger(Loggable logger) {
        this.logger = logger;
    }

    public Calculator(){

    }

    public int sum(int x, int y){
        int result = x+y;
        if (logger != null) logger.log(String.valueOf(result));
        return result;
    }

    public int diff(int x, int y){
        int result = x-y;
        if (logger != null) logger.log(String.valueOf(result));
        return result;

    }

    public int mult(int x, int y){
        int result = x*y;
        if (logger != null) logger.log(String.valueOf(result));
        return result;

    }

    public int div(int x, int y){
        int result = x/y;
        if (logger != null) logger.log(String.valueOf(result));
        return result;

    }
}
