package factorymethod.prototype;

import java.util.Objects;

public class Circle extends Shape {

    public int radius;

    public Circle() {
    }

    public Circle(Circle target) {
        super(target);
        this.radius = target.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Circle) || !super.equals(obj)) return false;
        Circle circle = (Circle) obj;
        return circle.radius == radius;
    }
}
