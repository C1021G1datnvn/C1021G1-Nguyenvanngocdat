package ss6_inheritance.bai_tap.triangle;

public class test_Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);
        triangle = new Triangle("blue", true, 1, 2, 3);
        System.out.println(triangle);
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());
    }
}
