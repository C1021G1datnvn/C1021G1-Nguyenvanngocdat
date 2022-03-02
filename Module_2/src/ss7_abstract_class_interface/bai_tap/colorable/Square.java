package ss7_abstract_class_interface.bai_tap.colorable;

public class Square extends Shape implements Colorable {
    private double agea = 0.0;
    public Square() {

    }
    public Square(double agea) {
        this.agea = agea;
    }

    public Square(String color, boolean filled, double agea) {
        super(color, filled);
        this.agea = agea;
    }

    public double getAgea() {
        return agea;
    }

    public void setAgea(double agea) {
        this.agea = agea;
    }
    public double getArea() {
        return this.agea * this.agea;
    }
    public double getPerimeter() {
        return this.agea * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "agea=" + agea +
                ",area=" + getArea() +
                ",perimeter=" + getPerimeter() +
                '}';
    }

    @Override
    public String howToColor() {
        return "Color all four sides.";
    }
}
