package factorymethod;


public class BMW extends Car {

    @Override
    protected void start() {
        System.out.println("BMW start");
    }

    @Override
    public void draw(String color) {
        this.color = color;
    }
}


