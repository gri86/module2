package factorymethod;

public class Audi extends Car{


    @Override
    protected void start() {
        System.out.println("Audi start");
    }

    @Override
    public void draw(String color) {
        this.color = color;
    }
}
