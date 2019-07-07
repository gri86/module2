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
public class QueueTest {
    int n;
    public synchronized int get(){
        System.out.println("Получено: "+n);
        return n;
    }
    
    public synchronized void put(int n){
        this.n = n;
        System.out.println("Oтпpaвлeнo: "+n);
    }
    
}


