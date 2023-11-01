package SOLIDPrinciples;

// Single Responsibility Principle (SRP)
// The Circle class has the single responsibility of representing a circle,
// and the CircleCalculator class has the single responsibility of calculating its area.

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class CircleCalculator {
    public double calculateArea(Circle circle) {
        return Math.PI * Math.pow(circle.getRadius(), 2);
    }
}

// Open/Closed Principle (OCP)

// the Shape interface, allowing for the extension of shapes without
// modifying existing code. The Rectangle class implements this interface,
// and it can be extended without changing the Shape interface or existing code.

interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Liskov Substitution Principle (LSP)

//  The Square class is a subtype of Rectangle.
//  Instances of Square can be used wherever Rectangle instances are expected.

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

// Interface Segregation Principle (ISP)

// two interfaces, SolidShape and FlatShape, each representing a specific set of behaviors.
// The Cuboid class implements both interfaces, and we can use the specific methods we need.

interface SolidShape {
    double calculateVolume();
}

interface FlatShape {
    double calculateArea();
}

class Cuboid implements SolidShape, FlatShape {
    private double length;
    private double width;
    private double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return length * width * height;
    }

    @Override
    public double calculateArea() {
        // Surface area of a cuboid
        return 2 * (length * width + width * height + height * length);
    }
}

// Dependency Inversion Principle (DIP)

// The AreaCalculator class depends on the FlatShape interface,
// following the DIP by relying on abstractions rather than concrete implementations.

class AreaCalculator {
    public double calculate(FlatShape shape) {
        return shape.calculateArea();
    }
}

public class SOLIDPrincipleExample {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        CircleCalculator circleCalculator = new CircleCalculator();
        double circleArea = circleCalculator.calculateArea(circle);
        System.out.println("Circle Area: " + circleArea);

        Rectangle rectangle = new Rectangle(4, 6);
        double rectangleArea = rectangle.calculateArea();
        System.out.println("Rectangle Area: " + rectangleArea);

        Square square = new Square(4);
        double squareArea = square.calculateArea();
        System.out.println("Square Area: " + squareArea);

        Cuboid cuboid = new Cuboid(2, 3, 4);
        double cuboidVolume = cuboid.calculateVolume();
        double cuboidArea = cuboid.calculateArea();
        System.out.println("Cuboid Volume: " + cuboidVolume);
        System.out.println("Cuboid Area: " + cuboidArea);

        AreaCalculator areaCalculator = new AreaCalculator();
        double calculatedArea = areaCalculator.calculate(cuboid);
        System.out.println("Calculated Area: " + calculatedArea);
    }
}
