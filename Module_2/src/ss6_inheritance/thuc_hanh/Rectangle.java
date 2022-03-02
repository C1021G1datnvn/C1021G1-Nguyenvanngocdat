package ss6_inheritance.thuc_hanh;

public class Rectangle extends Shape {
   private double width = 1.0;
   private double height = 1.0;
   private double area;
   private double perimeter;
   public Rectangle() {
       this.width = this.height = 1.0;
   }

   public Rectangle(double width, double height, double area, double perimeter) {
       this.width = width;
       this.height = height;
       this.area = area;
       this.perimeter = perimeter;
   }
   public Rectangle(double width, double height, String color, boolean filled) {
       super(color, filled);
       this.height = height;
       this.width = width;
   }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }



    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return area = width * height;
    }

    public double getPerimeter() {
        return perimeter = (width + this.height) * 2;
    }

    @Override
    public String toString() {
        return "A Rectangle with="
                + getWidth()
                +"and height="
                + getHeight()
                +" which is a subclass of"
                + super.toString();
    }

}
