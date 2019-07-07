/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitradingtest;

/**
 *
 * @author trunov_as
 */
public class CountMainSleep {
    public static void main(String[] args) {
        System.out.println("Запуск счетчика");
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                long num = 0;
                while (num<999999999) {            
                    num++;
                }
                System.out.println("Результат работы счетчика "+num);
            }
        }).start();
        try {
            Thread.sleep(1000);
            System.out.println("Пока выполняется счетчик - выведем это сообщение");
            System.out.println("Ну и посчитаем число ПИ в квадрате "+ Math.PI*Math.PI);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
        
    }
}
