package multitradingtest;

public class SimpleDeadLock {
    public static Object l1 = new Object();
    public static Object l2 = new Object();
    
    public static void main(String[] args) {
        new Thread(new ThreadOne()).start();
        new Thread(new ThreadTwo()).start();
    }
    
    public static class ThreadOne implements Runnable{

        @Override
        public void run() {
            synchronized(l1){
                System.out.println("Поток 1 захватил монитор объекта l1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток 1 хочет захватить монитор объекта l2");
                synchronized(l2){
                    System.out.println("Поток 1 захватил мониторы объектов l1 и l2");
                }
            }
        }
    
    }
    
    public static class ThreadTwo implements Runnable{

        @Override
        public void run() {
            synchronized(l2){
                System.out.println("Поток 2 захватил монитор объекта l2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток 2 хочет захватить монитор объекта l1");
                synchronized(l1){
                    System.out.println("Поток 2 захватил мониторы объектов l2 и l1");
                }
            }
        }
    
    }
    
}
