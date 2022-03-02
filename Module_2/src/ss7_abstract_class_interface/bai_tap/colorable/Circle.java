package ss7_abstract_class_interface.bai_tap.colorable;

public class Circle extends Shape{
    private double radius = 0.0;
    public Circle() {

    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getRadius() +
                "area=" + getArea() +
                "perimeter=" + getPerimeter() +
                '}';
    }
}
