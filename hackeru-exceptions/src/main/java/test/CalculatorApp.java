package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculatorApp {

    public static void main(String[] args) throws CalculatorException {

        Calculator calc = new Calculator();
        calc.divide(null, null);

    }

}
