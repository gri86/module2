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
public class Consumer implements Runnable{
    QueueGood q;

    public Consumer(QueueGood q) {
        this.q = q;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true) {            
            q.get();
        }
    }
    
}
