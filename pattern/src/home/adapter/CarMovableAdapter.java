package home.adapter;

public class CarMovableAdapter implements MovableAdapter {

    private Movable movable;

    public CarMovableAdapter(Movable movable) {
        this.movable = movable;
    }

    @Override
    public double getSpeed() {

        return 1.6 * movable.getSpeed();
    }
}
