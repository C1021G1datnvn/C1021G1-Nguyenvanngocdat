package ss4_class_and_object_java.thuc_hanh;


public class LopHinhChuNhat {
    double width, height;
    public LopHinhChuNhat () {
    }
    public LopHinhChuNhat(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
