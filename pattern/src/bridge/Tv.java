package bridge;

public class Tv extends Tele {


    public Tv(String name) {
        super(name);
    }

    @Override
    public void printInfo() {
        System.out.println("TV info:");
        System.out.println("Name: "+this.name);
        System.out.println("Channel: "+this.channel);
        System.out.println("Volume: "+this.volume);
    }
}
