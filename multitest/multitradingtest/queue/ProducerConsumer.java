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
public class ProducerConsumer {
    
    public static void main(String[] args) {
        QueueGood q = new QueueGood();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
    }
    
}
