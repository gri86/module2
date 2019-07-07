
package multitradingtest;

public class CountMultiThread {
    public static void main(String[] args) {
        System.out.println("Запуск счетчика");
        MyCountThread t1 = new MyCountThread();
        t1.start();
        System.out.println("Пока выполняется счетчик - выведем это сообщение");
        System.out.println("Ну и посчитаем число ПИ в квадрате "+ Math.PI*Math.PI);
        
    }
}

class MyCountThread extends Thread{

    @Override
    public void run() {
        long num = 0;
        while (num < 999999999) {            
            num++;
        }
        System.out.println("Результат работы счетчика "+ num);
    }
}
