package ss7_abstract_class_interface.bai_tap.resizeable;

public class Shape implements Resizeable {
    private String color = "blue";
    private boolean filled = true;
    public Shape() {

    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    @Override
    public void resize(double percent) {

    }
}
