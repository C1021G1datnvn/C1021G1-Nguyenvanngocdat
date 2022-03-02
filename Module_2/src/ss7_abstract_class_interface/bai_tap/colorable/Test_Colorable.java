package ss7_abstract_class_interface.bai_tap.colorable;

public class Test_Colorable {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle("blue", true, 3.5)
                , new Retangle("green", true, 5.5, 4.5),
                new Square("pink", true, 4.0)};
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        if (shape instanceof Square) {
            ((Colorable) shape).howToColor();
            System.out.println(((Square) shape).howToColor());
            }
        }
    }
}
