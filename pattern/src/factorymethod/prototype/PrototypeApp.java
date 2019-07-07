package factorymethod.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeApp {
    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        List<Shape> cloneShape = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";

        shapes.add(circle);
        //Circle anotherCircle = circle;
        Circle anotherCircle = (Circle) circle.clone();

        Triangle triangle = new Triangle();
        triangle.square = 40;
        triangle.color = "black";

        System.out.println(anotherCircle == circle);
        System.out.println(anotherCircle.equals(circle));

        shapes.add(triangle);



    }

}
