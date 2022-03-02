package ss7_abstract_class_interface.bai_tap.resizeable;

public class Test_Shape {
    public static void main(String[] args) {
        Shape[] array = new Shape[3];
        array[0] = new Circle("blue", true, 3.5);
        array[1] = new Retangle("green", true, 5.5, 4.5);
        array[2] = new Square("pink", true, 5.0);
        System.out.println("Befor: ");
        for (Shape shape : array) {
            System.out.println(shape);
        }
        double percent = Math.random() * 100;
        System.out.println(percent);

        System.out.println("After");
        for (Shape shape : array) {
            shape.resize(percent);
            System.out.println(shape);
        }
    }
}
