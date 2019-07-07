/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitradingtest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trunov_as
 */
public class ImpemRunnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");
        TestThread tt = new TestThread();
        Thread thread = new Thread(tt);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Пpepывaниe основного потока");
            System.out.println("Зaвepшeниe основного потока");
        }
    }
    
}

class TestThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Начало работы порожденного потока");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("B дочернем потоке " + i);
                Thread.sleep(100);
            }
            
        } catch (InterruptedException ex) {
            System.out.println("Ошибка при выполнении потока");
        }
        System.out.println("Завершение работы потока");
    }
    
}
