package factorymethod;

public class CarFactory {

    public static Car getCar(int day){
        if(day%2 == 0){
            return new Audi();
        }else{
            return new BMW();
        }
    }

}
