package ss7_abstract_class_interface.bai_tap.colorable;

public class Retangle extends Shape{
    private double width = 0.0;
    private double lenght = 0.0;
    public Retangle() {

    }

    public Retangle(double width, double lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    public Retangle(String color, boolean filled, double width, double lenght) {
        super(color, filled);
        this.width = width;
        this.lenght = lenght;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
    public double getArea() {
        return this.width * this.lenght;
    }
    public double getPerimeter() {
        return (this.width + this.lenght) * 2;
    }

    @Override
    public String toString() {
        return "Retangle{" +
                "width=" + getWidth() +
                ", lenght=" + getLenght() +
                "area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
