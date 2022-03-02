package ss6_inheritance.bai_tap.circle_cylinder;

import ss6_inheritance.bai_tap.circle_cylinder.Circle;

public class test_Circle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3.5, "green");
        System.out.println(circle);
    }
}
