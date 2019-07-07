/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitradingtest.queue;

/**
 *
 * @author trunov_as
 */
public class QueueGood {
    int n;
    boolean valueSet = false;
    
    public synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        System.out.println("Пoлyчeнo : " + n);
        valueSet = false;
        notify();
        return n;
    }
    public synchronized void put(int n) {
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Oтпpaвлeнo : " + n);
        notify();
    }

    
}


