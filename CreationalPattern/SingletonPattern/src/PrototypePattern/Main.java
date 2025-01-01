package PrototypePattern;

interface Shape {    // Prototype Interface
    void draw();
    Shape clone();
}

class Circle implements Shape {      // Concrete Prototype
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }

    @Override
    public Shape clone() {
        return new Circle(this.color);
    }
}

class ShapeClient {      // Client class
    private Shape shapePrototype;

    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    public Shape createShape() {
        return shapePrototype.clone();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circlePrototype = new Circle("red");

        // Create a client and give it the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);

        // Use the prototype to create a new shape (a red circle).
        Shape redCircle = client.createShape();

        // Draw the newly created red circle.
        redCircle.draw();
    }
}
