package multitradingtest;

public class PingPongApp {


    public static void main(String[] args) {
        PingPong pp = new PingPong();

        Thread t1 = new Thread(new ThreadPing(pp));
        Thread t2 = new Thread(new ThreadPong(pp));


        t1.start();
        t2.start();

        System.out.println("Конец программы");
    }


}



class PingPong{


    boolean flag = false;

    public synchronized void ping(){

        while(flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        System.out.println("PING");
        flag = true;
        notify();

    }

    public synchronized void pong(){
        if (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("PONG");
        flag = false;
        notify();

    }

}

class ThreadPong implements Runnable{

    PingPong pp = null;

    public ThreadPong(PingPong pp){
        this.pp = pp;
    }

    @Override
    public void run() {
        while (true){
            pp.pong();
        }
    }
}


class ThreadPing implements Runnable{

    PingPong pp = null;

    public ThreadPing(PingPong pp){
        this.pp = pp;
    }

    @Override
    public void run() {

        while (true){
            pp.ping();
        }

    }
}