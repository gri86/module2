package multitradingtest;

public class MultiCount {
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        Runnable r1 = new CountThread1(counter);
        Runnable r2 = new CountThread1(counter);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        try {
            Thread.sleep(3000);
            System.out.println(counter.getCounter());
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так");
        }
    }
}

class CountThread1 implements Runnable{
    private Counter counter;
    
    public CountThread1(Counter count){
        this.counter = count;
    }
   
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
            
        }
    }
}

class Counter{
    private long counter = 0L;
    public void increaseCounter() {
        counter++;
    }
    public long getCounter(){return this.counter;}
}
