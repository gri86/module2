package factorymethod.prototype;

import java.util.Objects;

public class Triangle extends Shape {

    public int square;

    public Triangle(){}

    public Triangle(Triangle target){
        super(target);
        this.square = target.square;
    }

    @Override
    public Shape clone() {
        return new Triangle(this);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Triangle) || !super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return square == triangle.square;
    }


}
