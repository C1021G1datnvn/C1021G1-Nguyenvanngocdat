package ss5_access_modifier_static_method_static_property.bai_tap;

public class Circle {
    private double radius = 10;
    private  String color = "red";
    private double area;
    public Circle() {

    }
    public Circle(double radius, double area) {
        this.radius = radius;
        this.area = area;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(this.radius,2) * Math.PI;
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Radius " + circle.getRadius());
        System.out.println("Area " + circle.getArea());
    }
}
