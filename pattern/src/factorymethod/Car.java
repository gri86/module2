package factorymethod;

public abstract class Car implements Drawable {

    protected String color;

    protected Engine engine;

    protected abstract void start();



}

class Engine{

}
