package bridge;

public class Radio extends Tele {
    public Radio(String name) {
        super(name);
    }

    @Override
    public void printInfo() {
        System.out.println("Radio info:");
        System.out.println("Name: "+this.name);
        System.out.println("Channel: "+this.channel);
        System.out.println("Volume: "+this.volume);
    }
}
