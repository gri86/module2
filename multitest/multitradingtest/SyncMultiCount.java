package multitradingtest;

public class SyncMultiCount {
    public static void main(String[] args) {
        SyncCounter counter = new SyncCounter();
        
        Runnable r1 = new SyncCountThread(counter);
        Runnable r2 = new SyncCountThread(counter);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
            System.out.println(counter.getCounter());
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так");
        }
    }
}

class SyncCountThread implements Runnable{
    private SyncCounter counter;
    
    public SyncCountThread(SyncCounter count){
        this.counter = count;
    }
   
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
            
        }
    }
}

class SyncCounter{
    private long counter = 0L;
    public synchronized void increaseCounter() {
        counter++;
    }    
    public long getCounter(){return this.counter;}
}

class SyncCounter2{
    private long counter = 0L;
    public void increaseCounter() {
        synchronized(this){
            counter++;
        }
    }
    public long getCounter(){return this.counter;}
}
