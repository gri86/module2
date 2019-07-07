import list.IntegerList;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyListApp {
    public static void main(String[] args) {


        ArrayList<Integer> arrList = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000 ; i++) {
            arrList.add(i);
        }
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        Instant start = Instant.now();
        arrList.remove(50000);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

         start = Instant.now();
        list.remove(50000);
         end = Instant.now();
        System.out.println(Duration.between(start, end));


//        Instant start = Instant.now();
//        Instant end = Instant.now();
//        System.out.println(Duration.between(start, end));
        //PT4.643S
        //PT0.005S

    }
}
