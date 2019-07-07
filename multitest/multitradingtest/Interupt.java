package multitradingtest;

public class Interupt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Запускаем нить");

        Thread r = new Thread(new InteruptThread3());

        r.start();

        Thread.sleep(5000);

        r.interrupt();


        r.join();

        System.out.println("Завершение программы");

    }
}


class InteruptThread implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Меня не остановить");
        }
    }
}

class InteruptThread2 implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Попытка остановить нить");
            }
            System.out.println("Меня не остановить");
        }
    }
}

class InteruptThread3 implements Runnable{

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Попытка остановить нить");
            }
            System.out.println("Меня не остановить");
        }
    }
}

class InteruptThread4 implements Runnable{

    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Меня не остановить");
        }
    }
}

