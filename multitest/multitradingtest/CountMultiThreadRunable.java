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
public class CountMultiThreadRunable {
    public static void main(String[] args) {
        System.out.println("Запуск счетчика");
        Runnable r = new MyRunableThread();
        Thread t1 = new Thread(r);
        t1.start();
        
        System.out.println("Пока выполняется счетчик - выведем это сообщение");
        System.out.println("Ну и посчитаем число ПИ в квадрате "+ Math.PI*Math.PI);
    }
}

class MyRunableThread implements Runnable{

    @Override
    public void run() {
        long num = 0;
        while (num<999999999) {            
            num++;
        }
        System.out.println("Результат работы счетчика "+num);
    }
    
}
