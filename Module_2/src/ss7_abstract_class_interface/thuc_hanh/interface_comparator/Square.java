package ss7_abstract_class_interface.thuc_hanh.interface_comparator;

public class Square extends Shape{
    double edge = 1;

    public Square() {
    }

    public Square(String color, boolean filled, double edge) {
        super(color, filled);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }
    public double getArea() {
        return edge * edge;
    }

    public double getPerimeter() {
        return 4 * edge;
    }

    @Override
    public String toString() {
        return "A Square with edge= "
                + getEdge()
                + ", has an area of "
                + getArea()
                + ", which is a subclass of "
                + super.toString();
    }
}
