package main;


import org.springframework.context.ApplicationContext;
import calculator.Calculator;
import factories.LoggerFactory;
import logger.BufferedFileLogger;
import logger.ConsoleLogger;
import logger.FileLogger;
import logger.Loggable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Calculator calculator = context.getBean(Calculator.class);
        calculator.sum(10,1000);



    //        Loggable logger = LoggerFactory.getLogger();  //null;//new BufferedFileLogger(3);
//
//        Calculator calculator = new Calculator(logger);
//
//        calculator.sum(10,10);
//        calculator.sum(10,10);
//        calculator.sum(10,10);
//        calculator.sum(10,10);


//        Scanner sc = new Scanner(System.in);
//
//        boolean flag = true;
//        String command = "";
//        int a = 0;
//        int b = 0;
//
//        while (flag){
//            System.out.println("Введите операцию \n Сумма: sum \n Разность: diff \n Умножение: mult \n Деление: div");
//            command = sc.nextLine();
//            System.out.println("Введите певрое число");
//            a = sc.nextInt();
//            System.out.println("Введите второе число");
//            b = sc.nextInt();
//
//            switch (command){
//                case "sum":
//                    System.out.println(calculator.sum(a,b));
//                    break;
//                case "mult":
//                    System.out.println(calculator.mult(a,b));
//                    break;
//                case "diff":
//                    System.out.println(calculator.diff(a,b));
//                    break;
//                case "div":
//                    System.out.println(calculator.div(a,b));
//                    break;
//                case "exit":
//                    flag = false;
//                    break;
//                default:
//                    System.out.println("Такой команды нет");
//            }



    }
}
