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
public class CountThread {
    public static void main(String[] args) {
         OneThread ot = new OneThread();
    }
   
}

class OneThread{

    public OneThread() {
        System.out.println("Запуск счетчика");
        counter();
        System.out.println("Пока выполняется счетчик - выведем это сообщение");
        System.out.println("Ну и посчитаем число ПИ в квадрате "+ Math.PI*Math.PI);
        
        
    }
    
    private void counter(){
        long num = 0;
        while (num < 999999999) {            
            num++;
        }
        System.out.println("Результат работы счетчика "+ num);
    }
    
}
