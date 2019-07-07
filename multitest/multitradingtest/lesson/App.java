package multitradingtest.lesson;


public class App {

    public static void main(String[] args) {

        Account acc = new Account();

        FirstThread ft = new FirstThread(acc);
        SecondThread st = new SecondThread(acc);

        ft.start();
        st.start();

    }

}

class Account{
    public synchronized void set(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello set");
    }

    public synchronized void get(){
        System.out.println("Hello get");
    }
}


class FirstThread extends Thread{
    private Account acc;

    public FirstThread(Account acc){
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.set();
    }
}

class SecondThread extends Thread{
    private Account acc;
    public SecondThread(Account acc){
        this.acc = acc;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        acc.get();
    }
}




//class BadGirl{
//    private int account;
//
//    public BadGirl(){
//        account = 0;
//    }
//
//    public synchronized void setAccount(int money){
//        this.account = this.account + money;
//    }
//
//    public int getAccount() {
//        return this.account;
//    }
//}
//
//class CowBoy implements Runnable{
//    BadGirl girl;
//
//    public CowBoy(BadGirl girl){
//        this.girl = girl;
//    }
//
//    @Override
//    public void run() {
//        int i = 0;
//        while (i<10000){
//            girl.setAccount(1);
//            i++;
//        }
//    }
//}
