package ss7_abstract_class_interface.bai_tap.resizeable;

public class Retangle extends Shape implements Resizeable {
    public double width = 1.0;
    public double length = 1.0;
    public Retangle() {

    }
    public Retangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public Retangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "Retangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

    @Override
    public void resize(double percent) {
        this.width = this.width * percent/100;
        this.length = this.length * percent/100;
    }
}
