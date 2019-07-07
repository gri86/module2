package multitradingtest;

public class MultiCountInt {
    public static void main(String[] args) {
        CounterInt counter = new CounterInt();
        
        Runnable r1 = new CountThreadInt(counter);
        Runnable r2 = new CountThreadInt(counter);

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

class CountThreadInt implements Runnable{
    private CounterInt counter;
    
    public CountThreadInt(CounterInt count){
        this.counter = count;
    }
   
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
            
        }
    }
}

class CounterInt{
    private int counter = 0;
    public void increaseCounter() {
        this.counter++;
    }
    public long getCounter(){return this.counter;}
}
