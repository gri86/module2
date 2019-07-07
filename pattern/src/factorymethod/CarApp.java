package factorymethod;

import java.util.LinkedList;
import java.util.List;

public class CarApp {

    public static void main(String[] args) {

        List<Car> carList = new LinkedList<>();
       for (DaysOfWeek day: DaysOfWeek.values()){
           Car car = CarFactory.getCar(day.getDay());
           carList.add(car);
       }

        System.out.println("da");


    }

}
