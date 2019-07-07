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
public class Producer implements Runnable{
    QueueGood q;

    public Producer(QueueGood q) {
        this.q = q;
        
        new Thread(this, "Поставщик").start();
    }
    
    @Override
    public void run() {
        int i = 0;
        while (true) {            
            q.put(i++);
        }
    }
    
}
