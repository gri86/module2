package multitradingtest;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableApp {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);

        List<Future<String>>  futures = new ArrayList<Future<String>>();
        Callable<String> callable = new CallableClass();

        for (int i = 0; i< 3; i++){
            Future<String> future = ex.submit(callable);
            futures.add(future);
        }

        for (Future<String> f: futures){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello ");
        ex.shutdown();
    }

}

class CallableClass implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return Thread.currentThread().getName();
    }
}